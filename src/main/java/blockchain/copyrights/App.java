package blockchain.copyrights;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple9;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.utils.Convert;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Vector;

public class App implements ItemListener {

    private static JPanel MAIN_GUI;
    public static Web3j WEB3;
    private static Window MAIN_WINDOW;
    private static Container MAIN_CONTAINER;
    public static Credentials WALLET = null;
    public static Copyrights BLOCKCHAIN = null;
    public static String USERNAME;
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
            text = "Error: could not get balance. Please logout and reconnect.";
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

    public static Vector<Artwork> getArtworks() {
        Vector<Artwork> artworks = new Vector<>();
        int count = 0;
        System.out.println("Getting artwork count...");
        try {
            count = BLOCKCHAIN.getArtworksCount().send().intValue();
            System.out.println("Artwork count is "+count);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Getting artwork "+(i+1));
            try {
                Tuple9 tuple = BLOCKCHAIN.getArtwork(BigInteger.valueOf(i)).send();
                artworks.add(new Artwork(tuple.getValue1().toString(), tuple.getValue2().toString(), tuple.getValue3().toString(), tuple.getValue4().toString(), tuple.getValue5().toString(), tuple.getValue6().toString(), (BigInteger) tuple.getValue7(), (BigInteger) tuple.getValue8(), (BigInteger) tuple.getValue9()));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return artworks;
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
        Producteur panel = new Producteur(MAIN_WINDOW.getWidth(), MAIN_WINDOW.getHeight());
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
            WALLET = null;
            BLOCKCHAIN = null;
            resetContainer();
            setTopBar();
            setLoginComponent();
            refreshContainer();
        }
    }

    class LoginListener implements ActionListener {
        private JTextField LOCATION;
        private JPasswordField PWD;
        private JTextField ADDR;

        public LoginListener(JTextField name, JTextField location, JPasswordField pwd, JTextField addr) {
            USERNAME = name.getText();
            LOCATION = location;
            PWD = pwd;
            ADDR = addr;
        }

        public void actionPerformed(ActionEvent e) {
            System.out.println("Logging in...");
            // WALLET connexion
            try {
                WALLET = WalletUtils.loadCredentials(String.valueOf(PWD.getPassword()), LOCATION.getText());
                System.out.println("Wallet is : "+WALLET);
                IS_LOGGED = true;
            } catch (IOException | CipherException ex) {
                ex.printStackTrace();
            }
            System.out.println("Catching blockchain...");
            // BLOCKCHAIN initialization
            try {
                //BLOCKCHAIN = Copyrights.deploy(WEB3, WALLET, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT).send();
                //System.out.println(BLOCKCHAIN.getContractAddress());
                BLOCKCHAIN = Copyrights.load(ADDR.getText(), WEB3, WALLET, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);
                System.out.println("Got blockchain !");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            if (IS_LOGGED) {
                //createTestArtworks();
                resetContainer();
                setTopBar();
                setMainGUI();
                refreshContainer();
            }
        }
    }

    private void createTestArtworks() {
        System.out.println("Creating artwork one...");
        try {
            BLOCKCHAIN.newArtwork("Requiem pour un fou","Song","0xe2e7873a04f16c41d1c416963c0d5da2a6e40ba6","Johnny Hallyday","0xe1771c0ca66f2372e31f396d794dcb1c4ec0b46d", "Augustin Gaillot", BigInteger.valueOf(1000000), BigInteger.valueOf(10)).send();
            System.out.println("Artwork one done.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("Creating artwork two...");
        try {
            BLOCKCHAIN.newArtwork("Rap God","Song","0xe2e7873a04f16c41d1c416963c0d5da2a6e40ba6","Eminem","0xe1771c0ca66f2372e31f396d794dcb1c4ec0b46d", "Augustin Gaillot", BigInteger.valueOf(2000), BigInteger.valueOf(1)).send();
            System.out.println("Artwork two done.");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void setLoginComponent() {
        // Layout
        GridLayout login_layout = new GridLayout(5, 0);
        // Username
        JPanel name = new JPanel();
        JLabel name_label = new JLabel("Name :");
        JTextField name_text = new JTextField(20);
        name_text.setText("Augustin Gaillot");
        name.add(name_label);
        name.add(name_text);
        // Account location
        JPanel account = new JPanel();
        JLabel account_label = new JLabel("Account location :");
        JTextField account_text = new JTextField(50);
        account_text.setText("/home/augustin/.ethereum/sharedchainJag/keystore/UTC--2018-10-08T07-15-28.021916890Z--e1771c0ca66f2372e31f396d794dcb1c4ec0b46d");
        account.add(account_label);
        account.add(account_text);
        // Password
        JPanel password = new JPanel();
        JLabel password_label = new JLabel("Password :");
        JPasswordField password_text = new JPasswordField(20);
        password_text.setEchoChar('*');
        password.add(password_label);
        password.add(password_text);
        // Bloackchain address
        JPanel address = new JPanel();
        JLabel address_label = new JLabel("Blockchain address :");
        JTextField address_text = new JTextField(20);
        address_text.setText("0x6f935219eea15ebcd6db62e8edfb282e69791c48");
        address.add(address_label);
        address.add(address_text);
        // Button
        JButton login_button = new JButton("Login");
        login_button.setAlignmentX(Component.CENTER_ALIGNMENT);
        login_button.addActionListener(new LoginListener(name_text, account_text, password_text, address_text));
        // Login
        JPanel login_pane = new JPanel();
        login_pane.setLayout(login_layout);
        login_pane.add(name);
        login_pane.add(account);
        login_pane.add(password);
        login_pane.add(address);
        login_pane.add(login_button);
        MAIN_CONTAINER.add(login_pane);
    }
}