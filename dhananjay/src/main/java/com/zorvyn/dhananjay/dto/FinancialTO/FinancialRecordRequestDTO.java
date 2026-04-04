package com.zorvyn.dhananjay.dto.FinancialTO;

import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinancialRecordRequestDTO {

    private BigDecimal amount;
    private String recordType;
    private String category;
    private LocalDate date;
    private String notes;
}