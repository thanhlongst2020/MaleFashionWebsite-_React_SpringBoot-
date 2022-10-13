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
@Table(name="role")
public class RoleEntity extends BaseEntity {
    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "role")
    List<AdminEntity> admin = new ArrayList<>();
}
