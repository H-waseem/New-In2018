package GUI.Actions;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Font;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class StatisticalReport {

    public StatisticalReport(){

        Font reportNameFont = FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD);
        Font dateFont = FontFactory.getFont(FontFactory.HELVETICA, 17, Font.NORMAL);
        Font tableFont = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.BOLD);
        Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 9, Font.NORMAL);

        Document document = new Document();
        try
        {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("data/StatisticalReport.pdf"));
            document.open();

            Paragraph reportName = new Paragraph("Statistical Report", reportNameFont);
            document.add(reportName);

            Paragraph date = new Paragraph("05/11/2001", dateFont);
            document.add(date);

            PdfPTable table = new PdfPTable(6); // 3 columns.
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(10f); //Space before table
            table.setSpacingAfter(10f); //Space after table

            //Set Column widths
            float[] columnWidths = {0.3f, 0.7f, 0.6f, 0.4f, 0.4f, 0.4f};
            table.setWidths(columnWidths);

            PdfPCell cell1 = new PdfPCell(new Paragraph("", tableFont));
            PdfPCell cell2 = new PdfPCell(new Paragraph("No. of vehicles booked (monthly)", tableFont));
            PdfPCell cell3 = new PdfPCell(new Paragraph("Type of customer (casual or account holder)", tableFont));
            PdfPCell cell4 = new PdfPCell(new Paragraph("Av. time (h)", tableFont));
            PdfPCell cell5 = new PdfPCell(new Paragraph("Av. price (£)", tableFont));
            PdfPCell cell6 = new PdfPCell(new Paragraph("Av. mechanic", tableFont));

            PdfPCell cell7 = new PdfPCell(new Paragraph("MoT", tableFont));
            PdfPCell cell8 = new PdfPCell(new Paragraph("8", contentFont));
            PdfPCell cell9 = new PdfPCell(new Paragraph("Casual Customer", contentFont));
            PdfPCell cell10 = new PdfPCell(new Paragraph("2", contentFont));
            PdfPCell cell11 = new PdfPCell(new Paragraph("50.00", contentFont));
            PdfPCell cell12 = new PdfPCell(new Paragraph("Anthony Wild", contentFont));

            PdfPCell cell13 = new PdfPCell(new Paragraph("Annual Service", tableFont));
            PdfPCell cell14 = new PdfPCell(new Paragraph("3", contentFont));
            PdfPCell cell15 = new PdfPCell(new Paragraph("Casual Customer", contentFont));
            PdfPCell cell16 = new PdfPCell(new Paragraph("2", contentFont));
            PdfPCell cell17 = new PdfPCell(new Paragraph("60.00", contentFont));
            PdfPCell cell18 = new PdfPCell(new Paragraph("Anthony Wild", contentFont));

            PdfPCell cell19 = new PdfPCell(new Paragraph("Repair", tableFont));
            PdfPCell cell20 = new PdfPCell(new Paragraph("5", contentFont));
            PdfPCell cell21 = new PdfPCell(new Paragraph("Account Holder", contentFont));
            PdfPCell cell22 = new PdfPCell(new Paragraph("9", contentFont));
            PdfPCell cell23 = new PdfPCell(new Paragraph("200.00", contentFont));
            PdfPCell cell24 = new PdfPCell(new Paragraph("Gavin Ross", contentFont));

            PdfPCell cell25 = new PdfPCell(new Paragraph("Overall", tableFont));
            PdfPCell cell26 = new PdfPCell(new Paragraph("5.3", contentFont));
            PdfPCell cell27 = new PdfPCell(new Paragraph("Casual Customer", contentFont));
            PdfPCell cell28 = new PdfPCell(new Paragraph("4.3", contentFont));
            PdfPCell cell29 = new PdfPCell(new Paragraph("103.33", contentFont));
            PdfPCell cell30 = new PdfPCell(new Paragraph("Anthony Wild", contentFont));

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);

            table.addCell(cell7);
            table.addCell(cell8);
            table.addCell(cell9);
            table.addCell(cell10);
            table.addCell(cell11);
            table.addCell(cell12);

            table.addCell(cell13);
            table.addCell(cell14);
            table.addCell(cell15);
            table.addCell(cell16);
            table.addCell(cell17);
            table.addCell(cell18);

            table.addCell(cell19);
            table.addCell(cell20);
            table.addCell(cell21);
            table.addCell(cell22);
            table.addCell(cell23);
            table.addCell(cell24);

            table.addCell(cell25);
            table.addCell(cell26);
            table.addCell(cell27);
            table.addCell(cell28);
            table.addCell(cell29);
            table.addCell(cell30);

            document.add(table);

            document.close();
            writer.close();

            System.out.println("GUI.Actions.Report Generated");

            File resource = new File("data/StatisticalReport.pdf");

            try {
                java.awt.Desktop.getDesktop().open(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
