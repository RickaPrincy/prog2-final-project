package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.Tag;
import com.ricka.prog2finalproject.repository.BasicImplementations.BasicRepositoryPostgresql;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpMethod;

import java.io.IOException;
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
            if(error.getMessage().contains("is still referenced from table")){
                StringBuilder errorMessage = new StringBuilder("Cannot delete the ");
                errorMessage.append(error.getMessage().split("\"")[1])
                        .append(" which has the id = ")
                        .append(id).append(" because it's linked with ")
                        .append( error.getMessage().split("\"")[5]);
                try {
                    response.sendError( HttpServletResponse.SC_BAD_REQUEST,errorMessage.toString());
                } catch (IOException internalError) {
                    return ResponseError.InternalServerError(response,internalError);
                }
                return null;
            }else{
                return ResponseError.InternalServerError(response, error);
            }
        }
    }

    protected T updateDb(HttpServletResponse response, Object[] args, HttpMethod method){
        try {
            T result;
            if (method == HttpMethod.PATCH) {
                if (ResponseError.isEveryNull(response, args))
                    return null;
                result = this.repository.update(args);
            } else {
                if (ResponseError.isBadRequest(response, args))
                    return null;
                if (method == HttpMethod.POST)
                    result = this.repository.create(args);
                else
                    result = this.repository.update(args);
            }
            return ResponseError.isNotFound(response,result);
        } catch (SQLException error) {
            return ResponseError.InternalServerError(response, error);
        }
    }
}
