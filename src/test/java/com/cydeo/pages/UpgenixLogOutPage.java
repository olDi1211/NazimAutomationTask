package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpgenixLogOutPage extends UpgenixLogInPage{

    public UpgenixLogOutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement logOutStep1;

    @FindBy(xpath = "//a[@data-menu='logout']")
    public WebElement logOutStep2;


}
