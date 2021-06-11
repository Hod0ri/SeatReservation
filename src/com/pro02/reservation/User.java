package com.pro02.reservation;

import java.sql.SQLException;

public class User {

    // Call to data.db User Table
    private int userNo;
    private String userName;
    private String userID;
    private String userPasswd;

    // Data Link
    LinkDB database = new LinkDB();

    // TODO: Fix Method (Infinite Loop and Can't call variable)
    public void SetUser(String name) throws SQLException, ClassNotFoundException {
        while (database.RunSQL("SELECT userNO, userName, userID, userPassWD FROM User WHERE userName = \"" + name + "\"").next()) {
            int userNo = this.userNo;
            String userName = this.userName;
            String userID = this.userID;
            String userPassWD = this.userPasswd;
        }
    }
    // Getter
    public int getUserNo() { return userNo; }
    public String getUserName() { return userName; }
    public String getUserID() { return userID; }
    public String getUserPasswd() { return userPasswd; }

    // Test Main Method
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        User user = new User();

        user.SetUser("admin");

        System.out.println(user.getUserPasswd());
    }
}
