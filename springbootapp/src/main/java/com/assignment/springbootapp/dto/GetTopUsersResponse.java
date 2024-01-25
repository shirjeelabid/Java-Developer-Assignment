package com.assignment.springbootapp.dto;

import lombok.Data;

@Data
public class GetTopUsersResponse {
    private Integer userId;
    private String userName;
    private Long totalOrders;

    public GetTopUsersResponse(Integer userId, String userName, Long totalOrders) {
        this.userId = userId;
        this.userName = userName;
        this.totalOrders = totalOrders;
    }
}
