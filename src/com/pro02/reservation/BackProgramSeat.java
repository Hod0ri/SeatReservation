package com.pro02.reservation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class BackProgramSeat extends ReservationGUI {
    public BackProgramSeat() throws SQLException, ClassNotFoundException {
    }

    static class EventHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Reservation reservation = new Reservation();
            for(int row = 0; row < seatRow; row++) {
                for (int line = 0; line < seatLine; line++) {
                    if (e.getSource() == seatBtn[row][line]) {
                        try {
                            if (reservation.isEmpty(seatBtn[row][line].getName())) {
                                reservation.Checkin(seatBtn[row][line].getName());
                                JOptionPane.showMessageDialog(null, "예약이 완료 되었습니다! \n" + seatBtn[row][line].getName());
                                seatBtn[row][line].setBackground(Color.RED);
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
    }
}
