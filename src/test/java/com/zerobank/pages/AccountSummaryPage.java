package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.ArrayList;
import java.util.List;

public class AccountSummaryPage {
    public AccountSummaryPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy (xpath = "//h2")
    public List<WebElement> accountTypes;

    @FindBy (xpath = "//div[3]/div/table/thead/tr/th ")
    public List<WebElement> tableElements;

    @FindBy(xpath = "(//*[.='Savings'])[1]")
    public WebElement savingsLink;

    @FindBy(xpath = "//*[.='Brokerage']")
    public WebElement brokerageLink;

    @FindBy(xpath = "//*[.='Checking']")
    public WebElement checkingLink;

    @FindBy(xpath = "//*[.='Credit Card']")
    public WebElement credit_cardLink;

    @FindBy(xpath = "//*[.='Loan']")
    public WebElement loanLink;
}
