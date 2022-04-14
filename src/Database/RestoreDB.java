package Database;


import java.io.IOException;

public class RestoreDB {

    public static void RestoreDB() throws IOException, InterruptedException {

        ProcessBuilder restoreDB = new ProcessBuilder("cmd.exe", "/c", "cd C:\\XAMPP\\mysql\\bin&&mysql -u root -h 127.0.0.1 garits < garits.sql");
        restoreDB.start().waitFor();
        System.out.println("Database restore complete");

    }
}