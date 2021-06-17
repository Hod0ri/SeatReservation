package com.pro02.reservation;

import java.sql.*;

public class Register {
    private String userName;
    private String userID;
    private String userPW;

    LinkDB linkDB = new LinkDB();

    public void insert(String name, String id, String passwd) {
        String sql = "INSERT INTO User(userName, userID, userPassWD) VALUES(?,?,?)";

        try ( Connection conn = linkDB.connect();
              PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, name);
            pstmt.setString(2, id);
            pstmt.setString(3, passwd);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private ResultSet addUser(String userName, String userID, String userPW) throws SQLException, ClassNotFoundException {
        LinkDB database = new LinkDB();
        ResultSet resultSet = database.RunSQL("INSERT INTO User(userName, userID, userPassWD) VALUES (\"" + userName + "\", \""+ userID +"\", \""+ userPW +"\")");
        return resultSet;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Register register = new Register();

        register.insert("오징어", "octofus", "ihatejava");
    }

    public void setInfo(String userName, String userID, String userPW){
        this.userName = userName;
        this.userID = userID;
        this.userPW = userPW;
    }

}
