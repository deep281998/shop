package com.example.Shop.repository;

import com.example.Shop.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Companyrepository extends JpaRepository<Company , Integer> {


    @Query(value = "select b from Company b where b.companyname = :name")
    Optional<Company> findbyname(String name);

    @Query(value = "select b from Company b where b.companyname = :name")
    Company findbynameandreturncompany(String name);
}
