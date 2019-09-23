package org.fasttrack.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class BasePageAdmin extends BasePage {

    protected BasePage basePage;

    @FindBy(id="search-submit")
    private WebElementFacade searchButton;

    @FindBy(id="the-list")
    private WebElementFacade bodyList;


    @FindBy(css=".submitdelete")
    private WebElementFacade deleteLink;

    @FindBy(css="[class*='has-row-actions']")
    private WebElementFacade rowActions;

    public void clickSearchButton(){
        clickOn(searchButton);
    }

    public boolean doesListContain(String text){
        return bodyList.containsText(text);
    }

    public void deleteItem(){
        clickOn(deleteLink);
    }

    public void enableRowActions() {
        clickOn(rowActions);
    }

}
