package com.malefashionshop.repository;

import com.malefashionshop.entities.AdminEntity;
import com.malefashionshop.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity,Long> {

}
