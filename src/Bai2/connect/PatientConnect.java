package Bai2.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PatientConnect {
    static final String url="jdbc:mysql://localhost:3306/session12";
    static final String user="root";
    static final String password="123456789";
    public static Connection getConnection() {
        try {
            Connection connection= DriverManager.getConnection(url,user,password);
            return  connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
