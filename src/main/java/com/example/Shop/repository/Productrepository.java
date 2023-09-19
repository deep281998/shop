package com.example.Shop.repository;

import com.example.Shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Productrepository extends JpaRepository<Product , Integer> {


    @Query(value = "select b from Product b where b.productname = :name")
    Optional<Product> findbyname(String name);
}
