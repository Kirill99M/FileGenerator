package ru.Kirill99m.Creator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import ru.Kirill99m.Model.User;
import ru.Kirill99m.Repository.UserData;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ExcelCreator implements Creation {
    private static XSSFCellStyle createStyleForTitle(XSSFWorkbook workbook) {
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        XSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    @Override
    public void createFile(List<User> users) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Employees sheet");
        int rowNum = 0;
        Cell cell;
        Row row = sheet.createRow(rowNum++);
        XSSFCellStyle style = createStyleForTitle(workbook);
        int i = 0;
        for (String nameOfColumn : namesOfColumns) {
            cell = row.createCell(i++, CellType.STRING);
            cell.setCellValue(nameOfColumn);
            cell.setCellStyle(style);
        }
        for (User user : users) {
            row = sheet.createRow(rowNum++);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(user.getFirstName());
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(user.getLastName());
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(user.getSecondName());
            cell = row.createCell(3, CellType.NUMERIC);
            cell.setCellValue(user.getAge());
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue(user.getGender());
            cell = row.createCell(5, CellType.STRING);
            String text = user.getBirthDate();
            cell.setCellValue((text));
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue(user.getHometown());
            cell = row.createCell(7, CellType.NUMERIC);
            cell.setCellValue(user.getIndex());
            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue(user.getCountry());
            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue(user.getRegion());
            cell = row.createCell(10, CellType.STRING);
            cell.setCellValue(user.getCity());
            cell = row.createCell(11, CellType.STRING);
            cell.setCellValue(user.getStreet());
            cell = row.createCell(12, CellType.NUMERIC);
            cell.setCellValue(user.getHomeNumber());
            cell = row.createCell(13, CellType.NUMERIC);
            cell.setCellValue(user.getFlat());
        }
        try {
            setColumnSize(sheet , namesOfColumns.size());
            File file = new File("ExcelTable.xlsx");
            FileOutputStream outFile = new FileOutputStream(file);
            workbook.write(outFile);
            workbook.close();
            outFile.close();
            System.out.println("Файл создан. Путь: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void setColumnSize(XSSFSheet sheet , int columnNumber){
        for (int j = 0 ; j < columnNumber ; j ++){
            sheet.autoSizeColumn(j);
        }
    }
}
