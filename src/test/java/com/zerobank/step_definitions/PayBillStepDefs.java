package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PayBillStepDefs {
    @Then("goto Account PayBill link")
    public void goto_Account_PayBill_link() {
        PayBillPage billPage = new PayBillPage();
        billPage.payBillLink.click();
    }

    @Given("page should have the title Zero - Pay Bills")
    public void page_should_have_the_title_Zero_Pay_Bills() {
        String expectedTitle = "Zero - Pay Bills";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Given("user inputs some amount in to Amount field {string}")
    public void user_inputs_some_amount_in_to_Amount_field(String amount) {
        new PayBillPage().amount.sendKeys(amount);
    }

    @When("select a date for the Date field {string}")
    public void select_a_date_for_the_Date_field(String date) {
        new PayBillPage().date.sendKeys(date);
        new PayBillPage().payButton.click();
    }

    @Then("message The payment was successfully submitted should be displayed.")
    public void message_The_payment_was_successfully_submitted_shown_in_the_page() {
        String expectedMessage = "The payment was successfully submitted.";
        String actualMessage = new PayBillPage().message.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Then("message Please fill out this field message should be displayed in the Amount field")
    public void message_Please_fill_out_this_field_message_should_be_displayed() {
        String expectedMessage = "Please fill out this field.";
        String actualMessage = new PayBillPage().amount.getAttribute("validationMessage");
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Then("message Please fill out this field message should be displayed in the Date field")
    public void message_Please_fill_out_this_field_message_should_be_displayed_in_the_Date_field() {
        String expectedMessage = "Please fill out this field.";
        String actualMessage = new PayBillPage().date.getAttribute("validationMessage");
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Given("amount field should not accept alphabetical or special characters.")
    public void amount_field_should_not_accept_alphabetical_or_special_characters() {
        PayBillPage billPage = new PayBillPage();
        billPage.amount.sendKeys("123");
        BrowserUtils.waitFor(2);
        boolean flag;
        String actualMessage = billPage.amount.getAttribute("value");
        if(Character.isDigit(Integer.parseInt(actualMessage))){
            Assert.assertTrue(flag=true);
        }else{
            Assert.assertTrue(flag=false);
        }
    }

    @Given("date field should not accept alphabetical characters.")
    public void date_field_should_not_accept_alphabetical_characters() {
        PayBillPage billPage = new PayBillPage();
        billPage.date.sendKeys("ALPHA");
        String actualMessage = billPage.amount.getAttribute("value");
        int count=actualMessage.length();
        boolean flag;
        if(count==0){
            Assert.assertTrue(flag=true);
        }else{
            Assert.assertTrue(flag=false);
        }
    }
}
