package org.fasttrack.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;


import java.util.List;

public class SearchResultsPage extends PageObject {

    @FindBy(css = ".collection_title h3")
    private List<WebElementFacade> searchResultItemsTitle;

//method checks if all results contain the searched text -> breaks at first element that doesn't contain the text
    public boolean isProductInResults(String searchItem) {
        for (WebElementFacade element : searchResultItemsTitle) {
            if (!element.getText().contains(searchItem)) {
                System.out.println("if element"+ element.getText());
                return false;
            }
        }
        return true;
    }
}