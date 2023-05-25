package com.company.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)

public class OrderDTO {

    private Integer id;

    private double price;

    private Integer employee_id;

    private Integer customer_id;

    private Integer product_id;
}
