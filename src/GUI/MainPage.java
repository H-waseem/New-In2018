package GUI;

import javax.swing.*;
import java.awt.*;

public class MainPage extends JFrame {

    JButton logoutButton = new JButton("Logout");
    JPanel mainPanel = new JPanel(new GridLayout(3, 1));

    MainPage() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Welcome");
        this.setSize(400, 200);
        this.setVisible(true);

        JLabel wel_label = new JLabel("Welcome");
        mainPanel.add(wel_label);
        mainPanel.add(logoutButton);
        add(mainPanel, BorderLayout.CENTER);
        logoutButton.addActionListener(e -> logoutButtonClicked());
    }



    private void logoutButtonClicked() {
        this.dispose();
        new LogInPanel();
//        mainPanel.setVisible(false);
//        LogInPanel logInPanel = new LogInPanel();
//        logInPanel.setVisible(true);
//        this.add(logInPanel);
    }
}
