package com.malefashionshop.dto.response;

import com.malefashionshop.entities.CartEntity;
import com.malefashionshop.entities.OrderEntity;
import com.malefashionshop.entities.RatingEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Data
public class CustomerResponseDto {
    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

    private String address;

    private String roleName;
}
