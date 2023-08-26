package com.ricka.prog2finalproject.controller;

import com.ricka.prog2finalproject.model.Tag;
import com.ricka.prog2finalproject.service.TagService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/tags")
public class TagController {
    private TagService tagService;

    @GetMapping
    public List<Tag> getAllTasks(HttpServletResponse response){
        return this.tagService.getAll(response);
    }

    @GetMapping("/{id}")
    public Tag getTagById(HttpServletResponse response, @PathVariable Integer id) {
        return this.tagService.getById(response, id);
    }
    @DeleteMapping("/{id}")
    public Tag deleteTagById(HttpServletResponse response, @PathVariable Integer id){
        return this.tagService.deleteById(response,id);
    }

    @PostMapping
    public Tag createTag(HttpServletResponse response, @RequestBody Tag tag){
        return this.tagService.createTag(response,tag);
    }

    @PutMapping("/{id}")
    public Tag updateTag(HttpServletResponse response,@PathVariable Integer id, @RequestBody  Tag tag){
        return this.tagService.updateTag(response,id,tag);
    }

    @PatchMapping("/{id}")
    public Tag updatePartialTag(HttpServletResponse response,@PathVariable Integer id, @RequestBody  Tag tag){
        return this.tagService.updatePartialTag(response,id,tag);
    }
}