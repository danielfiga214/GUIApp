package com.example.LogInProject.GUI;

import com.example.LogInProject.model.User;
import com.example.LogInProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.example.LogInProject.LogInProjectApplication.findLogin;

public class LogIn implements ActionListener {

    @Autowired
    UserRepository userRepository;

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Log in");
    JButton resetButton = new JButton("Reset");
    JTextField loginField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel loginLabel = new JLabel("Your login");
    JLabel passwordLabel = new JLabel("Password");
    JLabel welcomeShadeLabel = new JLabel("Log in page");
    JLabel welcomeLabel = new JLabel("Log in page");
    JLabel messageErrLabel = new JLabel("Wrong password or login");

    public LogIn() {
        loginLabel.setBounds(45, 100, 75, 25);
        loginLabel.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
        loginLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(45, 140, 75, 25);
        passwordLabel.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
        passwordLabel.setForeground(Color.WHITE);

        welcomeLabel.setBounds(54, 14, 390, 75);
        welcomeLabel.setFont(new Font(null, Font.BOLD, 50));
        welcomeLabel.setForeground(Color.BLACK);
        welcomeShadeLabel.setBounds(50, 10, 390, 75);
        welcomeShadeLabel.setFont(new Font(null, Font.BOLD, 50));
        welcomeShadeLabel.setForeground(new java.awt.Color(202, 116, 48));

        messageErrLabel.setBounds(35, 200, 390, 75);
        messageErrLabel.setFont(new Font(null, Font.ITALIC, 30));
        messageErrLabel.setForeground(new java.awt.Color(225, 0, 0));
        messageErrLabel.setVisible(false);

        loginField.setBounds(125, 100, 200, 25);
        passwordField.setBounds(125, 140, 200, 25);

        loginButton.setBounds(125, 180, 95, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(230, 180, 95, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(messageErrLabel);
        frame.add(loginLabel);
        frame.add(passwordLabel);
        frame.add(welcomeShadeLabel);
        frame.add(welcomeLabel);
        frame.add(loginField);
        frame.add(passwordField);
        frame.add(loginButton);
        frame.add(resetButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 270); //390
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new java.awt.Color(43, 43, 43));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginButton){

            User login = findLogin(loginField.getText());
            String password = String.valueOf(passwordField.getPassword());


            if(login == null){
                messageErrLabel.setVisible(true);
                frame.setSize(420, 300);
            }
            else if(password.equals(login.getPassword())){
                App app = new App();
                frame.dispose();
            }

        }

        if (e.getSource() == resetButton) {
            loginField.setText("");
            passwordField.setText("");
            messageErrLabel.setVisible(false);
            frame.setSize(420, 270);
        }

    }
}
