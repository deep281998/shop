package com.example.Shop.dtos.respodtos;

import com.example.Shop.model.Product;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerRespo {

    String name;

    List<Product> productList = new ArrayList<>();

}
