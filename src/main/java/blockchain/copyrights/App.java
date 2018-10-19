package blockchain.copyrights;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;

public class App {

    public static void main(String[] args) {

        String pwd = "test";
        String LOCATION_ACCOUNT = "test";
        Web3j web3 = Web3j.build(new HttpService());

        Credentials credentialsWallet = null;
        try {
            credentialsWallet = WalletUtils.loadCredentials(pwd, LOCATION_ACCOUNT);
        } catch (IOException | CipherException e) {
            e.printStackTrace();
        }

    }
}