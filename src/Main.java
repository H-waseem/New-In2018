import GUI.LogInPanel;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        PreparedStatement st;

        //Database transaction type set
        //AutoCommit to false when transacting and back to true when finished
        String query ="SET SESSION TRANSACTION ISOLATION LEVEL SERIALIZABLE";
        String url = "jdbc:mysql://127.0.0.1:3306/garits";
        try {
            DriverManager.getConnection(url, "root", "").setAutoCommit(false);
            st = DriverManager.getConnection(url, "root", "").prepareStatement(query);
            st.execute();
            DriverManager.getConnection(url, "root", "").setAutoCommit(true);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        new LogInPanel().setVisible(true);

    }
}
