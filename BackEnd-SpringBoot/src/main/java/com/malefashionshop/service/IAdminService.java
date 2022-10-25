package com.malefashionshop.service;

import com.malefashionshop.dto.request.AdminUpdateDto;
import com.malefashionshop.dto.request.CategoryUpdateDto;
import com.malefashionshop.dto.response.AdminResponseDto;
import com.malefashionshop.dto.response.CategoryResponseDto;
import com.malefashionshop.dto.response.ResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IAdminService {
    public List<AdminResponseDto> getAllAdmins();

    AdminResponseDto createAdmin(AdminUpdateDto dto);
}
