package com.example.Shop.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Painter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    long mobno;

    String address;

    String unicode;

    @OneToMany(mappedBy = "painter" , cascade = CascadeType.ALL)
    List<Customer> customerList = new ArrayList<>();
}
