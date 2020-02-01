package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayBillPage {
    public PayBillPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//a[.='Pay Bills']")
    public WebElement payBillLink;

    @FindBy(id = "sp_amount")
    public WebElement amount;

    @FindBy(id = "sp_date")
    public WebElement date;

    @FindBy(id = "pay_saved_payees")
    public WebElement payButton;

    @FindBy(xpath = "(//*[contains(text(),'successfully submitted.')])[1]")
    public WebElement message;

    @FindBy(xpath = "//a[.='Add New Payee']")
    public WebElement addNewPayee;

    @FindBy(id = "np_new_payee_name")
    public WebElement newPayeeNameInput;

    @FindBy(id = "np_new_payee_address")
    public WebElement newPayeeAddressInput;

    @FindBy(id = "np_new_payee_account")
    public WebElement newPayeeAccountInput;

    @FindBy(id = "np_new_payee_details")
    public WebElement newPayeeDetailsInput;

    @FindBy(xpath = "//div[contains(text(),'was successfully created.')]")
    public WebElement actualMessage;

    @FindBy(id = "add_new_payee")
    public WebElement addPayeeButton;
}
