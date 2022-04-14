package Payment;

import GUI.*;

import javax.swing.*;
import java.awt.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PayEmployee {

    int foremanRate = 125;
    int mechanicRate =  105;

    public PayEmployee(int staffID){
        int totalhours = 0;
        int total = 0;
        try {
            PreparedStatement st;
            PreparedStatement st2;

            ResultSet rs;
            ResultSet rs2;
            String query = "SELECT Actual_time from job_sheet WHERE Job_SheetNo = (SELECT Job_SheetNo FROM task WHERE StaffID = ? and Status = 'Complete')";
            String query2 = "SELECT Role from staff WHERE StaffID = ?";

            String url = "jdbc:mysql://127.0.0.1:3306/garits";


            st = DriverManager.getConnection(url, "root", "").prepareStatement(query);
            st2 = DriverManager.getConnection(url, "root", "").prepareStatement(query2);


            st.setInt(1, staffID);
            rs = st.executeQuery();

            st2.setInt(1, staffID);
            rs2 = st2.executeQuery();

            while (rs.next()) {
                totalhours = totalhours + rs.getInt(1);
            }

            if (rs2.next()){
                if (rs2.getString(1).equals("Mechanic")){
                    total = totalhours * mechanicRate;
                }
                if (rs2.getString(1).equals("Foreman")){
                    total = totalhours * foremanRate;
                }
            }

            System.out.println(staffID + " Gets paid for " + totalhours + " hours");
            System.out.println("£"+ total);

        } catch (HeadlessException | SQLException headlessException) {
            headlessException.printStackTrace();
        }

    }
}
