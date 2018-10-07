package com.popa.pogodo4ka.dao;


import java.util.List;

public interface GenericDao<T> {

         void add(T object);

         void update(T object);

         void delete(T object);

         List<T> getAll();
}
