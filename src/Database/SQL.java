package Database;


import java.sql.*;

public class SQL {
    Connection conn;

    public static void main(String[] args) {
        new SQL();
    }

    public SQL() {
        // connect to the database
        try {
            // database connection string
            // MySQL jdbc:mysql://{HOST}[:{PORT}][/{DB}]
            String url = "jdbc:mysql://127.0.0.1:3306/garits";
            // username and password
            conn = DriverManager.getConnection(url, "root", "");

            // examples of using the database
            //doTests();

            // cleanup, close the connection
            conn.close();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void doTests() {
        doSelectTest();

        //doInsertTest(); //doSelectTest();
       // doUpdateTest(); doSelectTest();
        // doDeleteTest(); doSelectTest();
    }

    private void doSelectTest() {
        System.out.println("[OUTPUT FROM SELECT]");
        String query = "SELECT Username FROM staff";
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                String s = rs.getString("Username");
                //float n = rs.getFloat("PRICE");
                System.out.println(s + "   " );
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void doInsertTest() {
        System.out.print("\n[Performing INSERT] ... ");
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("INSERT INTO STAFF " +
                    "VALUES (7, 'New', 'Old', 'NO', 'User123','Mechanic')");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void doUpdateTest() {
        System.out.print("\n[Performing UPDATE] ... ");
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("UPDATE COFFEES SET PRICE=4.99 WHERE COF_NAME='BREAKFAST BLEND'");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void doDeleteTest() {
        System.out.print("\n[Performing DELETE] ... ");
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM COFFEES WHERE COF_NAME='BREAKFAST BLEND'");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

}

