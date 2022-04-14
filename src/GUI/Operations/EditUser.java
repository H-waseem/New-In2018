package GUI.Operations;

import GUI.CustomerPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditUser extends JFrame implements ActionListener {

    String[] roles = {"Admin", "Foreperson", "Franchisee", "Mechanic", "Receptionist"};

    String[] users = {"Bob","Bill","Ben"};
    Container container = getContentPane();

    JLabel title = new JLabel("Edit GARITS user");
    JLabel make = new JLabel("Developed by LSC");

    JLabel userLabel = new JLabel("USER");
    JLabel fNameLabel = new JLabel("FIRST NAME");
    JLabel lNameLabel = new JLabel("LAST NAME");
    JLabel userNameLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JLabel roleLabel = new JLabel("ROLE");

    JTextField fNameTextField = new JTextField();
    JTextField lNameTextField = new JTextField();
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    JComboBox roleList = new JComboBox(roles);
    JComboBox userList = new JComboBox(users);

    JButton backButton = new JButton("Back to menu");
    JButton submitButton = new JButton("Submit");
    JButton resetButton = new JButton("Clear fields");

    JLabel logo = new JLabel();
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));


    public EditUser() {
        setLayoutManager();
        setPlacement();
        setContainerProperties();
        addActionEvent();
        this.setBounds(10, 10, 1080, 720);
        this.setTitle("GARITIS Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setPlacement() {
        logo.setIcon(imageIcon);
        logo.setBounds(925, 535, 150, 150);
        make.setBounds(5, 650, 200, 30);
        make.setForeground(Color.WHITE);
        title.setBounds(400, 75, 300, 30);
        title.setFont(new Font("Tahoma", Font.BOLD, 25));


        userLabel.setBounds(400,150,150,30);
        fNameLabel.setBounds(400, 200, 150, 30);
        lNameLabel.setBounds(400, 250, 150, 30);
        userNameLabel.setBounds(400, 300, 100, 30);
        passwordLabel.setBounds(400, 350, 100, 30);
        roleLabel.setBounds(400, 400, 150, 30);


        userLabel.setForeground(Color.WHITE);
        fNameLabel.setForeground(Color.WHITE);
        lNameLabel.setForeground(Color.WHITE);
        userNameLabel.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);
        roleLabel.setForeground(Color.WHITE);
        title.setForeground(Color.WHITE);

        userLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        fNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        lNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        userNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        roleLabel.setFont(new Font("Tahoma", Font.BOLD, 14));


        userList.setBounds(500,150,150,30);
        fNameTextField.setBounds(500, 200, 150, 30);
        lNameTextField.setBounds(500, 250, 150, 30);
        userTextField.setBounds(500, 300, 150, 30);
        passwordField.setBounds(500, 350, 150, 30);
        roleList.setBounds(500, 400, 150, 30);


        backButton.setBounds(10, 10, 125, 35);
        submitButton.setBounds(400, 500, 100, 30);
        resetButton.setBounds(550, 500, 100, 30);


    }

    public void setContainerProperties() {
        container.setBackground(new Color(35, 35, 35));
        container.add(logo);
        container.add(make);

        container.add(title);
        container.add(userLabel);
        container.add(fNameLabel);
        container.add(lNameLabel);
        container.add(userNameLabel);
        container.add(passwordLabel);
        container.add(roleLabel);

        container.add(userList);
        container.add(fNameTextField);
        container.add(lNameTextField);
        container.add(userTextField);
        container.add(passwordField);
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
        if (e.getSource() == backButton) {
            this.dispose();
            CustomerPanel ap = new CustomerPanel();
            ap.setVisible(true);
        }
    }
}
