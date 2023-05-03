package com.rest.app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "userID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userName", unique = true, nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "money")
    private float money;

    @OneToMany(mappedBy = "user")
    private List<Order> orderList;

    public void setMoney() {
        this.money = 100000;
    }
}
