package org.fasttrack.serenity.pages;


import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;


public class CheckoutPage extends BasePage {

    protected BasePage basePage;

    @FindBy(css = ".post-title")
    private WebElementFacade pageTitle;

    @FindBy(css = "#place_order")
    private WebElementFacade placeOrderButton;

    @FindBy(css = "li[class$=order] strong")
    private WebElementFacade orderNumberElement;

    public boolean isUserInCheckoutPage() {
        return pageTitle.containsText("CHECKOUT");
    }

    public void clickPlaceOrder() {
        clickOn(placeOrderButton);
        basePage.waitABit(5000);
    }

    public boolean isUserInOrderConfirmationPage() {
        return pageTitle.containsText("ORDER RECEIVED");
    }

    String orderNumber;

    public String getOrderNumber() {
        orderNumber = "#"+orderNumberElement.getText();
        System.out.println("the order number is " +orderNumber);
        return orderNumber;

    }


}