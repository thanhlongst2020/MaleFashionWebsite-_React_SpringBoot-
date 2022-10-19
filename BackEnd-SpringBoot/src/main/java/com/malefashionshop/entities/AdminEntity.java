package com.malefashionshop.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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