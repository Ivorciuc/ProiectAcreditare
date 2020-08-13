package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
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

    @FindBy(css = ".u-column1 .woocommerce-Address-title a")
    private WebElementFacade editBillingAddress;

    @FindBy(css = ".woocommerce-address-fields #billing_first_name")
    private WebElementFacade billingFirstName;

    @FindBy(css = ".woocommerce-address-fields #billing_last_name")
    private WebElementFacade billingLastName;

    @FindBy(id = "billing_company")
    private WebElementFacade billingCompany;

    @FindBy(id = "select2-billing_country-container")
    private WebElementFacade billingCountry;

    @FindBy(id = "select2-billing_country-result-jm5m-RU")
    private WebElementFacade selectRussia;

    @FindBy(css = ".woocommerce-address-fields #billing_address_1")
    private WebElementFacade streetAddress;

    @FindBy(css = ".woocommerce-address-fields #billing_city")
    private WebElementFacade billingCity;

    @FindBy(css = ".woocommerce-address-fields #billing_postcode")
    private WebElementFacade billingPostCode;

    @FindBy(css = ".woocommerce-address-fields #billing_phone")
    private WebElementFacade billingPhone;

    @FindBy(css = ".woocommerce-address-fields #billing_email")
    private WebElementFacade billingEmail;

    @FindBy(className = "button")
    private WebElementFacade saveAddress;

    @FindBy(css = ".u-column1 address")
    private WebElementFacade billingAddressSpecifications;

    @FindBy(css = ".u-column2 a")
    private WebElementFacade editShipping;

    @FindBy(id = "shipping_first_name")
    private WebElementFacade shippingFirstName;

    @FindBy(id = "shipping_last_name")
    private WebElementFacade shippingLastName;

    @FindBy(id = "shipping_company")
    private WebElementFacade shippingCompany;

    @FindBy(css = ".woocommerce-address-fields__field-wrapper #shipping_address_1")
    private WebElementFacade shippingStreetAddress;

    @FindBy(css = ".woocommerce-address-fields__field-wrapper #shipping_city")
    private WebElementFacade shippingCity;

    @FindBy(css = ".woocommerce-address-fields__field-wrapper #shipping_postcode")
    private WebElementFacade shippingPostCode;

    @FindBy(css = ".u-column2  address")
    private WebElementFacade shippingSpecifications;

    @FindBy(className = "woocommerce-error")
    private WebElementFacade newPassDoNotMatch;



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

    public void clickOnEditBilling(){
        clickOn(editBillingAddress);
    }

    public void setBillingFirstName(String firstName){
        typeInto(billingFirstName, firstName);
    }

    public void setBillingLastName(String lastName){
        typeInto(billingLastName, lastName);
    }

    public void setBillingCompany(String company){
        typeInto(billingCompany, company);
    }

    public void setBillingStreetAddress(String streetAddress1){
        typeInto(streetAddress, streetAddress1 );
    }

    public void setBillingCity(String city){
        typeInto(billingCity, city);
    }

    public void setBillingPostCode(String billingPostCode1){
        typeInto(billingPostCode, billingPostCode1);
    }

    public void setBillingPhone(String phoneNumber){
        typeInto(billingPhone, phoneNumber);
    }

    public void setBillingEmail(String email){
        typeInto(billingEmail, email);
    }

    public void saveAddressButton(){
        clickOn(saveAddress);
    }

    public boolean checkBillingSpecifications(String text){
        return billingAddressSpecifications.containsText(text);
    }

    public void clickOnEditShipping(){
        clickOn(editShipping);
    }
    public void setShippingFirstName(String firstName){
        typeInto(shippingFirstName, firstName);
    }

    public void setShippingLastName(String lastName){
        typeInto(shippingLastName, lastName);
    }

    public void setShippingCompany(String company){
        typeInto(shippingCompany, company);
    }

    public void setShippingStreetAddress(String streetAddress){
        typeInto(shippingStreetAddress, streetAddress);
    }

    public void setShippingCity(String city){
        typeInto(shippingCity, city);
    }

    public void setShippingPostCode(String postCode){
        typeInto(shippingPostCode, postCode);
    }

    public boolean checkShippingSpecifications(String text){
        return shippingSpecifications.containsText(text);
    }

    public boolean invalidNewPassMessage(String text){
        return newPassDoNotMatch.containsText(text);
    }



}
