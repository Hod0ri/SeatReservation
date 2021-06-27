package com.pro02.login;

import com.pro02.data.LinkDB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {
    private String inputID;
    private String inputPW;
    // Correct Value
    private String UserID;
    private String UserPasswd;

    public boolean LoginSys(String inputID, String inputPW) throws SQLException, ClassNotFoundException {
        // Initialize
        this.inputID = inputID;
        this.inputPW = inputPW;

        CallUser(inputID);
        if(isValidAccount()) {
            return true;
        } else {
            return false;
        }
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


    // Check Valid
    private boolean isValidAccount() {
        boolean isValid = false;
            if (inputPW.equals(UserPasswd))
                isValid = true;
        return isValid;
    }
}
