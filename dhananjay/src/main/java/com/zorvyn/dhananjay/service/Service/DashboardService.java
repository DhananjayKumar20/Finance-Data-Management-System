package com.zorvyn.dhananjay.service.Service;

import com.zorvyn.dhananjay.dto.DashboardDTO.*;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DashboardService {

    SummaryResponseDTO getSummary(String email);
    Page<RecentActivityDTO> getRecentActivity(String email, int zeroBasedPage, int size, String sortBy);
    Page<WeeklyTrendDTO> getWeeklyTrends(String email, int month, int year, int zeroBasedPage, int size, String sortBy);
    Page<MonthlyTrendDTO> getMonthlyTrends(String email, int year, int zeroBasedPage, int size, String sortBy);
    Page<CategoryTotalDTO> getCategoryTotals(String email, String type, int zeroBasedPage, int size, String sortBy);

}