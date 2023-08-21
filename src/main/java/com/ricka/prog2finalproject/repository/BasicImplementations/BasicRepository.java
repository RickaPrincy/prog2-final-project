package com.ricka.prog2finalproject.repository.BasicImplementations;

import java.sql.SQLException;
import java.util.List;

public interface BasicRepository<T>{
    List<T> getAll() throws SQLException;
    T getById(Integer id) throws SQLException;
    T deleteById(Integer id) throws SQLException;
    T create(Object[] newObjectArgs) throws SQLException;
}
