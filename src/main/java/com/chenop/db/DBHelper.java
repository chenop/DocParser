package com.chenop.db;

import com.chenop.models.CaseInsensitiveList;

import java.sql.*;
import java.util.List;

/**
 * Created by Chen on 20/12/2015.
 */
public class DBHelper {
    public static DBHelper INSTANCE = new DBHelper();
    private Statement statement;

    public DBHelper() {
        // create a database connection

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:/Users/Chen/My Projects/DocParser/database/docparser.db");
            statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Opened database successfully");
    }

    public List<String> getKeywords() {
        CaseInsensitiveList keywords = new CaseInsensitiveList();
        try {
            ResultSet rs = statement.executeQuery("select * from keywords");
            while(rs.next())
            {

                // read the result set
                String keywordName = rs.getString("name");
                System.out.println(keywordName);

                keywords.add(keywordName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return keywords;
    }
}