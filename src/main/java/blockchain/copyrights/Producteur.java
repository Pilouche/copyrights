package blockchain.copyrights;

import org.web3j.utils.Convert;

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
    private Vector<Artwork> MY_ARTWORKS;
    private Object[][] arrayValues;
    private final String[] COLUMNS = {
            "Name",
            "Category",
            "Artist name",
            "Producer name",
            "Producer investment",
            "Total worth",
            "Fare"
    };

    public Producteur(int height, int width) {
        HEIGHT = height;
        WIDTH = width;
        ARTWORKS = App.getArtworks();
        getMyArtworks();
        JTabbedPane tabbed_pane = new JTabbedPane();
        tabbed_pane.addTab("My projects", myProjectsView());
        tabbed_pane.addTab("New project", newProjectView());
        tabbed_pane.addTab("Buy projects", buyProjectView());
        this.add(tabbed_pane);
    }

    private void getMyArtworks() {
        MY_ARTWORKS = new Vector<>();
        for (int i = 0; i < ARTWORKS.size(); i++) {
            if (ARTWORKS.get(i).producer_addr.compareTo(App.WALLET.getAddress()) == 0)
                MY_ARTWORKS.add(ARTWORKS.get(i));
        }
        if (MY_ARTWORKS.size() > 0)
            setTableValues();
    }

    private void setTableValues() {
        arrayValues = new Object[MY_ARTWORKS.size()][COLUMNS.length];
        for (int i = 0; i < MY_ARTWORKS.size(); i++) {
            arrayValues[i] = MY_ARTWORKS.get(i).toArray();
        }
    }

    private JPanel myProjectsView() {
        JPanel panel = new JPanel();
        if (MY_ARTWORKS.size() == 0) {
            JLabel label = new JLabel("You have no project yet.");
            panel.add(label);
        } else {
            JTable table = new JTable(arrayValues, COLUMNS);
            table.setPreferredScrollableViewportSize(new Dimension(WIDTH, 500));
            table.setFillsViewportHeight(true);
            JScrollPane scrollPane = new JScrollPane(table);
            panel.add(scrollPane);
        }
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        return panel;
    }

    class ProjectsListener implements ActionListener {
        public ProjectsListener() {}

        public void actionPerformed(ActionEvent e) {
        }
    }

    private JPanel newProjectView() {
        JPanel panel = new JPanel();
        // Layout
        GridLayout layout = new GridLayout(6, 0);
        // Artwork name
        JPanel artwork = new JPanel();
        JLabel artwork_label = new JLabel("Artwork name :");
        JTextField artwork_text = new JTextField(20);
        artwork.add(artwork_label);
        artwork.add(artwork_text);
        // Category
        JPanel category = new JPanel();
        JLabel category_label = new JLabel("Category :");
        JTextField category_text = new JTextField(20);
        category.add(category_label);
        category.add(category_text);
        // Artsist address
        JPanel address = new JPanel();
        JLabel address_label = new JLabel("Artist's address :");
        JTextField address_text = new JTextField(20);
        address.add(address_label);
        address.add(address_text);
        // Artist name
        JPanel artist = new JPanel();
        JLabel artist_label = new JLabel("Artist name :");
        JTextField artist_text = new JTextField(20);
        artist.add(artist_label);
        artist.add(artist_text);
        // Investment
        JPanel investment = new JPanel();
        JLabel investment_label = new JLabel("Initial investment :");
        JTextField investment_text = new JTextField(20);
        investment.add(investment_label);
        investment.add(investment_text);
        // Fare
        JPanel fare = new JPanel();
        JLabel fare_label = new JLabel("Fare :");
        JTextField fare_text = new JTextField(20);
        fare.add(fare_label);
        fare.add(fare_text);
        // Button
        JButton submit_button = new JButton("Submit artwork");
        submit_button.setAlignmentX(Component.CENTER_ALIGNMENT);
        submit_button.addActionListener(new SubmitListener(artwork_text, category_text, address_text, artist_text, investment_text, fare_text));

        panel.setLayout(layout);
        panel.add(artwork);
        panel.add(category);
        panel.add(address);
        panel.add(artist);
        panel.add(investment);
        panel.add(fare);
        panel.add(submit_button);

        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        return panel;
    }

    class SubmitListener implements ActionListener {
        private JTextField ARTWORK;
        private JTextField CAT;
        private JTextField ADDR;
        private JTextField ARTIST;
        private JTextField INVEST;
        private JTextField FARE;

        public SubmitListener(JTextField artwork, JTextField cat, JTextField addr, JTextField artist, JTextField invest, JTextField fare) {
            ARTWORK = artwork;
            CAT = cat;
            ADDR = addr;
            ARTIST = artist;
            INVEST = invest;
            FARE = fare;
        }

        public void actionPerformed(ActionEvent e) {
            boolean ok = false;
            try {
                System.out.println("Sending block...");
                App.BLOCKCHAIN.newArtwork(ARTWORK.getText(), CAT.getText(), ADDR.getText(), ARTIST.getText(), App.WALLET.getAddress(), App.USERNAME, BigInteger.valueOf(1000), BigInteger.valueOf(Integer.parseInt(FARE.getText()))).send();
                System.out.println("Block sent!");
                ok = true;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (ok) {
                try {
                    System.out.println("Sending investment...");
                    App.BLOCKCHAIN.productionInvestment(BigInteger.valueOf(ARTWORKS.size()), Convert.toWei(INVEST.getText(), Convert.Unit.WEI).toBigInteger());
                    System.out.println("Investment done.");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    private JPanel buyProjectView() {
        JPanel panel = new JPanel();

        JLabel label = new JLabel("Buy project view");
        panel.add(label);

        panel.setPreferredSize(new Dimension(HEIGHT, WIDTH));
        return panel;
    }
}
