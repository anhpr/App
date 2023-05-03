package com.rest.app.service;

import com.rest.app.entity.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> findAll();
    Optional<Item> findById(int id);

}
