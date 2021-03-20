package tictactoe;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicTacToe extends JFrame implements ActionListener {
    private static final Logger log = Logger.getLogger(TicTacToe.class.getName());
    private final Board board = new Board(this);
    private final StatusBar statusBar = new StatusBar(this::reset);

    private int currentPlayer;

    {
        log.info("tictactoe.TicTacToe is started.");
        add(board, BorderLayout.CENTER);
        add(statusBar, BorderLayout.SOUTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 450);
        setBackground(Color.WHITE);
        setTitle("Tic Tac Toe");
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        log.entering(TicTacToe.class.getName(), "actionPerformed", e);
        final var button = (JButton) e.getSource();
        final var index = getIndex(button.getName().substring(6));
        log.log(Level.INFO, "Index: {0}", index);

        if (currentPlayer == 0) {
            button.setText("X");
//            board.set(index, Mark.X);
        } else {
            button.setText("O");
//            board.set(index, Mark.O);
        }
    }

    private static int getIndex(final String notation) {
        return ('3' - notation.charAt(1)) * 3 - 'A' + notation.charAt(0);
    }

    public void reset(final ActionEvent e) {
        board.clear();
        currentPlayer = 0;
        statusBar.status.setText(GameState.NOT_STARTED.getMessage());
    }
}