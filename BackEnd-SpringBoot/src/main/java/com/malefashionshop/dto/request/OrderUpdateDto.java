package com.malefashionshop.dto.request;

import com.malefashionshop.dto.response.OrderItemResponseDto;
import com.malefashionshop.entities.CustomerEntity;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder(toBuilder=true)
public class OrderUpdateDto {

    private Long customerID;

    private List<Long> orderItemID;


}
