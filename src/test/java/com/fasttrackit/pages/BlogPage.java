package com.fasttrackit.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;
import java.util.List;

@DefaultUrl("http://qa3.fasttrackit.org:8008/blog")
public class BlogPage extends PageObject {

    @FindBy(css = ".reply .comment-reply-link")
    private WebElementFacade replyButtons;

    @FindBy(css = ".comment-content")
    private List<WebElementFacade> commentList;

    @FindBy(css = ".comment-form-comment #comment")
    private WebElementFacade commentField;

    @FindBy(id = "submit")
    private WebElementFacade submitButton;


    public void typeAComment(String text){
        typeInto(commentField, text);
    }

    public void clickSubmit(){
        clickOn(submitButton);
    }

}
