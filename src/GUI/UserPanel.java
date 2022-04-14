package GUI;

import GUI.Operations.CreateUser;
import GUI.Operations.DeleteUser;
import GUI.Operations.EditUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserPanel extends JFrame implements ActionListener {

    Container container = getContentPane();

    JLabel title = new JLabel("User menu panel");
    JLabel make = new JLabel("Developed by LSC");
    JLabel logo = new JLabel();

    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));

    JButton createUserButton = new JButton("Create User");
    JButton editUserButton = new JButton("Edit User");
    JButton deleteUserButton = new JButton("Delete User");
    JButton logoutButton = new JButton("Log Out");


    public UserPanel() {
        setLayoutManager();
        setPlacement();
        setContainerProperties();
        addActionEvent();
        this.setBounds(10, 10, 1080, 720);
        this.setTitle("GARTIS Admin control panel");
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


        title.setForeground(Color.WHITE);
        title.setFont(new Font("Tahoma", Font.BOLD, 25));
        title.setBounds(400, 75, 300, 30);

        logoutButton.setBounds(10,10,85,35);
        createUserButton.setBounds(450,175,150,60);
        editUserButton.setBounds(450, 275, 150, 60);
        deleteUserButton.setBounds(450, 375, 150, 60);


    }

    public void setContainerProperties() {
        container.setBackground(new Color(35,35,35));
        container.add(logo);
        container.add(make);
        container.add(title);


        container.add(logoutButton);
        container.add(editUserButton);
        container.add(createUserButton);
        container.add(deleteUserButton);
    }

    public void addActionEvent() {
        createUserButton.addActionListener(this);
        deleteUserButton.addActionListener(this);
        editUserButton.addActionListener(this);
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

        if (e.getSource() == createUserButton) {
            this.dispose();
            new CreateUser().setVisible(true);
        }
        if (e.getSource() == deleteUserButton) {
            this.dispose();
            new DeleteUser().setVisible(true);
        }
        if (e.getSource() == editUserButton) {
            this.dispose();
            new EditUser().setVisible(true);
        }

    }
}