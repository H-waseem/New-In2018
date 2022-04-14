package GUI;
import GUI.Operations.*;

import java.awt.Font;
import java.awt.Image;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReportPanel extends JFrame implements ActionListener {

    Container container = getContentPane();

    JLabel title = new JLabel("Generate Report");
    JLabel make = new JLabel("Developed by LSC");

    JButton backButton = new JButton("Back to menu");
    JButton stockLevelButton = new JButton("Generate Stock Level Report");
    JButton statisticalButton = new JButton("Generate Statistical Report");

    JLabel logo = new JLabel();
    ImageIcon imageIcon = new ImageIcon(new ImageIcon("data/LosSantos.png").getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));

    public ReportPanel() {
        setLayoutManager();
        setPlacement();
        setContainerProperties();
        addActionEvent();
        this.setBounds(10, 10, 1080, 720);
        this.setTitle("GARITS Generate Report");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void addActionEvent() {
        stockLevelButton.addActionListener(this);
        statisticalButton.addActionListener(this);
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
        title.setBounds(415, 50, 300, 30);
        title.setFont(new Font("Tahoma", Font.BOLD, 25));
        title.setForeground(Color.WHITE);

        backButton.setBounds(10, 10, 125, 35);
        stockLevelButton.setBounds(400, 200, 250, 40);
        statisticalButton.setBounds(400, 300, 250, 40);
    }

    public void setContainerProperties() {
        container.setBackground(new Color(35, 35, 35));
        container.add(logo);
        container.add(make);

        container.add(title);

        container.add(backButton);
        container.add(stockLevelButton);
        container.add(statisticalButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton){
            this.dispose();
           new LogInPanel().setVisible(true);
        }
		if (e.getSource() == stockLevelButton){
            new GUI.Actions.StockLevelReport();
		}
        if (e.getSource() == statisticalButton){
            new GUI.Actions.StatisticalReport();
        }
    }
}
