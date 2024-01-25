package com.assignment.springbootapp.repository;

import com.assignment.springbootapp.entity.Order;
import com.assignment.springbootapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
