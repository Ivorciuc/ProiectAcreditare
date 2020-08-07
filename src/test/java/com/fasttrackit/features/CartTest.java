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
    public void addToCart() throws AWTException {
        shopSteps.openShopPage();
        searchSteps.typeInSearchField("Hoodie");
        searchSteps.pressEnterToSearch();
        searchSteps.selectTheProductYouWant("Hoodie with Pocket");
        productPageSteps.addToCart();
        productPageSteps.goToCart();
        cartSteps.findProductInCart("Hoodie with Pocket");
    }



}

