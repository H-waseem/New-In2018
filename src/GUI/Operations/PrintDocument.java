package GUI.Operations;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PrintDocument {

    public void print() {

        //FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");
        //dialog.setMode(FileDialog.LOAD);
        //dialog.setVisible(true);
        //String file = dialog.getFile();
        //System.out.println(file + " chosen.");
//
        //Desktop desktop = Desktop.getDesktop();
        //try {
        //    desktop.print(new File(file));
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}

        File resource = new File("data/StatisticalReport.PDF");

        try {
                java.awt.Desktop.getDesktop().open(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
