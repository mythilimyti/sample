package org.framework;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Skills {
	
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		WebElement element = driver.findElement(By.id("Skills"));
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		File file = new File ("C:\\Users\\KRISH\\eclipse-workspace\\Maven\\StudentDetails\\AutomationTesting-Skills-Fetching.xlsx");
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Skills");
		for(int i=0; i<options.size(); i++) {
		Row row = sheet.createRow(i);
		Cell cell = row.createCell(0);
		WebElement element2 = options.get(i);
		String text = element2.getText();
		System.out.println(text);
		
		cell.setCellValue(text);
		}
		FileOutputStream outputstream = new FileOutputStream(file);
		workbook.write(outputstream);
	}

}
