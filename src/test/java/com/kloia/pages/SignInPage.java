package com.kloia.pages;

import com.kloia.utilities.BrowserUtils;
import lombok.Getter;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

@Getter
public class SignInPage extends BrowserUtils {

    @FindBy(css = "#fld-e")
    private WebElementFacade emailBox;

    @FindBy(css = "#fld-p1")
    private WebElementFacade passwordBox;

    @FindBy(id = "logout-button")
    private WebElementFacade signOutButton;

    @FindBy(xpath = "//button[normalize-space()='Sign in with Google']")
    private WebElementFacade signInWithGoogleButton;

    @FindBy(id = "identifierId")
    private WebElementFacade googleEmailBox;

    @FindBy(name = "password")
    private WebElementFacade googlePassword;

    @FindBy(id = "identifierNext")
    private WebElementFacade googleEmailNext;

    @FindBy(id = "passwordNext")
    private WebElementFacade googlePasswordNext;

    @FindBy(xpath = "//input[contains(@id,'email')]")
    private WebElementFacade lastEmail;

    @FindBy(id = "fld-p1")
    private WebElementFacade lastPass;

    public void logIn(String email, String password) {
        typeInto(emailBox, email);
        typeInto(passwordBox, password);
        passwordBox.sendKeys(Keys.ENTER);
    }
}
