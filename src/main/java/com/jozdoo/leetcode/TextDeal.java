package com.jozdoo.leetcode;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/4/20
 * @email jozdoo@gmail.com
 */
public class TextDeal {
    public static void main(String[] args) throws IOException {
        DateTime dateTime =new DateTime();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("//Users/jozdoo/Documents/dailyData/2017-04-20 7000单词本/onlytext.txt"));
        String line = null;
        List<String> list = new ArrayList<>();
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(" ");
            list.add(split[1]);
        }
        int pageSize = 252;
        Workbook wb = new XSSFWorkbook();
        for (int i=0;i<list.size()/pageSize+1;i++){
            Sheet sheet = wb.createSheet(dateTime.plusDays(i).toString("MM-dd"));
            Row rowOne = sheet.createRow(0);
            Cell cell1 = rowOne.createCell(1);
            cell1.setCellValue(dateTime.plusDays(i).toString("MM-dd"));
            Cell cell2 = rowOne.createCell(2);
            cell2.setCellValue(dateTime.plusDays(i+2).toString("MM-dd"));
            Cell cell3 = rowOne.createCell(3);
            cell3.setCellValue(dateTime.plusDays(i+4).toString("MM-dd"));
            Cell cell4 = rowOne.createCell(4);
            cell4.setCellValue(dateTime.plusDays(i+7).toString("MM-dd"));
            Cell cell5 = rowOne.createCell(5);
            cell5.setCellValue(dateTime.plusDays(i+20).toString("MM-dd"));
            for (int j = 0; j < pageSize&&j+pageSize*i<list.size(); j++) {
                int rowLine = j+1;
                Row row = sheet.createRow(rowLine);
                Cell cell = row.createCell(0);
                cell.setCellValue(list.get(i*200+j));
            }
            sheet.autoSizeColumn((short)0);
        }
        ByteArrayOutputStream fileOut = new ByteArrayOutputStream();
        try {
            wb.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }

        byte[] bytes = fileOut.toByteArray();
        Files.write(Paths.get("/Users/jozdoo/Desktop/2.xlsx"),bytes);
    }
}
