package com.gustavosaron;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record Order(long id, String customerId, LocalDateTime createdAt, String status, BigDecimal total) {
}
