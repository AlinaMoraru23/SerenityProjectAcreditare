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
public class RegisterTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    LoginSteps loginSteps;

    @Steps
    AdminSteps adminSteps;

    @Test
    public void checkUserIsInAdminUserList(){
        loginSteps.navigateToLoginPage();
        loginSteps.performAdminLogin(Constants.ADMIN_EMAIL,Constants.ADMIN_PASS);
        adminSteps.openUsersPage();
        adminSteps.verifyTextInBodyList(Constants.USER_NAME);
    }

    @Test
    public void checkRegisterANewUser(){
        loginSteps.navigateToLoginPage();
        loginSteps.performRegister(Constants.REGISTER_EMAIL, Constants.REGISTER_PASS);
        loginSteps.logout();
        loginSteps.navigateToLoginPage();
        loginSteps.performAdminLogin(Constants.ADMIN_EMAIL,Constants.ADMIN_PASS);
        adminSteps.openUsersPage();
        adminSteps.verifyTextInBodyList(Constants.REGISTER_USERNAME);
        adminSteps.searchItemInAdminUsersPage(Constants.REGISTER_USERNAME);
        adminSteps.deleteItem();
        adminSteps.confirmDeletion();
    }

}
