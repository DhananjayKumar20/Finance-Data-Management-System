package com.zorvyn.dhananjay.controller.DashboardController;

import com.zorvyn.dhananjay.Pagination.PaginatedResponse;
import com.zorvyn.dhananjay.config.JwtUtils;
import com.zorvyn.dhananjay.dto.DashboardDTO.*;
import com.zorvyn.dhananjay.service.Service.DashboardService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;
    private final JwtUtils jwtUtils;

    //<<----------------------------Extract Email from JWT--------------------->>

    private String getEmailFromRequest(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("JWT token missing");
        }
        String token = authHeader.substring(7);
        return jwtUtils.getEmailFromJwt(token);
    }

//<<------------------------------------Overall Summary (ALL ROLES)--------------------------------->>

    @GetMapping("/summary")
    public ResponseEntity<SummaryResponseDTO> getSummary(
            HttpServletRequest request) {

        String email = getEmailFromRequest(request);
        SummaryResponseDTO response = dashboardService.getSummary(email);
        return ResponseEntity.ok(response);
    }

//<<------------------------------------Category-wise Totals (ANALYST, ADMIN)--------------------->>

    @GetMapping("/category-totals")
    public ResponseEntity<PaginatedResponse<CategoryTotalDTO>> getCategoryTotals(
            HttpServletRequest request,
            @RequestParam(required = false) String type,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "category") String sortBy) {

        String email = getEmailFromRequest(request);
        int zeroBasedPage = (page > 0) ? page - 1 : 0;

        Page<CategoryTotalDTO> response =
                dashboardService.getCategoryTotals(email, type, zeroBasedPage, size, sortBy);

        return ResponseEntity.ok(PaginatedResponse.from(response));
    }

//<<------------------------------------Monthly Trends (ANALYST, ADMIN)-------------------------->>

    @GetMapping("/monthly-trends")
    public ResponseEntity<PaginatedResponse<MonthlyTrendDTO>> getMonthlyTrends(
            HttpServletRequest request,
            @RequestParam int year,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "12") int size,
            @RequestParam(defaultValue = "month") String sortBy) {

        String email = getEmailFromRequest(request);
        int zeroBasedPage = (page > 0) ? page - 1 : 0;

        Page<MonthlyTrendDTO> response =
                dashboardService.getMonthlyTrends(email, year, zeroBasedPage, size, sortBy);

        return ResponseEntity.ok(PaginatedResponse.from(response));
    }
//<<------------------------------------Weekly Trends (ANALYST, ADMIN)--------------------------->>

    @GetMapping("/weekly-trends")
    public ResponseEntity<PaginatedResponse<WeeklyTrendDTO>> getWeeklyTrends(
            HttpServletRequest request,
            @RequestParam int month,
            @RequestParam int year,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "4") int size,
            @RequestParam(defaultValue = "week") String sortBy) {

        String email = getEmailFromRequest(request);
        int zeroBasedPage = (page > 0) ? page - 1 : 0;

        Page<WeeklyTrendDTO> response =
                dashboardService.getWeeklyTrends(email, month, year, zeroBasedPage, size, sortBy);

        return ResponseEntity.ok(PaginatedResponse.from(response));
    }

//<<------------------------------------Recent Activity (ALL ROLES)------------------------------->>

    @GetMapping("/recent-activity")
    public ResponseEntity<PaginatedResponse<RecentActivityDTO>> getRecentActivity(
            HttpServletRequest request,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "createdAt") String sortBy) {

        String email = getEmailFromRequest(request);
        int zeroBasedPage = (page > 0) ? page - 1 : 0;

        Page<RecentActivityDTO> response =
                dashboardService.getRecentActivity(email, zeroBasedPage, size, sortBy);

        return ResponseEntity.ok(PaginatedResponse.from(response));
    }
}