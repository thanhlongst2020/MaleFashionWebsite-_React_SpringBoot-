package com.malefashionshop.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="cart_item")
public class CartItemEntity extends BaseEntity {
    private int quantity;

    @ManyToOne()
    @JoinColumn(name = "cart_id")
    private CartEntity cart;

    @OneToOne()
    @JoinColumn(name = "product_detail_id")
    private ProductDetailEntity productDetail;
}
