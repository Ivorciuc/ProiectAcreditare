package com.fasttrackit.steps;

import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.MyAccountPage;
import com.fasttrackit.pages.MyDashboardPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;


public class LoginSteps {

    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private MyDashboardPage myDashboardPage;




    @Step
    public void navigateToLoginPage(){
        homePage.open();
        homePage.clickLogin();
        myAccountPage.isOnLoginPage();

    }

    @Step
    public void loginWithCredentials(String email, String pass){
        myAccountPage.setUserEmailField(email);
        myAccountPage.setUserPasswordField(pass);
        myAccountPage.clickLoginButton();
    }

    @Step
    public void login(String email, String pass){
        navigateToLoginPage();
        loginWithCredentials(email, pass);
    }

    @Step
    public void verifyNotLoggedIn(){
        Assert.assertTrue(myAccountPage.isOnLoginPage());
    }



}

