package blockchain.copyrights;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;
import java.util.Vector;

public class Producteur extends JPanel {

    private int HEIGHT;
    private int WIDTH;
    private Vector<Artwork> ARTWORKS;

    public Producteur(int height, int width) {
        HEIGHT = height;
        WIDTH = width;
        JTabbedPane tabbed_pane = new JTabbedPane();
        tabbed_pane.addTab("My projects", myProjectsView());
        tabbed_pane.addTab("New project", newProjectView());
        tabbed_pane.addTab("Buy projects", buyProjectView());
        this.add(tabbed_pane);
        ARTWORKS = App.getArtworks();
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
            for (int i = 0; i < ARTWORKS.size(); i++) {
                System.out.println(ARTWORKS.get(i));
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
