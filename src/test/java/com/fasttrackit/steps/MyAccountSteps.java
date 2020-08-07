package com.fasttrackit.steps;

import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.MyAccountPage;
import net.thucydides.core.annotations.Step;
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
    public void changeBillingAddress(){
        myAccountPage.clickOnAddresses();

    }



}
