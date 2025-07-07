package com.rg.dao;

import com.rg.entity.Book;

import java.util.List;

public interface BookDao {
    List<Book> getAll();

    int decr(int bid);

    int incr(int bid);

    Book getById(int bid);
}
