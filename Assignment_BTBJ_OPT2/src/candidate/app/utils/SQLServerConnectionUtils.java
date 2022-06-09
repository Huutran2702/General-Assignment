package candidate.app.utils;

import candidate.app.model.Candidate;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerConnectionUtils {

    public static Connection getConnection() {
        String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=Candidate_Management";
        String USER_NAME = "huu";
        String PASSWORD = "123";
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
