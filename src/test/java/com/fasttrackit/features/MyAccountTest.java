package com.fasttrackit.features;

import com.fasttrackit.steps.LoginSteps;
import com.fasttrackit.steps.MyAccountSteps;
import com.fasttrackit.util.BaseTest;
import com.fasttrackit.util.Constants;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class MyAccountTest extends BaseTest {

    @Steps
    private MyAccountSteps myAccountSteps;

    @Steps
    private LoginSteps loginSteps;

    @Test
    public void changePassword(){
        loginSteps.login(Constants.USER_EMAIL, Constants.USER_PASS);
        myAccountSteps.changePassword(Constants.USER_PASS, Constants.USER_PASS, Constants.USER_NEWPASS);
    }

    @Test
    public void changePasswordBack(){
        loginSteps.login(Constants.USER_EMAIL, Constants.USER_NEWPASS);
        myAccountSteps.changePassword(Constants.USER_NEWPASS, Constants.USER_PASS, Constants.USER_PASS);
    }

    @Test
    public void changePassWithSpecialCharacters(){
        loginSteps.login(Constants.USER_EMAIL, Constants.USER_PASS);
        myAccountSteps.changePassword(Constants.USER_PASS, Constants.USER_PASSWORDSPECIALCHARACTERS, Constants.USER_PASSWORDSPECIALCHARACTERS);
    }

    @Test
    public void changePassBackFromSpecialCharacters(){
        loginSteps.login(Constants.USER_EMAIL, Constants.USER_PASSWORDSPECIALCHARACTERS);
        myAccountSteps.changePassword(Constants.USER_PASSWORDSPECIALCHARACTERS, Constants.USER_PASS, Constants.USER_PASS);
    }

    @Test
    public void changeBillingAddress(){
        loginSteps.login(Constants.USER_EMAIL, Constants.USER_PASS);
        myAccountSteps.changeBillingAddress("Adrian", "Adriann", "Bood", "Caucaz",
                "Moscova", "11111", "111222", "aadriaan2@yahoo.com", "Adrian Adriann");
    }

    @Test
    public void changeShippingAddress(){
        loginSteps.login(Constants.USER_EMAIL, Constants.USER_PASS);
        myAccountSteps.changeShippingAddress("Adrian", "Adrianul", "Bood",
                "Caucaz", "Moscova", "11111", "Adrian Adrianul");
    }

}
