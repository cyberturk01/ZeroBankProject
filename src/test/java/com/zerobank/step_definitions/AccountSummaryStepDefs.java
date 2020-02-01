package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class AccountSummaryStepDefs {
    @Then("page should have the title Zero - Account summary")
    public void page_should_have_the_title_Zero_Account_summary() {
        String expectedTitle="Zero - Account Summary";
        String actualTitle=Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        System.out.println("expectedTitle = " + expectedTitle);
    }


    @Then("page should have the titles")
    public void page_should_have_the_titles(List<String> expectedtitles) {
        System.out.println("titles = " + expectedtitles);
        AccountSummaryPage title=new AccountSummaryPage();
        List<String>actualTitles= BrowserUtils.getElementsText(title.accountTypes);
        Assert.assertEquals(expectedtitles, actualTitles);
    }

    @Then("credit accounts should  have columns")
    public void credit_accounts_should_have_columns(List<String> expectedTable) {
        System.out.println("expectedTable = " + expectedTable);
        AccountSummaryPage table=new AccountSummaryPage();
        List<String>actualTable=BrowserUtils.getElementsText(table.tableElements);
        Assert.assertEquals(expectedTable,actualTable);
    }

    @Given("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String options) {
            Driver.get().findElement(By.xpath("//a[.='"+options+"']")).click();
    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        String expectedTitle="Zero - Account Activity";
        String actualTitle=Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String type) {
        AccountActivityPage activityPage=new AccountActivityPage();
        String actualType=activityPage.repeatOptionsList().getFirstSelectedOption().getText();
        String expectedType=type;
        Assert.assertEquals(expectedType,actualType);
    }


}
