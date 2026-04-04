package com.zorvyn.dhananjay.service.Service;

import com.zorvyn.dhananjay.dto.FinancialTO.FinancialRecordRequestDTO;
import com.zorvyn.dhananjay.dto.FinancialTO.FinancialRecordResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.List;

public interface FinancialService {

    FinancialRecordResponseDTO createRecord(String email, FinancialRecordRequestDTO requestBody);
    FinancialRecordResponseDTO getRecordById(String email, Long id);
    FinancialRecordResponseDTO updateRecord(String email, Long id, FinancialRecordRequestDTO requestBody);
    void deleteRecord(String email, Long id);
    List<FinancialRecordResponseDTO> filterRecords(String email, String type, String category, LocalDate startDate, LocalDate endDate);
    Page<FinancialRecordResponseDTO> getAllRecords(String email, int zeroBasedPage, int size, String sortBy);
}
