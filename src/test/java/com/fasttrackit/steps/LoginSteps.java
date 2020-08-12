package com.fasttrackit.steps;

import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.MyAccountPage;
import com.fasttrackit.pages.MyDashboardPage;
import com.fasttrackit.pages.WordPressPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;


public class LoginSteps {

    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private MyDashboardPage myDashboardPage;
    private WordPressPage wordPressPage;




    @Step
    public void navigateToLoginPage(){
        homePage.open();
        homePage.clickLoginCustomerAcc();
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
    public void checkIfYouAreNotLoggedIn(){
        Assert.assertTrue(myAccountPage.isOnLoginPage());
    }

    @Step
    public void logout(){
        myAccountPage.setLogout();
    }

    @Step
    public void checkIfYouAreLoggedIn(String text){
        Assert.assertTrue(myAccountPage.checkWelcomeMessage(text));
    }



}

