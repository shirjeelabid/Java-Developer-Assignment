package com.assignment.springbootapp.service;

import com.assignment.springbootapp.dto.GetMostReOrderedResponse;
import com.assignment.springbootapp.dto.GetTopProductsResponse;
import com.assignment.springbootapp.dto.GetTopUsersResponse;

import java.util.List;

public interface TestService {

    public List<GetTopUsersResponse> getTopUsers();

    public List<GetTopProductsResponse> getTopMostOrderedProducts();

    public List<GetMostReOrderedResponse> getMostReOrderedProducts();
}
