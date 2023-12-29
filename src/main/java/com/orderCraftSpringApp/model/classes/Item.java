package com.orderCraftSpringApp.model.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="itemID")
    private Long itemID;

    @Column(name="itemName")
    private String itemName;

    @Column(name="itemDescription")
    private String itemDescription;

    @Column(name="itemPrice")
    private Double itemPrice;

    @Column(name="quantity")
    private Integer quantity;

 
}