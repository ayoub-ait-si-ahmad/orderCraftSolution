package com.orderCraftSpringApp.repository;

import com.orderCraftSpringApp.model.classes.SalesReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesReportRepository extends JpaRepository<SalesReport, Long> {
}
