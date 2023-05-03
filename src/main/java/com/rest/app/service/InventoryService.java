package com.rest.app.service;

import com.rest.app.entity.Inventory;
import com.rest.app.entity.Item;

public interface InventoryService {
    Inventory getItemInInventory(Item item);
}
