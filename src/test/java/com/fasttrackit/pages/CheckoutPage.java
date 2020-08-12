package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import java.time.Duration;

@DefaultUrl("http://qa3.fasttrackit.org:8008/checkout")
public class CheckoutPage extends PageObject {

    @FindBy(id = "billing_first_name")
    private WebElementFacade firstName;

    @FindBy(id = "billing_last_name")
    private WebElementFacade lastName;

    @FindBy(id = "billing_company")
    private WebElementFacade company;

    @FindBy(id = "#select2-billing_country-container")
    private WebElementFacade dropdownCountry;

    @FindBy(css = ".woocommerce-billing-fields #billing_address_1")
    private WebElementFacade streetAddress;

    @FindBy(css = ".woocommerce-billing-fields__field-wrapper #billing_city")
    private WebElementFacade city;

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
        dropdownCountry.selectByVisibleText(country);
    }

    public void setStreetAddress(String text){
        typeInto(streetAddress, text);
    }

    public void setCity




}
