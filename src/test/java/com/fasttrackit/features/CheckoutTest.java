package com.fasttrackit.features;

import com.fasttrackit.pages.ShopPage;
import com.fasttrackit.steps.*;
import com.fasttrackit.util.BaseTest;
import com.fasttrackit.util.Constants;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class CheckoutTest extends BaseTest {

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private SearchSteps searchSteps;

    @Steps
    private CartSteps cartSteps;

    @Steps
    private CheckoutSteps checkoutSteps;

    @Steps
    private ShopSteps shopSteps;

    @Steps
    private ProductPageSteps productPageSteps;

    @Test
    public void checkoutTestWithoutLogin(){
        shopSteps.openShopPage();
        searchSteps.typeInSearchField("hoodie");
        searchSteps.pressEnterToSearch();
        searchSteps.selectTheProductYouWant("Hoodie with Pocket");
        productPageSteps.proceedToCheckOutFast("1", "Hoodie with Pocket");
        cartSteps.proceedToCheckout();
        checkoutSteps.validCheckout("Adrian", "Adriann", "Bood", "Qatar",
                "Bulevardului", "Qatarr", "Cluj", "112321","111232","aadriaan2@yahoo.com");
        checkoutSteps.checkIfPricesAreCorrect();
    }

    @Test
    public void checkoutWithLogin(){
        loginSteps.login(Constants.USER_EMAIL, Constants.USER_PASS);
        shopSteps.openShopPage();
        searchSteps.typeInSearchField("hoodie");
        searchSteps.pressEnterToSearch();
        searchSteps.selectTheProductYouWant("Hoodie with Pocket");
        productPageSteps.proceedToCheckOutFast("1", "Hoodie with Pocket");
        cartSteps.proceedToCheckout();
        checkoutSteps.clickPlaceOrderButton();
        checkoutSteps.checkIfPricesAreCorrect();
    }
}
