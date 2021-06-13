package com.pro02.reservation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Register extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Register frame = new Register();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Register() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 406, 277);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        textField = new JTextField();
        textField.setBounds(125, 40, 150, 21);
        panel.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(125, 71, 150, 21);
        panel.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setBounds(125, 102, 150, 21);
        panel.add(textField_2);

        JLabel lblNewLabel = new JLabel("이름");
        lblNewLabel.setBounds(63, 43, 50, 15);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("아이디");
        lblNewLabel_1.setBounds(63, 74, 50, 15);
        panel.add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("패스워드");
        lblNewLabel_1_1.setBounds(63, 105, 50, 15);
        panel.add(lblNewLabel_1_1);

        textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setBounds(125, 133, 150, 21);
        panel.add(textField_3);

        JLabel lblNewLabel_1_1_1 = new JLabel("재입력");
        lblNewLabel_1_1_1.setBounds(63, 136, 50, 15);
        panel.add(lblNewLabel_1_1_1);

        JButton btnNewButton = new JButton("회원가입");
        btnNewButton.setBounds(184, 164, 91, 23);
        panel.add(btnNewButton);
    }
}