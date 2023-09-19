package com.example.Shop.service;

import com.example.Shop.dtos.reqdtos.Productreqdtos;
import com.example.Shop.dtos.respodtos.ProductRespodtos;
import com.example.Shop.exception.CompanyNotFoundException;
import com.example.Shop.exception.ProductNotFoundException;
import com.example.Shop.exception.WrongSellingCostException;
import com.example.Shop.model.Company;
import com.example.Shop.model.Product;
import com.example.Shop.repository.Companyrepository;
import com.example.Shop.repository.Productrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.Shop.transformer.Producttransformer.prodtostopro;


@Service
public class Productservice {

    @Autowired
    Companyrepository companyrepository;
    @Autowired
    Productrepository productrepository;

    public String addproduct( Productreqdtos productreqdtos) {
        Optional<Company> optionalCompany = companyrepository.findbyname(productreqdtos.getCompanyname());
        if(optionalCompany.isEmpty()){
            throw new CompanyNotFoundException("company not present");
        }
        if(productreqdtos.getSellingcost() > productreqdtos.getMrp()){
            throw new WrongSellingCostException("Selling cost greater than mrp");
        }
        Company company = optionalCompany.get();
        Product product = prodtostopro(productreqdtos , company);
        productrepository.save(product);
        return "Succesfull";
    }


    public ProductRespodtos updatequantity(String name, int quantity) {
        Optional<Product> optionalProduct = productrepository.findbyname(name);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("add product first");
        }
        Product product = optionalProduct.get();
        product.setQuantity(product.getQuantity()+quantity);
        productrepository.save(product);
        return ProductRespodtos.builder()
                .name(product.getProductname())
                .quantity(product.getQuantity())
                .build();
    }

    public ProductRespodtos deletequantity(String name, int quantity) {
        Optional<Product> optionalProduct = productrepository.findbyname(name);
        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("add product first");
        }
        if(optionalProduct.get().getQuantity() < quantity){
            throw new ProductNotFoundException("less quantity in stock");
        }
        Product product = optionalProduct.get();
        product.setQuantity(product.getQuantity()-quantity);
        productrepository.save(product);
        return ProductRespodtos.builder()
                .name(product.getProductname())
                .quantity(product.getQuantity())
                .build();
    }
}
