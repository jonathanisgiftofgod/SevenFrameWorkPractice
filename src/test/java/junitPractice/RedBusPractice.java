package junitPractice;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RedBusPractice {
	public static WebDriver driver;
	@BeforeClass
	public static void launchUrl() {
	WebDriverManager.chromedriver().setup();
	driver =  new ChromeDriver();
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
	public void tc1() throws InterruptedException {
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		driver.findElement(By.id("signin-block")).click();
		driver.findElement(By.id("signInLink")).click();
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println(size);
		Thread.sleep(3000);
		driver.switchTo().frame("iframe2");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//div[@class='mobileInputContainer clearfix contact-box']")).sendKeys("9876543210");
	}
}
