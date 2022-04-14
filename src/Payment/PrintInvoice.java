package Payment;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Font;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PrintInvoice {

    public PrintInvoice() {

        Font invoiceNoFont = FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD);
        Font dateFont = FontFactory.getFont(FontFactory.HELVETICA, 17, Font.NORMAL);
        Font tableFont = FontFactory.getFont(FontFactory.HELVETICA, 15, Font.BOLD);
        Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 14, Font.NORMAL);

        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("data/Invoice.pdf"));
            document.open();

            Paragraph ParagraphInvoiceNo = new Paragraph("INVOICE NO.: 197362", invoiceNoFont);
            document.add(ParagraphInvoiceNo);

            Paragraph ParagraphDate = new Paragraph("18th October 2021", dateFont);
            document.add(ParagraphDate);

            PdfPTable table = new PdfPTable(5); // 5 columns.
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(10f); //Space before table
            table.setSpacingAfter(10f); //Space after table

            //Set Column widths
            float[] columnWidths = {0.7f, 0.7f, 0.5f, 0.2f, 0.f};
            table.setWidths(columnWidths);

            PdfPCell cell1 = new PdfPCell(new Paragraph("Item", tableFont));
            PdfPCell cell2 = new PdfPCell(new Paragraph("Part No.", tableFont));
            PdfPCell cell3 = new PdfPCell(new Paragraph("Unit Cost", tableFont));
            PdfPCell cell4 = new PdfPCell(new Paragraph("Qty.", tableFont));
            PdfPCell cell5 = new PdfPCell(new Paragraph("Cost (£)", tableFont));

            PdfPCell cell6 = new PdfPCell(new Paragraph("Exhaust pipe", contentFont));
            PdfPCell cell7 = new PdfPCell(new Paragraph("X784/6352J", contentFont));
            PdfPCell cell8 = new PdfPCell(new Paragraph("57.50", contentFont));
            PdfPCell cell9 = new PdfPCell(new Paragraph("1", contentFont));
            PdfPCell cell10 = new PdfPCell(new Paragraph("57.50", contentFont));

            PdfPCell cell11 = new PdfPCell(new Paragraph("Head Gasket", contentFont));
            PdfPCell cell12 = new PdfPCell(new Paragraph("Y76432-89T5", contentFont));
            PdfPCell cell13 = new PdfPCell(new Paragraph("15.75", contentFont));
            PdfPCell cell14 = new PdfPCell(new Paragraph("1", contentFont));
            PdfPCell cell15 = new PdfPCell(new Paragraph("15.75", contentFont));

            PdfPCell cell16 = new PdfPCell(new Paragraph("Valves", contentFont));
            PdfPCell cell17 = new PdfPCell(new Paragraph("672351X/34K", contentFont));
            PdfPCell cell18 = new PdfPCell(new Paragraph("5.15", contentFont));
            PdfPCell cell19 = new PdfPCell(new Paragraph("6", contentFont));
            PdfPCell cell20 = new PdfPCell(new Paragraph("30.90", contentFont));

            PdfPCell cell21 = new PdfPCell(new Paragraph("Grommet Seal", contentFont));
            PdfPCell cell22 = new PdfPCell(new Paragraph("X784/4563-2", contentFont));
            PdfPCell cell23 = new PdfPCell(new Paragraph("0.90", contentFont));
            PdfPCell cell24 = new PdfPCell(new Paragraph("3", contentFont));
            PdfPCell cell25 = new PdfPCell(new Paragraph("2.70", contentFont));

            PdfPCell cell26 = new PdfPCell(new Paragraph("Labour", tableFont));
            PdfPCell cell27 = new PdfPCell(new Paragraph("", contentFont));
            PdfPCell cell28 = new PdfPCell(new Paragraph("105.00", contentFont));
            PdfPCell cell29 = new PdfPCell(new Paragraph("5.75", contentFont));
            PdfPCell cell30 = new PdfPCell(new Paragraph("603.75", contentFont));

            PdfPCell cell31 = new PdfPCell(new Paragraph("", contentFont));
            PdfPCell cell32 = new PdfPCell(new Paragraph("", contentFont));
            PdfPCell cell33 = new PdfPCell(new Paragraph("Total", tableFont));
            PdfPCell cell34 = new PdfPCell(new Paragraph("", contentFont));
            PdfPCell cell35 = new PdfPCell(new Paragraph("710.60", contentFont));

            PdfPCell cell36 = new PdfPCell(new Paragraph("", contentFont));
            PdfPCell cell37 = new PdfPCell(new Paragraph("", contentFont));
            PdfPCell cell38 = new PdfPCell(new Paragraph("VAT", tableFont));
            PdfPCell cell39 = new PdfPCell(new Paragraph("", contentFont));
            PdfPCell cell40 = new PdfPCell(new Paragraph("142.12", contentFont));

            PdfPCell cell41 = new PdfPCell(new Paragraph("", contentFont));
            PdfPCell cell42 = new PdfPCell(new Paragraph("", contentFont));
            PdfPCell cell43 = new PdfPCell(new Paragraph("Grand Total", tableFont));
            PdfPCell cell44 = new PdfPCell(new Paragraph("", contentFont));
            PdfPCell cell45 = new PdfPCell(new Paragraph("852.72", contentFont));

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

            table.addCell(cell31);
            table.addCell(cell32);
            table.addCell(cell33);
            table.addCell(cell34);
            table.addCell(cell35);

            table.addCell(cell36);
            table.addCell(cell37);
            table.addCell(cell38);
            table.addCell(cell39);
            table.addCell(cell40);

            table.addCell(cell41);
            table.addCell(cell42);
            table.addCell(cell43);
            table.addCell(cell44);
            table.addCell(cell45);

            document.add(table);

            document.close();
            writer.close();

            System.out.println("Invoice Printed");

            File resource = new File("data/Invoice.pdf");

            try {
                java.awt.Desktop.getDesktop().open(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
