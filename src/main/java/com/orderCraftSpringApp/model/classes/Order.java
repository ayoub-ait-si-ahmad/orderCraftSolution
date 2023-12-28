package com.orderCraftSpringApp.model.classes;

import com.orderCraftSpringApp.model.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="orderID")
    private Long orderID;

    @Column(name="orderSerial")
    private String orderSerial;

    @Column(name="orderDate")
    private String orderDate;

    @Enumerated(EnumType.STRING)
    @Column(name="orderStatus")
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name="UserID", nullable = false)
    private User orderClient;

    @ManyToOne
    @JoinColumn(name="reportID", nullable = false)
    private SalesReport salesReport;

    @ManyToMany
    @JoinTable(
            name = "order_item",
            joinColumns = @JoinColumn(name = "orderID"),
            inverseJoinColumns = @JoinColumn(name = "itemID")
    )
    private List<Item> orderItems;
}