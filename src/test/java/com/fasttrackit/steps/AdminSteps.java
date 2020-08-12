package com.fasttrackit.steps;

import com.fasttrackit.pages.WordPressPage;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;

import java.sql.Driver;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.apache.commons.io.FileUtils.waitFor;

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
    public void createProduct(String product, String content, String price, String stock) throws InterruptedException {
        wordPressPage.clickOnProducts();
        wordPressPage.clickAddNewProduct();
        wordPressPage.setProductName(product);
        wordPressPage.writeProductContent(content);
        wordPressPage.productPrice(price);
        wordPressPage.clickInventory();
        wordPressPage.setProductStock(stock);
        wordPressPage.publishProduct();

    }

    @Step
    public void checkProductPublishing(String text){
        wordPressPage.checkPublishedMessage(text);
    }

    @Step
    public void deleteProduct(){
        wordPressPage.clickOnProducts();

    }

    @Step
    public void makeProductVisible(){
        wordPressPage.editVisibility();
        wordPressPage.setPublicVisibility();
        wordPressPage.pressOkForVisibilityOption();
    }



}
