package com.fasttrackit.features;

import com.fasttrackit.steps.SearchSteps;
import com.fasttrackit.steps.ShopSteps;
import com.fasttrackit.util.BaseTest;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class SearchTest extends BaseTest {

    @Steps
    SearchSteps searchSteps;

    @Steps
    ShopSteps shopSteps;

    @Test
    public void checkIfSearchBarWorks() throws AWTException {
        shopSteps.openShopPage();
        searchSteps.typeInSearchField("sunglasses");
        searchSteps.pressEnterToSearch();
        searchSteps.checkIfProductAppeared("");
    }

    @Test
    public void emptySearchBarTest() throws AWTException {
        shopSteps.openShopPage();
        searchSteps.typeInSearchField("");
        searchSteps.pressEnterToSearch();
        searchSteps.checkIfNothingFoundMessageAppeared();
    }

    @Test
    public void searchWithSpecialCharacter() throws AWTException {
        shopSteps.openShopPage();
        searchSteps.typeInSearchField("`@#");
        searchSteps.pressEnterToSearch();
        searchSteps.checkIfNothingFoundMessageAppeared();

    }


}
