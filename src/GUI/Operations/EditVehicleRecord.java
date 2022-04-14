package GUI.Operations;

import GUI.VehiclePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class EditVehicleRecord extends JFrame implements ActionListener {

    String[] vehicles;
    {
        try {
            vehicles = getVehicles().toArray(new String[0]);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    Container container = getContentPane();

    JLabel title = new JLabel("Edit Vehicle");
    JLabel make = new JLabel("Developed by LSC");

    JLabel regLabel = new JLabel("REGISTRATION");
    JLabel newRegLabel = new JLabel("NEW REGISTRATION");
    JLabel motLabel = new JLabel("MOT DATE");
    JLabel makeLabel = new JLabel("MAKE");
    JLabel modelLabel = new JLabel("MODEL");
    JLabel engineLabel = new JLabel("ENGINE SERIAL");
    JLabel chassisLabel = new JLabel("CHASSIS No");
    JLabel colourLabel = new JLabel("COLOUR");
    JLabel jobNoLabel = new JLabel("JOB SHEET NO");
    JLabel customerIDLabel = new JLabel("CUSTOMER ID");

    JTextField regTextField = new JTextField();
    JTextField motTextField = new JTextField();
    JTextField makeTextField = new JTextField();
    JTextField modelTextField = new JTextField();
    JTextField engineTextField = new JTextField();
    JTextField chassisTextField = new JTextField();
    JTextField colourTextField = new JTextField();
    JTextField jobNoTextField = new JTextField();
    JTextField customerIDTextField = new JTextField();

    JComboBox vehicleList = new JComboBox(vehicles);

    JButton backButton = new JButton("Back to menu");
    JButton submitButton = new JButton("Submit");
    JButton resetButton = new JButton("Clear fields");

    JLabel logo = new JLabel();
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));


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

    public EditVehicleRecord() {
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

        newRegLabel.setForeground(Color.WHITE);
        regLabel.setForeground(Color.WHITE);
        motLabel.setForeground(Color.WHITE);
        makeLabel.setForeground(Color.WHITE);
        modelLabel.setForeground(Color.WHITE);
        engineLabel.setForeground(Color.WHITE);
        chassisLabel.setForeground(Color.WHITE);
        colourLabel.setForeground(Color.WHITE);
        jobNoLabel.setForeground(Color.WHITE);
        customerIDLabel.setForeground(Color.WHITE);


        newRegLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        regLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        motLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        makeLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        modelLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        engineLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        chassisLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        colourLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        jobNoLabel.setFont(new Font("Tahoma",Font.BOLD,14));
        customerIDLabel.setFont(new Font("Tahoma",Font.BOLD,14));

        regLabel.setBounds(370,100,150,30);
        newRegLabel.setBounds(345,150,150,30);
        motLabel.setBounds(400,200,150,30);
        makeLabel.setBounds(400,250,150,30);
        modelLabel.setBounds(400, 300, 100, 30);
        engineLabel.setBounds(375, 350, 140, 30);
        chassisLabel.setBounds(400, 400, 150, 30);
        colourLabel.setBounds(400, 450, 150, 30);
        jobNoLabel.setBounds(390, 500, 150, 30);
        customerIDLabel.setBounds(390, 550, 150, 30);


        vehicleList.setBounds(500,100,150,30);
        regTextField.setBounds(500,150,150,30);
        motTextField.setBounds(500,200,150,30);
        makeTextField.setBounds(500, 250, 150, 30);
        modelTextField.setBounds(500, 300, 150, 30);
        engineTextField.setBounds(500, 350, 150, 30);
        chassisTextField.setBounds(500,400,150,30);
        colourTextField.setBounds(500,450,150,30);
        jobNoTextField.setBounds(500, 500, 150, 30);
        customerIDTextField.setBounds(500,550,150,30);


        backButton.setBounds(10, 10, 125, 35);
        submitButton.setBounds(400, 600, 100, 30);
        resetButton.setBounds(550, 600, 100, 30);


    }

    public void setContainerProperties() {
        container.setBackground(new Color(35,35,35));
        container.add(logo);
        container.add(make);
        container.add(title);

        container.add(newRegLabel);
        container.add(regLabel);
        container.add(motLabel);
        container.add(makeLabel);
        container.add(modelLabel);
        container.add(engineLabel);
        container.add(chassisLabel);
        container.add(colourLabel);
        container.add(jobNoLabel);
        container.add(customerIDLabel);

        container.add(vehicleList);
        container.add(regTextField);
        container.add(motTextField);
        container.add(makeTextField);
        container.add(modelTextField);
        container.add(engineTextField);
        container.add(chassisTextField);
        container.add(colourTextField);
        container.add(jobNoTextField);
        container.add(customerIDTextField);

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
            String reg = regTextField.getText();
            String mot = motTextField.getText();
            String make = makeTextField.getText();
            String model = modelTextField.getText();
            String engine = engineTextField.getText();
            String chassis = chassisTextField.getText();
            String colour = colourTextField.getText();
            String jobNo = jobNoTextField.getText();
            String customerID = customerIDTextField.getText();
            String vehicleReg = (String) vehicleList.getSelectedItem();

            // MySQL jdbc:mysql://{HOST}[:{PORT}][/{DB}]
            String url = "jdbc:mysql://127.0.0.1:3306/garits";
            System.out.println("Connection established");
            try {
                String SQL = "UPDATE vehicles SET RegNo = ?, MoT_Date = ?, Make = ?,Model = ?,Engine_Serial = ?,Chassis_Number = ?,Colour = ?,Job_SheetNo = ?,CustomerID = ? WHERE RegNo = ?";
                PreparedStatement stmt = DriverManager.getConnection(url, "root", "").prepareStatement(SQL);
                stmt.setString(1, reg);
                stmt.setString(2, mot);
                stmt.setString(3, make);
                stmt.setString(4, model);
                stmt.setString(5, engine);
                stmt.setString(6, chassis);
                stmt.setString(7, colour);
                stmt.setString(8, jobNo);
                stmt.setString(9, customerID);
                stmt.setString(10, vehicleReg);
                stmt.executeUpdate();
                stmt.close();
                System.out.println("Customer Edited");
                this.dispose();
                new EditVehicleRecord().setVisible(true);
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
        if (e.getSource() == backButton) {
            this.dispose();
            new VehiclePanel().setVisible(true);
        }
        if (e.getSource() == resetButton) {
            regTextField.setText("");
            motTextField.setText("");
            makeTextField.setText("");
            modelTextField.setText("");
            engineTextField.setText("");
            chassisTextField.setText("");
            colourTextField.setText("");
            jobNoTextField.setText("");
        }

    }
}

