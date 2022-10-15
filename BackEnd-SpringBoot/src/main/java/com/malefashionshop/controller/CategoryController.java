package com.malefashionshop.controller;

import com.malefashionshop.dto.request.CategoryUpdateDto;
import com.malefashionshop.dto.response.CategoryResponseDto;
import com.malefashionshop.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    List<CategoryResponseDto> getCategories(){
        return this.categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    CategoryResponseDto getCategoryById(@PathVariable("id") Long id){
        return this.categoryService.getCategoryById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    CategoryResponseDto createCategory(@Valid @RequestBody CategoryUpdateDto dto){
        return this.categoryService.createCategory(dto);
    }

    @PutMapping("/{id}")
    CategoryResponseDto updateCategory(@PathVariable("id") Long id,@Valid @RequestBody CategoryUpdateDto dto ){
        return this.categoryService.updateCategory(id, dto);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deletePost(@PathVariable Long id) {
        this.categoryService.deleteCategory(id);
        return HttpStatus.OK;
    }

}
