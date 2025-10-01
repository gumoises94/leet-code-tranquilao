package com.gustavosaron;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CustomerReportGenerator {
    
    private CustomerReportGenerator() {}
    public static List<CustomerReport> get3HighestSpendingCustomersInTheLast30Days(List<Order> orders) {
        return orders.stream()
                .filter(order -> Objects.equals(order.status(), "PAID") &&
                        order.createdAt().isAfter(LocalDate.now().minusDays(31).atTime(OffsetTime.MAX).toLocalDateTime())
                )
                .collect(Collectors.groupingBy(Order::customerId))
                .entrySet()
                .stream()
                .map(entry -> new CustomerReport(entry.getKey(), entry.getValue().stream()
                        .map(Order::total)
                        .reduce(BigDecimal.ZERO, BigDecimal::add)))
                .sorted(Comparator.comparing(CustomerReport::totalSum).reversed())
                .limit(3)
                .toList();
    }
}
