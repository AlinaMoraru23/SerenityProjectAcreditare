package org.fasttrack.serenity.features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.fasttrack.serenity.Util.Constants;
import org.fasttrack.serenity.steps.LoginSteps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


@RunWith(SerenityRunner.class)
public class LoginTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;


    @Steps
    private LoginSteps loginSteps;


    @Test
    public void validLoginTestWithEmailAddress() {
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin(Constants.USER_EMAIL, Constants.USER_PASS);
        loginSteps.checkLoggedIn(Constants.USER_NAME);
    }

    @Test
    public void validLoginTestWithUsername(){
        loginSteps.navigateToLoginPage();
        loginSteps.performLogin(Constants.USER_NAME, Constants.USER_PASS);
        loginSteps.checkLoggedIn(Constants.USER_NAME);
    }

}
