package Database;

import java.io.IOException;


public class BackupDB {

    public static void Backupdb() throws IOException, InterruptedException {

        ProcessBuilder backupDB = new ProcessBuilder("cmd.exe", "/c", "cd C:\\XAMPP\\mysql\\bin&&mysqldump -u root -h 127.0.0.1 garits > garits.sql");
        backupDB.start().waitFor();
        System.out.println("Database back up complete");
    }
}