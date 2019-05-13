package com.sweets.repositoty;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {


    public Connection getConnection() throws SQLException, IOException, ClassNotFoundException {
        Properties prop = new Properties();
        InputStream in = getClass().getClassLoader().getResourceAsStream("application.properties");
        prop.load(in);
        in.close();

        String drivers = prop.getProperty("jdbc.driver");
        String connectionURL = prop.getProperty("jdbc.url");
        String username = prop.getProperty("jdbc.username");
        String password = prop.getProperty("jdbc.password");
        Class.forName(drivers);

        Connection connection = DriverManager.getConnection(connectionURL, username, password);

        return connection;
    }
}
