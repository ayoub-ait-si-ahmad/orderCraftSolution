package com.orderCraftSpringApp.model.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stock")
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stockManagerID")
    private Long stockManagerID;

    @OneToMany(mappedBy = "stock", cascade = CascadeType.ALL)
    private List<Item> items;
}