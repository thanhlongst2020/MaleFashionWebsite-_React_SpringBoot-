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
@Table(name="product_detail")
public class ProductDetailEntity extends BaseEntity {
    @Column(name="name")
    private String name;

    @Column(name="price")
    private float price;

    @Column(name="quantity")
    private int quantity;

    @ManyToOne()
    @JoinColumn(name="product_id")
    private ProductEntity product;

    @ManyToOne()
    @JoinColumn(name = "size_id")
    private SizeEntity size;

    @ManyToOne()
    @JoinColumn(name = "color_id")
    private ColorEntity color;

    @OneToOne(mappedBy = "productDetail")
    private OrderItemEntity orderItem;

    @OneToOne()
    private CartEntity cartEntity;

}
