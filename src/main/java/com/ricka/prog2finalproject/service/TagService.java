package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.Tag;
import com.ricka.prog2finalproject.repository.TagRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService extends BasicService<Tag>{
    public TagService(TagRepository tagRepository){
        super(tagRepository);
    }
    public Tag createTag(HttpServletResponse response, Tag newTag){
        List<Object> newArgs = new ArrayList<>();
        newArgs.add(newTag.getName());
        return this.create(response,newArgs.toArray());
    }
}
