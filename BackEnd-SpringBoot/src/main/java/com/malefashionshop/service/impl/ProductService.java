package com.malefashionshop.service.impl;

import com.malefashionshop.dto.request.ProductUpdateDto;
import com.malefashionshop.dto.response.CategoryResponseDto;
import com.malefashionshop.dto.response.ProductResponseDto;
import com.malefashionshop.entities.*;
import com.malefashionshop.entities.enums.DeleteEnum;
import com.malefashionshop.exceptions.ResourceNotFoundException;
import com.malefashionshop.mappers.ProductEntityAndProductResponseDtoMapper;
import com.malefashionshop.repository.*;
import com.malefashionshop.service.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductImageRepository productImageRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductEntityAndProductResponseDtoMapper productEntityAndProductResponseDtoMapper;

    @Override
    public List<ProductResponseDto> getAllProducts() {
        List<ProductEntity> listProductEntity =  this.productRepository.findAll();
        List<ProductResponseDto> results = new ArrayList<>();

        listProductEntity.forEach(productEntity ->{

            ProductResponseDto customProductResponseDto = new ProductResponseDto();

            customProductResponseDto = productEntityAndProductResponseDtoMapper.map(productEntity);
//            productEntity.getImages().forEach(image -> {
//                System.out.println("-----------------------" + image.getUrl());
//            });
            modelMapper.map(productEntity, customProductResponseDto);

            results.add(customProductResponseDto);
        });

        return results;
    }

    @Override
    public ProductResponseDto getProductById(Long id) {
        Optional<ProductEntity> optionalProductEntity = this.productRepository.findById(id);

        if(optionalProductEntity.isEmpty()){
            throw new ResourceNotFoundException("Product Not Found");
        }

        ProductResponseDto customProductResponseDto =  productEntityAndProductResponseDtoMapper.map(optionalProductEntity.get());
        this.modelMapper.map(optionalProductEntity.get(), customProductResponseDto);

        return customProductResponseDto;
    }

    @Override
    public ProductResponseDto createProduct(ProductUpdateDto dto) {
        ProductEntity productEntity = modelMapper.map(dto, ProductEntity.class);

        //Set Brand object for productEntity to save to DB
        Optional<BrandEntity> optionalBrandEntity =  brandRepository.findById(dto.getBrandId());
        if(optionalBrandEntity.isEmpty()){
            throw new ResourceNotFoundException("Brand ID of product is not found");
        }
        productEntity.setBrand(optionalBrandEntity.get());

        //Set featureImage for productEntity to save to DB
        Optional<ProductImageEntity> optionalProductImageEntity =  productImageRepository.findById(dto.getFeatureImageID());
        if(optionalProductImageEntity.isEmpty()){
            throw new ResourceNotFoundException("Feature Image ID of product is not found");
        }
        productEntity.setFeatureImage(optionalProductImageEntity.get().getUrl());

        //Set CategoryEntity for productEntity to save to DB
        Optional<CategoryEntity> optionalCategoryEntity  =  categoryRepository.findById(dto.getCategoryId());
        if(optionalCategoryEntity.isEmpty()){
            throw new ResourceNotFoundException("Category ID of product is not found");
        }
        productEntity.setCategory(optionalCategoryEntity.get());

        //Set ProductImageEntity for productEntity to save to DB
        //Prepare list of productImage url for ProductResponseDto
        List<String> imageUrls = new ArrayList<>();
        List<ProductImageEntity> listProductImageEntity = new ArrayList<>();
        dto.getImageDetailIDs().forEach(imageDetailID ->{
            Optional<ProductImageEntity> productImageEntity = this.productImageRepository.findById(imageDetailID);
            if(productImageEntity.isEmpty()){
                throw new ResourceNotFoundException("Product Image ID:"+imageDetailID+" of product is not found");
            }
            imageUrls.add(productImageEntity.get().getUrl());
            listProductImageEntity.add(productImageEntity.get());
        });
        productEntity.setImages(listProductImageEntity);

        //Set TagEntity for productEntity to save to DB
        //Prepare list of tag name for ProductResponseDto
        List<String> listTags = new ArrayList<>();
        List<TagEntity> listTagEntity = new ArrayList<>();
        dto.getTagDetailsIDs().forEach(tagDetailsID ->{
            Optional<TagEntity> optionalTagEntity = this.tagRepository.findById(tagDetailsID);
            if(optionalTagEntity.isEmpty()){
                throw new ResourceNotFoundException("Product Tag ID:"+tagDetailsID+" of product is not found");
            }
            listTags.add(optionalTagEntity.get().getCode());
            listTagEntity.add(optionalTagEntity.get());
        });
        productEntity.setTags(listTagEntity);

        productEntity.setDeleteEnum(DeleteEnum.ACTIVE);

        //Save new productEntity to DB
        ProductEntity savedProductEntity = this.productRepository.save(productEntity);

        optionalProductImageEntity.get().setProduct(savedProductEntity);
        listProductImageEntity.forEach(productImageEntity -> {
            productImageEntity.setProduct(savedProductEntity);
            this.productImageRepository.save(productImageEntity);
        });


        //Set attribute for ProductResponseDto
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setBrandName(optionalBrandEntity.get().getName());
        productResponseDto.setFeatureImage(optionalProductImageEntity.get().getUrl());
        productResponseDto.setCategoryName(optionalCategoryEntity.get().getName());
        productResponseDto.setImageUrls(imageUrls);
        productResponseDto.setListTags(listTags);

        modelMapper.map(savedProductEntity,productResponseDto);

        return productResponseDto;
    }


}
