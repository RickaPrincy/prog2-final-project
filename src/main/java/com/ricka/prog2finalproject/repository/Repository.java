package com.ricka.prog2finalproject.repository;

import java.util.List;

public interface Repository<T>{
    List<T> getAll();
}
