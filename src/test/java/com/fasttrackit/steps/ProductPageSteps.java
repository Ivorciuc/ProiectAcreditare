package com.fasttrackit.steps;

import com.fasttrackit.pages.ProductPage;
import net.thucydides.core.annotations.Step;

public class ProductPageSteps {

    private ProductPage productPage;


    @Step
    public void addToCart(){
        productPage.setProductQuantity();
        productPage.clickAddToCart();
        productPage.checkAddedToCartMessage();
    }

    @Step
    public void goToCart(){
        productPage.clickViewCartButton();
    }

}
