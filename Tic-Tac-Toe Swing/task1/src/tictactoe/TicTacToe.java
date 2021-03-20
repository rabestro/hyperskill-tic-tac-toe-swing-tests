package tictactoe;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new Board(), BorderLayout.CENTER);
        setSize(450, 450);
        setBackground(Color.WHITE);
        setTitle("Tic Tac Toe");
        setResizable(false);
        setVisible(true);
    }
}