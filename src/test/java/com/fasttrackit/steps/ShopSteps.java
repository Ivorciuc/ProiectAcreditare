package com.fasttrackit.steps;

import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.ShopPage;
import net.thucydides.core.annotations.Step;

public class ShopSteps {

    private ShopPage shopPage;

    private HomePage homePage;

    @Step
    public void openShopPage(){
        shopPage.open();
    }

    @Step
    public void goToPage1(){
        shopPage.clickOnpage1();
    }

    @Step
    public void goToPage2(){
        shopPage.clickOnpage2();
    }

    @Step
    public void goToPage3(){
        shopPage.clickOnpage3();
    }


}
