package GUI.Actions;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.Font;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class StockLevelReport {

	public StockLevelReport(){

		Font reportNameFont = FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLD);
		Font dateFont = FontFactory.getFont(FontFactory.HELVETICA, 10, Font.NORMAL);
		Font tableFont = FontFactory.getFont(FontFactory.HELVETICA, 8, Font.BOLD);
		Font contentFont = FontFactory.getFont(FontFactory.HELVETICA, 7, Font.NORMAL);

		Document document = new Document();
		try
		{
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("data/StockLevelReport.pdf"));
			document.open();

			Paragraph reportName = new Paragraph("Stock Level Report", reportNameFont);
			document.add(reportName);

			Paragraph date = new Paragraph("05/11/2001", dateFont);
			document.add(date);

			PdfPTable table = new PdfPTable(13); // 3 columns.
			table.setWidthPercentage(100); //Width 100%
			table.setSpacingBefore(10f); //Space before table
			table.setSpacingAfter(10f); //Space after table

			//Set Column widths
			float[] columnWidths = {0.6f, 0.4f, 0.5f, 0.5f, 0.5f, 0.4f, 0.5f, 0.5f, 0.4f, 0.6f, 0.5f, 0.5f, 0.5f};
			table.setWidths(columnWidths);

			PdfPCell cell1 = new PdfPCell(new Paragraph("PART NAME", tableFont));
			PdfPCell cell2 = new PdfPCell(new Paragraph("CODE", tableFont));
			PdfPCell cell3 = new PdfPCell(new Paragraph("MANUFACTURER", tableFont));
			PdfPCell cell4 = new PdfPCell(new Paragraph("VEHICLE TYPE", tableFont));
			PdfPCell cell5 = new PdfPCell(new Paragraph("YEAR(S)", tableFont));
			PdfPCell cell6 = new PdfPCell(new Paragraph("PRICE", tableFont));
			PdfPCell cell7 = new PdfPCell(new Paragraph("INITIAL STOCK LEVEL", tableFont));
			PdfPCell cell8 = new PdfPCell(new Paragraph("INITIAL COST, £", tableFont));
			PdfPCell cell9 = new PdfPCell(new Paragraph("USED", tableFont));
			PdfPCell cell10 = new PdfPCell(new Paragraph("DELIVERY", tableFont));
			PdfPCell cell11 = new PdfPCell(new Paragraph("NEW STOCK LEVEL", tableFont));
			PdfPCell cell12 = new PdfPCell(new Paragraph("STOCK COST, £", tableFont));
			PdfPCell cell13 = new PdfPCell(new Paragraph("LOW LEVEL THRESHOLD", tableFont));

			PdfPCell cell14 = new PdfPCell(new Paragraph("TYRE", contentFont));
			PdfPCell cell15 = new PdfPCell(new Paragraph("XB5020", contentFont));
			PdfPCell cell16 = new PdfPCell(new Paragraph("Fjord", contentFont));
			PdfPCell cell17 = new PdfPCell(new Paragraph("Transit Van", contentFont));
			PdfPCell cell18 = new PdfPCell(new Paragraph("2012-2020", contentFont));
			PdfPCell cell19 = new PdfPCell(new Paragraph("£45.00", contentFont));
			PdfPCell cell20 = new PdfPCell(new Paragraph("11", contentFont));
			PdfPCell cell21 = new PdfPCell(new Paragraph("495.00", contentFont));
			PdfPCell cell22 = new PdfPCell(new Paragraph("3", contentFont));
			PdfPCell cell23 = new PdfPCell(new Paragraph("0", contentFont));
			PdfPCell cell24 = new PdfPCell(new Paragraph("8", contentFont));
			PdfPCell cell25 = new PdfPCell(new Paragraph("360.00", contentFont));
			PdfPCell cell26 = new PdfPCell(new Paragraph("6", contentFont));

			PdfPCell cell131 = new PdfPCell(new Paragraph("OIL FILTER", contentFont));
			PdfPCell cell132 = new PdfPCell(new Paragraph("OF842", contentFont));
			PdfPCell cell133 = new PdfPCell(new Paragraph("All makes", contentFont));
			PdfPCell cell134 = new PdfPCell(new Paragraph("All makes", contentFont));
			PdfPCell cell135 = new PdfPCell(new Paragraph("2008-2022", contentFont));
			PdfPCell cell136 = new PdfPCell(new Paragraph("£10.00", contentFont));
			PdfPCell cell137 = new PdfPCell(new Paragraph("20", contentFont));
			PdfPCell cell138 = new PdfPCell(new Paragraph("200.00", contentFont));
			PdfPCell cell139 = new PdfPCell(new Paragraph("4", contentFont));
			PdfPCell cell140 = new PdfPCell(new Paragraph("0", contentFont));
			PdfPCell cell141 = new PdfPCell(new Paragraph("16", contentFont));
			PdfPCell cell142 = new PdfPCell(new Paragraph("160.00", contentFont));
			PdfPCell cell143 = new PdfPCell(new Paragraph("15", contentFont));

			PdfPCell cell144 = new PdfPCell(new Paragraph("AIR FILTER", contentFont));
			PdfPCell cell145 = new PdfPCell(new Paragraph("AF954", contentFont));
			PdfPCell cell146 = new PdfPCell(new Paragraph("All makes", contentFont));
			PdfPCell cell147 = new PdfPCell(new Paragraph("All makes", contentFont));
			PdfPCell cell148 = new PdfPCell(new Paragraph("2007-2022", contentFont));
			PdfPCell cell149 = new PdfPCell(new Paragraph("£15.00", contentFont));
			PdfPCell cell150 = new PdfPCell(new Paragraph("22", contentFont));
			PdfPCell cell151 = new PdfPCell(new Paragraph("330.00", contentFont));
			PdfPCell cell152 = new PdfPCell(new Paragraph("7", contentFont));
			PdfPCell cell153 = new PdfPCell(new Paragraph("0", contentFont));
			PdfPCell cell154 = new PdfPCell(new Paragraph("15", contentFont));
			PdfPCell cell155 = new PdfPCell(new Paragraph("225.00", contentFont));
			PdfPCell cell156 = new PdfPCell(new Paragraph("10", contentFont));

			PdfPCell cell27 = new PdfPCell(new Paragraph("EXHAUST", contentFont));
			PdfPCell cell28 = new PdfPCell(new Paragraph("BCU698", contentFont));
			PdfPCell cell29 = new PdfPCell(new Paragraph("Fjord", contentFont));
			PdfPCell cell30 = new PdfPCell(new Paragraph("Estate", contentFont));
			PdfPCell cell31 = new PdfPCell(new Paragraph("2005-2014", contentFont));
			PdfPCell cell32 = new PdfPCell(new Paragraph("£200.00", contentFont));
			PdfPCell cell33 = new PdfPCell(new Paragraph("5", contentFont));
			PdfPCell cell34 = new PdfPCell(new Paragraph("1000.00", contentFont));
			PdfPCell cell35 = new PdfPCell(new Paragraph("2", contentFont));
			PdfPCell cell36 = new PdfPCell(new Paragraph("0", contentFont));
			PdfPCell cell37 = new PdfPCell(new Paragraph("3", contentFont));
			PdfPCell cell38 = new PdfPCell(new Paragraph("600.00", contentFont));
			PdfPCell cell39 = new PdfPCell(new Paragraph("2", contentFont));

			PdfPCell cell40 = new PdfPCell(new Paragraph("ENGINE MOUNTS", contentFont));
			PdfPCell cell41 = new PdfPCell(new Paragraph("VC5219", contentFont));
			PdfPCell cell42 = new PdfPCell(new Paragraph("All makes", contentFont));
			PdfPCell cell43 = new PdfPCell(new Paragraph("All makes", contentFont));
			PdfPCell cell44 = new PdfPCell(new Paragraph("2001-2014", contentFont));
			PdfPCell cell45 = new PdfPCell(new Paragraph("£15.00", contentFont));
			PdfPCell cell46 = new PdfPCell(new Paragraph("10", contentFont));
			PdfPCell cell47 = new PdfPCell(new Paragraph("150.00", contentFont));
			PdfPCell cell48 = new PdfPCell(new Paragraph("4", contentFont));
			PdfPCell cell49 = new PdfPCell(new Paragraph("0", contentFont));
			PdfPCell cell50 = new PdfPCell(new Paragraph("6", contentFont));
			PdfPCell cell51 = new PdfPCell(new Paragraph("90.00", contentFont));
			PdfPCell cell52 = new PdfPCell(new Paragraph("4", contentFont));

			PdfPCell cell53 = new PdfPCell(new Paragraph("SPARK PLUGS", contentFont));
			PdfPCell cell54 = new PdfPCell(new Paragraph("QW2134", contentFont));
			PdfPCell cell55 = new PdfPCell(new Paragraph("All makes", contentFont));
			PdfPCell cell56 = new PdfPCell(new Paragraph("All makes", contentFont));
			PdfPCell cell57 = new PdfPCell(new Paragraph("1998-2005", contentFont));
			PdfPCell cell58 = new PdfPCell(new Paragraph("£1.50", contentFont));
			PdfPCell cell59 = new PdfPCell(new Paragraph("26", contentFont));
			PdfPCell cell60 = new PdfPCell(new Paragraph("39.00", contentFont));
			PdfPCell cell61 = new PdfPCell(new Paragraph("3", contentFont));
			PdfPCell cell62 = new PdfPCell(new Paragraph("0", contentFont));
			PdfPCell cell63 = new PdfPCell(new Paragraph("23", contentFont));
			PdfPCell cell64 = new PdfPCell(new Paragraph("24.50", contentFont));
			PdfPCell cell65 = new PdfPCell(new Paragraph("20", contentFont));

			PdfPCell cell66 = new PdfPCell(new Paragraph("SPARK LEADS", contentFont));
			PdfPCell cell67 = new PdfPCell(new Paragraph("AB123", contentFont));
			PdfPCell cell68 = new PdfPCell(new Paragraph("All makes", contentFont));
			PdfPCell cell69 = new PdfPCell(new Paragraph("All makes", contentFont));
			PdfPCell cell70 = new PdfPCell(new Paragraph("2006-2010", contentFont));
			PdfPCell cell71 = new PdfPCell(new Paragraph("£12.50", contentFont));
			PdfPCell cell72 = new PdfPCell(new Paragraph("21", contentFont));
			PdfPCell cell73 = new PdfPCell(new Paragraph("262.50", contentFont));
			PdfPCell cell74 = new PdfPCell(new Paragraph("5", contentFont));
			PdfPCell cell75 = new PdfPCell(new Paragraph("0", contentFont));
			PdfPCell cell76 = new PdfPCell(new Paragraph("16", contentFont));
			PdfPCell cell77 = new PdfPCell(new Paragraph("200.00", contentFont));
			PdfPCell cell78 = new PdfPCell(new Paragraph("10", contentFont));

			PdfPCell cell79 = new PdfPCell(new Paragraph("DISTRIBUTOR CAP", contentFont));
			PdfPCell cell80 = new PdfPCell(new Paragraph("BOI123", contentFont));
			PdfPCell cell81 = new PdfPCell(new Paragraph("Fjord", contentFont));
			PdfPCell cell82 = new PdfPCell(new Paragraph("All makes", contentFont));
			PdfPCell cell83 = new PdfPCell(new Paragraph("2007-2018", contentFont));
			PdfPCell cell84 = new PdfPCell(new Paragraph("£35.00", contentFont));
			PdfPCell cell85 = new PdfPCell(new Paragraph("13", contentFont));
			PdfPCell cell86 = new PdfPCell(new Paragraph("455.00", contentFont));
			PdfPCell cell87 = new PdfPCell(new Paragraph("3", contentFont));
			PdfPCell cell88 = new PdfPCell(new Paragraph("0", contentFont));
			PdfPCell cell89 = new PdfPCell(new Paragraph("10", contentFont));
			PdfPCell cell90 = new PdfPCell(new Paragraph("350.00", contentFont));
			PdfPCell cell91 = new PdfPCell(new Paragraph("5", contentFont));

			PdfPCell cell92 = new PdfPCell(new Paragraph("ARROGANT RED PAINT (LITRES)", contentFont));
			PdfPCell cell93 = new PdfPCell(new Paragraph("GO351", contentFont));
			PdfPCell cell94 = new PdfPCell(new Paragraph("All makes", contentFont));
			PdfPCell cell95 = new PdfPCell(new Paragraph("All makes", contentFont));
			PdfPCell cell96 = new PdfPCell(new Paragraph("2015-2022", contentFont));
			PdfPCell cell97 = new PdfPCell(new Paragraph("£60.00", contentFont));
			PdfPCell cell98 = new PdfPCell(new Paragraph("5", contentFont));
			PdfPCell cell99 = new PdfPCell(new Paragraph("300.00", contentFont));
			PdfPCell cell100 = new PdfPCell(new Paragraph("2", contentFont));
			PdfPCell cell101 = new PdfPCell(new Paragraph("0", contentFont));
			PdfPCell cell102 = new PdfPCell(new Paragraph("3", contentFont));
			PdfPCell cell103 = new PdfPCell(new Paragraph("180.00", contentFont));
			PdfPCell cell104 = new PdfPCell(new Paragraph("2", contentFont));

			PdfPCell cell105 = new PdfPCell(new Paragraph("INTERIOR BULB", contentFont));
			PdfPCell cell106 = new PdfPCell(new Paragraph("JS211", contentFont));
			PdfPCell cell107 = new PdfPCell(new Paragraph("Rolls Royce", contentFont));
			PdfPCell cell108 = new PdfPCell(new Paragraph("All makes", contentFont));
			PdfPCell cell109 = new PdfPCell(new Paragraph("2012-2022", contentFont));
			PdfPCell cell110 = new PdfPCell(new Paragraph("£118.00", contentFont));
			PdfPCell cell111 = new PdfPCell(new Paragraph("4", contentFont));
			PdfPCell cell112 = new PdfPCell(new Paragraph("472.00", contentFont));
			PdfPCell cell113 = new PdfPCell(new Paragraph("2", contentFont));
			PdfPCell cell114 = new PdfPCell(new Paragraph("0", contentFont));
			PdfPCell cell115 = new PdfPCell(new Paragraph("2", contentFont));
			PdfPCell cell116 = new PdfPCell(new Paragraph("236.00", contentFont));
			PdfPCell cell117 = new PdfPCell(new Paragraph("1", contentFont));

			PdfPCell cell118 = new PdfPCell(new Paragraph("MOTOR OIL (GALLONS)", contentFont));
			PdfPCell cell119 = new PdfPCell(new Paragraph("RT329", contentFont));
			PdfPCell cell120 = new PdfPCell(new Paragraph("All makes", contentFont));
			PdfPCell cell121 = new PdfPCell(new Paragraph("All makes", contentFont));
			PdfPCell cell122 = new PdfPCell(new Paragraph("2015-2022", contentFont));
			PdfPCell cell123 = new PdfPCell(new Paragraph("£25.00", contentFont));
			PdfPCell cell124 = new PdfPCell(new Paragraph("34", contentFont));
			PdfPCell cell125 = new PdfPCell(new Paragraph("850.00", contentFont));
			PdfPCell cell126 = new PdfPCell(new Paragraph("4", contentFont));
			PdfPCell cell127 = new PdfPCell(new Paragraph("0", contentFont));
			PdfPCell cell128 = new PdfPCell(new Paragraph("30", contentFont));
			PdfPCell cell129 = new PdfPCell(new Paragraph("750.00", contentFont));
			PdfPCell cell130 = new PdfPCell(new Paragraph("25", contentFont));

			PdfPCell cell157 = new PdfPCell(new Paragraph("Total", tableFont));
			PdfPCell cell158 = new PdfPCell(new Paragraph("", contentFont));
			PdfPCell cell159 = new PdfPCell(new Paragraph("", contentFont));
			PdfPCell cell160 = new PdfPCell(new Paragraph("", contentFont));
			PdfPCell cell161 = new PdfPCell(new Paragraph("", contentFont));
			PdfPCell cell162 = new PdfPCell(new Paragraph("", contentFont));
			PdfPCell cell163 = new PdfPCell(new Paragraph("", contentFont));
			PdfPCell cell164 = new PdfPCell(new Paragraph("4553.50", contentFont));
			PdfPCell cell165 = new PdfPCell(new Paragraph("", contentFont));
			PdfPCell cell166 = new PdfPCell(new Paragraph("", contentFont));
			PdfPCell cell167 = new PdfPCell(new Paragraph("", contentFont));
			PdfPCell cell168 = new PdfPCell(new Paragraph("3175.50", contentFont));
			PdfPCell cell169 = new PdfPCell(new Paragraph("", contentFont));

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
			table.addCell(cell46);
			table.addCell(cell47);
			table.addCell(cell48);
			table.addCell(cell49);
			table.addCell(cell50);
			table.addCell(cell51);
			table.addCell(cell52);

			table.addCell(cell53);
			table.addCell(cell54);
			table.addCell(cell55);
			table.addCell(cell56);
			table.addCell(cell57);
			table.addCell(cell58);
			table.addCell(cell59);
			table.addCell(cell60);
			table.addCell(cell61);
			table.addCell(cell62);
			table.addCell(cell63);
			table.addCell(cell64);
			table.addCell(cell65);

			table.addCell(cell66);
			table.addCell(cell67);
			table.addCell(cell68);
			table.addCell(cell69);
			table.addCell(cell70);
			table.addCell(cell71);
			table.addCell(cell72);
			table.addCell(cell73);
			table.addCell(cell74);
			table.addCell(cell75);
			table.addCell(cell76);
			table.addCell(cell77);
			table.addCell(cell78);
			table.addCell(cell79);

			table.addCell(cell80);
			table.addCell(cell81);
			table.addCell(cell82);
			table.addCell(cell83);
			table.addCell(cell84);
			table.addCell(cell85);
			table.addCell(cell86);
			table.addCell(cell87);
			table.addCell(cell88);
			table.addCell(cell89);
			table.addCell(cell90);
			table.addCell(cell91);
			table.addCell(cell92);

			table.addCell(cell93);
			table.addCell(cell94);
			table.addCell(cell95);
			table.addCell(cell96);
			table.addCell(cell97);
			table.addCell(cell98);
			table.addCell(cell99);
			table.addCell(cell100);
			table.addCell(cell101);
			table.addCell(cell102);
			table.addCell(cell103);
			table.addCell(cell104);
			table.addCell(cell105);

			table.addCell(cell106);
			table.addCell(cell107);
			table.addCell(cell108);
			table.addCell(cell109);
			table.addCell(cell110);
			table.addCell(cell111);
			table.addCell(cell112);
			table.addCell(cell113);
			table.addCell(cell114);
			table.addCell(cell115);
			table.addCell(cell116);
			table.addCell(cell117);
			table.addCell(cell118);

			table.addCell(cell119);
			table.addCell(cell120);
			table.addCell(cell121);
			table.addCell(cell122);
			table.addCell(cell123);
			table.addCell(cell124);
			table.addCell(cell125);
			table.addCell(cell126);
			table.addCell(cell127);
			table.addCell(cell128);
			table.addCell(cell129);
			table.addCell(cell130);
			table.addCell(cell131);

			table.addCell(cell132);
			table.addCell(cell133);
			table.addCell(cell134);
			table.addCell(cell135);
			table.addCell(cell136);
			table.addCell(cell137);
			table.addCell(cell138);
			table.addCell(cell139);
			table.addCell(cell140);
			table.addCell(cell141);
			table.addCell(cell142);
			table.addCell(cell143);
			table.addCell(cell144);

			table.addCell(cell145);
			table.addCell(cell146);
			table.addCell(cell147);
			table.addCell(cell148);
			table.addCell(cell149);
			table.addCell(cell150);
			table.addCell(cell151);
			table.addCell(cell152);
			table.addCell(cell153);
			table.addCell(cell154);
			table.addCell(cell155);
			table.addCell(cell156);
			table.addCell(cell157);

			table.addCell(cell158);
			table.addCell(cell159);
			table.addCell(cell160);
			table.addCell(cell161);
			table.addCell(cell162);
			table.addCell(cell163);
			table.addCell(cell164);
			table.addCell(cell165);
			table.addCell(cell166);
			table.addCell(cell167);
			table.addCell(cell168);
			table.addCell(cell169);

			document.add(table);

			document.close();
			writer.close();

			System.out.println("GUI.Actions.Report Generated");

			File resource = new File("data/StockLevelReport.pdf");

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
