package com.malefashionshop.repository;

import com.malefashionshop.entities.AdminEntity;
import com.malefashionshop.entities.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity,Long> {

}
