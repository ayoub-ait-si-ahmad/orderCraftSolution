package com.orderCraftSpringApp.repository;

import com.orderCraftSpringApp.model.classes.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
}
