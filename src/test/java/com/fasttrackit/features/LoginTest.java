package com.fasttrackit.features;


import com.fasttrackit.steps.ForgotPasswordSteps;
import com.fasttrackit.steps.HomeSteps;
import com.fasttrackit.steps.LoginSteps;
import com.fasttrackit.steps.MyAccountSteps;
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

    @Steps
    private MyAccountSteps myAccountSteps;


    @Test
    public void navigateToLogin(){
        loginSteps.navigateToLoginPage();
    }

    @Test
    public void validLoginTest(){
        loginSteps.login(Constants.USER_EMAIL, Constants.USER_PASS);
        loginSteps.checkIfYouAreLoggedIn("Hello aadriaan2");
    }

    @Test
    public void invalidEmailTest(){
        loginSteps.login("aadriaan2@yahoocom", Constants.USER_PASS);
        loginSteps.checkIfYouAreNotLoggedIn();
    }

    @Test
    public void invalidPassLoginTest(){
        loginSteps.login(Constants.USER_EMAIL, "123123");
        loginSteps.checkIfYouAreNotLoggedIn();
    }

    @Test
    public void emptyPasswrodTest(){
        loginSteps.login(Constants.USER_EMAIL, "");
        loginSteps.checkIfYouAreNotLoggedIn();
    }

    @Test
    public void emptyUserEmailTest(){
        loginSteps.login("", Constants.USER_PASS);
        loginSteps.checkIfYouAreNotLoggedIn();
    }

    @Test
    public void emptyUserEmailAndPasswordTest(){
        loginSteps.login("", "");
        loginSteps.checkIfYouAreNotLoggedIn();
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

    @Test
    public void logoutTest(){
        loginSteps.login(Constants.USER_EMAIL, Constants.USER_PASS);
        loginSteps.checkIfYouAreLoggedIn("Hello aadriaan2");
        loginSteps.logout();
        loginSteps.checkIfYouAreNotLoggedIn();
    }

    





}
