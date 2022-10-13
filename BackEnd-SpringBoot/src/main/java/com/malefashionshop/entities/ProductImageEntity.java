package com.malefashionshop.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="product_images")
public class ProductImageEntity extends BaseEntity {

    @Column(name="image_url")
    private String image_url;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private ProductEntity product;
}
