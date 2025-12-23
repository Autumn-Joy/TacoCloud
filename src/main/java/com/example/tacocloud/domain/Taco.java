package com.example.tacocloud.domain;

import java.util.Date;
import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table
public class Taco {

    @Id
    private Long id;

    private Date createdAt =  new Date();
    private String name;
    private List<Ingredient> ingredients;
}



