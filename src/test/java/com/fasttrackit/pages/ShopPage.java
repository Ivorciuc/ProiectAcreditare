package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

@DefaultUrl("http://qa3.fasttrackit.org:8008/shop")
public class ShopPage extends PageObject {

    @FindBy(className = ".page-numbers li:nth-child(1)")
    private WebElementFacade clickpage1;

    @FindBy(className = ".page-numbers li:nth-child(2)")
    private WebElementFacade clickpage2;

    @FindBy(className = ".page-numbers li:nth-child(3)")
    private WebElementFacade clickpage3;

    @FindBy(css = ".page-numbers")
    private List<WebElementFacade> allShopPages;

    public void clickOnpage1(){
        clickOn(clickpage1);
    }

    public void clickOnpage2(){
        clickOn(clickpage2);
    }

    public void clickOnpage3(){
        clickOn(clickpage3);
    }









}
