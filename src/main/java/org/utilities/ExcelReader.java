package org.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    public static  Object[][] getDataFromExcel() throws IOException {

        FileInputStream file = new FileInputStream("C:\\Users\\Akansha Singh\\Downloads\\ck-project\\SeleniumCode\\src\\test\\resources\\~$dataProv.xlsx");

        Workbook workbook = new XSSFWorkbook(file);

        Sheet sheet = workbook.getSheet("sheet1");

        int rowCount = sheet.getPhysicalNumberOfRows();
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rowCount-1][colCount];

        for(int i=1;i<rowCount;i++){
            Row row = sheet.getRow(i);

            for(int j=0;j<colCount;j++){
                Cell cell = row.getCell(j);
                if(cell != null){
                    data[i-1][j] = getCellValue(cell);
                }
            }
        }
        workbook.close();
        file.close();
        return data;
    }

    private static String getCellValue(Cell cell){
        switch(cell.getCellType()){
            case STRING:
                return cell.getStringCellValue();

            case NUMERIC:
                return String.valueOf((int)cell.getNumericCellValue());

            case BOOLEAN:
                return String.valueOf((cell.getBooleanCellValue()));

            default:
                return "";


        }
    }
}
