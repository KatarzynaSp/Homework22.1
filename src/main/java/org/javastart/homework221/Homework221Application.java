package org.javastart.homework221;

import org.javastart.homework221.spring.TestConnector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Homework221Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Homework221Application.class, args);
        TestConnector bean = context.getBean(TestConnector.class);
        bean.saveToDatabase();
    }
}