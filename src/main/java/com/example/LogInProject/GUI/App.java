package com.example.LogInProject.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App implements ActionListener {
    JFrame frame = new JFrame();

    JLabel textLabel = new JLabel("Well this app don't do anything, sorry ¯\\_(-_-)_/¯ ");
    JButton unlessButton = new JButton("Unless...");

    JLabel welcomeShadeLabel = new JLabel("Welcome to my app");
    JLabel welcomeLabel = new JLabel("Welcome to my app");

    public App() {
        welcomeLabel.setBounds(62, 14, 790, 75);
        welcomeLabel.setFont(new Font(null, Font.BOLD, 50));
        welcomeLabel.setForeground(Color.BLACK);
        welcomeShadeLabel.setBounds(58, 10, 790, 75);
        welcomeShadeLabel.setFont(new Font(null, Font.BOLD, 50));
        welcomeShadeLabel.setForeground(new java.awt.Color(202, 116, 48));

        textLabel.setBounds(60, 125, 500, 25);
        textLabel.setFont(new Font("JetBrains Mono", Font.BOLD, 16));
        textLabel.setForeground(Color.WHITE);

        unlessButton.setBounds(250, 180, 95, 25);
        unlessButton.setFocusable(false);
        unlessButton.setBackground(new Color(43, 43, 43));
        unlessButton.setForeground(new Color(160, 116, 172));
        unlessButton.addActionListener(this);


        frame.add(textLabel);
        frame.add(unlessButton);
        frame.add(welcomeShadeLabel);
        frame.add(welcomeLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(620, 270); //390
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(new Color(43, 43, 43));

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == unlessButton){
            GameSelect gameSelect = new GameSelect();
            frame.dispose();
        }
    }
}