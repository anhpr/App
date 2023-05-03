package com.rest.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Item")
@Getter
@Setter
@NoArgsConstructor
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "itemId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "image")
    private String image;

    @Column(name = "des")
    private String description;

    @Column(name = "price")
    private float price;

    @ManyToMany(mappedBy = "listItem")
    private List<Order> listOrder;

    @OneToOne(mappedBy = "item")
    @JoinColumn(name = "inventoryId")
    private Inventory inventory;


}
