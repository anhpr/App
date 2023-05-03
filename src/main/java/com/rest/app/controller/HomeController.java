package com.rest.app.controller;

import com.rest.app.entity.Item;
import com.rest.app.service.InventoryService;
import com.rest.app.service.ItemService;
import com.rest.app.service.impl.OrderSeviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
public class HomeController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/")
    public ModelAndView homePage(){
        ModelAndView modelAndView = new ModelAndView();
        List<Item> items = itemService.findAll();
        modelAndView.addObject("items",items);
        modelAndView.addObject("cartSize", OrderSeviceImpl.itemsOrder.size());
        modelAndView.setViewName("Home");
        return  modelAndView;
    }
}
