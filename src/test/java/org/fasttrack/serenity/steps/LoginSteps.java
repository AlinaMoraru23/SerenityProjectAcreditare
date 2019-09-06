package org.fasttrack.serenity.steps;

import net.thucydides.core.annotations.Step;
import org.fasttrack.serenity.pages.AccountPage;
import org.fasttrack.serenity.pages.HomePage;
import org.fasttrack.serenity.pages.LoginPage;
import org.junit.Assert;

public class LoginSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private AccountPage accountPage;

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
}
