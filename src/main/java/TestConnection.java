/**
 * Created by rotor on 3/16/2016.
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;

/**
 * Test for JDBC connection to EC2 MySQL connection.
 */
public class TestConnection {
    final static String PUBLIC_DNS = "ec2-54-187-101-228.us-west-2.compute.amazonaws.com";
    private static final String PORT = "3306";
    private static final String DATABASE = "testdb";
    private static final String REMOTE_DATABASE_USERNAME = "remoteu";
    private static final String DATABASE_USER_PASSWORD = "rafa1234";
    private static final String sourcePath = "dumpfile.sql";

    public static void main(String[] args) {
        connectJDBCToAWSEC2();
    }

    public static void connectJDBCToAWSEC2() {

        System.out.println("----MySQL JDBC Connection Testing -------");

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            return;
        }

        System.out.println("MySQL JDBC Driver Registered!");
        Connection connection = null;

        try {
            connection = DriverManager.
                    getConnection("jdbc:mysql://" + PUBLIC_DNS + ":" + PORT + "/" + DATABASE, REMOTE_DATABASE_USERNAME, DATABASE_USER_PASSWORD);



        } catch (SQLException e) {
            System.out.println("Connection Failed!:" + e.getMessage());
        }

        if (connection != null) {
            System.out.println("SUCCESS!!!! You made it, take controlyour database now!");
        } else {
            System.out.println("FAILURE! Failed to make connection!");
        }


    }
}
