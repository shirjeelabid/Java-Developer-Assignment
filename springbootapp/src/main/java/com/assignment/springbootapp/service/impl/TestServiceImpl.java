package com.assignment.springbootapp.service.impl;

import com.assignment.springbootapp.dto.GetMostReOrderedResponse;
import com.assignment.springbootapp.dto.GetTopProductsResponse;
import com.assignment.springbootapp.dto.GetTopUsersResponse;
import com.assignment.springbootapp.entity.Order;
import com.assignment.springbootapp.entity.User;
import com.assignment.springbootapp.repository.OrderRepository;
import com.assignment.springbootapp.repository.UserRepository;
import com.assignment.springbootapp.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;
    @Override
    public List<GetTopUsersResponse> getTopUsers() {
        log.info(":::   TestServiceImpl.getTopUsers     :::");
        List<GetTopUsersResponse> list = orderRepository.findTop3UsersOrderedMostProducts(PageRequest.of(0,3));
        return list;
    }

    public List<GetTopProductsResponse> getTopMostOrderedProducts() {
        log.info(":::   TestServiceImpl.getTopMostOrderedProducts     :::");
        List<GetTopProductsResponse> list = orderRepository.findTop3MostOrderedProducts(PageRequest.of(0,3));
        return list;
    }

    @Override
    public List<GetMostReOrderedResponse> getMostReOrderedProducts() {
        log.info(":::   TestServiceImpl.getTopMostOrderedProducts     :::");

        List<User> users = userRepository.findAll();

        List<GetMostReOrderedResponse> responseList = new ArrayList<>();

        for(User user : users){
            List<Order> firstOrders = orderRepository.findUserFirstOrder(user,PageRequest.of(0, 1));

            if (!firstOrders.isEmpty()) {
                Order firstOrder = firstOrders.get(0);
                List<GetMostReOrderedResponse> top3Products = orderRepository.findTop3ReorderedProducts(firstOrder, PageRequest.of(0, 3));
                responseList.addAll(top3Products);
            }
        }
        return responseList;
    }
}
