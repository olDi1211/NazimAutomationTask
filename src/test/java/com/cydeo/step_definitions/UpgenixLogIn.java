package com.cydeo.step_definitions;

import com.cydeo.pages.UpgenixLogInPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class UpgenixLogIn {

    UpgenixLogInPage upgenixLogInPage = new UpgenixLogInPage();
    @Given("user is on the upgenix log in page")
    public void user_is_on_the_upgenix_log_in_page() {
        Driver.getDriver().navigate().to(ConfigurationReader.getProperty("upgenixURL"));
    }
    @When("user enter {string} and {string}")
    public void user_enter_and(String userName, String userPassword) {
        upgenixLogInPage.emailInput.sendKeys(userName);
        upgenixLogInPage.passwordInput.sendKeys(userPassword);
    }
    @When("click on the log in button")
    public void click_on_the_log_in_button() {
        upgenixLogInPage.logInButton.click();
    }
    @Then("user should be logged")
    public void user_should_be_logged() {
        //BrowserUtils.sleep(3);
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Odoo";

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    @When("user enter invalid userName")
    public void user_enter_invalid_user_name() {
      upgenixLogInPage.emailInput.sendKeys("invalidemail");
      upgenixLogInPage.passwordInput.sendKeys("posmanager");
    }
    @Then("{string} message should be displayed")
    public void message_should_be_displayed(String expectedMessage) {
        String actualMessage = upgenixLogInPage.alertMessage.getText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }

    @When("user enter invalid userPassword")
    public void user_enter_invalid_user_password() {
        upgenixLogInPage.emailInput.sendKeys("posmanager25@info.com");
        upgenixLogInPage.passwordInput.sendKeys("invalidPassword");
    }

    @When("user enter invalid userName and invalid userPassword")
    public void user_enter_invalid_user_name_and_invalid_user_password() {
        upgenixLogInPage.emailInput.sendKeys("invalidName");
        upgenixLogInPage.passwordInput.sendKeys("invalidPassword");
    }

    @When("user enter only userName")
    public void user_enter_only_user_name() {
        upgenixLogInPage.emailInput.sendKeys("posmanager25@info.com");
    }

    @Then("{string} message should be displayed near password")
    public void message_should_be_displayed_near_password(String expected) {
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();

        Boolean is_valid = (Boolean)js.executeScript("return arguments[0].checkValidity();", upgenixLogInPage.passwordInput);
        String message = (String)js.executeScript("return arguments[0].validationMessage;", upgenixLogInPage.passwordInput);
        Assert.assertEquals(expected,message);
    }

    @When("user enter only userPassword")
    public void user_enter_only_user_password() {
        upgenixLogInPage.passwordInput.sendKeys("posmanager");
    }
    @Then("{string} message should be displayed near user name")
    public void message_should_be_displayed_near_user_name(String expected) {
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();

        Boolean is_valid = (Boolean)js.executeScript("return arguments[0].checkValidity();", upgenixLogInPage.emailInput);
        String message = (String)js.executeScript("return arguments[0].validationMessage;", upgenixLogInPage.emailInput);
        Assert.assertEquals(expected,message);
    }


    @When("user enter password")
    public void user_enter_password() {
        upgenixLogInPage.passwordInput.sendKeys("hello");
    }
    @Then("user see the password in bullet signs by default while typing")
    public void user_see_the_password_in_bullet_signs_by_default_while_typing() {
        Assert.assertEquals("password",upgenixLogInPage.passwordInput.getAttribute("type"));
    }


    @When("user enter name and password")
    public void user_enter_name_and_password() {
        upgenixLogInPage.emailInput.sendKeys("posmanager25@info.com");
        upgenixLogInPage.passwordInput.sendKeys("posmanager");
    }
    @When("user push the Enter button")
    public void user_push_the_enter_button() {
        upgenixLogInPage.logInButton.sendKeys(Keys.ENTER);
    }

}
