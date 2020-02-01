package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityStepDefs {

    @Given("goto Account Activity link")
    public void goto_Account_Activity_link() {
        AccountActivityPage activityPage= new AccountActivityPage();
        activityPage.accountActivity.click();
    }
    @Then("page should have the title Zero - Account activity")
    public void page_should_have_the_title_Zero_Account_activity() {
        String actualTitle=Driver.get().getTitle();
        Assert.assertEquals("Zero - Account Activity", actualTitle);
    }

    @Then("drop down default option should be {string}")
    public void drop_down_default_option_should_be(String string) {
        AccountActivityPage options= new AccountActivityPage();
        options.repeatOptionsList().getFirstSelectedOption();
    }

    @Then("account drop down should have the following options")
    public void account_drop_down_should_have_the_following_options(List<String> expectedOptions) {
        AccountActivityPage dropDownOptions= new AccountActivityPage();
        List<WebElement> actual=dropDownOptions.repeatOptionsList().getOptions();
        List<String> actualOptions=new ArrayList<>();
        for (WebElement list : actual) {
            actualOptions.add(list.getText());
        }
        Assert.assertEquals(expectedOptions, actualOptions);
    }

    @Then("transactions table should have column names")
    public void transactions_table_should_have_column_names(List<String> expectedColumnNames) {
        AccountActivityPage activityPage=new AccountActivityPage();
        BrowserUtils.waitFor(2);
        List<String>actualColumnNames= BrowserUtils.getElementsText(activityPage.columnNames);
        System.out.println("actualColumnNames = " + actualColumnNames);
        Assert.assertEquals(expectedColumnNames,actualColumnNames);
    }

}
