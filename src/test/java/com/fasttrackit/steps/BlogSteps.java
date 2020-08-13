package com.fasttrackit.steps;

import com.fasttrackit.pages.BlogPage;
import net.thucydides.core.annotations.Step;

public class BlogSteps {

    private BlogPage blogPage;

    @Step
    public void writeAComment(String text){
        blogPage.open();
        blogPage.typeAComment(text);
        blogPage.clickSubmit();
    }


}
