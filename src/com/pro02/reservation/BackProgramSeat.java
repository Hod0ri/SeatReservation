package com.pro02.reservation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackProgramSeat extends ReservationGUI {
    static class EventHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == seatBtn[0][0]) {
                System.out.println(e.getSource());
            }
        }
    }
}
