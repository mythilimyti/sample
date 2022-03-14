package org.framework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.apache.poi.hpsf.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelData {

		public static void main(String[] args) throws IOException {
			
			File file = new File ("C:\\Users\\KRISH\\eclipse-workspace\\Maven\\StudentDetails\\StudentDetails.xlsx");
			FileInputStream stream = new FileInputStream (file);
			Workbook workbook = new XSSFWorkbook (stream);
			Sheet sheet = workbook.getSheet("Data");
			Row row = sheet.getRow(10);		
			Cell cell = row.getCell(1);
			System.out.println(cell);
			CellType type = cell.getCellType();
			switch(type) {
			case STRING:
				String stringcallvalues = cell.getStringCellValue();
				System.out.println(stringcallvalues);
				break;
			case NUMERIC:
				double d = cell.getNumericCellValue();
				BigDecimal b = BigDecimal.valueOf(d);
				String number = b.toString();
				System.out.println(number);
				break;
			}
			if(DateUtil.isCellDateFormatted(cell)) {
			Date date =new Date();
			SimpleDateFormat dateFormate = new SimpleDateFormat("DD/MM/YYYY");
			String format = dateFormate.format(date);
			System.out.println(format);
			}
			else {
				double d = cell.getNumericCellValue();
				BigDecimal b = BigDecimal.valueOf(d);
				String number = b.toString();
				System.out.println(number);
			}
				
			
		}}
	
