package org.fasttrack.serenity.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.serenity.pages.*;
import org.junit.Assert;
import org.yecht.Data;


public class AdminSteps {

    @Steps
    CheckoutSteps checkoutSteps;

    private AdminOrdersPage adminOrdersPage;
    private AdminUsersPage adminUsersPage;
    private CheckoutPage checkoutPage;
    private BasePageAdmin basePageAdmin;
    private AdminCouponsPage adminCouponsPage;


    @Step
    public void openOrdersPage() {
        adminOrdersPage.open();
    }

    @Step
    public void openUsersPage() {
        adminUsersPage.open();
    }

    @Step
    public void openCouponsPage() {
        adminCouponsPage.open();
    }

    @Step
    public void verifyOrderNumber() {
        String orderNumber = checkoutSteps.getOrderNumberValue();
        System.out.println("verify order number - last step" + orderNumber);
        Assert.assertTrue("The order number was not found in the Orders List", adminOrdersPage.doesListContain(orderNumber));

    }

    @Step
    public void verifyTextInBodyList(String text) {
        Assert.assertTrue("The text was not found in the body list", basePageAdmin.doesListContain(text));
    }

    @Step
    public void searchItemInAdminUsersPage(String searchItem) {
        adminUsersPage.setSearchField(searchItem);
        basePageAdmin.clickSearchButton();
    }

    @Step
    public void deleteItem() {
        basePageAdmin.enableRowActions();
        basePageAdmin.deleteItem();
    }

    @Step
    public void confirmDeletion() {
        adminUsersPage.confirmDeletion();
    }

    @Step
    public void createCoupon(String couponTitle, String discountType, String couponAmount) {
        adminCouponsPage.clickAddCoupon();
        adminCouponsPage.setCouponTitle(couponTitle);
        adminCouponsPage.selectDiscountType(discountType);
        adminCouponsPage.setCouponAmount(couponAmount);
        adminCouponsPage.clickPublishButton();
    }

    @Step
    public void searchItemInAdminCouponsPage(String searchItem) {
        adminCouponsPage.setSearchField(searchItem);
        basePageAdmin.clickSearchButton();
    }

}

