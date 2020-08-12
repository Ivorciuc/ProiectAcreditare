package com.fasttrackit.steps;

import com.fasttrackit.pages.WordPressPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class AdminSteps {

    private WordPressPage wordPressPage;

    @Step
    public void loginToAdminPage(String email, String pass){

        wordPressPage.open();
        wordPressPage.typeUserEmail(email);
        wordPressPage.typeUserPass(pass);
        wordPressPage.clickLogIn();

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
    public void deleteProduct(String productName, String message) {
        wordPressPage.openPosts();
        wordPressPage.openProducts();
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



}
