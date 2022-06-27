package com.ua.spring.client.server.rest;


import com.ua.spring.client.server.server.ServiceTest;
import com.ua.spring.client.server.trhrift.Book;
import lombok.AllArgsConstructor;
import org.apache.thrift.TException;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/book")
public class BookRestController {


    private ServiceTest serviceTest;


    @GetMapping("/test")
    public Map<String, Book> getAll() throws TException {
        return serviceTest.getAll();
    }

    @PostMapping
    public Map<String, Book> create(@RequestBody Book book) throws TException {
        return serviceTest.create(book);
    }


    @PatchMapping("/{key}")
    public Book update(@PathVariable String key, @RequestBody Book book) throws TException {
        return serviceTest.update(key, book);
    }

    @DeleteMapping("/{key}")
    public boolean delete(@PathVariable String key) throws TException {
        return serviceTest.remove(key);
    }
}
