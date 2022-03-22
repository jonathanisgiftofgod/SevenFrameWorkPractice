package flpikart;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class FlipKartPractice extends BaseClass {
	public static WebDriver driver;
	@BeforeClass
	public static void openBrowser() {
	launchUrl("https://www.flipkart.com/account/login");
	}
	@AfterClass
	public static void close() {
		System.out.println("All the best");
	}
	@Before
	public void startTime() {
		Date d = new Date();
		System.out.println("Start Time"+d);
	}
	@After
	public void endTime() {
		Date d = new Date();
		System.out.println("Start Time"+d);
	}
	@Test
	public void tc1() throws InterruptedException, IOException {
		FlipKartElements f = new FlipKartElements();
		enterText(f.getUserId(), readExcel("Sheet1", 0, 0));
		enterText(f.getPassword(), readExcel("Sheet1", 1, 0));
		btnClick(f.getButton());
	}

}
