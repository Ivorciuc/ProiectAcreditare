package com.fasttrackit.steps;

import com.fasttrackit.pages.ProductPage;
import com.fasttrackit.pages.WordPressPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class ProductPageSteps {

    private ProductPage productPage;

    private WordPressPage wordPressPage;

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

    @Step
    public void proceedToCheckOutFast(String value, String productName){
        productQuantity(value);
        addToCart(productName);
        goToCart();
    }

    @Step
    public void verifyProductName(String productTitle){
        Assert.assertTrue(productPage.checkProductName(productTitle));
    }

    @Step
    public void verifyProductPriceFromWord(int productPrice){
        productPage.getPriceFromProductPage(productPrice);
    }

    @Step
    public void openReviews(){
        productPage.clickReviews();
    }

    @Step
    public void writeAReview(String review){
        openReviews();
        productPage.fiveStarRating();
        productPage.typeInReviewsField(review);
        productPage.postReview();
    }

    @Step
    public void checkIfReviewExist() {
        Assert.assertTrue(productPage.checkReviewExistence());
    }

    @Step
    public void checkReviewApproveStatus(String approveStatus){
        Assert.assertTrue(productPage.checkApproveMessage(approveStatus));
    }

}
