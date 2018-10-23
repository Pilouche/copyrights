package blockchain.copyrights;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.math.BigDecimal;

public class App implements ItemListener {

    private static JPanel MAIN_GUI;
    private static Web3j WEB3;
    private static Window MAIN_WINDOW;
    private static Container MAIN_CONTAINER;
    private static Credentials WALLET = null;
    private static boolean IS_LOGGED = false;

    public App() {

        WEB3 = Web3j.build(new HttpService());

        MAIN_WINDOW = new Window("Artwork Copyrights Manager", 1000, 1000);
        MAIN_CONTAINER = MAIN_WINDOW.getContentPane();

        resetContainer();
        setTopBar();
        setLoginComponent();
        refreshContainer();

    }

    private void refreshContainer() {
        MAIN_WINDOW.setContentPane(MAIN_CONTAINER);
    }

    private void resetContainer() {
        MAIN_CONTAINER.removeAll();
    }

    private void setTopBar() {
        String text;
        if (IS_LOGGED) {
            text = "Balance : 1750 ETH";
        } else {
            text = "Connection";
        }
        if (WALLET != null) {
            String address = WALLET.getAddress();
            try {
                EthGetBalance ethGetBalance = WEB3.ethGetBalance(address, DefaultBlockParameterName.LATEST).sendAsync().get();
                BigDecimal balance = Convert.fromWei(ethGetBalance.getBalance().toString(), Convert.Unit.ETHER);
                text = "Balance : " + balance + " ETH";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        JLabel top_text = new JLabel(text);
        JPanel top_pane = new JPanel();
        top_pane.setPreferredSize(new Dimension(MAIN_WINDOW.getWidth(), 50));
        top_pane.add(top_text);
        if (IS_LOGGED) {
            JButton deco_button = new JButton("Log out");
            deco_button.addActionListener(new DecoListener());
            top_pane.add(deco_button, BorderLayout.EAST);
        }
        MAIN_CONTAINER.add(top_pane);
    }

    private void setMainGUI() {
        MAIN_GUI = new JPanel(new CardLayout());

        String producteurPanel = "Producteur";
        String artistePanel = "Artiste";
        String investisseurPanel = "Investisseur";
        String clientPanel = "Client";
        String comboBoxItems[] = { producteurPanel, artistePanel, investisseurPanel, clientPanel };
        JPanel comboBoxPane = new JPanel();
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        cb.addItemListener(this);
        comboBoxPane.add(cb);

        setProducteurView(producteurPanel);
        setArtisteView(artistePanel);
        setInvestisseurView(investisseurPanel);
        setClientView(clientPanel);

        MAIN_CONTAINER.add(comboBoxPane, BorderLayout.PAGE_START);
        MAIN_CONTAINER.add(MAIN_GUI, BorderLayout.CENTER);
    }

    private void setProducteurView(String name) {
        Producteur panel = new Producteur(WEB3, WALLET, MAIN_WINDOW.getWidth(), MAIN_WINDOW.getHeight());
        MAIN_GUI.add(panel, name);
    }

    private void setArtisteView(String name) {
        Artiste panel = new Artiste(WEB3, WALLET, MAIN_WINDOW.getWidth(), MAIN_WINDOW.getHeight());
        MAIN_GUI.add(panel, name);
    }

    private void setInvestisseurView(String name) {
        JPanel panel = new JPanel();

        JLabel labelTest = new JLabel(name);
        panel.add(labelTest);
        // GUI code here

        MAIN_GUI.add(panel, name);
    }

    private void setClientView(String name) {
        JPanel panel = new JPanel();

        JLabel labelTest = new JLabel(name);
        panel.add(labelTest);
        // GUI code here

        MAIN_GUI.add(panel, name);
    }

    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(MAIN_GUI.getLayout());
        cl.show(MAIN_GUI, (String)evt.getItem());
    }

    class DecoListener implements ActionListener {
        public DecoListener() {}

        public void actionPerformed(ActionEvent e) {
            IS_LOGGED = false;
            resetContainer();
            setTopBar();
            setLoginComponent();
            refreshContainer();
        }
    }

    class LoginListener implements ActionListener {
        private JTextField LOCATION;
        private JTextField PWD;

        public LoginListener(JTextField location, JTextField pwd) {
            LOCATION = location;
            PWD = pwd;
        }

        public void actionPerformed(ActionEvent e) {
            IS_LOGGED = true;
            /*try {
                WALLET = WalletUtils.loadCredentials(PWD.getText(), LOCATION.getText());
                IS_LOGGED = true;
            } catch (IOException | CipherException ex) {
                ex.printStackTrace();
            }*/
            if (IS_LOGGED) {
                resetContainer();
                setTopBar();
                setMainGUI();
                refreshContainer();
            }
        }
    }

    private void setLoginComponent() {
        // Layout
        GridLayout login_layout = new GridLayout(3, 0);
        // Account location
        JPanel account = new JPanel();
        JLabel account_label = new JLabel("Account location :");
        JTextField account_text = new JTextField(10);
        account.add(account_label);
        account.add(account_text);
        // Password
        JPanel password = new JPanel();
        JLabel password_label = new JLabel("Password :");
        JTextField password_text = new JTextField(10);
        password.add(password_label);
        password.add(password_text);
        // Button
        JButton login_button = new JButton("Login");
        login_button.setAlignmentX(Component.CENTER_ALIGNMENT);
        login_button.addActionListener(new LoginListener(account_text, password_text));
        // Login
        JPanel login_pane = new JPanel();
        login_pane.setBackground(Color.BLUE);
        login_pane.setLayout(login_layout);
        login_pane.add(account);
        login_pane.add(password);
        login_pane.add(login_button);
        MAIN_CONTAINER.add(login_pane);
    }
}