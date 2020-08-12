package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebElement;


@DefaultUrl("http://qa3.fasttrackit.org:8008/wp-login.php")
public class WordPressPage extends PageObject {

    @FindBy(id = "user_login")
    private WebElementFacade userEmail;

    @FindBy(id = "user_pass")
    private WebElementFacade userPass;

    @FindBy(id = "wp-submit")
    private WebElementFacade logInButton;

    @FindBy(id = "menu-posts-product")
    private WebElementFacade productsCategory;

    @FindBy(css = ".wrap > a:nth-child(2)")
    private WebElementFacade addNewProduct;

    @FindBy(css = "#title")
    private WebElementFacade productName;

    @FindBy(css = "#postdivrich #content")
    private WebElementFacade productContent;

    @FindBy(css = "#_regular_price")
    private WebElementFacade regularPrice;

    @FindBy(css = ".inventory_options")
    private WebElementFacade productInventory;

    @FindBy(id = "_sku")
    private WebElementFacade productStock;

    @FindBy(css = "#publishing-action")
    private WebElementFacade publish;

    @FindBy(css = ".wrap > #message")
    private WebElementFacade productPublishedMessage;

    @FindBy(css = ".edit-visibility span")
    private WebElementFacade productVisibility;

    @FindBy(id = "visibility-radio-public")
    private WebElementFacade publicVisibility;

    @FindBy(css = "#post-visibility-select .save-post-visibility")
    private WebElementFacade okButtonForVisibility;

    @FindBy(id = "qt_content_strong")
    private WebElementFacade boldOption;


    public void typeUserEmail(String email){
        typeInto(userEmail, email);
    }

    public void typeUserPass(String pass){
        typeInto(userPass, pass);
    }

    public void clickLogIn(){
        clickOn(logInButton);
    }

    public void clickOnProducts(){
        clickOn(productsCategory);
    }

    public void clickAddNewProduct(){
        clickOn(addNewProduct);
    }

    public void setProductName(String product){
        typeInto(productName, product);
    }

    public void writeProductContent(String content){
        typeInto(productContent, content);
    }

    public void productPrice(String price){
        typeInto(regularPrice, price);
    }

    public void clickInventory(){
        clickOn(productInventory);
    }

    public void setProductStock(String stock){
        typeInto(productStock, stock);
    }

    public void publishProduct(){
        
    }

    public boolean checkPublishedMessage(String text){
        return productPublishedMessage.containsText(text);
    }

    public void editVisibility(){
        clickOn(productVisibility);
    }

    public void setPublicVisibility(){
        clickOn(publicVisibility);
    }

    public void pressOkForVisibilityOption(){
        clickOn(okButtonForVisibility);
    }

    public void selectBoldText(){
        clickOn(boldOption);
    }


}
