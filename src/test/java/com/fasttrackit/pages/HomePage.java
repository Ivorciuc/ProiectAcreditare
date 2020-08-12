package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.interactions.Actions;

@DefaultUrl("http://qa3.fasttrackit.org:8008/")
public class HomePage extends PageObject {

    @FindBy(css = ".site-title a")
    private WebElementFacade toHomePage;

    @FindBy(css = "a[title='My Account']")
    private WebElementFacade accountLink;

    @FindBy(css = "a[title='Login']")
    private WebElementFacade loginLink;

    @FindBy(css = "#search-2 .search-field")
    private WebElementFacade searchField;

    @FindBy(css = "#meta-2 li:nth-child(2)")
    private WebElementFacade logInToAdmin;

    public void navigateToHomePage(){
        clickOn(toHomePage);
    }

    public void clickAccount(){
        clickOn(accountLink);
    }

    public void clickLoginCustomerAcc(){
        clickOn(loginLink);
    }

    public void typeInSearchBar(String productName){
        typeInto(searchField, productName);
    }

    public void clickToAdminAcc(){
        clickOn(logInToAdmin);
    }



}
