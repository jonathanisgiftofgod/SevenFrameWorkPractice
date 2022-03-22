package adactin;
import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgForAdactin extends BaseClass {
	public static AdactinElements a;
	public static String orderNum;
	@BeforeClass
	public void browserLaunch() {
		launchUrl("http://adactinhotelapp.com/");
	}
	@BeforeMethod
	public void startTime() {
		Date d = new Date();
		System.out.println("Start Time" + d);
	}
	@AfterMethod
	public void endTime() {
		Date d = new Date();
		System.out.println("End Time" + d);
	}
	
	@Test(priority = 1)
	public void loginPage() throws IOException {
		a = new AdactinElements();
		enterText(a.getUserId(), readExcel("Sheet1", 0, 0));
		enterText(a.getPassword(), readExcel("Sheet1", 1, 0));
		btnClick(a.getSubmit());
	}
	@Test(priority = 2)
	public void searchHotel() throws IOException {
		selectById(a.getLocation(), Integer.parseInt(readExcel("Sheet2", 0, 0)));
		selectById(a.getHotel(), Integer.parseInt(readExcel("Sheet2", 1, 0)));
		selectById(a.getRoomType(), Integer.parseInt(readExcel("Sheet2", 2, 0)));
		selectById(a.getRoomNo(), Integer.parseInt(readExcel("Sheet2", 3, 0)));
		clear(a.getDateIn());
		enterText(a.getDateIn(), readExcel("Sheet2", 4, 0));
		clear(a.getDateOut());
		enterText(a.getDateOut(), readExcel("Sheet2", 5, 0));
		selectById(a.getAdult(), Integer.parseInt(readExcel("Sheet2", 6, 0)));
		selectById(a.getChild(), Integer.parseInt(readExcel("Sheet2", 7, 0)));
		btnClick(a.getSearch());
	}
	@Test(priority = 3)
	public void selectHotel() {
		btnClick(a.getRadio());
		btnClick(a.getContinues());
	}
	@Test(priority =4)
	public void bookHotel() throws IOException, InterruptedException {
		enterText(a.getFirstName(), readExcel("Sheet3", 0, 0));
		enterText(a.getLastName(), readExcel("Sheet3", 1, 0));
		enterText(a.getAddress(), readExcel("Sheet3", 2, 0));
		enterText(a.getCcNum(), readExcel("Sheet3", 3, 0));
		selectById(a.getCcType(), Integer.parseInt(readExcel("Sheet3", 4, 0)));
		selectById(a.getMonth(),Integer.parseInt(readExcel("Sheet3", 5, 0)));
		selectById(a.getYear(), Integer.parseInt(readExcel("Sheet3", 6, 0)));
		enterText(a.getCvv(), readExcel("Sheet3", 7, 0));
		btnClick(a.getBookNow());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
//		2. WebDriverWait wait = new WebDriverWait(driver, 20);
//		wait.until(ExpectedConditions.urlToBe("http://adactinhotelapp.com/BookingConfirm.php"));
//		3. Wait <WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(2, TimeUnit.SECONDS)
//							.pollingEvery(30, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
//		wait.until(new Function<WebDriver, WebElement >(){
//			public WebElement apply(WebDriver driver) {
//				return driver.findElement(By.id("order_no"));
//			}

	}
	@Test(priority =5)
	public void takesScreenShot() throws AWTException, IOException {
		Robot r = new Robot();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle rect = new Rectangle(screenSize);
		BufferedImage source = r.createScreenCapture(rect);
		File destination = new File("C:\\Users\\Britto\\Desktop\\JAVA\\robotscreenshot.png");
		ImageIO.write(source, "png", destination);
	}

	@AfterClass

	public static void order() throws IOException {
		orderNum  = orderNum("order_no");
		writeExcel(0, 0, orderNum);
	}

}
 