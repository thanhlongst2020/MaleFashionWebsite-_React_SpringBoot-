package com.malefashionshop.controller;

import com.malefashionshop.dto.request.CategoryUpdateDto;
import com.malefashionshop.dto.request.ProductUpdateDto;
import com.malefashionshop.dto.response.CategoryResponseDto;
import com.malefashionshop.dto.response.ProductResponseDto;
import com.malefashionshop.service.impl.CategoryService;
import com.malefashionshop.service.impl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductResponseDto> getAllProducts(){
        return this.productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ProductResponseDto getProductById(@PathVariable Long id){
        return this.productService.getProductById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ProductResponseDto createProduct(@RequestBody ProductUpdateDto dto){
        return this.productService.createProduct(dto);
    }
}
