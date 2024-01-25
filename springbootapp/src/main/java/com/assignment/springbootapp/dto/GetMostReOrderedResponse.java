package com.assignment.springbootapp.dto;

import lombok.Data;

@Data
public class GetMostReOrderedResponse {
    private String productName;
    private Long totalReordered;

    public GetMostReOrderedResponse(String productName, Long totalReordered) {
        this.productName = productName;
        this.totalReordered = totalReordered;
    }
}
