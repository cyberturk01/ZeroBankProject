package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillPage;
import com.zerobank.pages.PurchaseForeignPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PurchaseForeignCurrencyStepDefs {
    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        PurchaseForeignPage foreignPage=new PurchaseForeignPage();
        new PayBillPage().payBillLink.click();
        foreignPage.purchaseLink.click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {
        PurchaseForeignPage foreignPage=new PurchaseForeignPage();
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        List<WebElement> Options=foreignPage.getSelect().getOptions();
        List<String> expected= BrowserUtils.getElementsText(Options);
        boolean flag=false;

        for (int i = 0; i <expected.size() ; i++) {
            for (int j = 0; j <dataTable.size() ; j++) {
                if(expected.get(i).equals(dataTable.get(j))){
                    flag=true;
                }
            }
        }
        Assert.assertTrue(flag);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        Driver.get().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        PurchaseForeignPage foreignPage=new PurchaseForeignPage();
        foreignPage.amount.sendKeys("123");
        foreignPage.calculateButton.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        String expectedMessage="Please, ensure that you have filled all the required fields with valid values.";
        String actualMessage=Driver.get().switchTo().alert().getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        Driver.get().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        PurchaseForeignPage foreignPage=new PurchaseForeignPage();
        foreignPage.getSelect().selectByIndex(2);
        foreignPage.calculateButton.click();
    }

}
