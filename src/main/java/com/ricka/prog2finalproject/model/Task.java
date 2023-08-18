package com.ricka.prog2finalproject.model;

import jakarta.websocket.server.ServerEndpoint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Task {
    private Integer id;
    private String title;
    private LocalDate startDate,endDate;
    private int priority,userId,projectId,tagId;
}
