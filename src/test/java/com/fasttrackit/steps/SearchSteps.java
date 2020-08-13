package com.fasttrackit.steps;

import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.SearchResultsPage;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.awt.*;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

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
    public void pressEnterToSearch() {
        getDriver().findElement(By.cssSelector("#search-2 .search-field")).sendKeys(Keys.ENTER);
    }

    @Step
    public void checkIfProductAppeared(String productName){
        Assert.assertTrue(searchResultsPage.setCheckIfProductAppeared(productName));
    }

    @Step
    public void checkIfSomethingAppeared(String leaveAComment){
        Assert.assertTrue(searchResultsPage.checkifSomethingAppearedWithEmptySearchBar(leaveAComment));
    }

    @Step
    public void checkIfNothingFoundMessageAppeared(String message){
        Assert.assertTrue(searchResultsPage.checkNothingFoundMessage(message));
    }
}
