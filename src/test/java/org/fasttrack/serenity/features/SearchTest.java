package org.fasttrack.serenity.features;



import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.serenity.steps.LoginSteps;
import org.fasttrack.serenity.steps.SearchSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(SerenityRunner.class)
public class SearchTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private SearchSteps searchSteps;


    @Test

    public void searchItemSingleResultDisplayed(){
        loginSteps.navigateToHomePage();
        searchSteps.searchItem("Cap");
        searchSteps.checkSearchedItemIsDispayed("Cap");
    }

    @Test
    public void searchItemMultipleResultsDisplayed(){
        loginSteps.navigateToHomePage();
        searchSteps.searchItem("T-Shirt");
        searchSteps.checkSearchedItemsAreDisplayed("T-Shirt");
    }



}
