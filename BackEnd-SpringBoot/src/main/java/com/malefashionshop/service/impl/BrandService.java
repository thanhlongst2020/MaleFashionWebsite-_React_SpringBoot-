package com.malefashionshop.service.impl;

import com.malefashionshop.dto.request.BrandUpdateDto;
import com.malefashionshop.dto.request.CategoryUpdateDto;
import com.malefashionshop.dto.response.BrandResponseDto;
import com.malefashionshop.dto.response.CategoryResponseDto;
import com.malefashionshop.entities.BrandEntity;
import com.malefashionshop.entities.CategoryEntity;
import com.malefashionshop.exceptions.ResourceNotFoundException;
import com.malefashionshop.repository.BrandRepository;
import com.malefashionshop.repository.CategoryRepository;
import com.malefashionshop.service.IBrandService;
import com.malefashionshop.service.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandService implements IBrandService {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BrandResponseDto createBrand(BrandUpdateDto dto) {
        BrandEntity brandEntity = modelMapper.map(dto, BrandEntity.class);
        BrandEntity savedbrandEntity = this.brandRepository.save(brandEntity);

        return modelMapper.map(savedbrandEntity, BrandResponseDto.class);
    }
}
