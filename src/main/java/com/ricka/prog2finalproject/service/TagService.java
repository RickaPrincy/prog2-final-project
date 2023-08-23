package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.Tag;
import com.ricka.prog2finalproject.repository.TagRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagService extends BasicService<Tag>{
    public TagService(TagRepository tagRepository){
        super(tagRepository);
    }
    public Tag createTag(HttpServletResponse response, Tag newTag){
        List<Object> args = new ArrayList<>();
        args.add(newTag.getName());
        return this.updateDb(response,args.toArray(), HttpMethod.POST);
    }

    public Tag updateTag(HttpServletResponse response,Integer id, Tag updateTad){
        List<Object> args = new ArrayList<>();
        args.add(id);
        args.add(updateTad.getName());
        return this.updateDb(response,args.toArray(), HttpMethod.PUT);
    }
}
