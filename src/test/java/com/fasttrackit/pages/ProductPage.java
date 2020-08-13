package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.yecht.Data;

import java.util.List;

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
    private WebElementFacade openReviews;

    @FindBy(className = "star-5")
    private WebElementFacade fiveStar;

    @FindBy(id = "comment")
    private WebElementFacade commentSection;

    @FindBy(css = "#comments .woocommerce-Reviews-title")
    private WebElementFacade checkReview;

    @FindBy(id = "submit")
    private WebElementFacade submitReview;

    @FindBy(className = "product_title")
    private WebElementFacade productName;

    @FindBy(className = "woocommerce-Price-amount")
    private WebElementFacade productPrice;

    @FindBy(css = ".comment-text .meta")
    private WebElementFacade approveMessageForReview;



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

    public void clickReviews(){
        clickOn(openReviews);
    }

    public void fiveStarRating(){
        clickOn(fiveStar);
    }

    public void typeInReviewsField(String review){
        typeInto(commentSection, review);
    }

    public boolean checkApproveMessage(String approveStatus){
        return approveMessageForReview.containsOnlyText(approveStatus);
    }

    public void postReview(){
        clickOn(submitReview);
    }

    public boolean checkReviewExistence(){
       return checkReview.isDisplayed();
    }

    public boolean checkProductName(String productTitle){
        return productName.containsText(productTitle);
    }

    public boolean getPriceFromProductPage(int productPriceCart){
        String productValue = productPrice.getText().replace(" lei", "").replace(",", "");
        int price = Integer.valueOf(productValue);
        if (price == productPriceCart){
            return true;
        }
        return false;
    }
}
