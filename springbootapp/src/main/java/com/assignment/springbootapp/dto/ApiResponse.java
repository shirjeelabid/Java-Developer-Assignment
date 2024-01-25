package com.assignment.springbootapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ApiResponse<T> {
    private Integer statusCode;
    private String statusDescription;
    private T result;
}
