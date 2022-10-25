package com.malefashionshop.dto.response;

import com.malefashionshop.entities.RoleEntity;
import lombok.Data;

@Data
public class AdminResponseDto {
    private Long id;
    private String name;
    private Long roleID;
}
