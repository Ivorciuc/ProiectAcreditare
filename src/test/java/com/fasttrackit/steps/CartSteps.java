package com.fasttrackit.steps;

import com.fasttrackit.pages.CartPage;
import com.fasttrackit.pages.ProductPage;
import com.fasttrackit.pages.SearchResultsPage;
import net.thucydides.core.annotations.Step;

public class CartSteps {

    private ProductPage productPage;
    private CartPage cartPage;
    private SearchResultsPage searchResultsPage;

    @Step
    public void findProductInCart(String productName){
        cartPage.productList(productName);
    }

}
