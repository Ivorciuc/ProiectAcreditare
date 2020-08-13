package com.fasttrackit.steps;

import com.fasttrackit.pages.CartPage;
import com.fasttrackit.pages.ProductPage;
import com.fasttrackit.pages.SearchResultsPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.NoSuchElementException;

public class CartSteps {

    private ProductPage productPage;
    private CartPage cartPage;
    private SearchResultsPage searchResultsPage;

    @Step
    public void findProductInCart(String productName){
        cartPage.productList(productName);
    }

    @Step
    public void checkIfCartIsEmpty(String message){
        Assert.assertTrue(cartPage.emptyCartText(message));
    }

    @Step
    public void checkProductQuantityInCart(String quantity){
        Assert.assertTrue(cartPage.checkProductQuantity(quantity));
    }

    @Step
    public void productQuantity(String quantity, String value){
        try {
            Assert.assertTrue(cartPage.checkProductQuantity(quantity));
        } catch ( AssertionError error ) {
            cartPage.setProductQuantity(value);
        }
    }

    @Step
    public void verifySubTotalPrice(){
        cartPage.checkSubTotalPrice();
    }

    @Step
    public void verifyTotalPrice(){
        cartPage.checkTotalPrice();
    }

    @Step
    public void proceedToCheckout(){
        cartPage.goToCheckout();
    }

    @Step
    public void removeFromCart(){
        cartPage.removeProductFromCart();
    }

    @Step
    public void removeAllProductsFromCart(){
        cartPage.deleteList();
    }

    @Step
    public void updateCart(){
        cartPage.updateTheCart();
    }

    @Step
    public void editProductQuantity(String quantity){
        cartPage.prdctQuantity(quantity);
    }

    @Step
    public void cartUpdateMessage(String message){
        Assert.assertTrue(cartPage.cartUpdate(message));
    }

}
