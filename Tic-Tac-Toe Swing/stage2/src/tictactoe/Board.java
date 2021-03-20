package tictactoe;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Board extends JPanel  {
    private static final int[][] TRIPS = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 4, 8}, {2, 4, 6}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}};
    private final List<Cell> cells;

    Board(final ActionListener listener) {
        super();
        setSize(450, 450);
        setBackground(Color.WHITE);
        setLayout(new GridLayout(3, 3));
        cells = Stream.of("A3", "B3", "C3", "A2", "B2", "C2", "A1", "B1", "C1")
                .map(name -> new Cell(name, listener))
                .peek(this::add)
                .collect(Collectors.toUnmodifiableList());

        setVisible(true);
    }

    void clear() {
        cells.forEach(cell -> cell.setText(" "));
    }
}