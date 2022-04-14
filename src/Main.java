import GUI.LogInPanel;
import GUI.ReportPanel;
import GUI.TestPanel;
import Payment.CalculateInvoice;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException, SQLException {
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

        //Create Test panel with button for EVERYTHING in Admin account

        //Checked
        //AdminPanel ap = new AdminPanel();
        //ap.setVisible(true);

        //Checked Receptionist and Franchisee (done)
        //CustomerPanel abp = new CustomerPanel();
        //abp.setVisible(true);

        //Checked Foreperson and Mechanic and Receptionist (done)
        //VehiclePanel vp = new VehiclePanel();
        //vp.setVisible(true);

        //Checked Mechanic and Foreperson (done)
        //JobPanel jp = new JobPanel();
        //jp.setVisible(true);

        //Checked Mechanic and Foreperson (done)
        //TaskPanel tp = new TaskPanel();
        //tp.setVisible(true);

        //Checked
        new LogInPanel().setVisible(true);

        //ADMIN: SYSDBA, Masterkey
        //RECEPTIONIST: Penelope, PinkMobile
        //FOREMAN: Sunny, Attitude
        //MECHANIC: Gavin, LondonWeight

        //Checked
        //Doesnt work but code seems like it works just need default configuration for printer
        //new PrintDocument().print();

        //Checked automatically (Trigger?)
        //GUI.Reminder remind = new GUI.Reminder();
        //remind.MotReminder();

        //Checked ???
        //new CalculateInvoice().setVisible(true);

        //new PayEmployee(6);

        //TakePayment tp2 = new TakePayment();
        //tp2.setVisible(true);

        //Cash c = new Cash();
        //c.setVisible(true);

        //Card ca = new Card();
        //ca.setVisible(true);

        //Checked
        //new LowStock();

        //ReportPanel rp = new ReportPanel();
        //rp.setVisible(true);


        //TEST EVERY PANEL
        //new TestPanel();



    }
}
