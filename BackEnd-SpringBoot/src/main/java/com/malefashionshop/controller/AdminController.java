package com.malefashionshop.controller;

import com.malefashionshop.dto.request.AdminUpdateDto;
import com.malefashionshop.dto.request.CategoryUpdateDto;
import com.malefashionshop.dto.response.AdminResponseDto;
import com.malefashionshop.dto.response.CategoryResponseDto;
import com.malefashionshop.dto.response.ResponseDto;
import com.malefashionshop.service.impl.AdminService;
import com.malefashionshop.service.impl.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping
    List<AdminResponseDto> getAdmins(){
        return this.adminService.getAllAdmins();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    AdminResponseDto createAdmin(@Valid @RequestBody AdminUpdateDto dto){
        return this.adminService.createAdmin(dto);
    }



}
