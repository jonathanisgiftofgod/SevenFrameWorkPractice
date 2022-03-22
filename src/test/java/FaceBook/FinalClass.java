package FaceBook;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FinalClass extends BaseClass {
	@BeforeClass
	public void BrowserOpen() {
		launchUrl("https://www.facebook.com/");
	}
	@BeforeMethod
	public void startDate() {
		Date d = new Date();
		System.out.println("Start Time"+d);
	}
	@AfterMethod
	public void endDate() {
		Date d = new Date();
		System.out.println("End Time"+d);
	}
	@Test(priority=1)
	public void login() throws IOException, InterruptedException {
		PomClassForFaceBook p = new PomClassForFaceBook();
		enterText(p.getUserID(), excelRead("Sheet1", 0, 0));
		enterText(p.getUserPassword(), excelRead("Sheet1",1,0));
		btnClick(p.getSubmit());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@Test(priority=2)
	public void createNewAccount() throws IOException {
		PomClassForFaceBook p = new PomClassForFaceBook();
		enterText(p.getFirstName(), excelRead("Sheet2", 0, 0));
		enterText(p.getLastName(), excelRead("Sheet2", 1, 0));
		enterText(p.getCreatePassword(), excelRead("Sheet2",2,0));
		selectOption(p.getDay(), 19);
		selectOption(p.getMonth(), 4);
		selectOption(p.getYear(), 9);
		btnClick(p.getMale());
	}
	@BeforeClass
	public void BrowserClose() {
		System.out.println("All the Best");
	}
}
