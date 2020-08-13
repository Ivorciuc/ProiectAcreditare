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
    public void postACommentTest() {
        loginSteps.login(Constants.USER_EMAIL, Constants.USER_PASS);
        loginSteps.checkIfYouAreLoggedIn("Hello aadriaan2");
        blogSteps.writeAComment("ce faci");
    }


}
