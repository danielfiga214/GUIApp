package com.example.LogInProject.GUI;


import com.example.LogInProject.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.example.LogInProject.LogInProjectApplication.createNewUser;
import static com.example.LogInProject.LogInProjectApplication.findLogin;

public class SignUp implements ActionListener {

    static String firstName;
    static String lastName;
    static String login;
    static String password;

    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Sign up");
    JButton resetButton = new JButton("Reset");
    JTextField firstNameField = new JTextField();
    JTextField lastNameField = new JTextField();
    JTextField loginField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JLabel firstNameLabel = new JLabel("First name");
    JLabel lastNameLabel = new JLabel("Last name");
    JLabel loginLabel = new JLabel("Your login");
    JLabel passwordLabel = new JLabel("Password");
    JLabel messageSuccessLabel = new JLabel("New User was registered");
    JLabel messageErrLabel = new JLabel("Please fill all field above");
    JLabel welcomeShadeLabel = new JLabel("Sign Up page");
    JLabel welcomeLabel = new JLabel("Sign Up page");

    User dbUser = null;

    public SignUp() {

        firstNameLabel.setBounds(45, 100, 75, 25);
        firstNameLabel.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
        firstNameLabel.setForeground(Color.WHITE);
        lastNameLabel.setBounds(45, 140, 75, 25);
        lastNameLabel.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
        lastNameLabel.setForeground(Color.WHITE);
        loginLabel.setBounds(45, 180, 75, 25);
        loginLabel.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
        loginLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(45, 220, 75, 25);
        passwordLabel.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
        passwordLabel.setForeground(Color.WHITE);

        welcomeLabel.setBounds(39, 14, 390, 75);
        welcomeLabel.setFont(new Font(null, Font.BOLD, 50));
        welcomeLabel.setForeground(Color.BLACK);
        welcomeShadeLabel.setBounds(35, 10, 390, 75);
        welcomeShadeLabel.setFont(new Font(null, Font.BOLD, 50));
        welcomeShadeLabel.setForeground(new java.awt.Color(202, 116, 48));

        messageSuccessLabel.setBounds(35, 280, 390, 75);
        messageSuccessLabel.setFont(new Font(null, Font.ITALIC, 30));
        messageSuccessLabel.setForeground(new java.awt.Color(105, 134, 88));
        messageSuccessLabel.setVisible(false);

        messageErrLabel.setBounds(35, 280, 390, 75);
        messageErrLabel.setFont(new Font(null, Font.ITALIC, 30));
        messageErrLabel.setForeground(new java.awt.Color(225, 0, 0));
        messageErrLabel.setVisible(false);

        firstNameField.setBounds(125, 100, 200, 25);
        lastNameField.setBounds(125, 140, 200, 25);
        loginField.setBounds(125, 180, 200, 25);
        passwordField.setBounds(125, 220, 200, 25);

        loginButton.setBounds(125, 260, 95, 25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(230, 260, 95, 25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        frame.add(firstNameLabel);
        frame.add(lastNameLabel);
        frame.add(loginLabel);
        frame.add(passwordLabel);
        frame.add(messageSuccessLabel);
        frame.add(messageErrLabel);
        frame.add(welcomeShadeLabel);
        frame.add(welcomeLabel);

        frame.add(firstNameField);
        frame.add(lastNameField);
        frame.add(loginField);
        frame.add(passwordField);

        frame.add(loginButton);
        frame.add(resetButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 350); //390
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new java.awt.Color(43, 43, 43));

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == resetButton) {
            firstNameField.setText("");
            lastNameField.setText("");
            loginField.setText("");
            passwordField.setText("");

            messageSuccessLabel.setVisible(false);
            messageErrLabel.setVisible(false);
            frame.setSize(420, 350);
        }

        if (e.getSource() == loginButton) {
            firstName = firstNameField.getText();
            lastName = firstNameField.getText();
            login = loginField.getText();
            password = String.valueOf(passwordField.getPassword());
            dbUser = findLogin(loginField.getText());

            if (firstName.length() != 0 && lastName.length() != 0 && login.length() != 0 && password.length() != 0) {
                if (dbUser == null){
                    messageSuccessLabel.setVisible(true);
                    messageErrLabel.setVisible(false);
                    frame.setSize(420, 390);
                    LogIn logIn = new LogIn();
                    createNewUser(firstName, lastName, login, password);
                    frame.dispose();
                }
                else if (login.equals(dbUser.getLogin())) {
                    messageErrLabel.setBounds(40, 280, 390, 75);
                    messageErrLabel.setText("Login is already taken");
                    messageErrLabel.setVisible(true);
                    frame.setSize(420, 390);
                }

            } else {
                messageErrLabel.setVisible(true);
                messageSuccessLabel.setVisible(false);
                frame.setSize(420, 390);
            }
        }
    }

}


