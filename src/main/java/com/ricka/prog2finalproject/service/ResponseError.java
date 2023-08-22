package com.ricka.prog2finalproject.service;

import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ResponseError {
    public static <T> T InternalServerError(HttpServletResponse response, Exception error){
        System.out.println(error.getMessage());
        try {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (IOException err) {
            System.out.println(err.getMessage());
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        return null;
    }

    public static <T> T isNotFound(HttpServletResponse response, T result){
        if(result == null) {
            try {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            } catch (IOException error) {
                ResponseError.InternalServerError(response,error);
            }
        }
        return result;
    }

    public static boolean isBadRequest(HttpServletResponse response, Object[] args){
        for(Object arg : args) {
            if (arg == null) {
                try {
                    response.sendError(
                            HttpServletResponse.SC_BAD_REQUEST,
                            "One or more fields are empty"
                    );
                } catch (IOException error) {
                    ResponseError.InternalServerError(response,error);
                }
                return true;
            }
        }
        return false;
    }
}
