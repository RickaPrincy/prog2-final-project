package com.ricka.prog2finalproject.controller;

import com.ricka.prog2finalproject.model.Tag;
import com.ricka.prog2finalproject.service.TagService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TagController {
    private TagService tagService;

    @GetMapping("tags")
    public List<Tag> getAllTasks(HttpServletResponse response){
        return this.tagService.getAll(response);
    }

    @GetMapping("tags/{id}")
    public Tag getTagById(HttpServletResponse response, @PathVariable Integer id) {
        return this.tagService.getById(response, id);
    }
    @DeleteMapping("tags/{id}")
    public Tag deleteTagById(HttpServletResponse response, @PathVariable Integer id){
        return this.tagService.deleteById(response,id);
    }

    @PostMapping("tags")
    public Tag createTag(HttpServletResponse response, @RequestBody Tag tag){
        return this.tagService.createTag(response,tag);
    }

    @PutMapping("tags/{id}")
    public Tag updateTag(HttpServletResponse response,@PathVariable Integer id, @RequestBody  Tag tag){
        return this.tagService.updateTag(response,id,tag);
    }

    @PatchMapping("tags/{id}")
    public Tag updatePartialTag(HttpServletResponse response,@PathVariable Integer id, @RequestBody  Tag tag){
        return this.tagService.updatePartialTag(response,id,tag);
    }

    @GetMapping("tasks/{id}/tags")
    public List<Tag> getTagsByTask(HttpServletResponse response, @PathVariable Integer id){
        return this.tagService.getByField(response,"taskId",id);
    }
}