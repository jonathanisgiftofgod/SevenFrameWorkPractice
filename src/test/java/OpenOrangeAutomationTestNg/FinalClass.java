package OpenOrangeAutomationTestNg;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FinalClass extends BaseClass{
			@BeforeClass
			public void browserLaunch() throws IOException {
				launchUrl("https://opensource-demo.orangehrmlive.com/");
				TakesScreenshot tk = (TakesScreenshot)driver;
				File source = tk.getScreenshotAs(OutputType.FILE);
				File des = new File("C:\\Users\\Britto\\Desktop\\JAVA\\ScreenShot\\OpenOrange\\login.png");
				FileHandler.copy(source, des);
			}
			@Test(priority=1)
			public void login() throws IOException, InterruptedException {
				PageOfMethodClass p = new PageOfMethodClass();
				enterText(p.getUsername(), excelRead("Sheet1", 0, 0));
				enterText(p.getPassword(), excelRead("Sheet1", 1, 0));
				btnClick(p.getLogin());
				
			}
			@Test(priority=2)
			public void assignLeave() throws InterruptedException, IOException, AWTException {
				PageOfMethodClass p = new PageOfMethodClass();
				Thread.sleep(3000);
				btnClick(p.getAssignLeave());
				Thread.sleep(5000);
				enterText(p.getEmployeeName(),excelRead("Sheet4", 0, 0));
				selectById(p.getLeavetype(), 5);
				clearClass(p.getFromDate());
				enterText(p.getFromDate(), excelRead("Sheet4", 1, 0));
				clearClass(p.getToDate());
				enterText(p.getToDate(), excelRead("Sheet4", 2, 0));
				Thread.sleep(3000);
				btnClick(p.getDetails());
				RobotClass();
				selectById(p.getPartialDay(), 1);
				selectById(p.getHalfDay(), 1);
				enterText(p.getComment(), excelRead("Sheet4", 3, 0));
				btnClick(p.getAssign());
				Thread.sleep(5000);
				btnClick(p.getOkButton());

			}
	}

