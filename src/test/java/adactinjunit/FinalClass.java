package adactinjunit;

import static org.testng.Assert.expectThrows;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class FinalClass extends BaseClass{
	public static String orderNum;
	@BeforeClass
	public static void openBrowser() {
		launchUrl("http://adactinhotelapp.com/");
	}
	@AfterClass
	public static void closeBrowser() {
		System.out.println("All the Best");
	}
	@Before
	public void startTime() {
		Date d = new Date();
		System.out.println("Start Time"+d);
	}
	@After
	public void endTime() {
		Date d = new Date();
		System.out.println("End Time"+d);
	}
	@Test
	public void tc1() throws IOException {
		AdactinElements a = new AdactinElements();
		enterText(a.getUserid(), readExcel("Sheet1", 0, 0));
		enterText(a.getPass(), readExcel("Sheet1", 1, 0));
		btnclick(a.getSubmit());
		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File to = new File("C:\\Users\\Britto\\Desktop\\JAVA\\ScreenShot\\login.png");
		FileHandler.copy(source, to);
	}
	@Test
	public void tc2() throws IOException {
		AdactinElements a = new AdactinElements();
		selectById(a.getLocation(), 6);
		selectById(a.getHotel(), 2);
		selectById(a.getRoomType(), 4);
		selectById(a.getRoomNo(), 2);
		clear(a.getDateIn());
		enterText(a.getDateIn(), readExcel("Sheet2", 4, 0));
		clear(a.getDateout());
		enterText(a.getDateout(), readExcel("Sheet2", 5, 0));
		selectById(a.getAdultRoom(), 2);
		selectById(a.getChild(), 1);
		btnclick(a.getSearchHotel());
		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Britto\\Desktop\\JAVA\\ScreenShot\\searchHotel.png");
		FileHandler.copy(source, des);
		btnclick(a.getRadio());
		btnclick(a.getContinues());
	}
	@Test
	public void tc3() throws IOException {
		AdactinElements a = new AdactinElements();
		enterText(a.getFirstName(), readExcel("Sheet3", 0, 0));
		enterText(a.getLastName(), readExcel("Sheet3", 1, 0));
		enterText(a.getAddress(), readExcel("Sheet3", 2, 0));
		enterText(a.getCardNumber(), readExcel("Sheet3", 3, 0));
		selectById(a.getCardType(), 2);
		selectById(a.getMonth(), 10);
		selectById(a.getYear(), 11);
		enterText(a.getCvv(), readExcel("Sheet3", 7, 0));
		btnclick(a.getBookNow());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		TakesScreenshot tk = (TakesScreenshot) driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File des = new File("C:\\Users\\Britto\\Desktop\\JAVA\\Book.png");
		FileHandler.copy(source, des);
	}
	@Test
	public void tc4() throws IOException {
		orderNum = orderNum("order_no"); 
		writeExcel(0, 0, orderNum);
	}
}
