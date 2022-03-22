package OpenOrangeAutomation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageOfMethodClass extends BaseClass{
	public PageOfMethodClass() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="txtUsername")
	private WebElement username;
	@FindBy(id="txtPassword")
	private WebElement password;
	@FindBy(id="btnLogin")
	private WebElement login;
	@FindBy (id="menu_dashboard_index")
	private WebElement dashboard;
	@FindBy (xpath="(//span[@class='quickLinkText'])[1]")
	private WebElement assignLeave;
	@FindBy (id = "assignleave_txtEmployee_empName")
	private WebElement employeeName;
	@FindBy (id="assignleave_txtLeaveType")
	private WebElement leavetype;
	@FindBy (id="assignleave_txtFromDate")
	private WebElement fromDate;
	@FindBy (id="assignleave_txtToDate")
	private WebElement toDate;
	@FindBy (id="assignleave_partialDays")
	private WebElement partialDay;
	@FindBy (id="assignleave_firstDuration_duration")
	private WebElement halfDay;
	@FindBy (id="assignleave_firstDuration_ampm")
	private WebElement time;
	@FindBy (id="assignleave_txtComment")
	private WebElement comment;
	@FindBy (xpath="//label[contains(text(),'Leave Balance')]")
	private WebElement details;
	@FindBy(id="closeButton")
	private WebElement okconfirm;
	@FindBy(id="assignBtn")
	private WebElement assign;
	@FindBy(id="confirmOkButton")
	private WebElement okButton;
	
	public WebElement getUsername() {
		return username;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLogin() {
		return login;
	}
	public WebElement getDashboard() {
		return dashboard;
	}
	public WebElement getAssignLeave() {
		return assignLeave;
	}
	public WebElement getEmployeeName() {
		return employeeName;
	}
	public WebElement getLeavetype() {
		return leavetype;
	}
	public WebElement getFromDate() {
		return fromDate;
	}
	public WebElement getToDate() {
		return toDate;
	}
	public WebElement getPartialDay() {
		return partialDay;
	}
	public WebElement getHalfDay() {
		return halfDay;
	}
	public WebElement getTime() {
		return time;
	}
	public WebElement getComment() {
		return comment;
	}
	public WebElement getDetails() {
		return details;
	}
	public WebElement getOkconfirm() {
		return okconfirm;
	}
	public WebElement getAssign() {
		return assign;
	}
	public WebElement getOkButton() {
		return okButton;
	}
}
