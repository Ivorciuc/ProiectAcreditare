package com.fasttrackit.features;


import com.fasttrackit.steps.ForgotPasswordSteps;
import com.fasttrackit.steps.HomeSteps;
import com.fasttrackit.steps.LoginSteps;
import com.fasttrackit.util.BaseTest;
import com.fasttrackit.util.Constants;
import io.vavr.collection.List;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class LoginTest extends BaseTest {


    @Steps
    private LoginSteps loginSteps;

    @Steps
    private HomeSteps homeSteps;

    @Steps
    private ForgotPasswordSteps forgotPasswordSteps;


    @Test
    public void navigateToLogin(){
        loginSteps.navigateToLoginPage();
    }

    @Test
    public void validLoginTest(){
        loginSteps.login(Constants.USER_EMAIL, Constants.USER_PASS);

    }

    @Test
    public void invalidEmailTest(){
        loginSteps.login("aadriaan2@yahoocom", Constants.USER_PASS);
        loginSteps.verifyNotLoggedIn();
    }

    @Test
    public void invalidPassLoginTest(){
        loginSteps.login(Constants.USER_EMAIL, "123123");
        loginSteps.verifyNotLoggedIn();
    }

    @Test
    public void emptyPasswrodTest(){
        loginSteps.login(Constants.USER_EMAIL, "");
        loginSteps.verifyNotLoggedIn();
    }

    @Test
    public void emptyUserEmailTest(){
        loginSteps.login("", Constants.USER_PASS);
        loginSteps.verifyNotLoggedIn();
    }

    @Test
    public void emptyUserEmailAndPasswordTest(){
        loginSteps.login("", "");
        loginSteps.verifyNotLoggedIn();
    }

    @Test
    public void validForgotPassOption(){
        loginSteps.navigateToLoginPage();
        forgotPasswordSteps.validForgotPass(Constants.USER_EMAIL);
    }

    @Test
    public void invalidEmailForForgotPass(){
        loginSteps.navigateToLoginPage();
        forgotPasswordSteps.invalidForgotPass("aadriaan22@yahoo.com");
    }

    





}
