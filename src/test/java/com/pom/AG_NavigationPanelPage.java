package com.pom;

import com.base.BaseClass;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AG_NavigationPanelPage {

    WebDriver wd;

    public AG_NavigationPanelPage(WebDriver d){

        wd = d;
        PageFactory.initElements(d,this);

    }
//    @FindBy(xpath= "//a[@href='/interpreters/interpreters']")
    @FindBy(xpath= "//div/*[text()='Interpreters']/..")
    private WebElement interpreters;

    @FindBy(xpath= "//a[@href='/interpreter/interpreter-home']")
    private WebElement Home_Interpreter;

    public void click_Home_Interpreter(){

        Home_Interpreter.click();
    }

    public void click_Interpreters() throws InterruptedException {
        Thread.sleep(3000);
        boolean b = BaseClass.isElementPresent(interpreters);
     //   BaseClass.goToElementVisibleArea(interpreters);
        WebElement el = new BaseClass().getElementByXpath(wd,"//div/*[text()='Interpreters']/../preceding-sibling::div");
        BaseClass.clickWithJavaScript(el);
        Thread.sleep(3000);

    }




}
