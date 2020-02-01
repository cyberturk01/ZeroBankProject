package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class NewPayeeStepDefs {
    @Given("Add new Payee tab")
    public void add_new_Payee_tab() {
        PayBillPage payBillPage=new PayBillPage();
        Driver.get().manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        payBillPage.payBillLink.click();
        payBillPage.addNewPayee.click();
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> dataTable) {
        PayBillPage payBillPage=new PayBillPage();
        payBillPage.newPayeeNameInput.sendKeys(dataTable.get("Payee Name"));
        payBillPage.newPayeeAddressInput.sendKeys(dataTable.get("Payee Address"));
        payBillPage.newPayeeAccountInput.sendKeys(dataTable.get("Account"));
        payBillPage.newPayeeDetailsInput.sendKeys(dataTable.get("Payee details"));
        payBillPage.addPayeeButton.click();
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String expectedMessage) {
        String actualMessage=new PayBillPage().actualMessage.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }



}
