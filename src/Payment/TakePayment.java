package Payment;

//import GUI.Actions.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TakePayment extends JFrame implements ActionListener {

    Container container = getContentPane();

    JLabel title = new JLabel("Payment panel");
    JLabel make = new JLabel("Developed by LSC");
    JLabel logo = new JLabel();

    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));

    JButton cashButton = new JButton("Cash");
    JButton cardButton = new JButton("Credit Card");

    JButton logoutButton = new JButton("Log Out");

    boolean CheckLate(){
        //Check if payment is late
        //if payment date = 30 days after invoice date
        //show popup saying it is late
        return false;
    }

    public TakePayment() {
        setLayoutManager();
        setPlacement();
        setContainerProperties();
        addActionEvent();
        this.setBounds(10, 10, 1080, 720);
        this.setTitle("GARITS Take Payment panel");
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
        title.setBounds(450, 75, 300, 30);

        logoutButton.setBounds(10, 10, 85, 35);
        cashButton.setBounds(450, 175, 150, 60);
        cardButton.setBounds(450, 275, 150, 60);


    }

    public void setContainerProperties() {
        container.setBackground(new Color(35, 35, 35));
        container.add(logo);
        container.add(make);
        container.add(title);


        container.add(logoutButton);
        container.add(cardButton);
        container.add(cashButton);
    }

    public void addActionEvent() {
        cashButton.addActionListener(this);
        cardButton.addActionListener(this);
        logoutButton.addActionListener(this);
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
        if (e.getSource() == logoutButton) {
            this.dispose();
            new TakePayment().setVisible(true);
            System.out.println("Log Out Successful");
        }
        if (e.getSource() == cashButton) {
            new Cash();
            System.out.println("Cash");
        }
        if(e.getSource() == cardButton) {
            new Card();
            System.out.println("Card");

        }
    }

}
