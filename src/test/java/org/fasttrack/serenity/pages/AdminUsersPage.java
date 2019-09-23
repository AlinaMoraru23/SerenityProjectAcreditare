package org.fasttrack.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;



@DefaultUrl("http://qa5.fasttrackit.org:8008/wp-admin/users.php")
public class AdminUsersPage extends BasePageAdmin {

    protected BasePageAdmin basePageAdmin;


    @FindBy(id="user-search-input")
    private  WebElementFacade searchField;


    @FindBy(id="submit")
    private WebElementFacade confirmDeleteButton;


    public void setSearchField(String searchItem){
        typeInto(searchField,searchItem);
    }

    public void confirmDeletion(){
        clickOn(confirmDeleteButton);

    }

}
