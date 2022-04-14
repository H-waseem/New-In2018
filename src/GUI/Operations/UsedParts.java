package GUI.Operations;

import GUI.JobPanel;
import Job.LowStock;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class UsedParts extends JFrame implements ActionListener {


    public ArrayList<String> getCustomers() throws SQLException {
        ArrayList l =new ArrayList();

        String url = "jdbc:mysql://127.0.0.1:3306/garits";
        Connection conn = DriverManager.getConnection(url, "root", ""); // create the connection according to your DB details
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select First_Name from customer");
        while (rs.next()) {
            l.add(rs.getString(1));
        }

        rs.close();
        stmt.close();
        l.toArray();
        return l;
    }
    Container container = getContentPane();

    JLabel title = new JLabel("Add parts used");
    JLabel make = new JLabel("Developed by LSC");

    JLabel quantityLabel = new JLabel("QUANTITY");
    JLabel partNoLabel = new JLabel("PARTNO");
    JLabel jobSheetNoLabel = new JLabel("JOB SHEETNO");

    JTextField quantityTextField = new JTextField();
    JTextField partNoTextField = new JTextField();
    JTextField jobSheetNoTextField = new JTextField();

    JButton backButton = new JButton("Back to menu");
    JButton deleteButton = new JButton("Add");

    JLabel logo = new JLabel();
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));


    public UsedParts() {
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
        title.setBounds(450, 75, 300, 30);
        title.setFont(new Font("Tahoma", Font.BOLD, 25));
        title.setForeground(Color.WHITE);

        quantityLabel.setBounds(400,150,150,30);
        quantityLabel.setForeground(Color.WHITE);
        quantityLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        partNoLabel.setBounds(400,200,150,30);
        partNoLabel.setForeground(Color.WHITE);
        partNoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        jobSheetNoLabel.setBounds(380,250,150,30);
        jobSheetNoLabel.setForeground(Color.WHITE);
        jobSheetNoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        quantityTextField.setBounds(500,150,150,30);
        partNoTextField.setBounds(500,200,150,30);
        jobSheetNoTextField.setBounds(500,250,150,30);


        backButton.setBounds(10, 10, 125, 35);
        deleteButton.setBounds(500, 300, 100, 30);
    }

    public void setContainerProperties() {
        container.setBackground(new Color(35, 35, 35));
        container.add(logo);
        container.add(make);

        container.add(title);
        container.add(quantityLabel);
        container.add(partNoLabel);
        container.add(jobSheetNoLabel);

        container.add(quantityTextField);
        container.add(partNoTextField);
        container.add(jobSheetNoTextField);

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
           new JobPanel().setVisible(true);
        }

        if (e.getSource() == deleteButton) {

            String quantity = quantityTextField.getText();
            String partNo = partNoTextField.getText();
            String jobSheetNo = jobSheetNoTextField.getText();

            String url = "jdbc:mysql://127.0.0.1:3306/garits";

            System.out.println("Connection established");
            try {
                String SQL = "INSERT INTO parts_used VALUES (?, ?, ?)";
                PreparedStatement stmt = DriverManager.getConnection(url, "root", "").prepareStatement(SQL);
                stmt.setString(1, quantity);
                stmt.setString(2, partNo);
                stmt.setString(3, jobSheetNo);
                stmt.executeUpdate();
                stmt.close();

                String SQL2 = "UPDATE part set Quantity = ((SELECT Quantity FROM part WHERE PartNO = ? ) - (SELECT Quantity FROM parts_used WHERE PartNO = ? )) WHERE PartNO = ?";
                PreparedStatement stmt2 = DriverManager.getConnection(url, "root", "").prepareStatement(SQL2);
                stmt2.setString(1, partNo);
                stmt2.setString(2, partNo);
                stmt2.setString(3, partNo);
                stmt2.executeUpdate();
                stmt2.close();

                System.out.println("Part added to parts used and deducted from available parts");
                new LowStock();
                this.dispose();
                new UsedParts().setVisible(true);
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

        }

    }
}
