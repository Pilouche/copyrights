package blockchain.copyrights;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class App {

    private static Web3j WEB3;
    private static Window MAIN_WINDOW;
    private static Container MAIN_CONTAINER;
    private static Credentials WALLET = null;
    private static boolean IS_LOGGED = false;

    public App() {
        WEB3 = Web3j.build(new HttpService());

        MAIN_WINDOW = new Window("Artwork Copyrights Manager", 1000, 1000);
        MAIN_CONTAINER = MAIN_WINDOW.getContentPane();

        JPanel top_bar = new JPanel();
        top_bar.setBackground(Color.GREEN);
        top_bar.setPreferredSize(new Dimension(MAIN_WINDOW.getWidth(), 100));
        MAIN_CONTAINER.add(top_bar, BorderLayout.NORTH);

        loginComponent();

    }

    private void loginComponent() {
        // Account location
        /*JPanel account = new JPanel();
        JLabel account_label = new JLabel("Account location :");
        JTextArea account_text = new JTextArea();
        account.add(account_label);
        account.add(account_text);
        // Password
        JPanel password = new JPanel();
        JLabel password_label = new JLabel("Password :");
        JTextArea password_text = new JTextArea();
        password.add(password_label);
        password.add(password_text);
        // Button
        JButton login_button = new JButton("Login");
        login_button.setAlignmentX(Component.CENTER_ALIGNMENT);
        login_button.addActionListener(new LoginListener(account_text, password_text));
        // Login
        JPanel login_pane = new JPanel();
        login_pane.setBackground(Color.BLUE);
        login_pane.add(account, BorderLayout.NORTH);
        login_pane.add(password, BorderLayout.CENTER);
        login_pane.add(login_button, BorderLayout.SOUTH);
        MAIN_CONTAINER.add(login_pane);*/

        JPanel account = new JPanel();
        JLabel account_label = new JLabel("Account location :");
        JTextArea account_text = new JTextArea();
        account.add(account_label);
        account.add(account_text);
        MAIN_CONTAINER.add(account, BorderLayout.CENTER);

    }

    class LoginListener implements ActionListener {
        private JTextArea LOCATION;
        private JTextArea PWD;

        public LoginListener(JTextArea location, JTextArea pwd) {
            LOCATION = location;
            PWD = pwd;
        }

        public void actionPerformed(ActionEvent e) {
            try {
                WALLET = WalletUtils.loadCredentials(PWD.getText(), LOCATION.getText());
                IS_LOGGED = true;
            } catch (IOException | CipherException ex) {
                ex.printStackTrace();
            }
            if (IS_LOGGED) {
                System.out.println(PWD.getText());
                System.out.println(LOCATION.getText());
            }
        }
    }
}