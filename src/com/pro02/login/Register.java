package com.pro02.login;

import com.pro02.data.LinkDB;

import java.sql.*;

public class Register {
    private String userName;
    private String userID;
    private String userPW;

    LinkDB linkDB = new LinkDB();

    private void InsertSQL() {
        String sql = "INSERT INTO User(userName, userID, userPassWD) VALUES(?,?,?)";

        try ( Connection conn = linkDB.connect();
              PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, userName);
            pstmt.setString(2, userID);
            pstmt.setString(3, userPW);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    public void setInfo(String userName, String userID, String userPW){
        this.userName = userName;
        this.userID = userID;
        this.userPW = userPW;

        InsertSQL();
    }

}
