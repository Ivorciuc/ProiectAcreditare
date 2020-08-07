package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends PageObject {

    @FindBy(className = ".woocommerce-cart-form__contents")
    private List<WebElementFacade> productList;

    public boolean productList(String productName){
        for (WebElementFacade product : productList){
            WebElement productWeb = product.findElement(By.cssSelector("woocommerce-cart-form__cart-item"));
            if (productWeb.getText().equals(productName)){
                productWeb.click();
                return true;
            }
        }
        return false;
    }

}
