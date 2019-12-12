package org.javastart.homework221.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mysql")
public class MySQLConnector implements DatabaseConnector {
    @Override
    public void connect() {
        System.out.println("Connected to MySQL");
    }

    @Override
    public void close() {
        System.out.printf("Close MySQL connection");
    }
}