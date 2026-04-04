package com.zorvyn.dhananjay.dto.FinancialTO;

import com.zorvyn.dhananjay.entity.RecordType;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinancialRecordResponseDTO {

    private Long id;
    private BigDecimal amount;
    private RecordType recordType;
    private String category;
    private LocalDate date;
    private String notes;
    private String createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
