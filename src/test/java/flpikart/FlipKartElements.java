package flpikart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipKartElements extends BaseClass {
	public FlipKartElements() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement userId;
	@FindBy(xpath = "//input[@type='password']")
	private WebElement password;
	@FindBy(xpath = "//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	private WebElement button;
		
	public WebElement getUserId() {
		return userId;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getButton() {
		return button;
	}
	
	
}
