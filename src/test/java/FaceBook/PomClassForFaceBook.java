package FaceBook;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PomClassForFaceBook extends BaseClass {
	public PomClassForFaceBook() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "email")
	private WebElement userID;
	@FindBy(id="pass")
	private WebElement userPassword;
	@FindBy(xpath="//a[contains(text(),'Create New Account')]")
	private WebElement submit;
	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement firstName;
	@FindBy(xpath = "(//input[@type='text'])[3]")
	private WebElement lastName;
	@FindBy(id = "password_step_input")
	private WebElement createPassword;
	@FindBy(id = "day")
	private WebElement day;
	@FindBy(id = "month")
	private WebElement month;
	@FindBy(id = "year")
	private WebElement year;
	@FindBy(xpath="(//input[@name=\"sex\"])[2]")
	private WebElement male;
	
	public WebElement getUserID() {
		return userID;
	}
	public WebElement getUserPassword() {
		return userPassword;
	}
	public WebElement getSubmit() {
		return submit;
	}
	public WebElement getFirstName() {
		return firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getCreatePassword() {
		return createPassword;
	}
	public WebElement getDay() {
		return day;
	}
	public WebElement getMonth() {
		return month;
	}
	public WebElement getYear() {
		return year;
	}
	public WebElement getMale() {
		return male;
	}

}
