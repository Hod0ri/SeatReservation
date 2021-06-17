package com.pro02.reservation;

import java.sql.*;

public class LinkDB {
    Connection connection = null;

    private void LinkJDBC() throws ClassNotFoundException, SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
        }
        catch(ClassNotFoundException e)  {
            System.out.println("org.sqlite.JDBC Not Found");
        }
        connection = DriverManager.getConnection("jdbc:sqlite:data.db");
    }
    // For Insert
    Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:data.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public ResultSet RunSQL(String sql) throws SQLException, ClassNotFoundException {
        LinkJDBC();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        return result;
    }
}
