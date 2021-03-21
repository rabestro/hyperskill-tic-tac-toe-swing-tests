package tictactoe;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class AppMenu extends JMenuBar {

    public AppMenu(final ActionListener actionListener) {
        final var menuFile = new JMenu("Game");
        menuFile.setName("MenuGame");
        menuFile.setMnemonic(KeyEvent.VK_G);
        add(menuFile);

        final var menuItemHH = new JMenuItem("Human vs Human", KeyEvent.VK_H);
        menuItemHH.setName("MenuHumanHuman");
        menuItemHH.addActionListener(actionListener);

        final var menuItemHR = new JMenuItem("Human vs Robot", KeyEvent.VK_R);
        menuItemHR.setName("MenuHumanRobot");
        menuItemHR.addActionListener(actionListener);

        final var menuItemRH = new JMenuItem("Robot vs Human", KeyEvent.VK_U);
        menuItemRH.setName("MenuHumanHuman");
        menuItemRH.addActionListener(actionListener);

        final var menuItemRR = new JMenuItem("Robot vs Robot", KeyEvent.VK_O);
        menuItemRR.setName("MenuHumanHuman");
        menuItemRR.addActionListener(actionListener);

        final var menuItemExit = new JMenuItem("Exit", KeyEvent.VK_X);
        menuItemExit.setName("MenuExit");
        menuItemExit.addActionListener(actionListener);

        menuFile.add(menuItemHH);
        menuFile.add(menuItemHR);
        menuFile.add(menuItemRH);
        menuFile.add(menuItemRR);
        menuFile.addSeparator();
        menuFile.add(menuItemExit);
    }

}