package org.fasttrack.serenity.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrack.serenity.Util.Constants;
import org.fasttrack.serenity.pages.*;
import org.junit.Assert;

public class LoginSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;
    private AdminOrdersPage adminOrdersPage;

    private CartPage cartPage;

    @Step
    public void navigateToHomePage(){
        homePage.open();
    }

    @Step
    public void navigateToLoginPage(){
        loginPage.open();
    }

    @Step
    public void performLogin(String email, String password){
        loginPage.setLoginUserNameOrEmailAddressField(email);
        loginPage.setLoginPasswordField(password);
        loginPage.clickLoginButton();
    }

    @Step
    public void checkLoggedIn(String username){
        Assert.assertTrue("Login not performed",accountPage.isLoggedIn(username));
    }

    @Step
    public void logout(){
        homePage.clickLogoutLink();
    }

    @Step
    public void performAdminLogin(){
        loginPage.setLoginUserNameOrEmailAddressField(Constants.ADMIN_EMAIL);
        loginPage.setLoginPasswordField(Constants.ADMIN_PASS);
        loginPage.clickLoginButton();
        adminOrdersPage.open();

    }

    @Step
    public void checkLoggedOut(){
        Assert.assertTrue("Logout not performed",homePage.isLoggedOut());
    }

}
