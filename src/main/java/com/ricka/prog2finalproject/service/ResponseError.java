package com.ricka.prog2finalproject.service;


import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public class ResponseError {
    public static <T> List<T> InternalServerError(HttpServletResponse response, Exception error){
        System.out.println(error.getMessage());
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        return null;
    }
}
