package GUI;

//import GUI.Actions.*;

import GUI.Operations.CreateVehicleRecord;
import GUI.Operations.DeleteVehicleRecord;
import GUI.Operations.EditVehicleRecord;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VehiclePanel extends JFrame implements ActionListener {

    Container container = getContentPane();

    JLabel title = new JLabel("Vehicle Panel");
    JLabel make = new JLabel("Developed by LSC");
    JLabel logo = new JLabel();

    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));

    JButton createVehicleButton = new JButton("Create Vehicle record");
    JButton editVehicleButton = new JButton("Edit Vehicle Record");
    JButton deleteVehicleButton = new JButton("Delete Vehicle Record");
    JButton logoutButton = new JButton("Log Out");


    public VehiclePanel() {
        setLayoutManager();
        setPlacement();
        setContainerProperties();
        addActionEvent();
        this.setBounds(10, 10, 1080, 720);
        this.setTitle("GARITS Vehicle control panel");
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
        title.setBounds(437, 75, 300, 30);

        logoutButton.setBounds(10,10,85,35);
        createVehicleButton.setBounds(450,175,170,60);
        editVehicleButton.setBounds(450, 275, 170, 60);
        deleteVehicleButton.setBounds(450, 375, 170, 60);


    }

    public void setContainerProperties() {
        container.setBackground(new Color(35,35,35));
        container.add(logo);
        container.add(make);
        container.add(title);


        container.add(logoutButton);
        container.add(editVehicleButton);
        container.add(createVehicleButton);
        container.add(deleteVehicleButton);
    }

    public void addActionEvent() {
        createVehicleButton.addActionListener(this);
        deleteVehicleButton.addActionListener(this);
        editVehicleButton.addActionListener(this);
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

        if (e.getSource() == createVehicleButton) {
            this.dispose();
            new CreateVehicleRecord().setVisible(true);
        }
        if (e.getSource() == deleteVehicleButton) {
            this.dispose();
            new DeleteVehicleRecord().setVisible(true);
        }
        if (e.getSource() == editVehicleButton) {
            this.dispose();
            new EditVehicleRecord().setVisible(true);
        }

    }
}