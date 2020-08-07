package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Test;
import org.yecht.Data;

@DefaultUrl("http://qa3.fasttrackit.org:8008/my-account")
public class MyAccountPage extends PageObject {

    @FindBy(id = "username")
    private WebElementFacade userEmailField;

    @FindBy(id = "password")
    private WebElementFacade userPasswordField;

    @FindBy(css ="button[name='login']")
    private WebElementFacade loginButton;

    @FindBy(css = ".woocommerce-MyAccount-content ")
    private WebElementFacade welcomeMessage;

    @FindBy(css = ".woocommerce-MyAccount-navigation-link--edit-account a")
    private WebElementFacade accountDetailsOption;

    @FindBy(id = "password_current")
    private WebElementFacade currentPassField;

    @FindBy(id = "password_1")
    private WebElementFacade newPass;

    @FindBy(id = "password_2")
    private WebElementFacade newPassConfirm;

    @FindBy(css = ".woocommerce-Button")
    private WebElementFacade saveChangesButton;

    @FindBy(className = "woocommerce-MyAccount-navigation-link--customer-logout")
    private WebElementFacade logout;

    @FindBy(className = "woocommerce-MyAccount-navigation-link--edit-address")
    private WebElementFacade addressesOption;



    public void setUserEmailField(String email){
        typeInto(userEmailField, email);
    }

    public boolean isOnLoginPage(){
        return userEmailField.isDisplayed();
    }

    public void setUserPasswordField(String pass){
        typeInto(userPasswordField, pass);
    }

    public void clickLoginButton(){
        clickOn(loginButton);
    }

    public boolean checkWelcomeMessage(String text){
        return welcomeMessage.containsText(text);
    }

    public void clickAccountDetails(){
        clickOn(accountDetailsOption);
    }

    public void setCurrentPassField(String currentPass){
        typeInto(currentPassField, currentPass);
    }

    public void setNewPass(String newPassword){
        typeInto(newPass, newPassword);
    }

    public void setNewPassConfirm(String newPasswordConfirm){
        typeInto(newPassConfirm, newPasswordConfirm);
    }

    public void clickSaveChanges(){
        clickOn(saveChangesButton);
    }

    public void setLogout(){
        clickOn(logout);
    }

    public void clickOnAddresses(){
        clickOn(addressesOption);
    }


}
