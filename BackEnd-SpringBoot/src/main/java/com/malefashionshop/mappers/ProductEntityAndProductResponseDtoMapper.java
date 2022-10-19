package com.malefashionshop.mappers;

import com.malefashionshop.dto.response.ProductResponseDto;
import com.malefashionshop.entities.ProductEntity;
import com.malefashionshop.entities.ProductImageEntity;
import com.malefashionshop.entities.TagEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductEntityAndProductResponseDtoMapper {
    public ProductResponseDto map(ProductEntity productEntity){
        ProductResponseDto customProductResponseDto = new ProductResponseDto();

        //Set some special attributes of ProductResponseDto class
        customProductResponseDto.setCategoryName(productEntity.getCategory().getName());

        customProductResponseDto.setBrandName(productEntity.getBrand().getName());

        List<ProductImageEntity> images = productEntity.getImages();
        List<String> listImages = new ArrayList<String>();
        images.forEach(image -> {
            listImages.add(image.getUrl());
        });
        customProductResponseDto.setImageUrls(listImages);

        List<TagEntity> tags = productEntity.getTags();
        List<String> listTags= new ArrayList<String>();
        tags.forEach(tag -> {
            listTags.add(tag.getCode());
        });
        customProductResponseDto.setListTags(listTags);

        return customProductResponseDto;
    }
}
