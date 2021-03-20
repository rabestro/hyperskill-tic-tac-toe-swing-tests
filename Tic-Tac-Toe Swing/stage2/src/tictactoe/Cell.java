package tictactoe;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;

class Cell extends JButton {
    private static final Font COMIC_SANS = new Font("Comic Sans", Font.BOLD, 50);
    private static final String EMPTY_CELL = " ";

    Cell(final String name, final ActionListener listener) {
        super(EMPTY_CELL);
        setName(name);
        setFont(COMIC_SANS);
        addActionListener(listener);
        setFocusPainted(false);
        setVisible(true);
    }
}