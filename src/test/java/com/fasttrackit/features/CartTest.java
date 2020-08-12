package com.fasttrackit.features;

import com.fasttrackit.steps.*;
import com.fasttrackit.util.BaseTest;
import com.fasttrackit.util.Constants;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

import java.awt.*;


public class CartTest extends BaseTest {

    @Steps
    private HomeSteps homeSteps;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private CartSteps cartSteps;

    @Steps
    private ProductPageSteps productPageSteps;

    @Steps
    private ShopSteps shopSteps;

    @Steps
    private SearchSteps searchSteps;

    @Test
    public void addToCart(){
        loginSteps.login(Constants.USER_EMAIL, Constants.USER_PASS);
        shopSteps.openShopPage();
        searchSteps.typeInSearchField("Hoodie");
        searchSteps.pressEnterToSearch();
        searchSteps.selectTheProductYouWant("Hoodie with Pocket");
        productPageSteps.productQuantity("1");
        productPageSteps.addToCart("Hoodie with Pocket");
        productPageSteps.goToCart();
        cartSteps.findProductInCart("Hoodie with Pocket");
    }

    @Test
    public void changeQuantityInCart() {
        loginSteps.login(Constants.USER_EMAIL, Constants.USER_PASS);
        shopSteps.openShopPage();
        searchSteps.typeInSearchField("Hoodie");
        searchSteps.pressEnterToSearch();
        searchSteps.selectTheProductYouWant("Hoodie with Pocket");
        productPageSteps.productQuantity("2");
        productPageSteps.addToCart("Hoodie with Pocket");
        productPageSteps.goToCart();
        cartSteps.productQuantity("2", "1");

    }

    @Test
    public void checkIfPricesAreCorrect() throws InterruptedException {
        loginSteps.login(Constants.USER_EMAIL, Constants.USER_PASS);
        shopSteps.openShopPage();
        searchSteps.typeInSearchField("Shirt");
        searchSteps.pressEnterToSearch();
        searchSteps.selectTheProductYouWant("T-Shirt");
        productPageSteps.productQuantity("1");
        productPageSteps.addToCart("T-Shirt");
        searchSteps.typeInSearchField("Hoodie");
        searchSteps.pressEnterToSearch();
        searchSteps.selectTheProductYouWant("Hoodie with Zipper");
        productPageSteps.addToCart("Hoodie with Zipper");
        productPageSteps.goToCart();
        cartSteps.verifySubTotalPrice();
        cartSteps.verifyTotalPrice();

    }



}

