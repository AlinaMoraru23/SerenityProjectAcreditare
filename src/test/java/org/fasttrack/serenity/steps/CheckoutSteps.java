package org.fasttrack.serenity.steps;


import net.thucydides.core.annotations.Step;
import org.fasttrack.serenity.pages.BasePage;
import org.fasttrack.serenity.pages.CartPage;
import org.fasttrack.serenity.pages.CheckoutPage;
import org.junit.Assert;

public class CheckoutSteps {

    private CheckoutPage checkoutPage;
    private BasePage basePage;
    private CartPage cartPage;


    @Step
    public void isCheckoutPageDisplayed() {
        Assert.assertTrue("User is not redirected to Checkout Page", checkoutPage.isUserInCheckoutPage());
    }


    String orderNumberValue;

    public String getOrderNumberValue(){
        return orderNumberValue;
    }

    @Step
    public void clickPlaceOrder() {
        checkoutPage.clickPlaceOrder();
        checkoutPage.waitForTextToAppear("ORDER RECEIVED");
        checkoutPage.getOrderNumber();
        orderNumberValue = checkoutPage.getOrderNumber();

    }

    @Step
    public void isOrderConfirmationPageDisplayed() {
        Assert.assertTrue("User is not redirected to Checkout - Order Confirmation Page", checkoutPage.isUserInOrderConfirmationPage());
    }



}
