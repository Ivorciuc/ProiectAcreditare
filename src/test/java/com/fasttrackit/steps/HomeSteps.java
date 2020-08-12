package com.fasttrackit.steps;

import com.fasttrackit.pages.CartPage;
import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.MyAccountPage;
import com.fasttrackit.pages.ProductPage;
import net.thucydides.core.annotations.Step;

public class HomeSteps {

    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private CartPage cartPage;
    private ProductPage productPage;

    @Step
    public void navigateToHomePage(){
        homePage.open();
    }

    @Step
    public void clickSignIn(){
        homePage.clickLoginCustomerAcc();
    }

    @Step
    public void clickAccount(){
        homePage.clickAccount();
    }

    @Step
    public void goToCartOption(){
        homePage.goToCart();
    }




}
