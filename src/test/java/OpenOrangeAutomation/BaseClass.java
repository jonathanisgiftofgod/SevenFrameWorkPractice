package OpenOrangeAutomation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;
	public static void launchUrl(String url) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get(url);
	}
	public static void enterText(WebElement id, String text) {
		id.sendKeys(text);
	}
	public static void btnClick(WebElement id) {
		id.click();
	}
	public static void selectById(WebElement id,int index) {
		Select s = new Select(id);
		s.selectByIndex(index);
	}
	public static void clearClass(WebElement id) {
		id.clear();
	}
	public static void RobotClass() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.keyRelease(KeyEvent.VK_ESCAPE);
	}
	public static String excelRead(String sheet, int row, int cloumn) throws IOException {
		File f = new File("C:\\Users\\Britto\\Desktop\\JAVA\\OpenOrange.xlsx");
		FileInputStream fi = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fi);
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cloumn);
		int cellType = c.getCellType();
		String value = null;
		if (cellType==1) {
			value = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)){
			Date dateCellValue = c.getDateCellValue();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
			value = sf.format(dateCellValue);
		}
		else {
			double numericCellValue = c.getNumericCellValue();
			long l = (long) numericCellValue;
			value = String.valueOf(l);
		}
		return value;
	}
}
