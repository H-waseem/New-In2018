package GUI.Operations;

import GUI.VehiclePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class DeleteVehicleRecord extends JFrame implements ActionListener {

    String[] vehicles;
    {
        try {
            vehicles = getVehicles().toArray(new String[0]);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<String> getVehicles() throws SQLException {
        ArrayList l =new ArrayList();

        String url = "jdbc:mysql://127.0.0.1:3306/garits";
        Connection conn = DriverManager.getConnection(url, "root", ""); // create the connection according to your DB details
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select RegNo from vehicles");
        while (rs.next()) {
            l.add(rs.getString(1));
        }

        rs.close();
        stmt.close();
        l.toArray();
        return l;
    }
    Container container = getContentPane();

    JLabel title = new JLabel("Delete vehicle");
    JLabel make = new JLabel("Developed by LSC");

    JLabel customerLabel = new JLabel("Registration");

    JComboBox vehicleList = new JComboBox(vehicles);

    JButton backButton = new JButton("Back to menu");
    JButton deleteButton = new JButton("Delete");

    JLabel logo = new JLabel();
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));


    public DeleteVehicleRecord() {
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

        customerLabel.setBounds(400,150,150,30);
        customerLabel.setForeground(Color.WHITE);
        customerLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        vehicleList.setBounds(500,150,150,30);

        backButton.setBounds(10, 10, 125, 35);
        deleteButton.setBounds(500, 200, 100, 30);
    }

    public void setContainerProperties() {
        container.setBackground(new Color(35, 35, 35));
        container.add(logo);
        container.add(make);

        container.add(title);
        container.add(customerLabel);

        container.add(vehicleList);

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
            new VehiclePanel().setVisible(true);
        }

        if (e.getSource() == deleteButton) {
            String vehicle = (String) vehicleList.getSelectedItem();
            String url = "jdbc:mysql://127.0.0.1:3306/garits";

            System.out.println("Connection established");
            try {
                String SQL = "DELETE FROM Vehicles WHERE RegNo = ?";
                PreparedStatement stmt = DriverManager.getConnection(url, "root", "").prepareStatement(SQL);
                stmt.setString(1, vehicle);
                stmt.executeUpdate();
                stmt.close();
                System.out.println("Vehicle Deleted");
                this.dispose();
                new DeleteVehicleRecord().setVisible(true);
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }

        }

    }
}
