package com.pro02.reservation;

import com.pro02.login.LoginGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ReservationGUI extends JFrame {

    int seatRow = 3;
    int seatLine = 10;
    int btnWidth = 25;
    int btnHeight = 23;
    int initialX = 196;
    int initialY = 62;

    ImageIcon img = new ImageIcon("img/icon.png");
    private JPanel contentPane;
    JLabel userNameLabel = new JLabel("Empty");
    JButton btn_Logout = new JButton("로그아웃");
    JButton btn_current = new JButton("예매 현황");
    JButton[][] seatBtn = new JButton[seatRow][seatLine];

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ReservationGUI frame = new ReservationGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ReservationGUI() {
        setIconImage(img.getImage());
        setTitle("기가박스 상영관 예매");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 661, 243);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        // User Name Label, Logout, Current Seat Check Button
        userNameLabel.setBounds(12, 44, 123, 15);
        panel.add(userNameLabel);

        btn_Logout.setBounds(12, 102, 91, 23);
        panel.add(btn_Logout);

        btn_current.setBounds(12, 69, 91, 23);
        panel.add(btn_current);

        for(int row = 0; row < seatRow; row++) {
            for(int line = 0; line < seatLine; line++) {
                seatBtn[row][line] = new JButton("");
                seatBtn[row][line].setBounds(initialX, initialY, btnWidth, btnHeight);
                panel.add(seatBtn[row][line]);
                initialX += 37;
            }
            // Reset X Position
            initialX = 196;
            initialY += 33;
        }

        JLabel lblNewLabel = new JLabel("A 열");
        lblNewLabel.setBounds(561, 70, 50, 15);
        panel.add(lblNewLabel);

        JLabel lblB = new JLabel("B 열");
        lblB.setBounds(561, 102, 50, 15);
        panel.add(lblB);

        JLabel lblC = new JLabel("C 열");
        lblC.setBounds(561, 136, 50, 15);
        panel.add(lblC);

    }

    class EventHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
