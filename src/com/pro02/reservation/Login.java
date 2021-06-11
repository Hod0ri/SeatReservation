package com.pro02.reservation;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    private String inputID;
    private String inputPW;
    // Correct Value
    private String UserID;
    private String UserPasswd;

    public void setValue(String inputID, String inputPW) {
        this.inputID = inputID;
        this.inputPW = inputPW;
    }

    // Call Account
    public void CallUser(String inputID) throws SQLException, ClassNotFoundException {
        LinkDB database = new LinkDB();
        ResultSet resultSet = database.RunSQL("SELECT userNO, userName, userID, userPassWD FROM User WHERE userID = \"" + inputID + "\"");
        while (resultSet.next()) {
            this.UserID = resultSet.getString("userID");
            this.UserPasswd = resultSet.getString("userPassWD");
        }
        resultSet.close();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Login lo = new Login();
        lo.CallUser("admin");
        System.out.println(lo.UserID);
        System.out.println(lo.UserPasswd);
    }

    // Check Invaild
    public boolean isValidAccount() {
        boolean isVaild = false;

        // TODO: SET LOGIN SYSTEM

        return isVaild;
    }
}
