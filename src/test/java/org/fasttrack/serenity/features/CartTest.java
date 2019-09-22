package org.fasttrack.serenity.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.serenity.steps.*;
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

    @Steps
    private CheckoutSteps checkoutSteps;


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
        cartSteps.cartProductSubtotalCalculation();
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
        cartSteps.waitForTextToDisappear("Polo");
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
        cartSteps.waitForTextToDisappear("Polo");
        cartSteps.undoRemoveItemFromCart();
        cartSteps.waitForTextToAppear("Polo");
        cartSteps.checkProductIsInCart("Polo");

    }

    @Test
    public void checkCartSubtotal(){
        loginSteps.navigateToHomePage();
        searchSteps.searchItem("Polo");
        productSteps.addProductToCart();
        searchSteps.searchItem("Cap");
        productSteps.addProductToCart();
        productSteps.clickViewCart();
        cartSteps.cartSubtotalCalculation();
        cartSteps.verifyCartSubtotalCalculation();

    }

    @Test
    public void checkCheckoutPageIsDisplayed(){
        loginSteps.navigateToHomePage();
        searchSteps.searchItem("Polo");
        productSteps.addProductToCart();
        productSteps.clickViewCart();
        cartSteps.clickCheckoutLink();
        checkoutSteps.isCheckoutPageDisplayed();

    }

    @Test
    public void checkCouponCodeIsDisplayedInCart(){
        loginSteps.navigateToHomePage();
        searchSteps.searchItem("Polo");
        productSteps.addProductToCart();
        productSteps.clickViewCart();
        cartSteps.useCouponCode("fixed10");
        cartSteps.verifyCouponCodeIsDisplayedInCartTotals("FIXED10");
    }

    @Test
    public void checkCartTotalWithCouponCode(){
        loginSteps.navigateToHomePage();
        searchSteps.searchItem("Polo");
        productSteps.addProductToCart();
        productSteps.clickViewCart();
        cartSteps.useCouponCode("fixed10");
        cartSteps.cartTotalCalculation();
        cartSteps.verifyCartTotalCalculationWithDiscount();
    }

    @Test
    public void checkPercentageDiscountCalculation(){
        loginSteps.navigateToHomePage();
        searchSteps.searchItem("Polo");
        productSteps.addProductToCart();
        productSteps.clickViewCart();
        cartSteps.useCouponCode("percentage20");
        cartSteps.percentageDiscountCalculation();
        cartSteps.verifyPercentageDiscountCalculation(20);
    }

}