package com.malefashionshop.mappers;

import com.malefashionshop.dto.request.AdminUpdateDto;
import com.malefashionshop.dto.request.CustomerUpdateDto;
import com.malefashionshop.dto.response.AdminResponseDto;
import com.malefashionshop.dto.response.CustomerResponseDto;
import com.malefashionshop.dto.response.RoleResponseDto;
import com.malefashionshop.entities.AdminEntity;
import com.malefashionshop.entities.CustomerEntity;
import com.malefashionshop.entities.RoleEntity;
import com.malefashionshop.exceptions.ResourceNotFoundException;
import com.malefashionshop.repository.RoleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerEntityAndCustomerResponseDtoMapper {

    @Autowired
    RoleRepository roleRepository;


    public void map(CustomerEntity customerEntity, CustomerResponseDto customerResponseDto){
        BeanUtils.copyProperties(customerEntity, customerResponseDto);
        if(customerEntity.getRole() == null){
            customerResponseDto.setRoleName(null);
        } else{
            customerResponseDto.setRoleName(customerEntity.getRole().getName());
        }
    }

    public void map(CustomerUpdateDto customerUpdateDto, CustomerEntity customerEntity){
        BeanUtils.copyProperties(customerUpdateDto, customerEntity);

        if(customerUpdateDto.getRoleID() == null){
            customerEntity.setRole(null);
        } else{
            Optional<RoleEntity> optionalRoleEntity = this.roleRepository.findById(customerUpdateDto.getRoleID());
            if(optionalRoleEntity.isEmpty()){
                throw new ResourceNotFoundException("Role with ID: "+customerUpdateDto.getRoleID()+"can be not found");
            }
            customerEntity.setRole(optionalRoleEntity.get());
        }

    }
}
