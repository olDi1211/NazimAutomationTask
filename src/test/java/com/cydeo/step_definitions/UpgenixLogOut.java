package com.cydeo.step_definitions;

import com.cydeo.pages.UpgenixLogOutPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;

public class UpgenixLogOut {

     UpgenixLogOutPage upgenixLogOutPage = new UpgenixLogOutPage();

    @Given("user is logged")
    public void user_is_logged() {
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("upgenixURL"));
        upgenixLogOutPage.emailInput.sendKeys("posmanager25@info.com");
        upgenixLogOutPage.passwordInput.sendKeys("posmanager" + Keys.ENTER);
        BrowserUtils.sleep(2);
    }
    @When("user click on the log out button")
    public void user_click_on_the_log_out_button() {
        upgenixLogOutPage.logOutStep1.click();
        upgenixLogOutPage.logOutStep2.click();
        BrowserUtils.sleep(1);
    }
    @Then("user is again on the upgenix log in page")
    public void user_is_again_on_the_upgenix_log_in_page() {
        String expectedTitle = "Login | Best solution for startups";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @When("user click on the step back button")
    public void user_click_on_the_step_back_button() {
        Driver.getDriver().navigate().back();
        //BrowserUtils.sleep(1);
    }




}
