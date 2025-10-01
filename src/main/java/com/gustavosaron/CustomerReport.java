package com.gustavosaron;

import java.math.BigDecimal;

public record CustomerReport(String customerId, BigDecimal totalSum) {
}
