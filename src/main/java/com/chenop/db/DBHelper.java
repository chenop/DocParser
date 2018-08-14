package com.chenop.db;

import com.chenop.common.Constants;

import java.sql.*;
import java.util.TreeSet;

/**
 * Created by Chen on 20/12/2015.
 */
public class DBHelper {
    public static DBHelper INSTANCE = new DBHelper();
    private Statement statement;

    public DBHelper() {
        // create a database connection

        try {
//            initSQLiteStatement();
            Class.forName("org.postgresql.Driver");
//            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "selavi99");
            Connection connection = DriverManager.getConnection(Constants.INSTANCE.DATABASE_URL, Constants.INSTANCE.DATABASE_USER, Constants.INSTANCE.DATABASE_PASSWORD);
            statement = connection.createStatement();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Opened database successfully");
    }

    private void initSQLiteStatement() throws SQLException {
        //            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Chen/My Projects/DocParser/database/docparser.db");
        Connection connection = DriverManager.getConnection("postgres://gsrtifvmtalryd:hQnY0mewfZ2TrM3uIFDYX-Y1h-@ec2-176-34-127-73.eu-west-1.compute.amazonaws.com:5432/dcgoerf6va8iej");
        statement = connection.createStatement();
        statement.setQueryTimeout(30);  // set timeout to 30 sec.
    }

    public TreeSet<String> getKeywords() throws SQLException {
        TreeSet<String> keywords = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

        try {
            ResultSet rs = statement.executeQuery("select * from keywords");
            while(rs.next())
            {

                // read the result set
                String keywordName = rs.getString("name");

                keywords.add(keywordName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return keywords;
    }
}
