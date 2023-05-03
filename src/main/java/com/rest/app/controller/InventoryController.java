package com.rest.app.controller;


import com.rest.app.entity.Inventory;
import com.rest.app.entity.Item;
import com.rest.app.service.InventoryService;
import com.rest.app.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/item")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ItemService itemService;


    @GetMapping()
    private ModelAndView getHome() {
        ModelAndView modelAndView = new ModelAndView();
        Item item = new Item();
        modelAndView.addObject("item", item);
        modelAndView.setViewName("CheckQuantityItem");
        return modelAndView;
    }

    @PostMapping("/check")
    private ModelAndView check(@ModelAttribute("item") Item item) {
        ModelAndView modelAndView = new ModelAndView();

        Optional<Item> item1 = itemService.findById(item.getId());
        if (item1.isPresent()) {
            Inventory inventory = inventoryService.getItemInInventory(item1.get());
            modelAndView.addObject("inventory", inventory);
            modelAndView.addObject("item", item1.get());
        } else {
            modelAndView.addObject("mes", "Item does not exit");
        }

        modelAndView.setViewName("CheckQuantityItem");
        return modelAndView;
    }


}
