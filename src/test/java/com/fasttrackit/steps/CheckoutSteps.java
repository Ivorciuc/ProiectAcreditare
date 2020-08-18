package com.fasttrackit.steps;

import com.fasttrackit.pages.CheckoutPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.yecht.Data;

import java.util.NoSuchElementException;

public class CheckoutSteps {

    private CheckoutPage checkoutPage;

    @Step
    public void validCheckout(String firstName, String lastName, String company, String country,
                              String streetAddress, String city, String county, String postCode,
                              String phoneNumber, String email ){
        checkoutPage.setFirstName(firstName);
        checkoutPage.setLastName(lastName);
        checkoutPage.setCompany(company);
        checkoutPage.setCountry(country);
        checkoutPage.setStreetAddress(streetAddress);
        checkoutPage.setCity(city);
        try {
            checkoutPage.setCountyDropdown(county);
        } catch ( WebDriverException error )
        {
            checkoutPage.setSimpleCountyOption();
        }
        checkoutPage.setPostCode(postCode);
        checkoutPage.setPhone(phoneNumber);
        checkoutPage.setEmail(email);
        try {
            checkoutPage.clickPlaceOrder();
        } catch ( StaleElementReferenceException error ){
            checkoutPage.clickPlaceOrder();
        }

    }

    @Step
    public void clickPlaceOrderButton(){
        checkoutPage.clickPlaceOrder();
    }


    @Step
    public void checkIfPricesAreCorrect(){
        checkoutPage.checkPrices();
    }

    @Step
    public void invalidErrorMessageCheck(String text){
        Assert.assertTrue(checkoutPage.invalidError(text));
    }


}
