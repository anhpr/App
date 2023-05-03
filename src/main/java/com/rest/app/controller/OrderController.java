package com.rest.app.controller;

import com.rest.app.entity.Inventory;
import com.rest.app.entity.Item;
import com.rest.app.entity.Order;
import com.rest.app.entity.User;
import com.rest.app.service.InventoryService;
import com.rest.app.service.ItemService;
import com.rest.app.service.OrderService;
import com.rest.app.service.impl.OrderSeviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/order")
public class OrderController {


    @Autowired
    private ItemService itemService;

    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ModelAndView orderPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsOrder", OrderSeviceImpl.itemsOrder);
        modelAndView.addObject("totalPrice", OrderSeviceImpl.itemsOrder.stream().mapToDouble(x -> x.getPrice()).sum());
        modelAndView.setViewName("Order");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addOrder(HttpServletRequest httpServletRequest, @RequestParam("itemId") Integer itemId){
        httpServletRequest.setAttribute("cartSize", orderService.addToCart(itemId));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Home");
        List<Item> items = itemService.findAll();
        List<Item> itemListResponse = items.stream().filter(item -> inventoryService.getItemInInventory(item).getQuantity()!=0).collect(Collectors.toList());
        modelAndView.addObject("items",itemListResponse);
        return modelAndView;
    }

    @PostMapping("/confirm")
    public ModelAndView confirmOrder(@RequestParam("totalPrice") Double totalPrice){
        ModelAndView modelAndView = new ModelAndView();
        List<Item> items = OrderSeviceImpl.itemsOrder;
        User user = UserController.userCurrent;
        String mes = orderService.confirmOrder(user, totalPrice);
        modelAndView.addObject("mes", mes);
        modelAndView.setViewName("Order");
        return modelAndView;
    }
}
