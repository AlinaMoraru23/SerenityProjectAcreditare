package org.fasttrack.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;


@DefaultUrl("http://qa5.fasttrackit.org:8008/wp-admin/edit.php?post_type=shop_order")
public class AdminOrdersPage extends BasePage {

    protected BasePage basePage;


    @FindBy(id="the-list")
    private WebElementFacade ordersList;

    public boolean doesListContain(String text){
        basePage.waitABit(2000);
        return ordersList.containsText(text);
    }

}

