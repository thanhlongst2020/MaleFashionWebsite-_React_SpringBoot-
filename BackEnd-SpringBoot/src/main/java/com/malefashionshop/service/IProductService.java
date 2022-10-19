package com.malefashionshop.service;

import com.malefashionshop.dto.request.CategoryUpdateDto;
import com.malefashionshop.dto.request.ProductUpdateDto;
import com.malefashionshop.dto.response.CategoryResponseDto;
import com.malefashionshop.dto.response.ProductResponseDto;

import java.util.List;

public interface IProductService {
    List<ProductResponseDto> getAllProducts();

    ProductResponseDto getProductById(Long id);

    ProductResponseDto createProduct(ProductUpdateDto dto);
}
