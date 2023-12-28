package com.orderCraftSpringApp.model.classes;

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
@Table(name = "salesReports")
public class SalesReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reportID")
    private Long reportID;

    @Column(name="reportSerialNumber")
    private String reportSerialNumber;

    @OneToMany(mappedBy = "salesReport", cascade = CascadeType.ALL)
    private List<Order> orders;
}