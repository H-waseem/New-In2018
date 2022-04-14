package GUI;

import GUI.Operations.PrintDocument;
import Job.LowStock;
import Payment.*;

import java.sql.SQLException;

public class TestPanel {
    public TestPanel() throws SQLException {
        //Checked
        AdminPanel ap = new AdminPanel();
        ap.setVisible(true);

        //Checked Receptionist and Franchisee (done)
        CustomerPanel abp = new CustomerPanel();
        abp.setVisible(true);

        //Checked Foreperson and Mechanic and Receptionist (done)
        VehiclePanel vp = new VehiclePanel();
        vp.setVisible(true);

        //Checked Mechanic and Foreperson (done)
        JobPanel jp = new JobPanel();
        jp.setVisible(true);

        //Checked Mechanic and Foreperson (done)
        TaskPanel tp = new TaskPanel();
        tp.setVisible(true);

        //Checked
        new LogInPanel().setVisible(true);

        //ADMIN: SYSDBA, Masterkey
        //RECEPTIONIST: Penelope, PinkMobile
        //FOREMAN: Sunny, Attitude
        //MECHANIC: Gavin, LondonWeight

        //Checked
        //Doesnt work but code seems like it works just need default configuration for printer
        new PrintDocument().print();

        //Checked automatically (Trigger?)
        Reminder remind = new Reminder();
        remind.MotReminder();


        //Checked ???
        new CalculateInvoice().setVisible(true);

        new PayEmployee(6);

        TakePayment tp2 = new TakePayment();
        tp2.setVisible(true);

        Cash c = new Cash();
        c.setVisible(true);

        Card ca = new Card();
        ca.setVisible(true);

        //Checked
        new LowStock();

        ReportPanel rp = new ReportPanel();
        rp.setVisible(true);
    }

}
