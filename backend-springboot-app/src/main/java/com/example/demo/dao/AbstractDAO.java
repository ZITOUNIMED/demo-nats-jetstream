package com.example.demo.dao;

import java.util.List;

public interface AbstractDAO<ID, T>{
    T findById(ID id);
    void save(T t);
    List<T> findAll();
}
