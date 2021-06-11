package com.pro02.reservation;

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
    public void CallUser(String inputID) {

    }

    // Check Invaild
    public boolean isValidAccount() {
        boolean isVaild = false;

        // TODO: SET LOGIN SYSTEM

        return isVaild;
    }
}
