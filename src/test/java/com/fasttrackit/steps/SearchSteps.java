package com.fasttrackit.steps;

import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.SearchResultsPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;

public class SearchSteps {

    private HomePage homePage;

    private SearchResultsPage searchResultsPage;

    @Step
    public void typeInSearchField(String productName){
        homePage.typeInSearchBar(productName);
    }

    @Step
    public void selectTheProductYouWant(String productName){
        searchResultsPage.listOfProducts(productName);
    }

    @Step
    public void pressEnterToSearch() throws AWTException {
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_ENTER);
        r.keyRelease(KeyEvent.VK_ENTER);
    }

    @Step
    public void clickonHoodie(){
        searchResultsPage.hoodieg();
    }

    @Step
    public void checkIfProductAppeared(String productName){
        Assert.assertTrue(searchResultsPage.setCheckIfProductAppeared(productName));
    }

    @Step
    public void checkIfNothingFoundMessageAppeared(String message){
        Assert.assertTrue(searchResultsPage.checkNothingFoundMessage(message));
    }
}
