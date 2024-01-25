package com.assignment.springbootapp.repository;

import com.assignment.springbootapp.entity.Order;
import com.assignment.springbootapp.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
