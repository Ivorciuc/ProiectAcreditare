package com.fasttrackit.steps;

import com.fasttrackit.pages.WordPressPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class AdminSteps {

    private WordPressPage wordPressPage;

    @Step
    public void goToWordPress(){
        wordPressPage.open();
    }

    @Step
    public void loginToAdminPage(String email, String pass){

        wordPressPage.open();
        wordPressPage.typeUserEmail(email);
        wordPressPage.typeUserPass(pass);
        wordPressPage.clickLogIn();
        wordPressPage.openWordHome();
    }

    @Step
    public void createProduct(String product, String content, String price, String stock) {
        wordPressPage.openProducts();
        wordPressPage.clickAddNewProduct();
        wordPressPage.writeProductContent(content);
        wordPressPage.productPrice(price);
        wordPressPage.clickInventory();
        wordPressPage.setProductStock(stock);
        wordPressPage.setProductName(product);
        wordPressPage.publishProduct();

    }

    @Step
    public void checkProductPublishing(String text){
        Assert.assertTrue(wordPressPage.checkPublishedMessage(text));
    }

    @Step
    public void openWordHomePage(){
        wordPressPage.openWordHome();
    }

    @Step
    public void openProductsPage(){
        wordPressPage.openProducts();
    }

    @Step
    public void openCommentsPage(){
        wordPressPage.openComments();
    }

    @Step
    public void deleteProduct(String productName, String message) {
        openWordHomePage();
        openProductsPage();
        wordPressPage.selectFromProductsCreated(productName);
        wordPressPage.setDeleteProductButton();
        Assert.assertTrue(wordPressPage.setMovedToTrashMessage(message));
    }

    @Step
    public void makeProductVisible(){
        wordPressPage.editVisibility();
        wordPressPage.setPublicVisibility();
        wordPressPage.pressOkForVisibilityOption();
    }

    @Step
    public void clickViewProductsOnFastTrackIt(){
        wordPressPage.checkProductsOnTheWebSite();
    }

    @Step
    public void search(String text){
        wordPressPage.typeInSearchBar(text);
        wordPressPage.clickSearch();
    }

    @Step
    public void selectAnyProductCreated(String productName){
        wordPressPage.selectFromProductsCreated(productName);
    }

    @Step
    public void approveReviewAdmin(){
        wordPressPage.approveReview();
    }

    @Step
    public void unapproveReviewAdmin(){
        wordPressPage.unapproveReview();
    }

    @Step
    public void deleteReviewAdmin(){
        wordPressPage.deleteReview();
    }

    @Step
    public void checkIfCommentsExist(){
        wordPressPage.noCommentsMessage();
    }






}
