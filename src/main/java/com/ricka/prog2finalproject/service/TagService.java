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
    private List<Object> getArgs(Tag tag){
        List<Object> args = new ArrayList<>();
        args.add(tag.getName());
        return args;
    }
    public Tag createTag(HttpServletResponse response,Tag tag){
        return this.updateDb(response,this.getArgs(tag).toArray(), HttpMethod.POST);
    }

    public Tag updateTag(HttpServletResponse response,Integer id, Tag tag){
        List<Object> args = this.getArgs(tag);
        args.add(0,id);
        return this.updateDb(response,args.toArray(), HttpMethod.PUT);
    }
}
