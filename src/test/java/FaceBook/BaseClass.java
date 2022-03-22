package FaceBook;

import java.io.File;
import java.io.FileInputStream;
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
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public void launchUrl(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
	}
	public void enterText(WebElement element, String userDetails) {
		element.sendKeys(userDetails);
	}
	public String excelRead(String sheet, int row, int column) throws IOException {
		File f = new File("C:\\Users\\Britto\\Desktop\\JAVA\\FaceBookLogin.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(column);
		int cellType = c.getCellType();
		String data = null;
		if (cellType==1) {
			data = c.getStringCellValue();
		}
		else if(DateUtil.isCellDateFormatted(c)) {
			Date dateCellValue = c.getDateCellValue();
			SimpleDateFormat sf = new SimpleDateFormat("dd/MM/YYYY");
			data = sf.format(dateCellValue);
		}
		else {
			double numericCellValue = c.getNumericCellValue();
			long l = (long)numericCellValue;
			data = String.valueOf(l);
		}
		return data;
	}
	public void btnClick(WebElement element) {
		element.click();
	}
	public static void selectOption(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
}
