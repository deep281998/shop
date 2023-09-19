package com.example.Shop.dtos.reqdtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class Productreqdtos {

    String name;

    double mrp;

    double sellingcost;

    String companyname;
}
