package tictactoe;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

public class StatusBar extends JPanel {
    final JLabel status = new JLabel(Board.State.NOT_STARTED.getMessage());

    {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        status.setName("LabelStatus");
        status.setPreferredSize(new Dimension(350, 20));
        add(status);
    }

    StatusBar(final ActionListener actionListener) {
        final var reset = new JButton();
        reset.setName("ButtonReset");
        reset.setText("Reset");
        reset.addActionListener(actionListener);
        add(reset);
    }

    void setMessage(Board.State state) {
        status.setText(state.getMessage());
    }
}
