package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.List;


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

    @FindBy(className = "row-title")
    private List<WebElementFacade> productsAlreadyCreated;

    @FindBy(css = "#delete-action a")
    private WebElementFacade deleteProductButton;

    @FindBy(id = "message")
    private WebElementFacade movedToTrashMessage;

    @FindBy(id = "post-search-input")
    private WebElementFacade searchBar;

    @FindBy(id = "search-submit")
    private WebElementFacade searchButton;

    @FindBy(id = "wp-admin-bar-wp-logo")
    private WebElementFacade wordHome;

    @FindBy(id = "wp-admin-bar-archive")
    private WebElementFacade viewProductsOnTheSite;

    @FindBy(className = "column-comment")
    private WebElementFacade reviewSection;

    @FindBy(id = "no-comments")
    private WebElementFacade noCommentsWarning;

    @FindBy(id = "menu-comments")
    private WebElementFacade openCommentsSection;

    @FindBy(css = "#the-comment-list .column-comment")
    private List<WebElementFacade> commentList;

    @FindBy(className = ".check-column input[type='checkbox']")
    private WebElementFacade checkColumn;

    @FindBy(id = "bulk-action-selector-top")
    private WebElementFacade bulkOption;

    @FindBy(id = "doaction")
    private WebElementFacade applyButton;



    public void typeUserEmail(String email){
        typeInto(userEmail, email);
    }

    public void typeUserPass(String pass){
        typeInto(userPass, pass);
    }

    public void clickLogIn(){
        clickOn(logInButton);
    }

    public void openProducts(){
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
        clickOn(publish);
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

    public boolean selectFromProductsCreated(String productName){
        for (WebElementFacade products: productsAlreadyCreated){
            if (products.getText().equals(productName)){
                products.click();
                return true;
            }
        }
        return false;
    }

    public void setDeleteProductButton(){
        clickOn(deleteProductButton);
    }

    public boolean setMovedToTrashMessage(String message){
        return movedToTrashMessage.containsText(message);
    }

    public void typeInSearchBar(String text){
        typeInto(searchBar, text);
    }

    public void clickSearch(){
        clickOn(searchButton);
    }

    public void openWordHome(){
        clickOn(wordHome);
    }

    public void checkProductsOnTheWebSite(){
        clickOn(viewProductsOnTheSite);
    }

    public void getProductPrice(){
        regularPrice.getText();
    }

    public void approveReview(){
        Actions action = new Actions(getDriver());
        WebElement column = getDriver().findElement(By.cssSelector(".column-comment"));
        action.moveToElement(column).moveToElement(getDriver().findElement(By.cssSelector(".approve"))).click().build().perform();
    }

    public void unapproveReview(){
        Actions action = new Actions(getDriver());
        WebElement column = getDriver().findElement(By.cssSelector(".column-comment"));
        action.moveToElement(column).moveToElement(getDriver().findElement(By.cssSelector(".unapprove"))).click().build().perform();
    }

    public void deleteReview(){
        Actions action = new Actions(getDriver());
        WebElement column = getDriver().findElement(By.cssSelector(".column-comment"));
        action.moveToElement(column).moveToElement(getDriver().findElement(By.cssSelector(".trash a"))).click().build().perform();

    }

    public boolean noCommentsMessage(){
        return noCommentsWarning.isDisplayed();
    }

    public void openComments(){
        clickOn(openCommentsSection);
    }








}
