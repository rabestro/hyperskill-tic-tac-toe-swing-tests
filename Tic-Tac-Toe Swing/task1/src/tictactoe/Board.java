package tictactoe;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Stream;

public class Board extends JPanel  {
    {
        setSize(450,450);
        setBackground(Color.WHITE);
        setLayout(new GridLayout(3, 3));
        Stream.of("A3", "B3", "C3", "A2", "B2", "C2", "A1", "B1", "C1")
                .map(Cell::new)
                .forEach(this::add);
        setVisible(true);
    }
}