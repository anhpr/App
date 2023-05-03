package com.rest.app.service.impl;

import com.rest.app.entity.Item;
import com.rest.app.repository.InventoryRepository;
import com.rest.app.repository.ItemRepository;
import com.rest.app.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    InventoryRepository inventoryRepository;
    @Override
    public List<Item> findAll() {
        List<Item> items = itemRepository.findAll();
        List<Item> itemListResponse = items.stream().filter(item -> inventoryRepository.findByItem(item).getQuantity()!=0).collect(Collectors.toList());
        return itemListResponse;
    }

    @Override
    public Optional<Item> findById(int id) {
        return itemRepository.findById(id);
    }
}
