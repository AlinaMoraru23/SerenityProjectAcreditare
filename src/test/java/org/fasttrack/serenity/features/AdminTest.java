package org.fasttrack.serenity.features;


import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.serenity.Util.Constants;
import org.fasttrack.serenity.steps.AdminSteps;
import org.fasttrack.serenity.steps.LoginSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class AdminTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    private LoginSteps loginSteps;

    @Steps
    private AdminSteps adminSteps;

    @Test
    public void checkCreatingPercentageDiscountCouponCode() {
        loginSteps.navigateToLoginPage();
        loginSteps.performAdminLogin(Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);
        adminSteps.openCouponsPage();
        adminSteps.createCoupon("20percentage", "Percentage discount", "20");
        adminSteps.openCouponsPage();
        adminSteps.searchItemInAdminCouponsPage("20percentage");
        adminSteps.verifyTextInBodyList("Percentage discount");
        adminSteps.verifyTextInBodyList("20");
        adminSteps.deleteItem();
    }

    @Test
    public void checkCreatingFixedCartDiscountCouponCode() {
        loginSteps.navigateToLoginPage();
        loginSteps.performAdminLogin(Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);
        adminSteps.openCouponsPage();
        adminSteps.createCoupon("10fixed", "Fixed cart discount", "10");
        adminSteps.openCouponsPage();
        adminSteps.searchItemInAdminCouponsPage("10fixed");
        adminSteps.verifyTextInBodyList("Fixed cart discount");
        adminSteps.verifyTextInBodyList("10");
        adminSteps.deleteItem();
    }

    @Test
    public void checkCreatingFixedProductDiscountCouponCode() {
        loginSteps.navigateToLoginPage();
        loginSteps.performAdminLogin(Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);
        adminSteps.openCouponsPage();
        adminSteps.createCoupon("15fixedproduct", "Fixed product discount", "15");
        adminSteps.openCouponsPage();
        adminSteps.searchItemInAdminCouponsPage("15fixedproduct");
        adminSteps.verifyTextInBodyList("Fixed product discount");
        adminSteps.verifyTextInBodyList("15");
        adminSteps.deleteItem();
    }


}