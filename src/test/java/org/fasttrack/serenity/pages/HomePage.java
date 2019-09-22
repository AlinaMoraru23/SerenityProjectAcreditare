package org.fasttrack.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/")
public class HomePage extends PageObject {

    @FindBy (css ="input[name='s']")
    WebElementFacade searchField;

    @FindBy (css ="button.searchsubmit")
    WebElementFacade searchButton;

    @FindBy(css= ".logout")
    WebElementFacade logoutLink;

    @FindBy (css ="#error-page a")
    WebElementFacade logoutConfirmationLink;

    @FindBy(id="mastheads")
    WebElementFacade siteHeader;

    public void setSearchField (String searchItem){
        typeInto(searchField,searchItem);
    }

    public void clickSearchButton(){
        clickOn(searchButton);
    }

    public void clickLogoutLink(){
        clickOn(logoutLink);
    }

    public boolean isLoggedOut(){
        return !siteHeader.containsText("Welcome");
    }

}
