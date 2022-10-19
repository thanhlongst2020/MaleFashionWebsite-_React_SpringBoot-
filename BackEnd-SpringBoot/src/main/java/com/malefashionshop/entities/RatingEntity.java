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
@Table(name="rating")
public class RatingEntity extends BaseEntity {

    @Column(name="comment")
    private String comment;

    @Column(name="score")
    private float score;

    @ManyToOne()
    @JoinColumn(name="customer_id")
    private CustomerEntity customer;

    @ManyToOne()
    @JoinColumn(name="product_id")
    private ProductEntity product;


}
