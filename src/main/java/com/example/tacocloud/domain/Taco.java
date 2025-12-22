package com.example.tacocloud.domain;

import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class Taco {

    private Long id;
    private Date createdAt =  new Date();
    private String name;
    private List<Ingredient> ingredients;
}



