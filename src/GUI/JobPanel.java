package GUI;

import GUI.Operations.ChangeJob;
import GUI.Operations.ChooseJob;
import GUI.Operations.UsedParts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JobPanel extends JFrame implements ActionListener {

    Container container = getContentPane();

    JLabel title = new JLabel("Job panel");
    JLabel make = new JLabel("Developed by LSC");
    JLabel logo = new JLabel();

    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));

    JButton chooseJobButton = new JButton("Choose Job");
    JButton editCustomerButton = new JButton("Change Job");
    JButton addPartUsedButton = new JButton("Add Parts used");
    JButton logoutButton = new JButton("Log Out");


    public JobPanel() {
        setLayoutManager();
        setPlacement();
        setContainerProperties();
        addActionEvent();
        this.setBounds(10, 10, 1080, 720);
        this.setTitle("GARITS Job panel");
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
        title.setBounds(460, 75, 300, 30);

        logoutButton.setBounds(10,10,85,35);
        chooseJobButton.setBounds(450,175,150,60);
        editCustomerButton.setBounds(450, 275, 150, 60);
        addPartUsedButton.setBounds(450, 375, 150, 60);
    }

    public void setContainerProperties() {
        container.setBackground(new Color(35,35,35));
        container.add(logo);
        container.add(make);
        container.add(title);


        container.add(logoutButton);
        container.add(editCustomerButton);
        container.add(chooseJobButton);
        container.add(addPartUsedButton);

    }

    public void addActionEvent() {
        chooseJobButton.addActionListener(this);
        editCustomerButton.addActionListener(this);
        addPartUsedButton.addActionListener(this);
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

        if (e.getSource() == chooseJobButton) {
            this.dispose();
            new ChooseJob().setVisible(true);
        }

        if (e.getSource() == editCustomerButton) {
            this.dispose();
            new ChangeJob().setVisible(true);
        }
        if (e.getSource() == addPartUsedButton) {
            this.dispose();
            new UsedParts().setVisible(true);
        }

    }
}