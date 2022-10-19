package com.malefashionshop.service;

import com.malefashionshop.dto.request.BrandUpdateDto;
import com.malefashionshop.dto.request.CategoryUpdateDto;
import com.malefashionshop.dto.response.BrandResponseDto;
import com.malefashionshop.dto.response.CategoryResponseDto;

import java.util.List;

public interface IBrandService {
    BrandResponseDto createBrand(BrandUpdateDto dto);
}
