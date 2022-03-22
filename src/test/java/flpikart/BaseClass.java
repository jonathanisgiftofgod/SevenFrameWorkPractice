package flpikart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static void launchUrl(String url) {
		WebDriverManager.chromedriver().setup();
		driver =  new ChromeDriver();
		driver.get(url);
	}
	public void enterText(WebElement element, String userDetails) {
		element.sendKeys(userDetails);
	}
	public void btnClick(WebElement element) {
		element.click();
	}
	public String readExcel(String sheet, int row, int column) throws IOException {
		File f = new File("C:\\Users\\Britto\\Desktop\\JAVA\\FlipKartLogin.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(column);
		int cellType = c.getCellType();
		String data = null;
		if (cellType==1) {
			data = c.getStringCellValue();
		} else if(DateUtil.isCellDateFormatted(c)){
			Date d = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
			data = sf.format(d);
		}
		else{
			double numericCellValue = c.getNumericCellValue();
			long l = (long)numericCellValue;
			data = String.valueOf(l);
		}
		return data;
	}
}
