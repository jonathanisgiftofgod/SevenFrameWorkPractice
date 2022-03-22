package adactinjunit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdactinElements extends BaseClass {
	public AdactinElements() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="username")
	private WebElement userid;
	@FindBy(id="password")
	private WebElement pass;
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
	private WebElement dateIn;
	@FindBy(id="datepick_out")
	private WebElement dateout;
	@FindBy(id="adult_room")
	private WebElement adultRoom;
	@FindBy(id="child_room")
	private WebElement child;
	
	@FindBy(id="Submit")
	private WebElement searchHotel;
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
	private WebElement cardNumber;
	@FindBy(id="cc_type")
	private WebElement cardType;
	@FindBy(id="cc_exp_month")
	private WebElement Month;
	@FindBy(id="cc_exp_year")
	private WebElement year;
	@FindBy(id="cc_cvv")
	private WebElement Cvv;
	@FindBy(id="book_now")
	private WebElement BookNow;
	@FindBy(id="order_no")
	private WebElement order;
	
	public WebElement getUserid() {
		return userid;
	}
	public WebElement getPass() {
		return pass;
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
		return dateIn;
	}
	public WebElement getDateout() {
		return dateout;
	}
	public WebElement getAdultRoom() {
		return adultRoom;
	}
	public WebElement getChild() {
		return child;
	}
	
	public WebElement getSearchHotel() {
		return searchHotel;
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
	
	public WebElement getCardNumber() {
		return cardNumber;
	}
	public WebElement getCardType() {
		return cardType;
	}
	public WebElement getMonth() {
		return Month;
	}
	public WebElement getYear() {
		return year;
	}
	public WebElement getCvv() {
		return Cvv;
	}
	public WebElement getBookNow() {
		return BookNow;
	}
	public WebElement getOrder() {
		return order;
	}
}
