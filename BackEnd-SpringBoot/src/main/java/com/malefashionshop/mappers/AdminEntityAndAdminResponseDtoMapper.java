package com.malefashionshop.mappers;

import com.malefashionshop.dto.request.AdminUpdateDto;
import com.malefashionshop.dto.request.OrderUpdateDto;
import com.malefashionshop.dto.response.AdminResponseDto;
import com.malefashionshop.dto.response.OrderItemResponseDto;
import com.malefashionshop.dto.response.OrderResponseDto;
import com.malefashionshop.entities.AdminEntity;
import com.malefashionshop.entities.OrderEntity;
import com.malefashionshop.entities.RoleEntity;
import com.malefashionshop.exceptions.ResourceNotFoundException;
import com.malefashionshop.repository.OrderItemRepository;
import com.malefashionshop.repository.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AdminEntityAndAdminResponseDtoMapper {
    @Autowired
    RoleRepository roleRepository;

    public void map(AdminEntity adminEntity, AdminResponseDto adminResponseDto){
        BeanUtils.copyProperties(adminEntity, adminResponseDto);
        if(adminEntity.getRole() != null){
            adminResponseDto.setRoleID(adminEntity.getRole().getId());
        } else{
            adminResponseDto.setRoleID(null);
        }
    }

    public void map(AdminUpdateDto adminUpdateDto, AdminEntity adminEntity){
        BeanUtils.copyProperties(adminUpdateDto, adminEntity);

        Optional<RoleEntity> optionalRoleEntity = this.roleRepository.findById(adminUpdateDto.getRoleID());
        if(optionalRoleEntity.isEmpty()){
            throw new ResourceNotFoundException("Role with ID: " +adminUpdateDto.getRoleID()+ "can be not found");
        }
        adminEntity.setRole(optionalRoleEntity.get()); // Tạm thời
    }
}
