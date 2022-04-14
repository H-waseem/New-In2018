package GUI;

//import GUI.Actions.*;

import GUI.Operations.ChangeJob;
import GUI.Operations.ChangeTask;
import GUI.Operations.ChooseJob;
import GUI.Operations.CompleteTask;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TaskPanel extends JFrame implements ActionListener {

    Container container = getContentPane();

    JLabel title = new JLabel("Task panel");
    JLabel make = new JLabel("Developed by LSC");
    JLabel logo = new JLabel();

    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));

    JButton completeTaskButton = new JButton("Complete Task");
    JButton editTaskButton = new JButton("Change Task Details");
    JButton logoutButton = new JButton("Log Out");


    public TaskPanel() {
        setLayoutManager();
        setPlacement();
        setContainerProperties();
        addActionEvent();
        this.setBounds(10, 10, 1080, 720);
        this.setTitle("GARITS Task panel");
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
        completeTaskButton.setBounds(450,175,150,60);
        editTaskButton.setBounds(450, 275, 150, 60);
    }

    public void setContainerProperties() {
        container.setBackground(new Color(35,35,35));
        container.add(logo);
        container.add(make);
        container.add(title);


        container.add(logoutButton);
        container.add(editTaskButton);
        container.add(completeTaskButton);

    }

    public void addActionEvent() {
        completeTaskButton.addActionListener(this);
        editTaskButton.addActionListener(this);
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

        if (e.getSource() == completeTaskButton) {
            this.dispose();
            new CompleteTask().setVisible(true);
        }

        if (e.getSource() == editTaskButton) {
            this.dispose();
            new ChangeTask().setVisible(true);
        }

    }
}