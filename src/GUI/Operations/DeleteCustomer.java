package GUI.Operations;

import GUI.CustomerPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class DeleteCustomer extends JFrame implements ActionListener {

    String[] customers;
    {
        try {
            customers = getCustomers().toArray(new String[0]);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

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

    JLabel title = new JLabel("Delete customer");
    JLabel make = new JLabel("Developed by LSC");

    JLabel customerLabel = new JLabel("CUSTOMER");

    JComboBox customerList = new JComboBox(customers);

    JButton backButton = new JButton("Back to menu");
    JButton deleteButton = new JButton("Delete");

    JLabel logo = new JLabel();
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));


    public DeleteCustomer() {
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
        title.setBounds(400, 75, 300, 30);
        title.setFont(new Font("Tahoma", Font.BOLD, 25));
        title.setForeground(Color.WHITE);

        customerLabel.setBounds(400,150,150,30);
        customerLabel.setForeground(Color.WHITE);
        customerLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        customerList.setBounds(500,150,150,30);

        backButton.setBounds(10, 10, 125, 35);
        deleteButton.setBounds(500, 200, 100, 30);
    }

    public void setContainerProperties() {
        container.setBackground(new Color(35, 35, 35));
        container.add(logo);
        container.add(make);

        container.add(title);
        container.add(customerLabel);

        container.add(customerList);

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

        if (e.getSource() == deleteButton) {
            String customer = (String) customerList.getSelectedItem();
            String url = "jdbc:mysql://127.0.0.1:3306/garits";

            System.out.println("Connection established");
            try {
                String SQL = "DELETE FROM Customer WHERE First_Name = ?";
                PreparedStatement stmt = DriverManager.getConnection(url, "root", "").prepareStatement(SQL);
                stmt.setString(1, customer);
                stmt.executeUpdate();
                stmt.close();
                System.out.println("Customer Deleted");
                this.dispose();
                new DeleteCustomer().setVisible(true);
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

        }

    }
}
