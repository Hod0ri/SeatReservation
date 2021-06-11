package com.pro02.reservation;

import java.sql.*;

public class LinkDB {
    Connection connection = null;

    private void LinkJDBC() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");

        String dataFile = "C:\\Users\\MintMoca\\Desktop\\SeatReservation\\data.db";
        connection = DriverManager.getConnection("jdbc:sqlite:" + dataFile);
    }

    public ResultSet RunSQL(String sql) throws SQLException, ClassNotFoundException {
        LinkJDBC();
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        return result;
    }
}
