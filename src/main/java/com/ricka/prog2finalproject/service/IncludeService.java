package com.ricka.prog2finalproject.service;

import com.ricka.prog2finalproject.model.Include;
import com.ricka.prog2finalproject.repository.IncludeRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IncludeService extends BasicService<Include>{
    public IncludeService(IncludeRepository includeRepository){
        super(includeRepository);
    }

    private List<Object> getArgs(Include include){
        List<Object> args = new ArrayList<>();
        args.add(include.getProjectId());
        args.add(include.getUserId());
        return args;
    }

    public Include createInclude(HttpServletResponse response, Include include){
        return this.updateDb(response,this.getArgs(include).toArray(),HttpMethod.POST);
    }

    public Include updateInclude(HttpServletResponse response, Integer id, Include include){
        List<Object> args = this.getArgs(include);
        args.add(0,id);
        return this.updateDb(response,args.toArray(),HttpMethod.PUT);
    }
}
