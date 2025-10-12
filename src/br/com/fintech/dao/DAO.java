package br.com.fintech.dao;

import java.util.List;

public interface DAO<T> {
    void insert(T entity);
    List<T> getAll();
}