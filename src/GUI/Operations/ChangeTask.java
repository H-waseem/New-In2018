package GUI.Operations;

import GUI.TaskPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class ChangeTask extends JFrame implements ActionListener {

    String[] tasks;
    String[] status = {"Incomplete","Complete"};
    {
        try {
            tasks = getTasks().toArray(new String[0]);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    Container container = getContentPane();

    JLabel title = new JLabel("Change Task");
    JLabel make = new JLabel("Developed by LSC");

    JLabel taskIDLabel = new JLabel("TASKID");
    JLabel descrptionLabel = new JLabel("DESCRIPTION");
    JLabel statusLabel = new JLabel("STATUS");
    JLabel jobSheetNoLabel = new JLabel("JOB SHEETNO");
    JLabel jobNoLabel = new JLabel("JOBNO");
    JLabel staffIDLabel = new JLabel("STAFFID");


    JComboBox taskIDList = new JComboBox(tasks);
    JTextField descriptionTextField = new JTextField();
    JComboBox statusList = new JComboBox(status);
    JTextField jobSheetNoTextField = new JTextField();
    JTextField jobNoTextField = new JTextField();
    JTextField staffIDTextField = new JTextField();


    JButton backButton = new JButton("Back to menu");
    JButton submitButton = new JButton("Submit");
    JButton resetButton = new JButton("Clear fields");

    JLabel logo = new JLabel();
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));


    public ArrayList<String> getTasks() throws SQLException {
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

    public ChangeTask() {
        setLayoutManager();
        setPlacement();
        setContainerProperties();
        addActionEvent();
        this.setBounds(10, 10, 1080, 720);
        this.setTitle("GARITS Edit vehicles");
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
        title.setBounds(450, 40, 300, 30);
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Tahoma", Font.BOLD, 25));

        descrptionLabel.setForeground(Color.WHITE);
        taskIDLabel.setForeground(Color.WHITE);
        statusLabel.setForeground(Color.WHITE);
        jobSheetNoLabel.setForeground(Color.WHITE);
        jobNoLabel.setForeground(Color.WHITE);
        staffIDLabel.setForeground(Color.WHITE);
        taskIDLabel.setForeground(Color.WHITE);

        descrptionLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        taskIDLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        statusLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        jobSheetNoLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        jobNoLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        staffIDLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        taskIDLabel.setFont(new Font("Tahoma",Font.BOLD,14));

        taskIDLabel.setBounds(400,100,150,30);
        descrptionLabel.setBounds(380,150,150,30);
        statusLabel.setBounds(400,200,150,30);
        jobSheetNoLabel.setBounds(380,250,150,30);
        jobNoLabel.setBounds(400,300,150,30);
        staffIDLabel.setBounds(400, 350, 100, 30);

        taskIDList.setBounds(500,100,150,30);
        descriptionTextField.setBounds(500,150,150,30);
        statusList.setBounds(500, 200, 150, 30);
        jobSheetNoTextField.setBounds(500, 250, 150, 30);
        jobNoTextField.setBounds(500, 300, 150, 30);
        staffIDTextField.setBounds(500, 350, 150, 30);

        backButton.setBounds(10, 10, 125, 35);
        submitButton.setBounds(400, 400, 100, 30);
        resetButton.setBounds(550, 400, 100, 30);


    }

    public void setContainerProperties() {
        container.setBackground(new Color(35,35,35));
        container.add(logo);
        container.add(make);
        container.add(title);

        container.add(descrptionLabel);
        container.add(taskIDLabel);
        container.add(statusLabel);
        container.add(jobSheetNoLabel);
        container.add(jobNoLabel);
        container.add(staffIDLabel);
        container.add(taskIDLabel);

        container.add(taskIDList);
        container.add(descriptionTextField);
        container.add(statusList);
        container.add(jobSheetNoTextField);
        container.add(jobNoTextField);
        container.add(staffIDTextField);

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

            String taskID = (String) taskIDList.getSelectedItem();
            String status = (String) statusList.getSelectedItem();
            String description = descriptionTextField.getText();
            String jobSheetNo = jobSheetNoTextField.getText();
            String jobNo = jobNoTextField.getText();
            String staffID = staffIDTextField.getText();

            // MySQL jdbc:mysql://{HOST}[:{PORT}][/{DB}]
            String url = "jdbc:mysql://127.0.0.1:3306/garits";
            System.out.println("Connection established");
            try {
                String SQL = "UPDATE Task SET Description = ?, Status = ?, Job_SheetNo = ?,JobNo = ? ,StaffID = ? WHERE TaskID = ?";
                PreparedStatement stmt = DriverManager.getConnection(url, "root", "").prepareStatement(SQL);
                stmt.setString(1, description);
                stmt.setString(2, status);
                stmt.setString(3, jobSheetNo);
                stmt.setString(4, jobNo);
                stmt.setString(5, staffID);
                stmt.setString(6, taskID);
                stmt.executeUpdate();
                stmt.close();
                System.out.println("Task Changed");
                this.dispose();
                new ChangeTask().setVisible(true);
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
        if (e.getSource() == backButton) {
            this.dispose();
            new TaskPanel().setVisible(true);
        }
        if (e.getSource() == resetButton) {
            jobSheetNoTextField.setText("");
            staffIDTextField.setText("");
        }

    }
}

