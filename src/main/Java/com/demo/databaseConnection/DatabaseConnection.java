package com.demo.databaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection initDatabase() throws ClassNotFoundException, SQLException {
        String dbDriver = "com.mysql.jdbc.Driver";
        String dbURL = "jdbc:mysql://localhost:3306/";

        String dbName = "demo_servlet";
        String dbTimeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String dbUserName = "root";
        String dbPassword = "";

        Class.forName(dbDriver);

        Connection con = DriverManager.getConnection(
                dbURL + dbName + dbTimeZone,dbUserName,dbPassword
        );
        return con;
    }
}
