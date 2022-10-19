package com.malefashionshop.repository;

import com.malefashionshop.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
//    List<ProductEntity> findAllByStateActive();
}
