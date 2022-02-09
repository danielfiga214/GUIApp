package com.example.LogInProject.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSelect implements ActionListener {


    JFrame frame = new JFrame();
    JButton snakeButton = new JButton("sssoon");
    JButton tictactoeButton = new JButton("TicTacToe");
    JLabel tictactoe = new JLabel( "Play TicTacToe! -------->");
    JLabel signUpLabel = new JLabel("Coming soon... --------->");
    JLabel welcomeShadeLabel = new JLabel("Games!!");
    JLabel welcomeLabel = new JLabel("Games!!");

    public GameSelect(){
        welcomeLabel.setBounds(94, 14, 390, 75);
        welcomeLabel.setFont(new Font(null, Font.BOLD, 50));
        welcomeLabel.setForeground(Color.BLACK);
        welcomeShadeLabel.setBounds(90, 10, 390, 75);
        welcomeShadeLabel.setFont(new Font(null, Font.BOLD, 50));
        welcomeShadeLabel.setForeground(new java.awt.Color(202, 116, 48));

        tictactoe.setBounds(45, 100, 275, 25);
        tictactoe.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
        tictactoe.setForeground(Color.WHITE);
        signUpLabel.setBounds(45, 140, 275, 25);
        signUpLabel.setFont(new Font("JetBrains Mono", Font.BOLD, 12));
        signUpLabel.setForeground(Color.WHITE);

        snakeButton.setBounds(250, 140, 95, 25);
        snakeButton.setFocusable(false);
        snakeButton.addActionListener(this);

        tictactoeButton.setBounds(250, 100, 95, 25);
        tictactoeButton.setFocusable(false);
        tictactoeButton.addActionListener(this);


        frame.add(snakeButton);
        frame.add(tictactoeButton);
        frame.add(tictactoe);
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
        if(e.getSource()== tictactoeButton){
            TicTacToe ticTacToe = new TicTacToe();
        }

    }
}
