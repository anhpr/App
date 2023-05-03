package com.rest.app.service.impl;

import com.rest.app.entity.Inventory;
import com.rest.app.entity.Item;
import com.rest.app.entity.Order;
import com.rest.app.entity.User;
import com.rest.app.repository.InventoryRepository;
import com.rest.app.repository.ItemRepository;
import com.rest.app.repository.OrderRepository;
import com.rest.app.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderSeviceImpl implements OrderService {

    public static List<Item> itemsOrder = new ArrayList<>();

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Integer addToCart(Integer itemId) {
        Item item = itemRepository.findById(itemId).get();
        Inventory inventory = inventoryRepository.findByItem(item);
        if (inventory.getQuantity()>=1){
            inventory.setQuantity(inventory.getQuantity()-1);
            itemsOrder.add(item);
            inventoryRepository.save(inventory);
        }
        return itemsOrder.size();
    }

    @Override
    @Transactional
    public String confirmOrder(User user, double totalPrice) {
        String mes = "";
        if(user.getMoney() >= totalPrice){
            user.setMoney((float) (user.getMoney() - totalPrice));
            Order order = new Order();
            order.setUser(user);
            order.setListItem(itemsOrder);
            order.setStatus("completly payment");

            orderRepository.save(order);
            mes = "Payment success";
        }else {
            mes = "Not enough money to pay";
        }
        System.out.println(mes);
        return  mes;
    }
}
