package com.ricka.prog2finalproject.repository.BasicImplementations;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.ResultSet;

@Getter
@AllArgsConstructor
public class ResultQuery {
    private ResultSet resultSet;
    private int columnCount;
}
