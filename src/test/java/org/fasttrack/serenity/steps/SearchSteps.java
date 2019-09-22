package org.fasttrack.serenity.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrack.serenity.pages.HomePage;
import org.fasttrack.serenity.pages.ProductPage;
import org.fasttrack.serenity.pages.SearchResultsPage;
import org.junit.Assert;

public class SearchSteps {

    private HomePage homePage;
    private ProductPage productPage;
    private SearchResultsPage searchResultsPage;

    @Step
    public void searchItem(String searchItem) {
        homePage.setSearchField(searchItem);
        homePage.clickSearchButton();
    }

    @Step
    public void checkSearchedItemIsDispayed(String searchItem) {
        Assert.assertTrue("Result doesn't contain the searched item", productPage.isProductInResult(searchItem));
    }

    @Step
    public void checkSearchedItemsAreDisplayed(String searchItem){
        Assert.assertTrue("Not all results contain the searched item", searchResultsPage.isProductInResults(searchItem));

    }



}