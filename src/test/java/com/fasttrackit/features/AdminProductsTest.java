package com.fasttrackit.features;

import com.fasttrackit.steps.*;
import com.fasttrackit.util.BaseTest;
import com.fasttrackit.util.Constants;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class AdminProductsTest extends BaseTest {

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private ShopSteps shopSteps;

    @Steps
    private AdminSteps adminSteps;

    @Steps
    private SearchSteps searchSteps;

    @Steps
    private ProductPageSteps productPageSteps;


    @Test
    public void createNewProductTest() {
        adminSteps.loginToAdminPage(Constants.USER_EMAIL_WORDPRESS, Constants.USER_PASS_WORDPRESS);
        adminSteps.createProduct("JACKETR", "IT IS A SUPER JACKET!",  "10", "20");
        adminSteps.checkProductPublishing("Product published.");
        adminSteps.deleteProduct("JACKETR", "1 product moved to the Trash.");
    }

    @Test
    public void checkIfProductPublishedOnSiteCorrect(){
        adminSteps.loginToAdminPage(Constants.USER_EMAIL_WORDPRESS, Constants.USER_PASS_WORDPRESS);
        adminSteps.createProduct("CARPET", "IS IS A SUPER CARPET", "10", "20");
        adminSteps.checkProductPublishing("Product published.");
        adminSteps.openWordHomePage();
        adminSteps.openProductsPage();
        adminSteps.clickViewProductsOnFastTrackIt();
        searchSteps.typeInSearchField("CARPET");
        searchSteps.pressEnterToSearch();
        searchSteps.selectTheProductYouWant("CARPET");
        productPageSteps.verifyProductName("CARPET");
        productPageSteps.verifyProductPriceFromWord(10);
        adminSteps.openWordHomePage();
        adminSteps.deleteProduct("CARPET", "1 product moved to the Trash." );

    }



}
