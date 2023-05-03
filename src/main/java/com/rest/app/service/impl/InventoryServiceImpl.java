package com.rest.app.service.impl;


import com.rest.app.entity.Inventory;
import com.rest.app.entity.Item;
import com.rest.app.repository.InventoryRepository;
import com.rest.app.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Inventory getItemInInventory(Item item) {
        return inventoryRepository.findByItem(item);
    }
}
