package org.fasttrack.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/wp-admin/users.php")
public class AdminUsersPage extends PageObject {

    @FindBy(id="the-list")
    WebElementFacade userList;

    public boolean doesListContain(String text){

        return userList.containsText(text);
    }



}
