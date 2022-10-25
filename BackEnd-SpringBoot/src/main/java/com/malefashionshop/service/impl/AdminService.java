package com.malefashionshop.service.impl;

import com.malefashionshop.dto.request.AdminUpdateDto;
import com.malefashionshop.dto.request.CategoryUpdateDto;
import com.malefashionshop.dto.response.AdminResponseDto;
import com.malefashionshop.dto.response.CategoryResponseDto;
import com.malefashionshop.dto.response.ResponseDto;
import com.malefashionshop.entities.AdminEntity;
import com.malefashionshop.entities.CategoryEntity;
import com.malefashionshop.exceptions.ResourceNotFoundException;
import com.malefashionshop.mappers.AdminEntityAndAdminResponseDtoMapper;
import com.malefashionshop.repository.AdminRepository;
import com.malefashionshop.repository.CategoryRepository;
import com.malefashionshop.service.IAdminService;
import com.malefashionshop.service.ICategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService implements IAdminService {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    AdminEntityAndAdminResponseDtoMapper adminEntityAndResponseDtoMapper;

    @Override
    public List<AdminResponseDto> getAllAdmins() {
        List<AdminEntity> listAdminEntity  = this.adminRepository.findAll();
        List<AdminResponseDto> listAdminResponseDto = new ArrayList<>();
        listAdminEntity.forEach(adminEntity->{
            AdminResponseDto adminResponseDto = new AdminResponseDto();
            this.adminEntityAndResponseDtoMapper.map(adminEntity, adminResponseDto);
            listAdminResponseDto.add(adminResponseDto);
        });
        return listAdminResponseDto;
    }

    @Override
    public AdminResponseDto createAdmin(AdminUpdateDto dto) {
        AdminEntity adminEntity = new AdminEntity();
        this.adminEntityAndResponseDtoMapper.map(dto,adminEntity);

        this.adminRepository.save(adminEntity);

        AdminResponseDto adminResponseDto = new AdminResponseDto();
        this.adminEntityAndResponseDtoMapper.map(adminEntity,adminResponseDto);

        return adminResponseDto;
    }
}
