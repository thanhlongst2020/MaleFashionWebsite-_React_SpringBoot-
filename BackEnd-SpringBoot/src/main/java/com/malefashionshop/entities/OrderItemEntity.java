package com.malefashionshop.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="order_item")
public class OrderItemEntity extends BaseEntity {
    private int quantity;

    @ManyToOne()
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @OneToOne()
    @JoinColumn(name = "product_detail_id")
    private ProductDetailEntity productDetail;
}
