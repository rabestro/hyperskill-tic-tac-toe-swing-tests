package tictactoe;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel {
    final PlayerChooser[] players = new PlayerChooser[]{new PlayerChooser(), new PlayerChooser()};
    private final JButton start = new JButton("Start");

    Toolbar(final ActionListener listener) {
        setLayout(new GridLayout(1, 3));
        add(players[0]);
        add(start);
        add(players[1]);
        setPreferredSize(new Dimension(450, 30));
        setVisible(true);
        start.setName("ButtonStartReset");
        start.addActionListener(listener);
    }

    public void startGame() {
        players[0].setEnabled(false);
        players[1].setEnabled(false);
        start.setText("Reset");
    }

    public void resetGame() {
        players[0].setEnabled(true);
        players[1].setEnabled(true);
        start.setText("Start");
    }
}