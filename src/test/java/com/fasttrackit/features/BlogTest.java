package com.fasttrackit.features;

import com.fasttrackit.steps.AdminSteps;
import com.fasttrackit.steps.BlogSteps;
import com.fasttrackit.steps.LoginSteps;
import com.fasttrackit.util.BaseTest;
import com.fasttrackit.util.Constants;
import io.vavr.collection.List;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class BlogTest extends BaseTest {

    @Steps
    private BlogSteps blogSteps;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private AdminSteps adminSteps;

    @Test
    public void postACommentLikeCustomerTest() {
        loginSteps.login(Constants.USER_EMAIL, Constants.USER_PASS);
        loginSteps.checkIfYouAreLoggedIn("Hello aadriaan2");
        blogSteps.writeAComment("how are you?");
    }

    @Test
    public void postACommentLikeAdminTest(){
        adminSteps.loginToAdminPage(Constants.USER_EMAIL_WORDPRESS, Constants.USER_PASS_WORDPRESS);
        blogSteps.navigateToBlogPage();
        blogSteps.writeAComment("I'm the admin.");
    }

    @Test
    public void postAReply(){
        loginSteps.login(Constants.USER_EMAIL, Constants.USER_PASS);
        loginSteps.checkIfYouAreLoggedIn("Hello aadriaan2");
        blogSteps.writeAReply("This is a reply!!");
    }


}
