package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.Tag;
import com.ricka.prog2finalproject.repository.TagRepository;
import org.springframework.stereotype.Service;

@Service
public class TagService extends BasicService<Tag>{
    public TagService(TagRepository tagRepository){
        super(tagRepository);
    }
}
