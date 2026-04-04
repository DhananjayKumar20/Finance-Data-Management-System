package com.zorvyn.dhananjay.controller.FinancialRecords;

import com.zorvyn.dhananjay.Pagination.PaginatedResponse;
import com.zorvyn.dhananjay.config.JwtUtils;
import com.zorvyn.dhananjay.dto.FinancialTO.FinancialRecordRequestDTO;
import com.zorvyn.dhananjay.dto.FinancialTO.FinancialRecordResponseDTO;
import com.zorvyn.dhananjay.service.Service.FinancialService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/records")
public class FinancialController {

    private final FinancialService financialService;
    private final JwtUtils jwtUtils;

    private String getEmailFromRequest(HttpServletRequest request) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("JWT token missing");
        }
        String token = authHeader.substring(7);
        return jwtUtils.getEmailFromJwt(token);
    }

//<<------------------------------------Create Record (ADMIN)--------------------------------->>

    @PostMapping
    public ResponseEntity<FinancialRecordResponseDTO> createRecord(
            HttpServletRequest request,
            @RequestBody FinancialRecordRequestDTO requestBody) {

        String email = getEmailFromRequest(request);
        FinancialRecordResponseDTO response =
                financialService.createRecord(email, requestBody);

        return ResponseEntity.ok(response);
    }

//<<------------------------------------Get All Records--------------------------------->>

    @GetMapping
    public ResponseEntity<PaginatedResponse<FinancialRecordResponseDTO>> getAllRecords(
            HttpServletRequest request,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy) {

        String email = getEmailFromRequest(request);

        int zeroBasedPage = (page > 0) ? page - 1 : 0;

        Page<FinancialRecordResponseDTO> response =
                financialService.getAllRecords(email, zeroBasedPage, size, sortBy);

        return ResponseEntity.ok(PaginatedResponse.from(response));
    }

//<<------------------------------------Get Record By ID-------------------------------->>

    @GetMapping("/{id}")
    public ResponseEntity<FinancialRecordResponseDTO> getRecordById(
            HttpServletRequest request,
            @PathVariable Long id) {

        String email = getEmailFromRequest(request);
        FinancialRecordResponseDTO response =
                financialService.getRecordById(email, id);

        return ResponseEntity.ok(response);
    }

//<<------------------------------------Update Record (ADMIN)------------------------------>>

    @PutMapping("/{id}")
    public ResponseEntity<FinancialRecordResponseDTO> updateRecord(
            HttpServletRequest request,
            @PathVariable Long id,
            @RequestBody FinancialRecordRequestDTO requestBody) {

        String email = getEmailFromRequest(request);
        FinancialRecordResponseDTO response =
                financialService.updateRecord(email, id, requestBody);

        return ResponseEntity.ok(response);
    }

//<<------------------------------------Delete Record (ADMIN)---------------------------->>

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRecord(
            HttpServletRequest request,
            @PathVariable Long id) {

        String email = getEmailFromRequest(request);
        financialService.deleteRecord(email, id);
        return ResponseEntity.ok("Record deleted successfully");
    }

//<<------------------------------------Filter Records--------------------------------->>

    @GetMapping("/filter")
    public ResponseEntity<List<FinancialRecordResponseDTO>> filterRecords(
            HttpServletRequest request,
            @RequestParam(required = false) String type,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate) {

        String email = getEmailFromRequest(request);

        List<FinancialRecordResponseDTO> response =
                financialService.filterRecords(email, type, category, startDate, endDate);

        return ResponseEntity.ok(response);
    }
}