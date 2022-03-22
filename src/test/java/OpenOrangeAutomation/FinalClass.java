package OpenOrangeAutomation;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FinalClass extends BaseClass{
	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		
		launchUrl("https://opensource-demo.orangehrmlive.com/");
		PageOfMethodClass p = new PageOfMethodClass();
		enterText(p.getUsername(), excelRead("Sheet1", 0, 0));
		enterText(p.getPassword(), excelRead("Sheet1", 1, 0));
		btnClick(p.getLogin());
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
		Thread.sleep(3000);
		btnClick(p.getOkButton());
	}
}
