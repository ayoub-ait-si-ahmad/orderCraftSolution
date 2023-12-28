package com.orderCraftSpringApp.repository;

import com.orderCraftSpringApp.model.classes.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
}
