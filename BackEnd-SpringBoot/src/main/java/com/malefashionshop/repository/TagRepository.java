package com.malefashionshop.repository;

import com.malefashionshop.entities.CategoryEntity;
import com.malefashionshop.entities.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<TagEntity,Long> {

    TagEntity findByCode(String code);
}
