package com.zorvyn.dhananjay.service.Implementation;

import com.zorvyn.dhananjay.dto.DashboardDTO.*;
import com.zorvyn.dhananjay.entity.FinancialRecord;
import com.zorvyn.dhananjay.entity.RecordType;
import com.zorvyn.dhananjay.entity.User;
import com.zorvyn.dhananjay.entity.UserType;
import com.zorvyn.dhananjay.exception.AccessDeniedException;
import com.zorvyn.dhananjay.exception.BadRequestException;
import com.zorvyn.dhananjay.exception.UserNotFoundException;
import com.zorvyn.dhananjay.repository.FinancialRecordRepository;
import com.zorvyn.dhananjay.repository.UserRepository;
import com.zorvyn.dhananjay.service.Service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final FinancialRecordRepository recordRepository;
    private final UserRepository userRepository;

    //<<----------------------------Get User By Email--------------------->>

    private User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    //<<----------------------------Check All Roles--------------------->>

    private void checkAllRolesAccess(User user) {
        if (user.getUserType() == null) {
            throw new AccessDeniedException("Invalid user");
        }
    }

    //<<----------------------------Check Analyst or Admin Only--------------------->>

    private void checkAnalystOrAdmin(User user) {
        if (user.getUserType() != UserType.ANALYST && user.getUserType() != UserType.ADMIN) {
            throw new AccessDeniedException("Access denied. Only ANALYST and ADMIN allowed");
        }
    }

//<<------------------------------------Overall Summary (ALL ROLES)--------------------------------->>

    @Override
    public SummaryResponseDTO getSummary(String email) {

        User user = getUserByEmail(email);
        checkAllRolesAccess(user);

        List<FinancialRecord> allRecords = recordRepository.findAll();

        BigDecimal totalIncome = allRecords.stream()
                .filter(r -> r.getType() == RecordType.INCOME)
                .map(FinancialRecord::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalExpense = allRecords.stream()
                .filter(r -> r.getType() == RecordType.EXPENSE)
                .map(FinancialRecord::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return SummaryResponseDTO.builder()
                .totalIncome(totalIncome)
                .totalExpenses(totalExpense)
                .netBalance(totalIncome.subtract(totalExpense))
                .totalRecords(allRecords.size())
                .build();
    }

//<<------------------------------------Category-wise Totals (ANALYST, ADMIN)--------------------->>

    @Override
    public Page<CategoryTotalDTO> getCategoryTotals(String email, String type,
                                                    int page, int size, String sortBy) {
        User user = getUserByEmail(email);
        checkAnalystOrAdmin(user);

        List<FinancialRecord> records = recordRepository.findAll();

        if (type != null && !type.trim().isEmpty()) {
            RecordType recordType;
            try {
                recordType = RecordType.valueOf(type.toUpperCase());
            } catch (IllegalArgumentException e) {
                throw new BadRequestException("Invalid type: " + type + ". Allowed: INCOME, EXPENSE");
            }
            records = records.stream()
                    .filter(r -> r.getType() == recordType)
                    .toList();
        }

        List<CategoryTotalDTO> result = records.stream()
                .collect(Collectors.groupingBy(FinancialRecord::getCategory))
                .entrySet().stream()
                .map(entry -> {
                    BigDecimal total = entry.getValue().stream()
                            .map(FinancialRecord::getAmount)
                            .reduce(BigDecimal.ZERO, BigDecimal::add);
                    return CategoryTotalDTO.builder()
                            .category(entry.getKey())
                            .total(total)
                            .count(entry.getValue().size())
                            .build();
                })
                .sorted(Comparator.comparing(CategoryTotalDTO::getCategory))
                .collect(Collectors.toList());

        return toPage(result, page, size);
    }

//<<------------------------------------Monthly Trends (ANALYST, ADMIN)-------------------------->>

    @Override
    public Page<MonthlyTrendDTO> getMonthlyTrends(String email, int year,
                                                  int page, int size, String sortBy) {
        User user = getUserByEmail(email);
        checkAnalystOrAdmin(user);

        List<FinancialRecord> records = recordRepository.findAll().stream()
                .filter(r -> r.getDate().getYear() == year)
                .toList();

        Map<Integer, List<FinancialRecord>> groupedByMonth = records.stream()
                .collect(Collectors.groupingBy(r -> r.getDate().getMonthValue()));

        List<MonthlyTrendDTO> trends = new ArrayList<>();
        for (int month = 1; month <= 12; month++) {
            List<FinancialRecord> monthRecords = groupedByMonth.getOrDefault(month, Collections.emptyList());

            BigDecimal income = monthRecords.stream()
                    .filter(r -> r.getType() == RecordType.INCOME)
                    .map(FinancialRecord::getAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal expense = monthRecords.stream()
                    .filter(r -> r.getType() == RecordType.EXPENSE)
                    .map(FinancialRecord::getAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            trends.add(MonthlyTrendDTO.builder()
                    .month(LocalDate.of(year, month, 1)
                            .getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH))
                    .income(income)
                    .expense(expense)
                    .net(income.subtract(expense))
                    .build());
        }

        return toPage(trends, page, size);
    }

//<<------------------------------------Weekly Trends (ANALYST, ADMIN)--------------------------->>

    @Override
    public Page<WeeklyTrendDTO> getWeeklyTrends(String email, int month, int year,
                                                int page, int size, String sortBy) {
        User user = getUserByEmail(email);
        checkAnalystOrAdmin(user);

        List<FinancialRecord> monthRecords = recordRepository.findAll().stream()
                .filter(r -> r.getDate().getMonthValue() == month
                        && r.getDate().getYear() == year)
                .toList();

        int[][] weekRanges  = { {1, 7}, {8, 14}, {15, 21}, {22, 31} };
        String[] weekLabels = {
                "Week 1 (Day 1-7)",
                "Week 2 (Day 8-14)",
                "Week 3 (Day 15-21)",
                "Week 4 (Day 22-31)"
        };

        List<WeeklyTrendDTO> trends = new ArrayList<>();
        for (int i = 0; i < weekRanges.length; i++) {
            int startDay = weekRanges[i][0];
            int endDay   = weekRanges[i][1];

            List<FinancialRecord> weekRecords = monthRecords.stream()
                    .filter(r -> r.getDate().getDayOfMonth() >= startDay
                            && r.getDate().getDayOfMonth() <= endDay)
                    .toList();

            BigDecimal income = weekRecords.stream()
                    .filter(r -> r.getType() == RecordType.INCOME)
                    .map(FinancialRecord::getAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal expense = weekRecords.stream()
                    .filter(r -> r.getType() == RecordType.EXPENSE)
                    .map(FinancialRecord::getAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            trends.add(WeeklyTrendDTO.builder()
                    .week(weekLabels[i])
                    .income(income)
                    .expense(expense)
                    .net(income.subtract(expense))
                    .build());
        }

        return toPage(trends, page, size);
    }

//<<------------------------------------Recent Activity (ALL ROLES)------------------------------->>

    @Override
    public Page<RecentActivityDTO> getRecentActivity(String email, int page, int size, String sortBy) {

        User user = getUserByEmail(email);
        checkAllRolesAccess(user);

        // pagination
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());
        Page<FinancialRecord> recordsPage = recordRepository.findAll(pageable);

        return recordsPage.map(r -> RecentActivityDTO.builder()
                .id(r.getId())
                .amount(r.getAmount())
                .recordType(r.getType())
                .category(r.getCategory())
                .date(r.getDate())
                .notes(r.getNotes())
                .createdAt(r.getCreatedAt())
                .build());
    }

    private <T> Page<T> toPage(List<T> list, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        int start = (int) pageable.getOffset();
        int end   = Math.min(start + size, list.size());
        if (start >= list.size()) {
            return new PageImpl<>(Collections.emptyList(), pageable, list.size());
        }
        return new PageImpl<>(list.subList(start, end), pageable, list.size());
    }
}