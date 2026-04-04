package com.zorvyn.dhananjay.dto.DashboardDTO;

import com.zorvyn.dhananjay.entity.RecordType;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
public class RecentActivityDTO {
    private Long id;
    private BigDecimal amount;
    private RecordType recordType;
    private String category;
    private LocalDate date;
    private String notes;
    private LocalDateTime createdAt;
}