package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class AdminPanel extends JFrame implements ActionListener {

    Container container = getContentPane();

    JLabel title = new JLabel("Admin panel");
    JLabel make = new JLabel("Developed by LSC");
    JLabel logo = new JLabel();

    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));

    JButton backupButton = new JButton("Backup Database");
    JButton restoreButton = new JButton("Restore Database");

    JButton logoutButton = new JButton("Log Out");


    public AdminPanel() {
        setLayoutManager();
        setPlacement();
        setContainerProperties();
        addActionEvent();
        this.setBounds(10, 10, 1080, 720);
        this.setTitle("GARITS Admin control panel");
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
        title.setBounds(450, 75, 300, 30);

        logoutButton.setBounds(10,10,85,35);
        backupButton.setBounds(450,175,150,60);
        restoreButton.setBounds(450, 275, 150, 60);


    }

    public void setContainerProperties() {
        container.setBackground(new Color(35,35,35));
        container.add(logo);
        container.add(make);
        container.add(title);


        container.add(logoutButton);
        container.add(restoreButton);
        container.add(backupButton);
    }

    public void addActionEvent() {
        backupButton.addActionListener(this);
        restoreButton.addActionListener(this);
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
        if (e.getSource() == backupButton) {
            try {
                Database.BackupDB.Backupdb();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            System.out.println("Backup made");
        }
        if (e.getSource() == restoreButton) {
            try {
                Database.RestoreDB.RestoreDB();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            System.out.println("Database Restored");
        }
    }
}