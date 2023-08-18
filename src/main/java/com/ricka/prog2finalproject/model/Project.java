package com.ricka.prog2finalproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Project {
    private Integer id;
    private boolean status;
    private String title;
    private LocalDate startDate,endDate;
    private int userId;
}
