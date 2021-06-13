package com.pro02.reservation;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RegisterGUI extends JFrame {

    private JPanel contentPane;
    private JTextField nameBox;
    private JTextField idBox;
    private JPasswordField passwdBox;
    private JPasswordField reCheckBox;

    JButton submitBtn = new JButton("회원가입");

    public void ShowRegister() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegisterGUI frame = new RegisterGUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RegisterGUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 406, 277);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        nameBox = new JTextField();
        nameBox.setBounds(125, 40, 150, 21);
        panel.add(nameBox);
        nameBox.setColumns(10);

        idBox = new JTextField();
        idBox.setColumns(10);
        idBox.setBounds(125, 71, 150, 21);
        panel.add(idBox);

        passwdBox = new JPasswordField();
        passwdBox.setColumns(10);
        passwdBox.setBounds(125, 102, 150, 21);
        panel.add(passwdBox);

        JLabel lblNewLabel = new JLabel("이름");
        lblNewLabel.setBounds(63, 43, 50, 15);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("아이디");
        lblNewLabel_1.setBounds(63, 74, 50, 15);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("패스워드");
        lblNewLabel_1_1.setBounds(63, 105, 50, 15);
        panel.add(lblNewLabel_1_1);

        reCheckBox = new JPasswordField();
        reCheckBox.setColumns(10);
        reCheckBox.setBounds(125, 133, 150, 21);
        panel.add(reCheckBox);

        JLabel lblNewLabel_1_1_1 = new JLabel("재입력");
        lblNewLabel_1_1_1.setBounds(63, 136, 50, 15);
        panel.add(lblNewLabel_1_1_1);

        submitBtn.setBounds(184, 164, 91, 23);
        panel.add(submitBtn);

        submitBtn.addActionListener(new EventHandler());
    }

    class EventHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == submitBtn) {
                // TODO : Event Handling
                String name = nameBox.getText();
                String userID = idBox.getText();
                String passwd = String.valueOf(passwdBox.getPassword());
            }
        }
    }

    private boolean checkPasswd(String input) {
        String compare = String.valueOf(reCheckBox.getPassword());
        if(input.equals(compare)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다!", "경고", 0);
            return false;
        }
    }
}