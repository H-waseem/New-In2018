package GUI.Operations;

import GUI.JobPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class ChangeJob extends JFrame implements ActionListener {

    String[] jobs;
    String[] status = {"Incomplete","Pending","Complete"};
    String[] type = {"MoT","Repair"};
    {
        try {
            jobs = getJobs().toArray(new String[0]);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    Container container = getContentPane();

    JLabel title = new JLabel("Edit Job");
    JLabel make = new JLabel("Developed by LSC");

    JLabel jobNoLabel = new JLabel("JOBNO");
    JLabel typeLabel = new JLabel("TYPE");
    JLabel statusLabel = new JLabel("STATUS");
    JLabel dateLabel = new JLabel("DATE");
    JLabel bayNoLabel = new JLabel("BAYNO");


    JComboBox jobNoList = new JComboBox(jobs);
    JComboBox typeList = new JComboBox(type);
    JComboBox statusList = new JComboBox(status);
    JTextField dateTextField = new JTextField();
    JTextField bayNoTextField = new JTextField();


    JButton backButton = new JButton("Back to menu");
    JButton submitButton = new JButton("Submit");
    JButton resetButton = new JButton("Clear fields");

    JLabel logo = new JLabel();
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));


    public ArrayList<String> getJobs() throws SQLException {
        ArrayList l =new ArrayList();

        String url = "jdbc:mysql://127.0.0.1:3306/garits";
        Connection conn = DriverManager.getConnection(url, "root", ""); // create the connection according to your DB details
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select JobNo from Job");
        while (rs.next()) {
            l.add(rs.getString(1));
        }

        rs.close();
        stmt.close();
        l.toArray();
        return l;
    }

    public ChangeJob() {
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

        typeLabel.setForeground(Color.WHITE);
        jobNoLabel.setForeground(Color.WHITE);
        statusLabel.setForeground(Color.WHITE);
        dateLabel.setForeground(Color.WHITE);
        bayNoLabel.setForeground(Color.WHITE);
        jobNoLabel.setForeground(Color.WHITE);

        typeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        jobNoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        statusLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        dateLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        bayNoLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        jobNoLabel.setFont(new Font("Tahoma",Font.BOLD,14));

        jobNoLabel.setBounds(400,100,150,30);
        typeLabel.setBounds(400,150,150,30);
        statusLabel.setBounds(400,200,150,30);
        dateLabel.setBounds(400,250,150,30);
        bayNoLabel.setBounds(400, 300, 100, 30);

        jobNoList.setBounds(500,100,150,30);
        typeList.setBounds(500,150,150,30);
        statusList.setBounds(500, 200, 150, 30);
        dateTextField.setBounds(500, 250, 150, 30);
        bayNoTextField.setBounds(500, 300, 150, 30);

        backButton.setBounds(10, 10, 125, 35);
        submitButton.setBounds(400, 400, 100, 30);
        resetButton.setBounds(550, 400, 100, 30);


    }

    public void setContainerProperties() {
        container.setBackground(new Color(35,35,35));
        container.add(logo);
        container.add(make);
        container.add(title);

        container.add(typeLabel);
        container.add(jobNoLabel);
        container.add(statusLabel);
        container.add(dateLabel);
        container.add(bayNoLabel);
        container.add(jobNoLabel);

        container.add(jobNoList);
        container.add(typeList);
        container.add(statusList);
        container.add(dateTextField);
        container.add(bayNoTextField);

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

            String jobNo = (String) jobNoList.getSelectedItem();
            String type = (String) typeList.getSelectedItem();
            String status = (String) statusList.getSelectedItem();
            String date = dateTextField.getText();
            String bay = bayNoTextField.getText();

            // MySQL jdbc:mysql://{HOST}[:{PORT}][/{DB}]
            String url = "jdbc:mysql://127.0.0.1:3306/garits";
            System.out.println("Connection established");
            try {
                String SQL = "UPDATE job SET Type = ?, Status = ?, Date = ?,BayNo = ? WHERE JobNo = ?";
                PreparedStatement stmt = DriverManager.getConnection(url, "root", "").prepareStatement(SQL);
                stmt.setString(1, type);
                stmt.setString(2, status);
                stmt.setString(3, date);
                stmt.setString(4, bay);
                stmt.setString(5, jobNo);
                stmt.executeUpdate();
                stmt.close();
                System.out.println("Job Changed");
                this.dispose();
                new ChangeJob().setVisible(true);
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
        if (e.getSource() == backButton) {
            this.dispose();
            new JobPanel().setVisible(true);
        }
        if (e.getSource() == resetButton) {
            dateTextField.setText("");
            bayNoTextField.setText("");
        }

    }
}

