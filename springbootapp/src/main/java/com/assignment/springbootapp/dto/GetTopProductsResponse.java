package com.assignment.springbootapp.dto;

import lombok.Data;

@Data
public class GetTopProductsResponse {
    private String productName;
    private Long totalOrders;

    public GetTopProductsResponse(String productName, Long totalOrders) {
        this.productName = productName;
        this.totalOrders = totalOrders;
    }
}
