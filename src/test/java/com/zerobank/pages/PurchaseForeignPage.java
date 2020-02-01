package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PurchaseForeignPage {
    public PurchaseForeignPage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "//a[.='Purchase Foreign Currency']")
    public WebElement purchaseLink;

    @FindBy(id = "pc_currency")
    public WebElement currencyOptions;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateButton;

    @FindBy(id = "pc_amount")
    public WebElement amount;

    public Select getSelect(){
        return new Select(currencyOptions);
    }

}
