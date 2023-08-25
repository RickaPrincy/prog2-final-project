package com.ricka.prog2finalproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private Integer id;
    private String title;
    private Boolean status;
    private Timestamp startDate,endDate;
    private Integer priority,userId,projectId,tagId;
}
