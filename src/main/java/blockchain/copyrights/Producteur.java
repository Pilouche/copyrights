package blockchain.copyrights;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

public class Producteur extends JPanel {

    private static int HEIGHT;
    private static int WIDTH;

    public Producteur(int height, int width) {
        HEIGHT = height;
        WIDTH = width;
        JTabbedPane tabbed_pane = new JTabbedPane();
        tabbed_pane.addTab("My projects", myProjectsView());
        tabbed_pane.addTab("New project", newProjectView());
        tabbed_pane.addTab("Buy projects", buyProjectView());
        this.add(tabbed_pane);
    }

    private JPanel myProjectsView() {
        JPanel panel = new JPanel();

        JLabel label = new JLabel("My projects view");
        panel.add(label);
        JButton button = new JButton("Get blockchain");
        button.addActionListener(new ProjectsListener());
        panel.add(button);

        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        return panel;
    }

    class ProjectsListener implements ActionListener {
        public ProjectsListener() {}

        public void actionPerformed(ActionEvent e) {
            int count = 0;
            System.out.println("Getting artwork count...");
            try {
                count = App.BLOCKCHAIN.getArtworksCount().send().intValue();
                System.out.println("Artwork count is "+count);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            for (int i = 0; i < count; i++) {
                System.out.println("Getting artwork "+i);
                try {
                    System.out.println(App.BLOCKCHAIN.getArtwork(BigInteger.valueOf(i)).send());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private JPanel newProjectView() {
        JPanel panel = new JPanel();

        GridLayout grid = new GridLayout(2,2);
        panel.setLayout(grid);

        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        return panel;
    }

    private JPanel buyProjectView() {
        JPanel panel = new JPanel();

        JLabel label = new JLabel("Buy project view");
        panel.add(label);

        panel.setPreferredSize(new Dimension(HEIGHT, WIDTH));
        return panel;
    }
}
