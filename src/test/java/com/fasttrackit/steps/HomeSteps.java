package com.fasttrackit.steps;

import com.fasttrackit.pages.CartPage;
import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.MyAccountPage;
import com.fasttrackit.pages.ProductPage;

public class HomeSteps {

    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private CartPage cartPage;
    private ProductPage productPage;

    public void navigateToHomePage(){
        homePage.open();
    }

    public void clickSignIn(){
        homePage.clickLoginCustomerAcc();
    }

    public void clickAccount(){
        homePage.clickAccount();
    }




}
