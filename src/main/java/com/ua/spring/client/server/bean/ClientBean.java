package com.ua.spring.client.server.bean;

import com.ua.spring.client.server.trhrift.BookService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.transport.TSocket;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ClientBean {

    @Bean
    private BookService.Client client() {
        return new BookService.Client(new TBinaryProtocol(new TSocket("localhost", 8282)));
    }
}
