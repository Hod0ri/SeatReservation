package com.pro02.reservation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.EventHandler;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class LoginGUI extends JFrame {

    private JPanel contentPane;
    private JTextField idBox;
    private JTextField passwdBox;
    JButton LoginSubmit = new JButton("로그인");
    JButton Register = new JButton("회원가입");


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginGUI frame = new LoginGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LoginGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 350, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        idBox = new JTextField();
        idBox.setBounds(115, 70, 175, 21);
        panel.add(idBox);
        idBox.setColumns(10);

        passwdBox = new JTextField();
        passwdBox.setColumns(10);
        passwdBox.setBounds(115, 101, 175, 21);
        panel.add(passwdBox);

        JLabel viewMenuID = new JLabel("아이디");
        viewMenuID.setBounds(53, 73, 50, 15);
        panel.add(viewMenuID);

        JLabel viewMenuPW = new JLabel("패스워드");
        viewMenuPW.setBounds(53, 104, 50, 15);
        panel.add(viewMenuPW);

        LoginSubmit.setBounds(199, 132, 91, 23);
        panel.add(LoginSubmit);

        JLabel lblNewLabel_2 = new JLabel("보유하신 계정이 없으신가요?");
        lblNewLabel_2.setBounds(26, 169, 185, 15);
        panel.add(lblNewLabel_2);

        Register.setBounds(223, 165, 91, 23);
        panel.add(Register);

        LoginSubmit.addActionListener(new EventHandler());
    }

    class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == LoginSubmit) {
                Login login = new Login();
                String id = idBox.getText();
                String passwd = passwdBox.getText();
                login.setValue(id, passwd);
            }
        }
    }
}
