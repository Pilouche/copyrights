package blockchain.copyrights;

import java.awt.*;
import javax.swing.*;

public class Window extends JFrame {

    public Window(String title, int width, int height) {
        this.setTitle(title);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel container = new JPanel();
        container.setBackground(Color.GRAY);

        this.setContentPane(container);
        this.setVisible(true);
    }
}
