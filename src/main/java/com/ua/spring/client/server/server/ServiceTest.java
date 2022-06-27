package com.ua.spring.client.server.server;

import com.ua.spring.client.server.trhrift.Book;
import org.apache.thrift.TException;

import java.util.Map;

public interface ServiceTest {


    Map<String, Book> create(Book value) throws TException;

    Map<String, Book> getAll() throws TException;

    boolean remove(String k) throws TException;

    Book update(String key, Book value) throws TException;
}
