package com.ricka.prog2finalproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private Integer id;
    private String name, description;
    private Boolean status;
    private Timestamp startDate,endDate;
    private Integer userId;
}
