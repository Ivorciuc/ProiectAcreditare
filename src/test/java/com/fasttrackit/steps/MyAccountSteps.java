package com.fasttrackit.steps;

import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.MyAccountPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.yecht.Data;

public class MyAccountSteps {

    private MyAccountPage myAccountPage;
    private HomePage homePage;


    @Step
    public void changePassword(String currentPass, String newPassword, String newPassConfirm){
        myAccountPage.clickAccountDetails();
        myAccountPage.setCurrentPassField(currentPass);
        myAccountPage.setNewPass(newPassword);
        myAccountPage.setNewPassConfirm(newPassConfirm);
        myAccountPage.clickSaveChanges();
    }

    @Step
    public void changeBillingAddress(String firstName, String lastName ,String company, String streetAddress,
                                     String city, String postCode, String phoneNumber, String email, String text){

        myAccountPage.clickOnAddresses();
        myAccountPage.clickOnEditBilling();
        myAccountPage.setBillingFirstName(firstName);
        myAccountPage.setBillingLastName(lastName);
        myAccountPage.setBillingCompany(company);
        myAccountPage.setBillingStreetAddress(streetAddress);
        myAccountPage.setBillingCity(city);
        myAccountPage.setBillingPostCode(postCode);
        myAccountPage.setBillingPhone(phoneNumber);
        myAccountPage.setBillingEmail(email);
        myAccountPage.saveAddressButton();
        Assert.assertTrue(myAccountPage.checkBillingSpecifications(text));

    }

    @Step
    public void changeShippingAddress(String firstName, String lastName, String company, String streetAddress,
                                      String city, String postCode, String text){

        myAccountPage.clickOnAddresses();
        myAccountPage.clickOnEditShipping();
        myAccountPage.setShippingFirstName(firstName);
        myAccountPage.setShippingLastName(lastName);
        myAccountPage.setShippingCompany(company);
        myAccountPage.setShippingStreetAddress(streetAddress);
        myAccountPage.setShippingCity(city);
        myAccountPage.setShippingPostCode(postCode);
        myAccountPage.saveAddressButton();
        Assert.assertTrue(myAccountPage.checkShippingSpecifications(text));
    }

    @Step
    public void invalidPassChangeWarning(String text){
        Assert.assertTrue(myAccountPage.invalidNewPassMessage(text));
    }



}
