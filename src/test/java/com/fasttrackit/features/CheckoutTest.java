package com.fasttrackit.features;

import com.fasttrackit.steps.CartSteps;
import com.fasttrackit.steps.CheckoutSteps;
import com.fasttrackit.steps.LoginSteps;
import com.fasttrackit.steps.SearchSteps;
import com.fasttrackit.util.BaseTest;
import com.fasttrackit.util.Constants;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;

public class CheckoutTest extends BaseTest {

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private SearchSteps searchSteps;

    @Steps
    private CartSteps cartSteps;

    @Steps
    private CheckoutSteps checkoutSteps;


}
