package com.pro02.reservation;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Register {
    private String userName;
    private String userID;
    private String userPW;

    private ResultSet addUser(String userName, String userID, String userPW) throws SQLException, ClassNotFoundException {
        LinkDB database = new LinkDB();
        ResultSet resultSet = database.RunSQL("INSERT INTO User(userName, userID, userPassWD) VALUES (\"" + userName + "\", \""+ userID +"\", \""+ userPW +"\")");
        return resultSet;
    }

    public void callSQL(){

    }

    public void setInfo(String userName, String userID, String userPW){
        this.userName = userName;
        this.userID = userID;
        this.userPW = userPW;
    }

}
