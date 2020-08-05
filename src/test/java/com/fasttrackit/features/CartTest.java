package com.fasttrackit.features;

import com.fasttrackit.steps.CartSteps;
import com.fasttrackit.steps.LoginSteps;
import com.fasttrackit.util.BaseTest;
import com.fasttrackit.util.Constants;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;


public class CartTest extends BaseTest {

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private CartSteps cartSteps;



}

