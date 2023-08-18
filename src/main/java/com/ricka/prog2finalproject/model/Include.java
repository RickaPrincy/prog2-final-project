package com.ricka.prog2finalproject.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class Include {
    private Integer id;
    private int userId,projectId;
}