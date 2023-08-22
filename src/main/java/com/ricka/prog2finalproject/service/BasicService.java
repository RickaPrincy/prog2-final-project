package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.repository.BasicImplementations.BasicRepositoryPostgresql;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;

import java.sql.SQLException;
import java.util.List;

@AllArgsConstructor
public class BasicService<T> {
    protected BasicRepositoryPostgresql<T> repository;
    public List<T> getAll(HttpServletResponse response){
        try {
            return this.repository.getAll();
        } catch (SQLException error) {
            return ResponseError.InternalServerError(response, error);
        }
    }

    public T getById(HttpServletResponse response, Integer id){
        try {
            T result = this.repository.getById(id);
            return ResponseError.isNotFound(response,result);
        } catch (SQLException error) {
            return ResponseError.InternalServerError(response, error);
        }
    }

    public T deleteById(HttpServletResponse response, Integer id){
        try {
            T result = this.repository.deleteById(id);
            return ResponseError.isNotFound(response,result);
        } catch (SQLException error) {
            return ResponseError.InternalServerError(response, error);
        }
    }

    public T create(HttpServletResponse response, Object[] objectArgs){
        try {
            if(ResponseError.isBadRequest(response,objectArgs)){
                return null;
            }
            T result = this.repository.create(objectArgs);
            return ResponseError.isNotFound(response,result);
        } catch (SQLException error) {
            return ResponseError.InternalServerError(response, error);
        }
    }
}
