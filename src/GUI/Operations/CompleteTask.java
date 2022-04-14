package GUI.Operations;

import GUI.JobPanel;
import GUI.TaskPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class CompleteTask extends JFrame implements ActionListener {

    String[] task;
    {
        try {
            task = getTask().toArray(new String[0]);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<String> getTask() throws SQLException {
        ArrayList l =new ArrayList();

        String url = "jdbc:mysql://127.0.0.1:3306/garits";
        Connection conn = DriverManager.getConnection(url, "root", ""); // create the connection according to your DB details
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select TaskID from Task");
        while (rs.next()) {
            l.add(rs.getString(1));
        }

        rs.close();
        stmt.close();
        l.toArray();
        return l;
    }
    Container container = getContentPane();

    JLabel title = new JLabel("Choose to complete Task");
    JLabel make = new JLabel("Developed by LSC");

    JLabel jobNoLabel = new JLabel("TASKNO");
    JLabel taskDescriptionLabel = new JLabel("Task Description");
    JLabel jobStatuslLabel = new JLabel("Task status");

    JComboBox taskList = new JComboBox(task);

    JButton backButton = new JButton("Back to menu");

    JButton chooseButton = new JButton("Complete");

    JLabel logo = new JLabel();
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));


    public CompleteTask() {
        setLayoutManager();
        setPlacement();
        setContainerProperties();
        addActionEvent();
        this.setBounds(10, 10, 1080, 720);
        this.setTitle("GARITS Delete customer");
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
        title.setBounds(400, 75, 400, 30);
        title.setFont(new Font("Tahoma", Font.BOLD, 25));
        title.setForeground(Color.WHITE);

        jobNoLabel.setBounds(400,150,150,30);
        jobNoLabel.setForeground(Color.WHITE);
        jobNoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        taskDescriptionLabel.setBounds(800,200,550,30);
        taskDescriptionLabel.setForeground(Color.WHITE);
        taskDescriptionLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        jobStatuslLabel.setBounds(800,150,150,30);
        jobStatuslLabel.setForeground(Color.WHITE);
        jobStatuslLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        taskList.setBounds(500,150,150,30);

        backButton.setBounds(10, 10, 125, 35);
        chooseButton.setBounds(525, 225, 100, 30);
    }

    public void setContainerProperties() {
        container.setBackground(new Color(35, 35, 35));
        container.add(logo);
        container.add(make);

        container.add(title);

        container.add(jobNoLabel);
        container.add(taskDescriptionLabel);
        container.add(jobStatuslLabel);
        container.add(taskList);

        container.add(backButton);
        container.add(chooseButton);
    }

    public void addActionEvent() {
        chooseButton.addActionListener(this);
        backButton.addActionListener(this);
        taskList.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backButton) {
            this.dispose();
            new TaskPanel().setVisible(true);
        }

        if (e.getSource() == taskList) {
            String type = null;
            String status = null;

            String task = (String) taskList.getSelectedItem();
            String url = "jdbc:mysql://127.0.0.1:3306/garits";

            System.out.println("Connection established");
            try {
                String SQL = "SELECT Description FROM task WHERE TaskID = ?";
                PreparedStatement stmt = DriverManager.getConnection(url, "root", "").prepareStatement(SQL);
                stmt.setString(1, task);
                ResultSet rs = stmt.executeQuery();
                if(rs.next())
                    type= rs.getString(1);
                stmt.executeQuery();
                taskDescriptionLabel.setText(String.valueOf(type));
                stmt.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
            try {
                String SQL = "SELECT Status FROM task WHERE TaskID = ?";
                PreparedStatement stmt = DriverManager.getConnection(url, "root", "").prepareStatement(SQL);
                stmt.setString(1, task);
                ResultSet rs = stmt.executeQuery();
                if(rs.next())
                    status= rs.getString(1);
                stmt.executeQuery();
                jobStatuslLabel.setText(String.valueOf(status));
                stmt.close();
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }

        if (e.getSource() == chooseButton) {
            String job = (String) taskList.getSelectedItem();
            String url = "jdbc:mysql://127.0.0.1:3306/garits";
            System.out.println("Connection established");
            try {
                String SQL = "UPDATE Task SET Status = 'Complete' WHERE TaskID = ?";
                PreparedStatement stmt = DriverManager.getConnection(url, "root", "").prepareStatement(SQL);
                stmt.setString(1, job);
                stmt.executeUpdate();
                stmt.close();
                System.out.println("Task Completed");
                this.dispose();
                new CompleteTask().setVisible(true);
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

        }

    }
}
