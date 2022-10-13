package com.malefashionshop.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="cart")
public class CartEntity extends BaseEntity{
    @Column(name="total_price")
    private float totalPrice;

    @ManyToOne()
    @JoinColumn(name="customer_id")
    private CustomerEntity customer;

    @OneToMany(mappedBy = "cart")
    private List<CartItemEntity> cartItems = new ArrayList<>();
}
