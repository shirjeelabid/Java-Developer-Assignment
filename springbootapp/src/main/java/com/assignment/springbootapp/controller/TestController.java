package com.assignment.springbootapp.controller;

import com.assignment.springbootapp.common.Constants;
import com.assignment.springbootapp.dto.ApiResponse;
import com.assignment.springbootapp.dto.GetMostReOrderedResponse;
import com.assignment.springbootapp.dto.GetTopProductsResponse;
import com.assignment.springbootapp.dto.GetTopUsersResponse;
import com.assignment.springbootapp.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    TestService testService;

    @GetMapping("/task-1")
    public ResponseEntity<?> getTop3Users(){
        log.info(":::   TestController.getTopUsers      :::");
        ApiResponse<List<GetTopUsersResponse>> apiResponse = new ApiResponse<>(Constants.SUCCESS_CODE,Constants.SUCCESS_DESCRIPTION,testService.getTopUsers());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }


    @GetMapping("/task-2")
    public ResponseEntity<?> getTop3MostOrderProducts(){
        log.info(":::   TestController.getTop3MostOrderProducts      :::");
        ApiResponse<List<GetTopProductsResponse>> apiResponse = new ApiResponse<>(Constants.SUCCESS_CODE,Constants.SUCCESS_DESCRIPTION,testService.getTopMostOrderedProducts());
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }

    @GetMapping("/task-3")
    public ResponseEntity<?> getTop3MostReOrderedProducts(){
        log.info(":::   TestController.getTop3MostOrderProducts      :::");
        ApiResponse<List<GetMostReOrderedResponse>> apiResponse = new ApiResponse<>(Constants.SUCCESS_CODE,Constants.SUCCESS_DESCRIPTION,testService.getMostReOrderedProducts());
        return new ResponseEntity<>(apiResponse,HttpStatus.OK);
    }
}
