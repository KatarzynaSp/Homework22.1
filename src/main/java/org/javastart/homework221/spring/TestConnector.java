package org.javastart.homework221.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestConnector {
    private DatabaseConnector databaseConnector;

    @Autowired
    public TestConnector(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    public void saveToDatabase() {
        databaseConnector.connect();
        databaseConnector.close();
    }
}