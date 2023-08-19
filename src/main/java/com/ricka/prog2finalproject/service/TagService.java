package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.Tag;
import com.ricka.prog2finalproject.repository.TagRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class TagService {
    private TagRepository tagRepository;
    public List<Tag> getAllTags(){
        try {
            return this.tagRepository.getAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
