package GUI;

import javax.swing.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Reminder {

    public void MotReminder() {
        //If Current date is 1 week before MOT date
        //send reminder
        Date motWeek = new Date();
        String mot = "";
        String currentDate;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        currentDate = formatter.format(c.getTime());
        System.out.println(currentDate);
        String url = "jdbc:mysql://127.0.0.1:3306/garits";
        try {
            String SQL = "SELECT MoT_Date FROM Vehicles";
            PreparedStatement stmt = DriverManager.getConnection(url, "root", "").prepareStatement(SQL);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                mot  = rs.getString(1);
                Date motD = formatter.parse(mot);
                Date currentDateD = formatter.parse(currentDate);

                Calendar calendar = Calendar.getInstance();
                calendar.setTime(motWeek);
                calendar.add(Calendar.DAY_OF_YEAR, -7);
                Date newDate = calendar.getTime();

                if (currentDateD.after(newDate) && newDate.before(motD)){
                    JOptionPane.showMessageDialog(null, "MOT DATE COMING UP", "MOT REMINDER", 2);
                }
            }
            stmt.executeQuery();
            System.out.println(mot);
            stmt.close();
        } catch (SQLException | ParseException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
