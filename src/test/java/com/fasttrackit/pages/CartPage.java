package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;

public class CartPage extends PageObject {

    @FindBy(className = ".woocommerce-cart-form__contents")
    private List<WebElementFacade> productList;

    @FindBy(css = ".qty")
    private WebElementFacade productQuantity;

    @FindBy(css = ".product-subtotal .woocommerce-Price-amount")
    private List<WebElementFacade> prices;

    @FindBy(css = ".cart-subtotal .woocommerce-Price-amount")
    private WebElementFacade cartSubTotalPrice;

    @FindBy(css = ".order-total .woocommerce-Price-amount")
    private WebElementFacade cartTotalPrice;

    @FindBy(css = ".wc-proceed-to-checkout .checkout-button")
    private WebElementFacade proceedToCheckout;

    @FindBy(css = ".product-remove a")
    private WebElementFacade deleteProduct;

    @FindBy(className = ".woocommerce-message")
    private WebElementFacade successRemoveMessage;

    @FindBy(css = ".actions .button:nth-child(2)")
    private WebElementFacade updateCartButton;

    @FindBy(css = ".woocommerce-message")
    private WebElementFacade cartUpdateMessage;

    @FindBy(css = ".woocommerce .cart-empty")
    private WebElementFacade emptycartMessage;

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

    public void setProductQuantity(String value){
        typeInto(productQuantity, value);
    }

    public boolean checkProductQuantity(String quantity){
        return productQuantity.containsText(quantity);
    }

    public void prdctQuantity(String quantity){
        typeInto(productQuantity, quantity);
    }

    public int getPrices(){
        int sum = 0;
        for (WebElementFacade element : prices){
            String productPriceText = element.getText().replace(" lei", "").replace(",", "");
            int productPrice = Integer.valueOf(productPriceText);
            sum+=productPrice;
        }
        return sum;
    }


    public boolean checkSubTotalPrice(){
        String cartTotalExt = cartSubTotalPrice.getText().replace(" lei", "").replace(",", "");
        int cartSubTotalInt = Integer.valueOf(cartTotalExt);
        if (cartSubTotalInt == getPrices()){
            return true;
        }
        return false;
    }

    public boolean checkTotalPrice(){
        String cartTotalExt = cartTotalPrice.getText().replace(" lei", "").replace(",", "");
        int cartTotalInt = Integer.valueOf(cartTotalExt);
        if (cartTotalInt == getPrices()){
            return true;
        }
        return false;
    }

    public void goToCheckout(){
        clickOn(proceedToCheckout);
    }

    public void removeProductFromCart() {
        try {
            WebElement removeOption = getDriver().findElement(By.cssSelector(".cart_item .product-remove a"));
            removeOption.click();
        } catch ( StaleElementReferenceException error ){
            WebElement removeOption = getDriver().findElement(By.cssSelector(".cart_item .product-remove a"));
            waitFor(removeOption).click();
        }
    }

    public void removeProductFromCart1(){
        try{
            clickOn(deleteProduct);
        } catch ( StaleElementReferenceException error ){
            getDriver().navigate().refresh();
            clickOn(deleteProduct);
        }
    }


    public void updateTheCart(){
        clickOn(updateCartButton);
    }

    public boolean cartUpdate(String message){
        return cartUpdateMessage.containsText(message);
    }

    public boolean emptyCartText(String message){
        return emptycartMessage.containsText(message);
    }




}
