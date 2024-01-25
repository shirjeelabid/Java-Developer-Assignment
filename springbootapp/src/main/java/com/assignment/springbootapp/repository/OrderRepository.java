package com.assignment.springbootapp.repository;

import com.assignment.springbootapp.dto.GetMostReOrderedResponse;
import com.assignment.springbootapp.dto.GetTopProductsResponse;
import com.assignment.springbootapp.dto.GetTopUsersResponse;
import com.assignment.springbootapp.entity.Order;
import com.assignment.springbootapp.entity.User;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT new com.assignment.springbootapp.dto.GetTopUsersResponse( u.userId,u.userName, COUNT(o.quantity)) " +
            "FROM User u " +
            "JOIN u.orders o " +
            "GROUP BY u " +
            "ORDER BY COUNT(o.quantity) DESC")
    List<GetTopUsersResponse> findTop3UsersOrderedMostProducts(PageRequest pageRequest);



    @Query("SELECT new com.assignment.springbootapp.dto.GetTopProductsResponse( p.productName, COUNT(o))" +
            "FROM Product p " +
            "JOIN p.orders o " +
            "GROUP BY p " +
            "ORDER BY COUNT(o) DESC")
    List<GetTopProductsResponse> findTop3MostOrderedProducts(PageRequest pageRequest);
    @Query(value = "SELECT o FROM Order o WHERE o.user = :user ORDER BY o.orderDate ASC")
    List<Order> findUserFirstOrder(@Param("user") User user, PageRequest pageRequest);

    @Query(value = "SELECT new com.assignment.springbootapp.dto.GetMostReOrderedResponse(op.product.productName, COUNT(op.order.quantity)) " +
            "FROM OrderProduct op " +
            "WHERE op.order = :order " +
            "GROUP BY op.product " +
            "ORDER BY COUNT(op.order.quantity) DESC")
    List<GetMostReOrderedResponse> findTop3ReorderedProducts(@Param("order") Order order, PageRequest pageRequest);






}
