package com.fasttrackit.steps;

import com.fasttrackit.pages.HomePage;
import com.fasttrackit.pages.LostPasswordPage;
import com.fasttrackit.pages.MyAccountPage;
import com.fasttrackit.pages.MyDashboardPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class ForgotPasswordSteps {

    private HomePage homePage;
    private MyAccountPage myAccountPage;
    private LostPasswordPage lostPasswordPage;


    @Step
    public void validForgotPass(String email){
        lostPasswordPage.forgotPassButton();
        Assert.assertTrue(lostPasswordPage.setLostPassMessage());
        lostPasswordPage.setEmailField(email);
        lostPasswordPage.setResetPasswordButton();
        Assert.assertTrue(lostPasswordPage.setResetPassEmailMessage());
    }

    @Step
    public void invalidForgotPass(String email){
        lostPasswordPage.forgotPassButton();
        Assert.assertTrue(lostPasswordPage.setLostPassMessage());
        lostPasswordPage.setEmailField(email);
        lostPasswordPage.setResetPasswordButton();
        Assert.assertTrue(lostPasswordPage.setinvalidEmailForForgottenPass());
    }

}
