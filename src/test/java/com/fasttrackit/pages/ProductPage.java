package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductPage extends PageObject {

    @FindBy(css = ".quantity .qty")
    private WebElementFacade productQuantity;

    @FindBy(css = ".single_add_to_cart_button")
    private WebElementFacade addToCartButton;

    @FindBy(css = ".woocommerce-message")
    private WebElementFacade addedToCartMessage;

    @FindBy(className = "wc-forward")
    private WebElementFacade viewCartButton;

    @FindBy(id = "tab-title-reviews")
    private WebElementFacade reviewsOption;

    public void setProductQuantity(String value){
        typeInto(productQuantity, value);
    }

    public void clickAddToCart(){
        clickOn(addToCartButton);
    }

    public boolean checkAddedToCartMessage(String text){
        return addedToCartMessage.containsText(text);
    }

    public void clickViewCartButton(){
        clickOn(viewCartButton);
    }

    public void checkReviews(){
        clickOn(reviewsOption);
    }
}
