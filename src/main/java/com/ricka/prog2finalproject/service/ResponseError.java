package com.ricka.prog2finalproject.service;

import jakarta.servlet.http.HttpServletResponse;

public class ResponseError {
    public static <T> T InternalServerError(HttpServletResponse response, Exception error){
        System.out.println(error.getMessage());
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return null;
    }

    public static <T> T isNotFound(HttpServletResponse response, T result){
        if(result == null)
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        return result;
    }
}
