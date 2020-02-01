package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.WeakHashMap;

public class FindTransactionsPage {
    public FindTransactionsPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(xpath = "//*[.='Find Transactions']")
    public WebElement findTransactionsLink;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(xpath = "//*[.='Find']")
    public WebElement findButton;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[1]")
    public List<WebElement> listDates;

    @FindBy(id = "aa_description")
    public WebElement description;

    @FindBy(xpath = "//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[2]")
    public List<WebElement> onlineOrOfline;

    @FindBy(xpath="//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[3]")
    public List<WebElement> deposit;

    @FindBy(xpath="//*[@id='filtered_transactions_for_account']/table/tbody/tr/td[4]")
    public List<WebElement> withdrawal;

    @FindBy(id="aa_type")
    public WebElement typeOptions;

    public Select getSelect(){
        return new Select(typeOptions);
    }
}
