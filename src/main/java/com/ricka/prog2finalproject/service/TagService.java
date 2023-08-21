package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.Tag;
import com.ricka.prog2finalproject.repository.TagRepository;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class TagService {
    private TagRepository tagRepository;
    public List<Tag> getAllTags(HttpServletResponse response){
        try {
            return this.tagRepository.getAll();
        } catch (SQLException error) {
            return ResponseError.InternalServerError(response,error);
        }
    }

    public Tag getTagById(HttpServletResponse response, Integer id){
        try {
            Tag result = this.tagRepository.getById(id);
            return ResponseError.isNotFound(response,result);
        }
        catch (SQLException error){
            return ResponseError.InternalServerError(response,error);
        }
    }
}
