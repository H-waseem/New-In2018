package GUI.Operations;

import GUI.CustomerPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteUser extends JFrame implements ActionListener {

    String[] users = {"Bob","Bill","Ben"};
    Container container = getContentPane();

    JLabel title = new JLabel("Delete GARITS user");
    JLabel make = new JLabel("Developed by LSC");

    JLabel userLabel = new JLabel("USER");

    JComboBox userList = new JComboBox(users);

    JButton backButton = new JButton("Back to menu");
    JButton deleteButton = new JButton("Delete");

    JLabel logo = new JLabel();
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));


    public DeleteUser() {
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
        title.setForeground(Color.WHITE);

        userLabel.setBounds(400,150,150,30);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        userList.setBounds(500,150,150,30);

        backButton.setBounds(10, 10, 125, 35);
        deleteButton.setBounds(500, 200, 100, 30);
    }

    public void setContainerProperties() {
        container.setBackground(new Color(35, 35, 35));
        container.add(logo);
        container.add(make);

        container.add(title);
        container.add(userLabel);

        container.add(userList);

        container.add(backButton);
        container.add(deleteButton);
    }

    public void addActionEvent() {
        deleteButton.addActionListener(this);
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
