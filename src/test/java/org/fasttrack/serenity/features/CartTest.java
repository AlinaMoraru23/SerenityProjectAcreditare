package org.fasttrack.serenity.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.serenity.steps.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CartTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private SearchSteps searchSteps;

    @Steps
    private ProductSteps productSteps;

    @Steps
    private CartSteps cartSteps;


    @Test
    public void checkProductIsAddedToCart() {
        loginSteps.navigateToHomePage();
        searchSteps.searchItem("Polo");
        productSteps.addProductToCart();
        productSteps.clickViewCart();
        cartSteps.checkProductIsInCart("Polo");
    }

    @Test
    public void checkModifyProductQuantityInCart() {
        loginSteps.navigateToHomePage();
        searchSteps.searchItem("Polo");
        productSteps.addProductToCart();
        productSteps.clickViewCart();
        cartSteps.changeProductQuantity("3");
        cartSteps.checkProductQuantityIsUpdated(3);
    }

    @Test
    public void checkCartProductSubtotal(){
        loginSteps.navigateToHomePage();
        searchSteps.searchItem("Polo");
        productSteps.addProductToCart();
        productSteps.clickViewCart();
        cartSteps.changeProductQuantity("5");
        cartSteps.wait(5000);
        cartSteps.cartSubtotalCalculation();
        cartSteps.verifyProductSubtotalCalculation();


    }

    @Test
    public void checkRemoveItemFromCart(){
        loginSteps.navigateToHomePage();
        searchSteps.searchItem("Polo");
        productSteps.addProductToCart();
        searchSteps.searchItem("Cap");
        productSteps.addProductToCart();
        productSteps.clickViewCart();
        cartSteps.removeFirstItemFromCart();
        cartSteps.wait(200);
        cartSteps.checkProductWasRemovedFromCart("Polo");
    }

    @Test
    public void checkRemoveItemFromCartUndo(){
        loginSteps.navigateToHomePage();
        searchSteps.searchItem("Polo");
        productSteps.addProductToCart();
        searchSteps.searchItem("Cap");
        productSteps.addProductToCart();
        productSteps.clickViewCart();
        cartSteps.removeFirstItemFromCart();
        cartSteps.wait(1000);
        cartSteps.undoRemoveItemFromCart();
        cartSteps.wait(1000);
        cartSteps.checkProductIsInCart("Polo");

    }


}