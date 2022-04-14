package GUI;

//import GUI.Actions.*;

import GUI.Operations.CreateCustomer;
import GUI.Operations.DeleteCustomer;
import GUI.Operations.EditCustomer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CustomerPanel extends JFrame implements ActionListener {

    Container container = getContentPane();

    JLabel title = new JLabel("Customer menu panel");
    JLabel make = new JLabel("Developed by LSC");
    JLabel logo = new JLabel();

    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));

    JButton createCustomerButton = new JButton("Create Customer");
    JButton editCustomerButton = new JButton("Edit Customer");
    JButton deleteCustomerButton = new JButton("Delete Customer");
    JButton logoutButton = new JButton("Log Out");


    public CustomerPanel() {
        setLayoutManager();
        setPlacement();
        setContainerProperties();
        addActionEvent();
        this.setBounds(10, 10, 1080, 720);
        this.setTitle("GARITS Customer control panel");
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


        title.setForeground(Color.WHITE);
        title.setFont(new Font("Tahoma", Font.BOLD, 25));
        title.setBounds(400, 75, 300, 30);

        logoutButton.setBounds(10,10,85,35);
        createCustomerButton.setBounds(450,175,150,60);
        editCustomerButton.setBounds(450, 275, 150, 60);
        deleteCustomerButton.setBounds(450, 375, 150, 60);


    }

    public void setContainerProperties() {
        container.setBackground(new Color(35,35,35));
        container.add(logo);
        container.add(make);
        container.add(title);


        container.add(logoutButton);
        container.add(editCustomerButton);
        container.add(createCustomerButton);
        container.add(deleteCustomerButton);
    }

    public void addActionEvent() {
        createCustomerButton.addActionListener(this);
        deleteCustomerButton.addActionListener(this);
        editCustomerButton.addActionListener(this);
        logoutButton.addActionListener(this);
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
        if (e.getSource() == logoutButton) {
            this.dispose();
            new LogInPanel().setVisible(true);
            System.out.println("Log Out Successful");
        }

        if (e.getSource() == createCustomerButton) {
            this.dispose();
            new CreateCustomer().setVisible(true);
        }
        if (e.getSource() == deleteCustomerButton) {
            this.dispose();
            new DeleteCustomer().setVisible(true);
        }
        if (e.getSource() == editCustomerButton) {
            this.dispose();
            new EditCustomer().setVisible(true);
        }

    }
}