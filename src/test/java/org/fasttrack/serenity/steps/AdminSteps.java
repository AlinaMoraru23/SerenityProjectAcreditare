package org.fasttrack.serenity.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.serenity.pages.AdminOrdersPage;
import org.fasttrack.serenity.pages.AdminUsersPage;
import org.fasttrack.serenity.pages.CheckoutPage;
import org.junit.Assert;


public class AdminSteps {

    @Steps
    CheckoutSteps checkoutSteps;

    private AdminOrdersPage adminOrdersPage;
    private AdminUsersPage adminUsersPage;
    private CheckoutPage checkoutPage;


    @Step
    public void openWooCommerce() {
        adminOrdersPage.open();
    }

    @Step
    public void openUsers() {
        adminUsersPage.open();
    }

    @Step
    public void verifyOrderNumber() {
        String orderNumber = checkoutSteps.getOrderNumberValue();
        System.out.println("verify order number - last step" + orderNumber);
        Assert.assertTrue("The order number was not found in the Orders List", adminOrdersPage.doesListContain(orderNumber));

    }

    @Step
    public void verifyUsernameIsInAdminUserList(String user) {
        Assert.assertTrue("The username was not found in the Username List", adminUsersPage.doesListContain(user));
    }
}

