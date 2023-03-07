package com.tests;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.aventstack.extentreports.Status;
import com.pom.DashBoardPage;
import com.utils.CommonUtils;
import com.utils.DashBoardHeaders;
import com.utils.ExcelUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.base.BaseClass;
import com.pom.LoginPage;
import com.pom.NewAppointmentPage;

@Listeners({com.listeners.ListenerTest.class})
public class SetAppointmentTest extends BaseClass
{



	@Test
	public void cancelNewAppointment() throws Throwable
	{
		//driver=openBrowser();
		//driver.manage().window().maximize();
		driver.get("http://uat.ims.client.sstech.us/login");
		logger = extent.createTest(BaseClass.getMethodName() + "method started");

		LoginPage lo = new LoginPage(driver);
		lo.doLogin(datasheet.get("UserName"), datasheet.get("Password"));

		NewAppointmentPage nap = new NewAppointmentPage(driver);

		logger.addScreenCaptureFromPath(takeScreenshotForStep("Appointments table"));
		nap.cancelAppointment();
		logger.addScreenCaptureFromPath(takeScreenshotForStep("Canceled the appointment"));
		lo.click_logOut();
	}



	@AfterMethod
	public void captureResult(ITestResult result) throws IOException {

		String methodName = BaseClass.getMethodName();
		logger.log(Status.PASS, "Method completed");
		logger.addScreenCaptureFromPath(takeScreenshotForStep("End of " + methodName));
		try{
			Thread.sleep(3000);

		}catch (Exception e){
			e.printStackTrace();
		}
	}



}
