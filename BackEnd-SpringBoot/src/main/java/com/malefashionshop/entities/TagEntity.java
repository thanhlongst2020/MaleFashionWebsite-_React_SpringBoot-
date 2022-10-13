package com.malefashionshop.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="tag")
public class TagEntity extends BaseEntity {

    @Column(name = "code")
    private String code;

    @ManyToMany
    @JoinTable(name = "product_tag", joinColumns = @JoinColumn(name = "tag_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<ProductEntity> products = new ArrayList<>();


}
