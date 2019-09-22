package org.fasttrack.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class AccountPage extends PageObject {

    @FindBy (css ="[class*='MyAccount-content']")
    private WebElementFacade helloText;



    public boolean isLoggedIn(String userName){
        return helloText.containsText(userName);
    }


}
