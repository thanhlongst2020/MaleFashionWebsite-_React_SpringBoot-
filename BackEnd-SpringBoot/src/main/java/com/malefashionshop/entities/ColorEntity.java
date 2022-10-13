package com.malefashionshop.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="color")
public class ColorEntity extends BaseEntity {
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "color")
    List<ProductDetailEntity> productDetail = new ArrayList<>();
}
