package com.rest.app.repository;

import com.rest.app.entity.Inventory;
import com.rest.app.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
    Inventory findByItem(Item item);
}
