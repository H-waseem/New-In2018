package GUI.Operations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddPart extends JFrame implements ActionListener {

    Container container = getContentPane();

    JLabel title = new JLabel("Add part");
    JLabel make = new JLabel("Developed by LSC");

    JLabel PartNoLabel = new JLabel("PART NO.");
    JLabel PartNameLabel = new JLabel("PART NAME");
    JLabel QuantityLabel = new JLabel("QUANTITY");
    JLabel ThresholdLabel = new JLabel("THRESHOLD");
    JLabel CodeLabel = new JLabel("CODE");
    JLabel ManufacturerLabel = new JLabel("MANUFACTURER");
    JLabel VehicleTypeLabel = new JLabel("VEHICLE TYPE");
    JLabel MinYearLabel = new JLabel("MIN YEAR");
    JLabel MaxYearLabel = new JLabel("MAX YEAR");
    JLabel PriceLabel = new JLabel("PRICE");

    JTextField PartNoField = new JTextField();
    JTextField PartNameField = new JTextField();
    JTextField QuantityField = new JTextField();
    JTextField ThresholdField = new JTextField();
    JTextField CodeField = new JTextField();
    JTextField ManufacturerField = new JTextField();
    JTextField VehicleTypeField = new JTextField();
    JTextField MinYearField = new JTextField();
    JTextField MaxYearField = new JTextField();
    JTextField PriceField = new JTextField();

    JButton backButton = new JButton("Back to menu");
    JButton addButton = new JButton("Add");

    JLabel logo = new JLabel();
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));


    public AddPart() {
        setLayoutManager();
        setPlacement();
        setContainerProperties();
        addActionEvent();
        this.setBounds(10, 10, 1080, 720);
        this.setTitle("GARITS Add part");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void addActionEvent() {
        addButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setPlacement() {
        logo.setIcon(imageIcon);
        logo.setBounds(925, 535, 150, 150);
        make.setBounds(5, 650, 200, 30);
        make.setForeground(Color.WHITE);
        title.setBounds(400, 50, 300, 30);
        title.setFont(new Font("Tahoma", Font.BOLD, 25));
        title.setForeground(Color.WHITE);

        PartNoLabel.setBounds(400,100,150,30);
        PartNoLabel.setForeground(Color.WHITE);
        PartNoLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        PartNameLabel.setBounds(400,150,150,30);
        PartNameLabel.setForeground(Color.WHITE);
        PartNameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        QuantityLabel.setBounds(400,200,150,30);
        QuantityLabel.setForeground(Color.WHITE);
        QuantityLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        ThresholdLabel.setBounds(400,250,150,30);
        ThresholdLabel.setForeground(Color.WHITE);
        ThresholdLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        CodeLabel.setBounds(400,300,150,30);
        CodeLabel.setForeground(Color.WHITE);
        CodeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        ManufacturerLabel.setBounds(400,350,150,30);
        ManufacturerLabel.setForeground(Color.WHITE);
        ManufacturerLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        VehicleTypeLabel.setBounds(400,400,150,30);
        VehicleTypeLabel.setForeground(Color.WHITE);
        VehicleTypeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        MinYearLabel.setBounds(400,450,150,30);
        MinYearLabel.setForeground(Color.WHITE);
        MinYearLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        MaxYearLabel.setBounds(400,500,150,30);
        MaxYearLabel.setForeground(Color.WHITE);
        MaxYearLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        PriceLabel.setBounds(400,550,150,30);
        PriceLabel.setForeground(Color.WHITE);
        PriceLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        PartNoField.setBounds(550,100,150,30);
        PartNoField.setFont(new Font("Tahoma", Font.BOLD, 14));

        PartNameField.setBounds(550,150,150,30);
        PartNameField.setFont(new Font("Tahoma", Font.BOLD, 14));

        QuantityField.setBounds(550,200,150,30);
        QuantityField.setFont(new Font("Tahoma", Font.BOLD, 14));

        ThresholdField.setBounds(550,250,150,30);
        ThresholdField.setFont(new Font("Tahoma", Font.BOLD, 14));

        CodeField.setBounds(550,300,150,30);
        CodeField.setFont(new Font("Tahoma", Font.BOLD, 14));

        ManufacturerField.setBounds(550,350,150,30);
        ManufacturerField.setFont(new Font("Tahoma", Font.BOLD, 14));

        VehicleTypeField.setBounds(550,400,150,30);
        VehicleTypeField.setFont(new Font("Tahoma", Font.BOLD, 14));

        MinYearField.setBounds(550,450,150,30);
        MinYearField.setFont(new Font("Tahoma", Font.BOLD, 14));

        MaxYearField.setBounds(550,500,150,30);
        MaxYearField.setFont(new Font("Tahoma", Font.BOLD, 14));

        PriceField.setBounds(550,550,150,30);
        PriceField.setFont(new Font("Tahoma", Font.BOLD, 14));

        backButton.setBounds(10, 10, 125, 35);
        addButton.setBounds(500, 600, 100, 30);
    }

    public void setContainerProperties() {
        container.setBackground(new Color(35, 35, 35));
        container.add(logo);
        container.add(make);

        container.add(title);
        container.add(PartNoLabel);
        container.add(PartNameLabel);
        container.add(QuantityLabel);
        container.add(ThresholdLabel);
        container.add(CodeLabel);
        container.add(ManufacturerLabel);
        container.add(VehicleTypeLabel);
        container.add(MinYearLabel);
        container.add(MaxYearLabel);
        container.add(PriceLabel);

        container.add(PartNoField);
        container.add(PartNameField);
        container.add(QuantityField);
        container.add(ThresholdField);
        container.add(CodeField);
        container.add(ManufacturerField);
        container.add(VehicleTypeField);
        container.add(MinYearField);
        container.add(MaxYearField);
        container.add(PriceField);

        container.add(backButton);
        container.add(addButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton){
            System.out.println("bk");
        }
        if (e.getSource() == addButton){
            String PartID = PartNoField.getText();
            String PartName = PartNameField.getText();
            String Quantity = QuantityField.getText();
            String Threshold = ThresholdField.getText();
            String Code = CodeField.getText();
            String Manufacturer = ManufacturerField.getText();
            String VehicleType = VehicleTypeField.getText();
            String MinYear = MinYearField.getText();
            String MaxYear = MaxYearField.getText();
            String Price = PriceField.getText();
            // MySQL jdbc:mysql://{HOST}[:{PORT}][/{DB}]
            String url = "jdbc:mysql://127.0.0.1:3306/garits";
            System.out.println("Connection established");

            try {
                String SQL = "INSERT INTO PART VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = DriverManager.getConnection(url, "root", "").prepareStatement(SQL);
                stmt.setString(1, PartID);
                stmt.setString(2, PartName);
                stmt.setString(3, Quantity);
                stmt.setString(4, Threshold);
                stmt.setString(5, Code);
                stmt.setString(6, Manufacturer);
                stmt.setString(7, VehicleType);
                stmt.setString(8, MinYear);
                stmt.setString(9, MaxYear);
                stmt.setString(10, Price);
                stmt.executeUpdate();
                stmt.close();
                System.out.println("Part Added");
            } catch (SQLException ex) {
                System.err.println(ex.getMessage());
            }
        }
            System.out.println("add");
        }
    }
