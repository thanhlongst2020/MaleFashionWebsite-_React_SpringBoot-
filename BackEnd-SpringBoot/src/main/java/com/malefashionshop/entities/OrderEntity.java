package com.malefashionshop.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="order")
public class OrderEntity extends BaseEntity{
    @Column(name="total_price")
    private float totalPrice;

    @ManyToOne()
    @JoinColumn(name="customer_id")
    private CustomerEntity customer;

    @OneToMany(mappedBy = "order")
    private List<OrderItemEntity> orderItems = new ArrayList<>();
}
