package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa3.fasttrackit.org:8008/my-account/lost-password")
public class LostPasswordPage extends PageObject {

    @FindBy(css = ".lost_password a")
    private WebElementFacade forgotPassLink;

    @FindBy(css = ".lost_reset_password p:nth-child(1)")
    private WebElementFacade lostPassMessage;

    @FindBy(id = "user_login")
    private WebElementFacade emailField;

    @FindBy(className = "woocommerce-Button")
    private WebElementFacade resetPasswordButton;

    @FindBy(className = "woocommerce-message")
    private WebElementFacade resetPassEmailMessage;

    @FindBy(className = "woocommerce-error")
    private WebElementFacade invalidEmailForForgottenPass;

    public void forgotPassButton(){
        clickOn(forgotPassLink);
    }

    public boolean setLostPassMessage(){
        return lostPassMessage.isDisplayed();
    }

    public void setEmailField(String email){
        typeInto(emailField, email);
    }

    public void setResetPasswordButton(){
        clickOn(resetPasswordButton);
    }

    public boolean setResetPassEmailMessage(){
        return resetPassEmailMessage.isDisplayed();
    }

    public boolean setinvalidEmailForForgottenPass(){
        return invalidEmailForForgottenPass.isDisplayed();
    }

}
