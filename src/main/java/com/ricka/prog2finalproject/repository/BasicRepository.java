package com.ricka.prog2finalproject.repository;

import java.sql.SQLException;
import java.util.List;

public interface BasicRepository<T>{
    List<T> getAll() throws SQLException;
}
