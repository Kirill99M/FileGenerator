package ru.Kirill99m.Creator;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import ru.Kirill99m.Model.User;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class PdfCreator implements Creation {
    private static Font font;

    public PdfCreator() {
        BaseFont workingFont = null;
        try {
            workingFont = BaseFont.createFont("arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        font = new Font(workingFont);
    }

    @Override
    public void createFile(List<User> users) {
        try {
            Document pdfDocument = new Document();
            PdfWriter.getInstance(pdfDocument, new FileOutputStream("PdfTable.pdf"));
            pdfDocument.setPageSize(new Rectangle(1640, 1000));
            File pdfFile = new File("Pdftable.pdf");
            pdfDocument.open();
            PdfPTable table = new PdfPTable(namesOfColumns.size());
            addTableHeader(table);
            for (User user : users) {
                addRows(table, user);
            }
            pdfDocument.add(table);
            pdfDocument.close();
            System.out.println("Pdf файл создан. Путь: " + pdfFile.getAbsolutePath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    private static void addTableHeader(PdfPTable table) {
        Stream.of("Имя", "Фамилия", "Отчество", "Возраст", "пол", "дата рождения", "Родной город", "почтовый индекс", "страна",
                "область", "город", "улица", "дом", "квартира")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(2);
                    header.setPhrase(new Phrase(columnTitle, font));
                    table.addCell(header);
                });
    }

    private static void addRows(PdfPTable table, User user) {

        table.addCell(new Phrase(user.getFirstName(), font));
        table.addCell(new Phrase(user.getLastName(), font));
        table.addCell(new Phrase(user.getSecondName(), font));
        table.addCell(new Phrase(Integer.toString(user.getAge()), font));
        table.addCell(new Phrase(user.getGender(), font));
        table.addCell(new Phrase(user.getBirthDate(), font));
        table.addCell(new Phrase(user.getHometown(), font));
        table.addCell(new Phrase(Integer.toString(user.getIndex()), font));
        table.addCell(new Phrase(user.getCountry(), font));
        table.addCell(new Phrase(user.getRegion(), font));
        table.addCell(new Phrase(user.getCity(), font));
        table.addCell(new Phrase(user.getStreet(), font));
        table.addCell(new Phrase(Integer.toString(user.getHomeNumber()), font));
        table.addCell(new Phrase(Integer.toString(user.getFlat()), font));
    }
}
