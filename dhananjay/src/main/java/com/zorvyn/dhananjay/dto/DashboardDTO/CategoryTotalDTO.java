package com.zorvyn.dhananjay.dto.DashboardDTO;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class CategoryTotalDTO {
    private String category;
    private BigDecimal total;
    private long count;
}