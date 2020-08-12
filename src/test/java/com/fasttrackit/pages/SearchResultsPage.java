package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class SearchResultsPage extends PageObject {

    @FindBy(css = "#primary .product")
    private List<WebElementFacade> listOfProductFromSearch;

    @FindBy(css = ".entry-title a")
    private WebElementFacade checkIfProductAppeared;

    @FindBy(css = ".page-content p")
    private WebElementFacade nothingFoundMessage;

    @FindBy(css = "#primary #main")
    private WebElementFacade verifyEmptySearchBar;

    public boolean listOfProducts(String productName){
            for (WebElementFacade product : listOfProductFromSearch){
                WebElement productWeb = product.findElement(By.cssSelector(".entry-title a"));
                if (productWeb.getText().equals(productName)){
                    productWeb.click();
                    return true;
                }
            }
            return false;
        }

    public boolean setCheckIfProductAppeared(String productName) {
           return checkIfProductAppeared.containsOnlyText(productName);
    }

    public boolean checkNothingFoundMessage(String message){
        return nothingFoundMessage.containsText(message);
    }

    public boolean checkifSomethingAppearedWithEmptySearchBar(String leaveAComment){
        return verifyEmptySearchBar.containsText(leaveAComment);
    }








}
