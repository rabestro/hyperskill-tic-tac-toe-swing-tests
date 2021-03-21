package tictactoe;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;

class Cell extends JButton {
    private static final Font COMIC_SANS = new Font("Comic Sans", Font.BOLD, 50);
    private static final String EMPTY_CELL = " ";

    Cell(final String name, final ActionListener listener) {
        super(EMPTY_CELL);
        setName("Button" + name);
        setFont(COMIC_SANS);
        addActionListener(listener);
        setFocusPainted(false);
        setVisible(true);
    }

    void clear() {
        setText(Mark.EMPTY.getMark());
    }

    boolean isEmpty() {
        return getText().equals(Mark.EMPTY.getMark());
    }

    void setMark(final Mark mark) {
        setText(mark.getMark());
    }

    public enum Mark {
        EMPTY(" "), X("X"), O("O");

        private String mark;

        public String getMark() {
            return mark;
        }

        Mark(String mark) {
            this.mark = mark;
        }
    }
}