package com.fasttrackit.steps;

import com.fasttrackit.pages.ProductPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class ProductPageSteps {

    private ProductPage productPage;

    @Step
    public void productQuantity(String value){
        productPage.setProductQuantity(value);
    }

    @Step
    public void addToCart(String text){
        productPage.clickAddToCart();
        Assert.assertTrue(productPage.checkAddedToCartMessage(text));

    }

    @Step
    public void goToCart(){
        productPage.clickViewCartButton();
    }

}
