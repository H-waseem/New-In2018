package Payment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;


public class CalculateInvoice extends JFrame implements ActionListener {
    double VAT = 1.2;
    double markUp = 1.3;

    int foremanRate = 125;
    int mechanicRate = 105;

    double price = 0;

    int jobSheetNo = 1001;

    String[] jobSheetN;
    {
        try {
            jobSheetN = getJobSheetN().toArray(new String[0]);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    JComboBox jobSheetList = new JComboBox(jobSheetN);

    public ArrayList<String> getJobSheetN() throws SQLException {
        ArrayList l =new ArrayList();

        String url = "jdbc:mysql://127.0.0.1:3306/garits";
        Connection conn = DriverManager.getConnection(url, "root", ""); // create the connection according to your DB details
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select Job_SheetNo from Job_Sheet");
        while (rs.next()) {
            l.add(rs.getString(1));
        }

        rs.close();
        stmt.close();
        l.toArray();
        return l;
    }
    Container container = getContentPane();

    JLabel title = new JLabel("Choose JobSheet to Invoice");
    JLabel make = new JLabel("Developed by LSC");

    JLabel jobNoLabel = new JLabel("JOBSHEETNO");

    JButton backButton = new JButton("Back to menu");

    JButton chooseButton = new JButton("Complete");

    JLabel logo = new JLabel();
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));


    public CalculateInvoice() throws SQLException {
        setLayoutManager();
        setPlacement();
        setContainerProperties();
        addActionEvent();
        this.setBounds(10, 10, 1080, 720);
        this.setTitle("GARITS Delete customer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ArrayList<Integer> quantity = getQuantity();
        ArrayList<Double> price = getPrice();
        String role = getRole();
        double hours = getHours();
        Calculate(quantity, price, role);
    }
    public void RunInvoice() throws SQLException {
        ArrayList<Integer> quantity = getQuantity();
        ArrayList<Double> price = getPrice();
        String role = getRole();
        double hours = getHours();
        Calculate(quantity, price, role);
    }

    public ArrayList<Integer> getQuantity() throws SQLException {
        ArrayList q = new ArrayList();

        String url = "jdbc:mysql://127.0.0.1:3306/garits";
        String SQL = "SELECT Quantity FROM parts_used WHERE Job_SheetNo = ?";
        PreparedStatement stmt = DriverManager.getConnection(url, "root", "").prepareStatement(SQL);
        stmt.setInt(1, jobSheetNo);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            q.add(rs.getInt(1));
        }
        stmt.executeQuery();

        rs.close();
        stmt.close();
        return q;
    }

    public ArrayList<Double> getPrice() throws SQLException {
        ArrayList pid = new ArrayList();

        String url = "jdbc:mysql://127.0.0.1:3306/garits";
        String SQL = "SELECT Price FROM Part WHERE PartNo in (SELECT PartNo FROM parts_used WHERE Job_SheetNo = ?)";
        PreparedStatement stmt = DriverManager.getConnection(url, "root", "").prepareStatement(SQL);
        stmt.setInt(1, jobSheetNo);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            pid.add(rs.getDouble(1) * markUp);
        }
        stmt.executeQuery();

        rs.close();
        stmt.close();
        return pid;

    }

    public String getRole() throws SQLException {
        String role = "";

        String url = "jdbc:mysql://127.0.0.1:3306/garits";
        String SQL = "SELECT Role FROM Staff WHERE StaffID in (SELECT StaffID FROM task WHERE Job_SheetNo = ?)";
        PreparedStatement stmt = DriverManager.getConnection(url, "root", "").prepareStatement(SQL);
        stmt.setInt(1, jobSheetNo);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            role = rs.getString(1);
            if (rs.getString(1).equals("Mechanic")) {
            }
        }
        stmt.executeQuery();

        rs.close();
        stmt.close();
        return role;

    }

    public double getHours() throws SQLException {
        double hours = 0;
        String job = (String) jobSheetList.getSelectedItem();

        String url = "jdbc:mysql://127.0.0.1:3306/garits";
        String SQL = "SELECT Actual_Time FROM Job_Sheet WHERE Job_SheetNo = ?";
        PreparedStatement stmt = DriverManager.getConnection(url, "root", "").prepareStatement(SQL);
        stmt.setInt(1, Integer.parseInt(job));
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            hours = hours + rs.getDouble(1);
        }
        stmt.executeQuery();

        rs.close();
        stmt.close();
        return hours;
    }

    public double Calculate(ArrayList<Integer> quantity, ArrayList<Double> price, String role) throws SQLException {
        double total = 0;
        for (int i = 0; i < quantity.size(); i++) {
            total = total + (quantity.get(i) * price.get(i));
        }
        if (role.equals( "Mechanic")) {
            total = total + (getHours() * mechanicRate);
        }
        total = total * VAT;
        System.out.println("Total " + total);
        return total;

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

        jobSheetList.setBounds(500,150,150,30);

        backButton.setBounds(10, 10, 125, 35);
        chooseButton.setBounds(525, 225, 100, 30);
    }

    public void setContainerProperties() {
        container.setBackground(new Color(35, 35, 35));
        container.add(logo);
        container.add(make);

        container.add(title);
        container.add(jobSheetList);

        container.add(jobNoLabel);

        container.add(backButton);
        container.add(chooseButton);
    }

    public void addActionEvent() {
        chooseButton.addActionListener(this);
        backButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == chooseButton){
            try {
                RunInvoice();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}


