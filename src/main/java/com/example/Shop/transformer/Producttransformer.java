package com.example.Shop.transformer;

import com.example.Shop.dtos.reqdtos.Productreqdtos;
import com.example.Shop.model.Company;
import com.example.Shop.model.Product;
import com.example.Shop.repository.Companyrepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Producttransformer {


    public  static  Product prodtostopro(Productreqdtos productreqdtos , Company company){

        return Product.builder()
                .productname(productreqdtos.getName())
                .mrp(productreqdtos.getMrp())
                .sellingcost(productreqdtos.getSellingcost())
                .company(company)
                .quantity(0)
                .build();
    }
}
