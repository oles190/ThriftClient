package com.ua.spring.client.server.server.impl;


import com.ua.spring.client.server.server.ServiceTest;
import com.ua.spring.client.server.trhrift.Book;
import com.ua.spring.client.server.trhrift.BookService;
import lombok.AllArgsConstructor;
import org.apache.thrift.TException;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@AllArgsConstructor
public class ClientService implements ServiceTest {

    private BookService.Client client;

    @Override
    public Map<String, Book> create(Book value) throws TException {
        client.getOutputProtocol().getTransport().open();

     Map<String, Book> map =  client.create(value);
        client.getOutputProtocol().getTransport().close();

        return  map;
    }

    @Override
    public Map<String, Book> getAll() throws TException {
        client.getOutputProtocol().getTransport().open();
        Map<String, Book> books = client.getAll();
        client.getOutputProtocol().getTransport().close();
        return books;
    }

    @Override
    public boolean remove(String k) throws TException {
        client.getOutputProtocol().getTransport().open();
        boolean flag = client.remove(k);
        client.getOutputProtocol().getTransport().close();
        return flag;
    }

    @Override
    public Book update(String key, Book value) throws TException {
        client.getOutputProtocol().getTransport().open();

        Book book = client.update(key, value);

        client.getOutputProtocol().getTransport().close();
        return book;
    }
}
