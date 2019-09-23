package org.fasttrack.serenity.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("http://qa5.fasttrackit.org:8008/?page_id=7")
public class LoginPage extends PageObject {

    @FindBy(id = "username")
    private WebElementFacade loginUserNameOrEmailAddressField;

    @FindBy(id = "password")
    private WebElementFacade loginPasswordField;

    @FindBy(css = "button[name = 'login']")
    private WebElementFacade loginButton;

    @FindBy(id = "reg_email")
    private WebElementFacade registerEmailAddressField;

    @FindBy(id = "reg_password")
    private WebElementFacade registerPasswordField;

    @FindBy(css = "button[name = 'register']")
    private WebElementFacade registerButton;

    @FindBy (css ="[class*='LostPassword'] a")
    private WebElementFacade lostPasswordLink;


    public void setLoginUserNameOrEmailAddressField(String email){
        typeInto(loginUserNameOrEmailAddressField, email);
    }

    public void setLoginPasswordField(String password) {
        typeInto(loginPasswordField, password);
    }

    public void clickLoginButton(){
        clickOn(loginButton);
    }

    public void setRegisterEmailAddressField(String email){
        typeInto(registerEmailAddressField,email);
    }

    public void setRegisterPasswordField(String password){
        typeInto(registerPasswordField,password);
    }

    public void clickRegisterButton(){
        clickOn(registerButton);
    }





}
