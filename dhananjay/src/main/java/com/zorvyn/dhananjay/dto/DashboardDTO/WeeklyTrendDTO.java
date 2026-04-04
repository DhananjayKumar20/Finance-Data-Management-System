package com.zorvyn.dhananjay.dto.DashboardDTO;

import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class WeeklyTrendDTO {
    private String week;
    private BigDecimal income;
    private BigDecimal expense;
    private BigDecimal net;
}