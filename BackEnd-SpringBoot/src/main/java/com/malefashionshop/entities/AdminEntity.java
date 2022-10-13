package com.malefashionshop.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="admin")
public class AdminEntity extends BaseEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @ManyToOne()
    @JoinColumn(name = "role_id")
    private RoleEntity role;
}