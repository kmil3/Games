package sample;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.collections.ObservableList;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class EscrevePDF {

    public static void escrever_pdf(ObservableList<Games> listajogos) {
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(
                    "Games.pdf"));
            document.open();

            PdfPTable table = new PdfPTable(4); // 3 columns.
            table.setWidthPercentage(100); //Width 100%
            table.setSpacingBefore(10f); //Space before table
            table.setSpacingAfter(10f); //Space after table

            //Set Column widths
            float[] columnWidths = {1f, 1f, 1f, 1f};
            table.setWidths(columnWidths);


            for (Games z : listajogos) {
                PdfPCell cell1 = new PdfPCell(new Paragraph("Nome"));
                cell1.setBorderColor(BaseColor.BLUE);
                cell1.setPaddingLeft(10);
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell2 = new PdfPCell(new Paragraph("Gênero"));
                cell2.setBorderColor(BaseColor.GREEN);
                cell2.setPaddingLeft(10);
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell3 = new PdfPCell(new Paragraph("Desenvolvedor"));
                cell3.setBorderColor(BaseColor.RED);
                cell3.setPaddingLeft(10);
                cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);

                PdfPCell cell4 = new PdfPCell(new Paragraph("Ano"));
                cell4.setBorderColor(BaseColor.BLACK);
                cell4.setPaddingLeft(10);
                cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);

                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);
                for (Games a : z.listajogos) {
                    cell1.addElement(new Phrase(a.getNome()));
                    cell2.addElement(new Phrase(a.getGenero()));
                    cell3.addElement(new Phrase(a.getDesenvolvedor()));
                    cell4.addElement(new Phrase(a.getAno()));
                    table.addCell(cell1);
                    table.addCell(cell2);
                    table.addCell(cell3);
                    table.addCell(cell4);
                }
                document.add(table);

            }
                writer.close();
                document.close();
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
