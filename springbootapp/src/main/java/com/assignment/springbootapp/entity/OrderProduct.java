package com.assignment.springbootapp.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "order_product")
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_product_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", foreignKey = @ForeignKey(name = "order_product_order_fk"))
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", foreignKey = @ForeignKey(name = "order_product_product_fk"))
    private Product product;
}
