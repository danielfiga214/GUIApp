package com.example.LogInProject.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage implements ActionListener {

    JFrame frame = new JFrame();
    JButton signUpButton = new JButton("Sign up");
    JButton logInButton = new JButton("Log in");
    JLabel logInLabel = new JLabel("Have an Account? ------->");
    JLabel signUpLabel = new JLabel("Don't have an Account? ->");
    JLabel welcomeShadeLabel = new JLabel("Welcome");
    JLabel welcomeLabel = new JLabel("Welcome");

    public WelcomePage(){
        welcomeLabel.setBounds(84, 14, 390, 75);
        welcomeLabel.setFont(new Font(null, Font.BOLD, 50));
        welcomeLabel.setForeground(Color.BLACK);
        welcomeShadeLabel.setBounds(80, 10, 390, 75);
        welcomeShadeLabel.setFont(new Font(null, Font.BOLD, 50));
        welcomeShadeLabel.setForeground(new java.awt.Color(202, 116, 48));

        logInLabel.setBounds(45, 100, 275, 25);
        logInLabel.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
        logInLabel.setForeground(Color.WHITE);
        signUpLabel.setBounds(45, 140, 275, 25);
        signUpLabel.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
        signUpLabel.setForeground(Color.WHITE);

        logInButton.setBounds(250, 100, 95, 25);
        logInButton.setFocusable(false);
        logInButton.addActionListener(this);

        signUpButton.setBounds(250, 140, 95, 25);
        signUpButton.setFocusable(false);
        signUpButton.addActionListener(this);

        frame.add(signUpButton);
        frame.add(logInButton);
        frame.add(logInLabel);
        frame.add(signUpLabel);
        frame.add(welcomeShadeLabel);
        frame.add(welcomeLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 270); //390
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new java.awt.Color(43, 43, 43));


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpButton){
            SignUp signUp = new SignUp();
            frame.dispose();
        }

        if(e.getSource() == logInButton){
            LogIn logIn = new LogIn();
            frame.dispose();
        }

    }
}
