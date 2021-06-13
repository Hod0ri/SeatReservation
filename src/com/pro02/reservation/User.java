package com.pro02.reservation;

import java.sql.ResultSet;
import java.sql.SQLException;

public class User {

    // Call to data.db User Table
    private int userNo;
    private String userName;
    private String userID;
    private String userPasswd;

    // Data Link
    LinkDB database = new LinkDB();

    // Set User Field
    // TODO : Exception Not include parameter
    public void SetUser(String name) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = database.RunSQL("SELECT userNO, userName, userID, userPassWD FROM User WHERE userName = \"" + name + "\"");
        while (resultSet.next()) {
            this.userNo = resultSet.getInt("userNo");
            this.userID = resultSet.getString("userID");
            this.userPasswd = resultSet.getString("userPassWD");
            this.userName = resultSet.getString("userName");
        }
        resultSet.close();
    }
    // Getter
    public int getUserNo() { return userNo; }
    public String getUserName() { return userName; }
    public String getUserID() { return userID; }
    public String getUserPasswd() { return userPasswd; }
}
