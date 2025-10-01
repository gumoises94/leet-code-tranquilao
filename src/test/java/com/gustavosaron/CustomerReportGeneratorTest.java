package com.gustavosaron;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CustomerReportGeneratorTest {
    
    private List<Order> orders;
    


    @Test
    void shouldGet3HighestSpendingCustomersInTheLast30Days() {
        List<CustomerReport> reports = CustomerReportGenerator.get3HighestSpendingCustomersInTheLast30Days(orders);
        // 1º
        assertEquals("customerC", reports.get(0).customerId());
        assertEquals( new BigDecimal("1800"), reports.get(0).totalSum());
        // 2º
        assertEquals("customerA", reports.get(1).customerId());
        assertEquals(new BigDecimal("1200"), reports.get(1).totalSum());
        // 3º
        assertEquals("customerB", reports.get(2).customerId());
        assertEquals(new BigDecimal("550"), reports.get(2).totalSum());
    }





    @BeforeEach
    void setUp() {
        long id = 1;
        orders = List.of(
                new Order(id++, "customerB", LocalDate.now().minusDays(34).atStartOfDay(), "CREATED", new BigDecimal("100")),
                new Order(id++, "customerA", LocalDate.now().minusDays(33).atStartOfDay(), "PENDING", new BigDecimal("150")),
                new Order(id++, "customerC", LocalDate.now().minusDays(32).atStartOfDay(), "PAID", new BigDecimal("200")),
                new Order(id++, "customerB", LocalDate.now().minusDays(31).atStartOfDay(), "CREATED", new BigDecimal("250")),
                new Order(id++, "customerA", LocalDate.now().minusDays(30).atStartOfDay(), "PENDING", new BigDecimal("300")),
                new Order(id++, "customerC", LocalDate.now().minusDays(29).atStartOfDay(), "PAID", new BigDecimal("350")),
                new Order(id++, "customerB", LocalDate.now().minusDays(28).atStartOfDay(), "CREATED", new BigDecimal("400")),
                new Order(id++, "customerA", LocalDate.now().minusDays(27).atStartOfDay(), "PAID", new BigDecimal("450")),
                new Order(id++, "customerC", LocalDate.now().minusDays(26).atStartOfDay(), "CREATED", new BigDecimal("500")),
                new Order(id++, "customerB", LocalDate.now().minusDays(25).atStartOfDay(), "PAID", new BigDecimal("550")),
                new Order(id++, "customerA", LocalDate.now().minusDays(24).atStartOfDay(), "CREATED", new BigDecimal("600")),
                new Order(id++, "customerC", LocalDate.now().minusDays(23).atStartOfDay(), "PAID", new BigDecimal("650")),
                new Order(id++, "customerB", LocalDate.now().minusDays(22).atStartOfDay(), "CREATED", new BigDecimal("700")),
                new Order(id++, "customerA", LocalDate.now().minusDays(21).atStartOfDay(), "PAID", new BigDecimal("750")),
                new Order(id++, "customerC", LocalDate.now().minusDays(20).atStartOfDay(), "PAID", new BigDecimal("800")),
                new Order(id++, "customerD", LocalDate.now().minusDays(360).atStartOfDay(), "PAID", new BigDecimal("800")),
                new Order(id++, "customerD", LocalDate.now().minusDays(360).atStartOfDay(), "PAID", new BigDecimal("800")),
                new Order(id++, "customerD", LocalDate.now().minusDays(360).atStartOfDay(), "PAID", new BigDecimal("800")),
                new Order(id++, "customerE", LocalDate.now().minusDays(360).atStartOfDay(), "CREATED", new BigDecimal("800")),
                new Order(id, "customerE", LocalDate.now().minusDays(360).atStartOfDay(), "CREATED", new BigDecimal("800"))

                // c: 1800
                //a: 1200
                //b: 550
                
        );
    }
}
