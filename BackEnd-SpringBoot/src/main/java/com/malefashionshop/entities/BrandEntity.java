package com.malefashionshop.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="brand")
public class BrandEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<ProductEntity> products = new ArrayList<>();

}
