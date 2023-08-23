package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.repository.BasicImplementations.BasicRepositoryPostgresql;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;

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

    protected T updateDb(HttpServletResponse response, Object[] args, HttpMethod method){
        try {
            if(ResponseError.isBadRequest(response,args)){
                return null;
            }
            T result;
            if(method == HttpMethod.POST)
                result = this.repository.create(args);
            else
                result = this.repository.update(args);

            return ResponseError.isNotFound(response,result);
        } catch (SQLException error) {
            return ResponseError.InternalServerError(response, error);
        }
    }
}
