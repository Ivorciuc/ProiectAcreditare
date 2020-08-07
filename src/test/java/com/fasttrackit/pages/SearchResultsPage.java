package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class SearchResultsPage extends PageObject {

    @FindBy(id = ".post-loop-content:nth-child(2)")
    private List<WebElementFacade> listOfProductFromSearch;

    @FindBy(css = ".first h3")
    private WebElementFacade hoodie;

    @FindBy(css = ".entry-title a")
    private WebElementFacade checkIfProductAppeared;

    @FindBy(css = ".page-content p")
    private WebElementFacade nothingFoundMessage;

    public boolean listOfProducts(String productName){
            for (WebElementFacade product : listOfProductFromSearch){
                WebElement productWeb = product.findElement(By.cssSelector(".first h3 a"));
                if (productWeb.getText().equals(productName)){
                    productWeb.click();
                    return true;
                }
            }
            return false;
        }

    public void hoodieg(){
        clickOn(hoodie);
    }

    public boolean setCheckIfProductAppeared(String productName) {
           return checkIfProductAppeared.containsOnlyText(productName);
    }

    public boolean checkNothingFoundMessage(){
        try {
        return nothingFoundMessage.isDisplayed();
    } catch ( NoSuchElementException error ) {
        System.out.println("Element has not been found");
    }
        return true;

}






}
