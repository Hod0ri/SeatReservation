package com.pro02.login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.pro02.login.LoginGUI;

public class RegisterGUI extends JFrame {

    Register register = new Register();

    private JPanel contentPane;
    private JTextField nameBox;
    private JTextField idBox;
    private JPasswordField passwdBox;
    private JPasswordField reCheckBox;

    ImageIcon img = new ImageIcon("img/icon.png");

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
        setIconImage(img.getImage());
        setTitle("기가박스 회원가입");
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
                String compare = String.valueOf(reCheckBox.getPassword());


                if (!name.isEmpty() || !userID.isEmpty() || !passwd.isEmpty() || !compare.isEmpty()) {
                    if (!name.isBlank() || !userID.isBlank() || !passwd.isBlank() || !compare.isBlank()) {
                        if (checkPasswd(passwd, compare)) {
                            register.setInfo(name, userID, passwd);
                            JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다!");

                            setVisible(false);
                            LoginGUI login = new LoginGUI();
                            login.ShowLogin();
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "입력되지 않은 칸이 존재합니다!", "경고", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "입력되지 않은 칸이 존재합니다!", "경고", JOptionPane.WARNING_MESSAGE);
                }

            }
        }


    }

    private boolean checkPasswd(String input, String compare) {
        if(input.equals(compare)) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다!", "경고", 0);
            return false;
        }
    }
}