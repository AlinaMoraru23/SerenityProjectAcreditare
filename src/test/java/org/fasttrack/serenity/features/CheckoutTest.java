package org.fasttrack.serenity.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.serenity.Util.Constants;
import org.fasttrack.serenity.steps.*;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class CheckoutTest {

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

    @Steps
    private AdminSteps adminSteps;


    @Test
    public void checkOrderConfirmationPageIsDisplayed() {
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        searchSteps.searchItem("Polo");
        productSteps.addProductToCart();
        productSteps.clickViewCart();
        cartSteps.clickCheckoutLink();
        checkoutSteps.clickPlaceOrder();
        checkoutSteps.isOrderConfirmationPageDisplayed();

    }

    //test not finished - cannot transfer order number
    @Ignore
    public void checkOrderWasSentToServer() {
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        searchSteps.searchItem("Polo");
        productSteps.addProductToCart();
        productSteps.clickViewCart();
        cartSteps.clickCheckoutLink();
        checkoutSteps.clickPlaceOrder();
        loginSteps.logout();
        loginSteps.navigateToLoginPage();
        loginSteps.performAdminLogin();
        adminSteps.openWooCommerce();
        adminSteps.verifyOrderNumber();


    }

}
