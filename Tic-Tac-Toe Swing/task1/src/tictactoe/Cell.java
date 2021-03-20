package tictactoe;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    private static final Font COMIC_SANS = new Font("Comic Sans", Font.BOLD, 50);

    Cell(final String name) {
        super(name);
        setName("Button" + name);
        setFont(COMIC_SANS);
        setFocusPainted(false);
        setVisible(true);
    }
}