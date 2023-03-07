package com.pom;

import com.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import  static com.base.BaseClass.logger;

import java.io.IOException;
import java.util.List;

public class AppointmentDetailsPage {
    WebDriver wd;

    BaseClass b;
    public AppointmentDetailsPage(WebDriver d){

        wd = d;
        PageFactory.initElements(d,this);
       b  = new BaseClass();

    }
    @FindBy(xpath= "//input[@name='AppointmentId']")
    private WebElement appointmentId;

    @FindBy(xpath= "//span[text()='INTERPRETER MATCHING']")
    private WebElement tabInterpreterMatching;

    @FindBy(css= ".MuiButtonBase-root.MuiButton-root.MuiButton-outlined.MuiButton-outlinedPrimary.MuiButton-sizeMedium.MuiButton-outlinedSizeMedium.css-1kqzef6")
    private WebElement buttonFindInterpreters;

    @FindBy(xpath= "//table[@class='MuiTable-root css-jiyur0']")
    private WebElement interpreterListTable;


//    @FindBy(xpath= "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 MuiGrid-grid-lg-12 css-1y5l420']//table/tbody")
    @FindBy(xpath= "(//table[@class='MuiTable-root css-jiyur0']/tbody)[2]")
    private WebElement interpreterListTableBody;


    @FindBy(xpath= "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 MuiGrid-grid-lg-12 css-1y5l420']//table//tr/td[6]")
    private WebElement interpreterListTableActionsCol;

    @FindBy(xpath= "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 MuiGrid-grid-lg-12 css-1y5l420']//table//tr/td[1]")
    private WebElement interpreterListTableInterpreterCol;

    @FindBy(xpath= "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-xs-12 MuiGrid-grid-md-12 MuiGrid-grid-lg-12 css-1y5l420']//table//tr/td[2]")
    private WebElement interpreterListTableEmailCol;

    @FindBy(xpath= "//span[text()='make an offer']")
    private WebElement makeAnOffer;

    @FindBy(xpath= "//button[text()='Close']")
    private WebElement close;

    public  WebElement get_appointmentId(){

        return appointmentId;
    }

   public  void clickTabInterpreterMatching(){

        tabInterpreterMatching.click();
    }

    public  void clickButtonFindInterpreters() throws InterruptedException, IOException {


        buttonFindInterpreters.click();
        Thread.sleep(3000);
        logger.addScreenCaptureFromPath(b.takeScreenshotForStep("Find Interpreter"));
    }

    public  WebElement get_interpreterListTableBody(){

        return interpreterListTableBody;
    }

    public  List<WebElement> get_interpreterListTableActionsCol(){

        return  wd.findElements(By.xpath("(//table[@class='MuiTable-root css-jiyur0']/tbody)[2]//tr/td[6]"));

    }

    public  List<WebElement> get_interpreterListTableInterpreterCol(){

        return  wd.findElements(By.xpath("(//table[@class='MuiTable-root css-jiyur0']/tbody)[2]//tr/td[1]"));

    }
    public List<WebElement> get_interpreterListTableEmailCol(){

        return  wd.findElements(By.xpath("(//table[@class='MuiTable-root css-jiyur0']/tbody)[2]//tr/td[2]"));
    }

    public  void clickClose(){

        close.click();
    }


    }



