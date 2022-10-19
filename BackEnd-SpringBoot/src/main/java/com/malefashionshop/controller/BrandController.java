package com.malefashionshop.controller;

import com.malefashionshop.dto.request.BrandUpdateDto;
import com.malefashionshop.dto.request.CategoryUpdateDto;
import com.malefashionshop.dto.request.TagUpdateDto;
import com.malefashionshop.dto.response.BrandResponseDto;
import com.malefashionshop.dto.response.CategoryResponseDto;
import com.malefashionshop.dto.response.TagResponseDto;
import com.malefashionshop.service.impl.BrandService;
import com.malefashionshop.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private BrandService brandService;

//    @GetMapping
//    List<BrandResponseDto> getAllBrands(){
//        return this.brandService.getAllBrands();
//    }

//    @GetMapping("/{id}")
//    CategoryResponseDto getCategoryById(@PathVariable("id") Long id){
//        return this.categoryService.getCategoryById(id);
//    }
//
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    BrandResponseDto createBrand(@RequestBody BrandUpdateDto dto){
        return this.brandService.createBrand(dto);
    }
//
//    @PutMapping("/{id}")
//    CategoryResponseDto updateCategory(@PathVariable("id") Long id,@Valid @RequestBody CategoryUpdateDto dto ){
//        return this.categoryService.updateCategory(id, dto);
//    }
//
//    @DeleteMapping("/{id}")
//    public HttpStatus deletePost(@PathVariable Long id) {
//        this.categoryService.deleteCategory(id);
//        return HttpStatus.OK;
//    }

}
