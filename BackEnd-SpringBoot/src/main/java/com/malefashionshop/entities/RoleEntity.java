package com.malefashionshop.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="role")
public class RoleEntity  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "role")
    List<AdminEntity> admins;

    @OneToMany(mappedBy = "role")
    List<CustomerEntity> customers;

    @PreRemove
    private void preRemove() {
        this.customers.forEach(customer->{
            customer.setRole(null);
        });

        this.admins.forEach(admin->{
            admin.setRole(null);
        });
    }
}
