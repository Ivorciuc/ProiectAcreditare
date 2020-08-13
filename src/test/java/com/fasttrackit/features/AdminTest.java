package com.fasttrackit.features;

import com.fasttrackit.steps.*;
import com.fasttrackit.util.BaseTest;
import com.fasttrackit.util.Constants;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class AdminTest extends BaseTest {

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

    @Test
    public void createProductAndWriteReview(){
        adminSteps.loginToAdminPage(Constants.USER_EMAIL_WORDPRESS, Constants.USER_PASS_WORDPRESS);
        adminSteps.createProduct("Shirt Bear Logo", "TedyBear Shirt", "1", "200");
        adminSteps.checkProductPublishing("Product published.");
        adminSteps.openWordHomePage();
        adminSteps.openProductsPage();
        adminSteps.clickViewProductsOnFastTrackIt();
        searchSteps.typeInSearchField("Shirt Bear");
        searchSteps.pressEnterToSearch();
        searchSteps.selectTheProductYouWant("Shirt Bear Logo");
        productPageSteps.writeAReview("E de 5 stele.");
        adminSteps.loginToAdminPage(Constants.USER_EMAIL_WORDPRESS, Constants.USER_PASS_WORDPRESS);
        adminSteps.deleteProduct("Shirt Bear Logo", "1 product moved to the Trash.");
    }

    @Test
    public void approveReviewCustomer() {
        loginSteps.login(Constants.USER_EMAIL, Constants.USER_PASS);
        shopSteps.openShopPage();
        searchSteps.typeInSearchField("Hoodie");
        searchSteps.pressEnterToSearch();
        searchSteps.selectTheProductYouWant("Hoodie with Pocket");
        productPageSteps.writeAReview("Very good product!");
        productPageSteps.checkIfReviewExist();
        adminSteps.loginToAdminPage(Constants.USER_EMAIL_WORDPRESS, Constants.USER_PASS_WORDPRESS);
        adminSteps.openProductsPage();
        adminSteps.search("Hoodie");
        adminSteps.selectAnyProductCreated("Hoodie with Pocket");
        adminSteps.approveReviewAdmin();
        adminSteps.openWordHomePage();
        adminSteps.openProductsPage();
        adminSteps.clickViewProductsOnFastTrackIt();
        searchSteps.typeInSearchField("Hoodie");
        searchSteps.pressEnterToSearch();
        searchSteps.selectTheProductYouWant("Hoodie with Pocket");
        productPageSteps.openReviews();
        productPageSteps.checkIfReviewExist();
        adminSteps.loginToAdminPage(Constants.USER_EMAIL_WORDPRESS, Constants.USER_PASS_WORDPRESS);
        adminSteps.openProductsPage();
        adminSteps.search("Hoodie");
        adminSteps.selectAnyProductCreated("Hoodie with Pocket");
        adminSteps.unapproveReviewAdmin();
        adminSteps.deleteReviewAdmin();
        adminSteps.openWordHomePage();
        adminSteps.openProductsPage();
        adminSteps.search("Hoodie");
        adminSteps.selectAnyProductCreated("Hoodie with Pocket");
        adminSteps.checkIfCommentsExist();
    }

}
