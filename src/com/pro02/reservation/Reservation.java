package com.pro02.reservation;

import com.pro02.data.LinkDB;
import com.pro02.data.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.pro02.data.LinkDB;

public class Reservation {
    private String seatNum;
    // 0 : Empty, 1 : Fill
    // Cannot use boolean because sqlite! (NOT INCLUDE BOOLEAN TYPE)
    private int isSeatEmpty;

    // Call LinkDB Class and User Info
    LinkDB data = new LinkDB();

    User user = new User();
    // Getter and Setter
    public String getSeatNum() {
        return this.seatNum;
    }
    public int getSeatEmpty() {
        return this.isSeatEmpty;
    }

    public void LoadSeat(String seatNum) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = data.RunSQL("SELECT SeatNo, SeatEmpty FROM Seat WHERE SeatNo = \"" + seatNum + "\"");
        while (resultSet.next()) {
            this.seatNum = resultSet.getString("SeatNo");
            this.isSeatEmpty= resultSet.getInt("SeatEmpty");
        }
        resultSet.close();
    }
    public boolean isEmpty(String name) throws SQLException, ClassNotFoundException {
        LoadSeat(name);
        if(isSeatEmpty == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void Checkin(String name) {

        String sql = "Update Seat Set SeatEmpty = 1 where SeatNo = ?";

        try ( Connection conn = data.connect();
              PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, name);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
