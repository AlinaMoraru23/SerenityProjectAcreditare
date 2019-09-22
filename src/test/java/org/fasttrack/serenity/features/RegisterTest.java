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
        loginSteps.performAdminLogin();
        adminSteps.openUsers();
        adminSteps.verifyUsernameIsInAdminUserList(Constants.USER_NAME);
    }

}
