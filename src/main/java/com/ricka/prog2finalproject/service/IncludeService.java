package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.Include;
import com.ricka.prog2finalproject.repository.IncludeRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncludeService extends BasicService<Include>{
    public IncludeService(IncludeRepository includeRepository){
        super(includeRepository);
    }
    public Include createInclude(HttpServletResponse response, Include newInclude){
        List<Object> args = new ArrayList<>();
        args.add(newInclude.getProjectId());
        args.add(newInclude.getUserId());
        return this.create(response,args.toArray());
    }
}
