package blockchain.copyrights;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;

import javax.swing.*;
import java.awt.*;

public class Artiste extends JPanel {

    private static Web3j WEB3;
    private static Credentials WALLET;
    private static int HEIGHT;
    private static int WIDTH;

    public Artiste(Web3j web3, Credentials wallet, int height, int width) {
        WEB3 = web3;
        WALLET = wallet;
        HEIGHT = height;
        WIDTH = width;
        JTabbedPane tabbed_pane = new JTabbedPane();
        tabbed_pane.addTab("My projects", myProjectsView());
        this.add(tabbed_pane);
    }

    private JPanel myProjectsView() {
        JPanel panel = new JPanel();

        JLabel label = new JLabel("My projects view");
        panel.add(label);

        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        return panel;
    }
}
