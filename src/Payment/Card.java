package Payment;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

public class Card extends JFrame implements ActionListener {

    String[] invoiceID;
    String[] type = {"Casual", "Account Holder"};

    {
        try {
            invoiceID = getInvoiceID().toArray(new String[0]);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<String> getInvoiceID() throws SQLException {
        ArrayList l = new ArrayList();
        String url = "jdbc:mysql://127.0.0.1:3306/garits";
        Connection conn = DriverManager.getConnection(url, "root", ""); // create the connection according to your DB details
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select InvoiceID from invoice");
        while (rs.next()) {
            l.add(rs.getString(1));
        }

        rs.close();
        stmt.close();
        l.toArray();
        return l;
    }

    Container container = getContentPane();

    JLabel discountLabel = new JLabel("Discount?");
    JLabel InvoiceIDLabel = new JLabel("INVOICE ID");
    JLabel typeLabel = new JLabel("CUSTOMER TYPE");
    JLabel amountPaidLabel = new JLabel("AMOUNT PAID");


    JComboBox invoiceIDList = new JComboBox(invoiceID);
    JComboBox typeList = new JComboBox(type);
    JTextField ammountTextField = new JTextField();

    JLabel title = new JLabel("Card Payment Panel");
    JLabel make = new JLabel("Developed by LSC");
    JLabel logo = new JLabel();

    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));

    JButton payCashButton = new JButton("Pay");
    JButton backButton = new JButton("Back to menu");


    public Card() {
        setLayoutManager();
        setPlacement();
        setContainerProperties();
        addActionEvent();
        this.setBounds(10, 10, 1080, 720);
        this.setTitle("GARITS Card Panel");
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
        title.setBounds(400, 75, 300, 30);


        typeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        InvoiceIDLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        amountPaidLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        typeLabel.setForeground(Color.WHITE);
        InvoiceIDLabel.setForeground(Color.WHITE);
        amountPaidLabel.setForeground(Color.WHITE);
        discountLabel.setFont(new Font("Tahoma", Font.BOLD, 14));

        discountLabel.setForeground(Color.WHITE);

        discountLabel.setBounds(600, 150, 250, 30);
        typeList.setBounds(450, 150, 130, 30);
        ammountTextField.setBounds(450, 270, 130, 30);
        invoiceIDList.setBounds(450, 210, 130, 30);
        backButton.setBounds(10, 10, 125, 35);
        payCashButton.setBounds(450, 350, 150, 60);


        InvoiceIDLabel.setBounds(300, 210, 100, 30);
        typeLabel.setBounds(300, 150, 150, 30);
        amountPaidLabel.setBounds(300, 270, 150, 30);


    }

    public void setContainerProperties() {
        container.setBackground(new Color(35, 35, 35));
        container.add(logo);
        container.add(make);
        container.add(title);
        container.add(invoiceIDList);

        container.add(ammountTextField);
        container.add(typeList);
        container.add(discountLabel);

        container.add(backButton);
        container.add(payCashButton);

        container.add(typeLabel);
        container.add(amountPaidLabel);
        container.add(InvoiceIDLabel);
    }

    public void addActionEvent() {
        payCashButton.addActionListener(this);
        backButton.addActionListener(this);
        typeList.addActionListener(this);
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
        if (e.getSource() == payCashButton) {
            System.out.println("CARD PAID");
        }
        if (e.getSource() == backButton) {
            this.dispose();
            new TakePayment().setVisible(true);
        }
        if (e.getSource() == typeList) {
            String type = (String) typeList.getSelectedItem();
            System.out.println(type);
            if (type.equals("Account Holder")) {
                discountLabel.setText("DISCOUNT OF __ ADDED");
                System.out.println("account holder selected show discount");
            }
            if (typeList.getSelectedItem().equals("Casual")) {
                discountLabel.setText(" NEW DISCOUNT OF __ ADDED");
                System.out.println("account holder selected show discount");
            }
        }
    }
}

