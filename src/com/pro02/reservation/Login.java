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
        boolean isValid = false;

        // TODO: SET LOGIN SYSTEM
        if(inputPW.equals(UserPasswd))
            isValid = true;

        return isValid;
    }

    //Check PWLetter (' 39, " 34, - 45, = 61)
    public boolean blockInjection(String InputPW){
        boolean isValid = true;
        char[] tempChar = new char[InputPW.length()];

        for(int i = 0; i < tempChar.length; i++){
            tempChar[i] = InputPW.charAt(i);
            switch((int)tempChar[i]){
                case 34 :
                case 39 :
                case 45 :
                case 61 : isValid = false; break;
            }
        }

        return isValid;
    }
}
