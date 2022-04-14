package Job;


import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;

public class LowStock {

    public LowStock() {
        ArrayList<Integer> quantity2 = null;
        {
            try {
                quantity2 = getQuantity();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        ArrayList<Integer> threshold2 = null;
        {
            try {
                threshold2 = getThreshold();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        CheckSmaller(quantity2, threshold2);
    }


    public ArrayList<Integer> getQuantity() throws SQLException {
        ArrayList q = new ArrayList();

        String url = "jdbc:mysql://127.0.0.1:3306/garits";
        Connection conn = DriverManager.getConnection(url, "root", ""); // create the connection according to your DB details
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select Quantity from Part");
        while (rs.next()) {
            q.add(rs.getInt(1));
        }

        rs.close();
        stmt.close();
        return q;
    }

    public ArrayList<Integer> getThreshold() throws SQLException {
        ArrayList t = new ArrayList();

        String url = "jdbc:mysql://127.0.0.1:3306/garits";
        Connection conn = DriverManager.getConnection(url, "root", ""); // create the connection according to your DB details
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select Threshold from Part");
        while (rs.next()) {
            t.add(rs.getInt(1));
        }

        rs.close();
        stmt.close();
        return t;
    }

    public boolean CheckSmaller(ArrayList<Integer> quantity, ArrayList<Integer> threshold) {
        boolean isSmaller = false;

        for (int i = 0; i < quantity.size(); i++) {
                if (quantity.get(i) < threshold.get(i)) {
                isSmaller = true;
                JOptionPane.showMessageDialog(null, "One or more stock levels are under the threshold. Please restock.", "Low Stock Level", 2);
            }
        }
        return isSmaller;
    }

}
