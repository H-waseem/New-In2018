package GUI.Operations;

import GUI.CustomerPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.*;
import java.time.LocalDate;

public class CreateCustomer extends JFrame implements ActionListener {

    String [] cTypes = {"Casual","Account Holder"};

    Container container = getContentPane();

    JLabel title = new JLabel("Register Customer");
    JLabel make = new JLabel("Developed by LSC");

    JLabel fNameLabel = new JLabel("FIRST NAME");
    JLabel lNameLabel = new JLabel("LAST NAME");
    JLabel addressLabel = new JLabel("ADDRESS");
    JLabel postcodeLabel = new JLabel("POSTCODE");
    JLabel phoneLabel = new JLabel("PHONE");
    JLabel mobileLabel = new JLabel("MOBILE");
    JLabel emailLabel = new JLabel("EMAIL");
    JLabel faxLabel = new JLabel("FAX");
    JLabel roleLabel = new JLabel("TYPE");

    JTextField fNameTextField = new JTextField();
    JTextField lNameTextField = new JTextField();
    JTextField addressTextField = new JTextField();
    JTextField postcodeTextField = new JTextField();
    JTextField phoneTextField = new JTextField();
    JTextField mobileTextField = new JTextField();
    JTextField emailTextField = new JTextField();
    JTextField faxTextField = new JTextField();


    JComboBox roleList = new JComboBox(cTypes);

    JButton backButton = new JButton("Back to menu");
    JButton submitButton = new JButton("Submit");
    JButton resetButton = new JButton("Clear fields");

    JLabel logo = new JLabel();
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));


    public CreateCustomer() {
        setLayoutManager();
        setPlacement();
        setContainerProperties();
        addActionEvent();
        this.setBounds(10, 10, 1080, 720);
        this.setTitle("GARITS Customer registration");
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
        title.setBounds(400, 40, 300, 30);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Tahoma", Font.BOLD, 25));

        fNameLabel.setForeground(Color.WHITE);
        lNameLabel.setForeground(Color.WHITE);
        addressLabel.setForeground(Color.WHITE);
        postcodeLabel.setForeground(Color.WHITE);
        phoneLabel.setForeground(Color.WHITE);
        mobileLabel.setForeground(Color.WHITE);
        emailLabel.setForeground(Color.WHITE);
        faxLabel.setForeground(Color.WHITE);
        roleLabel.setForeground(Color.WHITE);

        fNameLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        lNameLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        addressLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        postcodeLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        phoneLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        mobileLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        emailLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        faxLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        roleLabel.setFont(new Font("Tahoma",Font.BOLD,14));

        fNameLabel.setBounds(400,100,150,30);
        lNameLabel.setBounds(400,150,150,30);
        addressLabel.setBounds(400, 200, 100, 30);
        postcodeLabel.setBounds(400, 250, 100, 30);
        phoneLabel.setBounds(400, 300, 150, 30);
        mobileLabel.setBounds(400, 350, 150, 30);
        emailLabel.setBounds(400, 400, 150, 30);
        faxLabel.setBounds(400, 450, 150, 30);
        roleLabel.setBounds(400, 500, 150, 30);

        fNameTextField.setBounds(500,100,150,30);
        lNameTextField.setBounds(500,150,150,30);
        addressTextField.setBounds(500, 200, 150, 30);
        postcodeTextField.setBounds(500, 250, 150, 30);
        phoneTextField.setBounds(500, 300, 150, 30);
        mobileTextField.setBounds(500,350,150,30);
        emailTextField.setBounds(500,400,150,30);
        faxTextField.setBounds(500, 450, 150, 30);
        roleList.setBounds(500, 500, 150, 30);

        backButton.setBounds(10, 10, 125, 35);
        submitButton.setBounds(400, 600, 100, 30);
        resetButton.setBounds(550, 600, 100, 30);

        submitButton.setBackground(Color.WHITE);
        resetButton.setBackground(Color.WHITE);


    }

    public void setContainerProperties() {
        container.setBackground(new Color(35,35,35));
        container.add(logo);
        container.add(make);
        container.add(title);

        container.add(fNameLabel);
        container.add(lNameLabel);
        container.add(addressLabel);
        container.add(postcodeLabel);
        container.add(phoneLabel);
        container.add(mobileLabel);
        container.add(emailLabel);
        container.add(faxLabel);
        container.add(roleLabel);

        container.add(fNameTextField);
        container.add(lNameTextField);
        container.add(addressTextField);
        container.add(postcodeTextField);
        container.add(phoneTextField);
        container.add(mobileTextField);
        container.add(emailTextField);
        container.add(faxTextField);
        container.add(roleList);

        container.add(backButton);
        container.add(submitButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        submitButton.addActionListener(this);
        resetButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            Date regDate = Date.valueOf(LocalDate.now());
            String fName = fNameTextField.getText();
            String lName = lNameTextField.getText();
            String address = addressTextField.getText();
            String postCode = postcodeTextField.getText();
            String phone = phoneTextField.getText();
            String mobile = mobileTextField.getText();
            String email = emailTextField.getText();
            String fax = faxTextField.getText();
            String customerType = (String) roleList.getSelectedItem();
            Date payDate = Date.valueOf(LocalDate.now());


            // MySQL jdbc:mysql://{HOST}[:{PORT}][/{DB}]
            String url = "jdbc:mysql://127.0.0.1:3306/garits";

            System.out.println("Connection established");
            try {
                String SQL = "INSERT INTO Customer VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = DriverManager.getConnection(url, "root", "").prepareStatement(SQL);
                stmt.setInt(1, 4);
                stmt.setDate(2, regDate);
                stmt.setString(3, fName);
                stmt.setString(4, lName);
                stmt.setString(5, address);
                stmt.setString(6, postCode);
                stmt.setString(7, phone);
                stmt.setString(8, mobile);
                stmt.setString(9, email);
                stmt.setString(10, fax);
                stmt.setString(11, customerType);
                stmt.setDate(12, payDate);
                stmt.setInt(13,0);
                stmt.executeUpdate();
                stmt.close();
                System.out.println("Customer Registered");
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
        if (e.getSource() == resetButton) {
            fNameTextField.setText("");
            lNameTextField.setText("");
            addressTextField.setText("");
            postcodeTextField.setText("");
            phoneTextField.setText("");
            mobileTextField.setText("");
            emailTextField.setText("");
            faxTextField.setText("");
        }
        if (e.getSource() == backButton) {
            this.dispose();
          new CustomerPanel().setVisible(true);
        }
    }
}

/*
//       b1.addActionListener(new SaveUser(usernameField, passField));
        b1.addActionListener(e -> {
            this.dispose();
            LogInPanel.USERS.put(usernameField.getText(), passField.getText());
            LogInPanel logInPanel = new LogInPanel();
        });
    }*/

