package com.pro02.reservation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class BackProgramSeat extends ReservationGUI {
    static class EventHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Reservation reservation = new Reservation();
            if(e.getSource() == seatBtn[0][0]) {
                try {
                    if(reservation.isEmpty(seatBtn[0][0].getName())) {
                        reservation.Checkin(seatBtn[0][0].getName());
                        JOptionPane.showMessageDialog(null, "예약이 완료 되었습니다! \n" + seatBtn[0][0].getName());
                    } else {
                        JOptionPane.showMessageDialog(null, "이미 예매된 좌석입니다.", "경고", 0);
                    }
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
            }
        }
    }
}
