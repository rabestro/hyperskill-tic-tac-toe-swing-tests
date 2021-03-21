package tictactoe;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class StatusBar extends JPanel {
    final JLabel status = new JLabel(Board.State.NOT_STARTED.getMessage());

    {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        status.setName("LabelStatus");
        status.setPreferredSize(new Dimension(350, 20));
        add(status);
    }
    void setMessage(Board.State state) {
        status.setText(state.getMessage());
    }
}
