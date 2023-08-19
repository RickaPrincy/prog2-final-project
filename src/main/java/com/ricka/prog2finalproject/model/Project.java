package com.ricka.prog2finalproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private Integer id;
    private String name, description;
    private boolean status;
    private LocalDate startDate,endDate;
    private int userId;
}
