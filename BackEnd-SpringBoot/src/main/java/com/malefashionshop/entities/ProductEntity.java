package com.malefashionshop.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="product")
public class ProductEntity extends BaseEntity{

    @Column(name="name")
    private String name;

    @Column(name ="feature_image")
    private String feature_image;

    @Column(name="description")
    private String description;

    @Column(name="content")
    private String content;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne()
    @JoinColumn(name = "brand_id")
    private BrandEntity brand;

    @OneToMany(mappedBy = "product")
    private List<ProductImageEntity> product_images = new ArrayList<>();

    @ManyToMany(mappedBy = "products")
    private List<TagEntity> tags = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    List<RatingEntity> ratings = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    List<ProductImageEntity> images = new ArrayList<>();

}
