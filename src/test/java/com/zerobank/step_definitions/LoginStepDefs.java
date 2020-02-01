package com.zerobank.step_definitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {
    @Given("users should be able to login to the application")
    public void users_should_be_able_to_login_to_the_application() {
        System.out.println("Connecting to the Zero Bank Website");
        Driver.get().get(ConfigurationReader.get("url"));
        BrowserUtils.waitFor(2);
    }

    @And("user logs in with valid credentials")
    public void user_logs_in_with_valid_credentials() {
       LoginPage loginPage=new LoginPage();
       String username=ConfigurationReader.get("username");
       String password=ConfigurationReader.get("password");
       loginPage.login(username,password);
    }

    @Then("Account summary page should display")
    public void account_summary_page_should_display() {
        String expectedTitle="Zero - Account Summary";
        String actualTitle=Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        System.out.println(expectedTitle);
    }

    @When("users with wrong {string} and {string} should not be able to login")
    public void users_with_wrong_and_should_not_be_able_to_login(String username, String password) {
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
    }

    @Then("error message should displayed")
    public void error_message_should_displayed() {
        LoginPage loginPage=new LoginPage();
        Assert.assertTrue(loginPage.errorMessage.getText().contains("Login and/or password are wrong."));
    }
}
