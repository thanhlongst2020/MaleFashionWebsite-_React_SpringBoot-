package com.malefashionshop.dto.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder(toBuilder=true)
public class AdminUpdateDto {
    private String name;
    private String password;
    private Long roleID;


}
