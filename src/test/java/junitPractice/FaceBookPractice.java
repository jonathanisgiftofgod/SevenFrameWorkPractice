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
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookPractice {
	public static WebDriver driver;
	@Test
	public void tc1() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("java");
		driver.findElement(By.id("pass")).sendKeys("java12");
		driver.findElement(By.xpath("//button[@value='1']")).click();
		}
	@BeforeClass
	public static void launch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	@AfterClass
	public static void closeBrowser() {
		System.out.println("All the Best");
	}
	@Before
	public void startTime() {
		Date d = new Date();
		System.out.println(d);
	}
	@After
	public void endTime() {
		Date d = new Date();
		System.out.println(d);
	}
}
