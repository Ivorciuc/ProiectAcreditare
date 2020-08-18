package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://qa3.fasttrackit.org:8008/checkout")
public class CheckoutPage extends PageObject {

    @FindBy(id = "billing_first_name")
    private WebElementFacade firstName;

    @FindBy(id = "billing_last_name")
    private WebElementFacade lastName;

    @FindBy(id = "billing_company")
    private WebElementFacade company;

    @FindBy(id = "billing_country")
    private WebElementFacade dropDownCountry;

    @FindBy(css = ".woocommerce-billing-fields #billing_address_1")
    private WebElementFacade streetAddress;

    @FindBy(css = ".woocommerce-billing-fields__field-wrapper #billing_city")
    private WebElementFacade city;

    @FindBy(className = ".woocommerce-billing-fields #billing_state")
    private WebElementFacade dropDownCounty;

    @FindBy(css = ".woocommerce-billing-fields #billing_state" )
    private WebElementFacade simpleCountyOption;

    @FindBy(css = ".woocommerce-billing-fields #billing_postcode")
    private WebElementFacade postCode;

    @FindBy(css = ".woocommerce-billing-fields #billing_phone")
    private WebElementFacade phone;

    @FindBy(css = ".woocommerce-billing-fields #billing_email")
    private WebElementFacade email;

    @FindBy(css = ".woocommerce-thankyou-order-received")
    private WebElementFacade yourOrderHasBeenReceivedMessage;

    @FindBy(id = "place_order")
    private WebElementFacade placeOrderButton;

    @FindBy(css = ".order-total .woocommerce-Price-amount")
    private WebElement totalPriceCheckout;

    @FindBy(css = ".product-total .woocommerce-Price-amount")
    private WebElementFacade totalPriceOrder;

    @FindBy(css = ".woocommerce-error li")
    private WebElementFacade invalidErrorMessage;

    public void setFirstName(String text){
        typeInto(firstName, text);
    }

    public void setLastName(String text){
        typeInto(lastName, text);
    }

    public void setCompany(String text){
        typeInto(company, text);
    }

    public void setCountry(String country){
        dropDownCountry.selectByVisibleText(country);
    }

    public void setStreetAddress(String text){
        typeInto(streetAddress, text);
    }

    public void setCity(String text){
        typeInto(city, text);
    }

    public void setCountyDropdown(String county){
        dropDownCounty.selectByVisibleText(county);
    }

    public void  setSimpleCountyOption(){
        typeInto(simpleCountyOption, "Cluj");
    }

    public void setPostCode(String text){
        typeInto(postCode, text);
    }

    public void setPhone(String number){
        typeInto(phone, number);
    }

    public void setEmail(String text){
        typeInto(email, text);
    }

    public void clickPlaceOrder(){
        waitFor(placeOrderButton);
        clickOn(placeOrderButton);
    }

    public boolean succesMessage(String message){
        return yourOrderHasBeenReceivedMessage.containsText(message);
    }

    public int getTotalPriceCheckout(){
        String totalPrice = totalPriceCheckout.getText().replace(" lei", "").replace(",", "");
        int productTotalPrice = Integer.valueOf(totalPrice);
        return productTotalPrice;
    }

    public int getTotalPriceOrder(){
        String totalPrice1 = totalPriceOrder.getText().replace("Total:", "").replace(" lei", "").replace(",", "");
        int productTotalPriceOrder = Integer.valueOf(totalPrice1);
        return productTotalPriceOrder;
    }

    public boolean checkPrices(){
        if(getTotalPriceCheckout() == getTotalPriceOrder()){
            return true;
        }
        return false;
    }

    public boolean invalidError(String text){
        return invalidErrorMessage.containsText(text);
    }





}
