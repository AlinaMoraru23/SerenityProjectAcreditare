package org.fasttrack.serenity.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrack.serenity.Util.Constants;
import org.fasttrack.serenity.pages.*;
import org.junit.Assert;
import org.yecht.Data;

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
    public void performAdminLogin(String email, String password){
        loginPage.setLoginUserNameOrEmailAddressField(email);
        loginPage.setLoginPasswordField(password);
        loginPage.clickLoginButton();
        adminOrdersPage.open();

    }

    @Step
    public void checkLoggedOut(){
        Assert.assertTrue("Logout not performed",homePage.isLoggedOut());
    }

    @Step
    public void performRegister(String email, String password){
        loginPage.setRegisterEmailAddressField(email);
        loginPage.setRegisterPasswordField(password);
        loginPage.clickRegisterButton();
    }


}
