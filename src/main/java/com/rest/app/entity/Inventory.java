package com.rest.app.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Inventory")
@Getter
@Setter
@NoArgsConstructor
public class Inventory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "inventoryId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Item item;

    @Column(name = "quantity")
    private int quantity;

}
