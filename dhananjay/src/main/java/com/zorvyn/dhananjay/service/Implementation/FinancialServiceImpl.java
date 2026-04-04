package com.zorvyn.dhananjay.service.Implementation;

import com.zorvyn.dhananjay.dto.FinancialTO.FinancialRecordRequestDTO;
import com.zorvyn.dhananjay.dto.FinancialTO.FinancialRecordResponseDTO;
import com.zorvyn.dhananjay.entity.FinancialRecord;
import com.zorvyn.dhananjay.entity.RecordType;
import com.zorvyn.dhananjay.entity.User;
import com.zorvyn.dhananjay.entity.UserType;
import com.zorvyn.dhananjay.exception.AccessDeniedException;
import com.zorvyn.dhananjay.exception.BadRequestException;
import com.zorvyn.dhananjay.exception.UserNotFoundException;
import com.zorvyn.dhananjay.repository.FinancialRecordRepository;
import com.zorvyn.dhananjay.repository.UserRepository;
import com.zorvyn.dhananjay.service.Service.FinancialService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FinancialServiceImpl implements FinancialService {

    private final FinancialRecordRepository recordRepository;
    private final UserRepository userRepository;

    private User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    private void checkAdmin(User user) {
        if (user.getUserType() != UserType.ADMIN) {
            throw new AccessDeniedException("Only admin allowed");
        }
    }

    private void checkViewerAccess(User user) {
        if (user.getUserType() == null) {
            throw new AccessDeniedException("Invalid user");
        }
    }

//<<------------------------------------Create Record (ADMIN)--------------------------------->>

    @Override
    public FinancialRecordResponseDTO createRecord(String email, FinancialRecordRequestDTO request) {

        User user = getUserByEmail(email);
        checkAdmin(user);

        RecordType type;
        try {
            type = RecordType.valueOf(request.getRecordType().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new BadRequestException("Invalid type: " + request.getRecordType() + ". Allowed: INCOME, EXPENSE");
        }

        FinancialRecord record = FinancialRecord.builder()
                .amount(request.getAmount())
                .type(type)
                .category(request.getCategory())
                .date(request.getDate())
                .notes(request.getNotes())
                .createdBy(user.getId().toString())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return mapToDTO(recordRepository.save(record));
    }

//<<------------------------------------Get All Records--------------------------------->>

    @Override
    public Page<FinancialRecordResponseDTO> getAllRecords(String email, int page, int size,
                                                          String sortBy) {

        User user = getUserByEmail(email);
        checkViewerAccess(user);

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).descending());
        Page<FinancialRecord> recordsPage = recordRepository.findAll(pageable);
        return recordsPage.map(this::mapToDTO);
    }

//<<------------------------------------Get Record By ID-------------------------------->>

    @Override
    public FinancialRecordResponseDTO getRecordById(String email, Long id) {

        User user = getUserByEmail(email);
        checkViewerAccess(user);

        FinancialRecord record = recordRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Record not found"));

        return mapToDTO(record);
    }

//<<------------------------------------Update Record (ADMIN)------------------------------>>

    @Override
    public FinancialRecordResponseDTO updateRecord(String email, Long id, FinancialRecordRequestDTO request) {

        User user = getUserByEmail(email);
        checkAdmin(user);

        FinancialRecord record = recordRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Record not found"));

        record.setAmount(request.getAmount());
        record.setCategory(request.getCategory());
        record.setDate(request.getDate());
        record.setNotes(request.getNotes());
        record.setUpdatedAt(LocalDateTime.now());

        return mapToDTO(recordRepository.save(record));
    }

//<<------------------------------------Delete Record (ADMIN)---------------------------->>

    @Override
    public void deleteRecord(String email, Long id) {

        User user = getUserByEmail(email);
        checkAdmin(user);

        FinancialRecord record = recordRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Record not found"));

        recordRepository.delete(record);
    }

//<<-------------------------------------Filter Records---------------------------------------->>

    @Override
    public List<FinancialRecordResponseDTO> filterRecords(String email, String type, String category,
                                                          LocalDate startDate,
                                                          LocalDate endDate) {

        User user = getUserByEmail(email);
        checkViewerAccess(user);

        List<FinancialRecord> records = recordRepository.findAll();

        return records.stream()
                .filter(r -> type == null || r.getType().name().equalsIgnoreCase(type))
                .filter(r -> category == null || r.getCategory().equalsIgnoreCase(category))
                .filter(r -> startDate == null || !r.getDate().isBefore(startDate))
                .filter(r -> endDate == null || !r.getDate().isAfter(endDate))
                .map(this::mapToDTO)
                .toList();
    }

    //<<----------------------------Response Helper Method--------------------->>

    private FinancialRecordResponseDTO mapToDTO(FinancialRecord record) {
        return FinancialRecordResponseDTO.builder()
                .id(record.getId())
                .amount(record.getAmount())
                .recordType(record.getType())
                .category(record.getCategory())
                .date(record.getDate())
                .notes(record.getNotes())
                .createdBy(record.getCreatedBy())
                .createdAt(record.getCreatedAt())
                .updatedAt(record.getUpdatedAt())
                .build();
    }
}