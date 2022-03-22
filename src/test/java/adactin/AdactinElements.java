package adactin;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinElements extends BaseClass {
	public AdactinElements() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='username']")
	private WebElement userId;
	@FindBy(xpath="//input[@name='password']")
	private WebElement password;
	@FindBy(id="login")
	private WebElement submit;
	@FindBy(id="location")
	private WebElement location;
	@FindBy(id="hotels")
	private WebElement hotel;
	@FindBy(id="room_type")
	private WebElement roomType;
	@FindBy(id="room_nos")
	private WebElement roomNo;
	@FindBy(id="datepick_in")
	private WebElement DateIn;
	@FindBy(id="datepick_out")
	private WebElement DateOut;
	@FindBy(id="adult_room")
	private WebElement Adult;
	@FindBy(id="child_room")
	private WebElement Child;
	@FindBy(id="Submit")
	private WebElement search;
	@FindBy(id="radiobutton_0")
	private WebElement radio;
	@FindBy(id="continue")
	private WebElement continues;
	@FindBy(id="first_name")
	private WebElement firstName;
	@FindBy(id="last_name")
	private WebElement lastName;
	@FindBy(id="address")
	private WebElement Address;
	@FindBy(id="cc_num")
	private WebElement ccNum;
	@FindBy(id="cc_type")
	private WebElement ccType;
	
	@FindBy(id="cc_exp_month")
	private WebElement month;
	@FindBy(id="cc_exp_year")
	private WebElement year;
	@FindBy(id="cc_cvv")
	private WebElement cvv;
	@FindBy(id="book_now")
	private WebElement bookNow;
	@FindBy(id="order_no")
	private WebElement order_no;
	
	public WebElement getUserId() {
		return userId;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getSubmit() {
		return submit;
	}
	public WebElement getLocation() {
		return location;
	}
	
	public WebElement getHotel() {
		return hotel;
	}
	public WebElement getRoomType() {
		return roomType;
	}
	public WebElement getRoomNo() {
		return roomNo;
	}

	public WebElement getDateIn() {
		return DateIn;
	}
	public WebElement getDateOut() {
		return DateOut;
	}
	public WebElement getAdult() {
		return Adult;
	}
	public WebElement getChild() {
		return Child;
	}
	public WebElement getSearch() {
		return search;
	}
	public WebElement getRadio() {
		return radio;
	}
	public WebElement getContinues() {
		return continues;
	}

	public WebElement getFirstName() {
		return firstName;
	}
	public WebElement getLastName() {
		return lastName;
	}
	public WebElement getAddress() {
		return Address;
	}
	public WebElement getCcNum() {
		return ccNum;
	}
	public WebElement getCcType() {
		return ccType;
	}
	
	public WebElement getMonth() {
		return month;
	}
	public WebElement getYear() {
		return year;
	}
	public WebElement getCvv() {
		return cvv;
	}
	public WebElement getBookNow() {
		return bookNow;
	}
	public WebElement getOrder_no() {
		return order_no;
	}
}
