package com.malefashionshop.dto.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder(toBuilder=true)
public class BrandUpdateDto {
    @NotBlank(message = "Tag code is required")
    private String code;

    private String name;


}
