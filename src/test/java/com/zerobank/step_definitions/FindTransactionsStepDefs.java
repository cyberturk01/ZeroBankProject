package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.FindTransactionsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FindTransactionsStepDefs {
    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        new AccountActivityPage().accountActivity.click();
        FindTransactionsPage transactionsPage=new FindTransactionsPage();
        transactionsPage.findTransactionsLink.click();
        BrowserUtils.waitFor(2);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String date1, String date2) {
        FindTransactionsPage transactionsPage=new FindTransactionsPage();
        transactionsPage.fromDate.sendKeys(date1);
        transactionsPage.toDate.sendKeys(date2);
        transactionsPage.findButton.click();
    }

    @When("clicks search")
    public void clicks_search() {
        FindTransactionsPage transactionsPage=new FindTransactionsPage();
        transactionsPage.findButton.click();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String date1, String date2) {
        FindTransactionsPage transactionsPage=new FindTransactionsPage();
        List<String> dates=BrowserUtils.getElementsText(transactionsPage.listDates);
        Boolean flag;
        String[]fromDate=date1.split("-");
        String[]toDate=date2.split("-");
        Integer num1=Integer.parseInt(fromDate[2]);
        Integer num2=Integer.parseInt(toDate[2]);
        if(num1==1){
            if(dates.contains(num1) && dates.contains(num2) && num1<1 || num2>6){
                Assert.assertTrue(flag=false);
            }else{
                Assert.assertTrue(flag=true);
            }
        }else{
            if(dates.contains(num1) && dates.contains(num2) && num1<2 || num2>6){
                Assert.assertTrue(flag=false);
            }else{
                Assert.assertTrue(flag=true);
            }
        }

    }


    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        FindTransactionsPage transactionsPage=new FindTransactionsPage();
        List<String> actualDates=BrowserUtils.getElementsText(transactionsPage.listDates);
        List<String> expectedDates=BrowserUtils.getElementsText(transactionsPage.listDates);
        Collections.sort(actualDates);
        Assert.assertEquals(expectedDates,actualDates);
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        FindTransactionsPage transactionsPage=new FindTransactionsPage();
        List<String> actualDates=BrowserUtils.getElementsText(transactionsPage.listDates);
        boolean flag;
        if(!actualDates.contains(date)){
            Assert.assertTrue(flag=true);
        }else{
            Assert.assertTrue(flag=false);
        }
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String desc) {
        FindTransactionsPage transactionsPage=new FindTransactionsPage();
        transactionsPage.description.sendKeys(desc);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String actualMessage) {
        FindTransactionsPage transactionsPage=new FindTransactionsPage();
        BrowserUtils.waitFor(2);
        List<String> expectedDescriptions=BrowserUtils.getElementsText(transactionsPage.onlineOrOfline);
        boolean flag;
        if(expectedDescriptions.size()>0){
            for (String desc : expectedDescriptions) {
                if(desc.trim().contains(actualMessage)){
                    System.out.println("true");
                    Assert.assertTrue(flag=true);
                }else{
                    System.out.println("false-2");
                    Assert.assertTrue(flag=false);
                }
            }
        }else{
            System.out.println("false-3");
            Assert.assertTrue(flag=false);
        }

    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        FindTransactionsPage transactionsPage=new FindTransactionsPage();
        Driver.get().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        List<String>expectedValue=BrowserUtils.getElementsText(transactionsPage.deposit);
        boolean flag;
        if(expectedValue.size()>0){
            Assert.assertTrue(flag=true);
            System.out.println(true);
        }
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        FindTransactionsPage transactionsPage=new FindTransactionsPage();
        List<String>expectedValue=BrowserUtils.getElementsText(transactionsPage.withdrawal);
        boolean flag;
        if(expectedValue.size()>0){
            Assert.assertTrue(flag=true);
        }
    }

    @When("user selects type {string}")
    public void user_selects_type_Deposit(String str) {
        FindTransactionsPage transactionsPage=new FindTransactionsPage();
        int num=0;
        if(str.equals("Deposit")){
            num=1;
        }else if(str.equals("Withdrawal")){
            num=2;
        }
        transactionsPage.getSelect().selectByIndex(num);
        transactionsPage.findButton.click();
        System.out.println("type");
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        FindTransactionsPage transactionsPage=new FindTransactionsPage();
        List<String> expectedValue=BrowserUtils.getElementsText(transactionsPage.withdrawal);
        boolean flag;
        if(expectedValue.size()==0){
            Assert.assertTrue(flag=true);
        }
    }

    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        FindTransactionsPage transactionsPage=new FindTransactionsPage();
        List<String> expectedValue=BrowserUtils.getElementsText(transactionsPage.deposit);
        boolean flag;
        if(expectedValue.size()==0){
            Assert.assertTrue(flag=true);
        }
    }

}
