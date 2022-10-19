package com.malefashionshop.controller;

import com.malefashionshop.dto.request.CategoryUpdateDto;
import com.malefashionshop.dto.request.TagUpdateDto;
import com.malefashionshop.dto.response.CategoryResponseDto;
import com.malefashionshop.dto.response.TagResponseDto;
import com.malefashionshop.service.impl.CategoryService;
import com.malefashionshop.service.impl.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("tags")
public class TagControllerController {

    @Autowired
    private TagService tagService;

    @GetMapping
    List<TagResponseDto> getAllTags(){
        return this.tagService.getAllTags();
    }

//    @GetMapping("/{id}")
//    CategoryResponseDto getCategoryById(@PathVariable("id") Long id){
//        return this.categoryService.getCategoryById(id);
//    }
//
    @PostMapping("/create")
//    @ResponseStatus(HttpStatus.CREATED)
    TagResponseDto createTag( @RequestBody TagUpdateDto dto){

        return this.tagService.createTag(dto);
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
