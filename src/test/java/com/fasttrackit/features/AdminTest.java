package com.fasttrackit.features;

import com.fasttrackit.steps.AdminSteps;
import com.fasttrackit.steps.LoginSteps;
import com.fasttrackit.util.BaseTest;
import com.fasttrackit.util.Constants;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class AdminTest extends BaseTest {

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private AdminSteps adminSteps;

    @Test
    public void createNewProductTest() throws InterruptedException {
        adminSteps.loginToAdminPage(Constants.USER_EMAIL_WORDPRESS, Constants.USER_PASS_WORDPRESS);
        adminSteps.createProduct("JACKETR", "IT IS A SUPER JACKET!",  "10", "20");
        adminSteps.checkProductPublishing("Product published.");

    }
}
