package nl.quintor.jpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by Ron on 05/12/2016.
 */
public class JdbcRunner {

    public static void main(String... args) throws Exception{
        new JdbcRunner().run();
        System.exit(0);
    }


    private void run() throws Exception{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/employees?" +
                        "user=root&password=root");

        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("select first_name, last_name from employees");
        while (resultSet.next()) {
            String first = resultSet.getString(1);
            String last = resultSet.getString(2);
            System.out.println(first + " " + last);
        }
        resultSet.close();
        statement.close();
    }
}
