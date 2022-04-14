package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class LogInPanel extends JFrame implements ActionListener {

    public static Map<String, String> USERS = new HashMap<>() {{
        put("test@gmail.com", "test");
        put("max@gmail.com", "111");
    }};

    Container container = getContentPane();

    JLabel title = new JLabel("Welcome to GARITS");
    JLabel make = new JLabel("Developed by LSC");

    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");

    JLabel logo = new JLabel();
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));


    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Clear fields");
    JCheckBox showPassword = new JCheckBox("Show Password");

    //private static final JLabel l4 = new JLabel();
    //private final JTextField textField1, textField2;

    public LogInPanel() {
        setLayoutManager();
        setPlacement();
        setContainerProperties();
        addActionEvent();
        this.setBounds(10, 10, 1080, 720);
        this.setTitle("GARITS Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setPlacement() {
        logo.setIcon(imageIcon);
        logo.setBounds(925, 535, 150, 150);
        make.setBounds(5, 650, 200, 30);
        make.setForeground(Color.WHITE);

        userLabel.setBounds(400, 150, 100, 30);
        passwordLabel.setBounds(400, 200, 100, 30);


        userLabel.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);
        title.setForeground(Color.WHITE);


        userLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        passwordLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        title.setFont(new Font("Tahoma", Font.BOLD, 25));

        title.setBounds(400, 75, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 25));

        userTextField.setBounds(500, 150, 150, 30);
        passwordField.setBounds(500, 200, 150, 30);

        showPassword.setBounds(500, 230, 150, 30);
        showPassword.setBackground(new Color(35,35,35));
        showPassword.setForeground(Color.WHITE);

        loginButton.setBounds(400, 275, 100, 30);
        resetButton.setBounds(550, 275, 100, 30);


    }

    public void setContainerProperties() {
        container.setBackground(new Color(35,35,35));
        container.add(logo);
        container.add(make);
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(title);

        container.add(userTextField);
        container.add(passwordField);

        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }

    public void displayGUI() {
        // TODO - implement GUI.displayGUI
        throw new UnsupportedOperationException();
    }

    public void takeInput() {
        // TODO - implement GUI.takeInput
        throw new UnsupportedOperationException();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            PreparedStatement st;
            ResultSet rs;
            String username = userTextField.getText();
            String password = String.valueOf(passwordField.getPassword());

            String query = "SELECT Role FROM staff WHERE Username = ? and Password = ?";

            try {
                String url = "jdbc:mysql://127.0.0.1:3306/garits";
                st = DriverManager.getConnection(url, "root", "").prepareStatement(query);

                st.setString(1, username);
                st.setString(2, password);
                rs = st.executeQuery();

                if (rs.next()) {
                    System.out.println("Log in successful");
                    this.dispose();
                    if(rs.getString(1).equals("Admin")){
                        new AdminPanel().setVisible(true);
                    }
                    if(rs.getString(1).equals("Receptionist")){
                        new CustomerPanel().setVisible(true);
                        new VehiclePanel().setVisible(true);
                    }
                    if(rs.getString(1).equals("Foreman")){
                        new CustomerPanel().setVisible(true);
                        new VehiclePanel().setVisible(true);
                        new TaskPanel().setVisible(true);
                    }
                    if(rs.getString(1).equals("Franchisee")){
                        new CustomerPanel().setVisible(true);
                    }
                    if(rs.getString(1).equals("Mechanic")){
                        new JobPanel().setVisible(true);
                        new TaskPanel().setVisible(true);
                        new VehiclePanel().setVisible(true);
                    }

                } else {
                    // error message
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Login Error", 2);
                }
            } catch (HeadlessException | SQLException headlessException) {
                headlessException.printStackTrace();
            }

        }
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }
}