package com.kloia.steps;

import com.kloia.utilities.BrowserUtils;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Collections;
import java.util.Set;

import static org.junit.Assert.*;

public class BestBuySteps extends BrowserUtils {

    private String expectedItemName;

    @Step("user should be on the expected page")
    public void userShouldBeOnTheExpectedPage(String url) {
        getDriver().get(url);
        if (getDriver().getTitle().contains("Select your Country")) {
            clickOn(bestBuyPage.getSelectUnitedStates());
        }
        if (bestBuyPage.getCloseSignUpPopUp().isDisplayed()) {
            clickOn(bestBuyPage.getCloseSignUpPopUp());
        }
    }

    @Step("user ensures that the page title is expected")
    public void pageTitleIsExpected(String title) {
        assertEquals(title, getDriver().getTitle());
    }

    @Step("user searches an item")
    public void userSearchesAnItem(String item) {
        typeInto(bestBuyPage.getSearchBox(), item);
        clickOn(bestBuyPage.getSubmitButton());
    }

    @Step("user ensures that expected item(s) is/are listed")
    public void userEnsuresExpectedItemListed(String item) {
        assertTrue(getDriver().getTitle().contains(item.toLowerCase()));
        assertTrue(bestBuyPage.getSearchTitle().getText().contains(item.toLowerCase()));
    }

    @Step("user navigates to sign in page")
    public void userNavigatesToSignInPage() {
        try {
            bestBuyPage.getAccountButton().waitUntilClickable();
            clickOn(bestBuyPage.getAccountButton());
        } catch (Exception e) {
            clickWithJS(bestBuyPage.getAccountButton());
        }
        try {
            bestBuyPage.getSignInButton().waitUntilVisible();
            bestBuyPage.getSignInButton().waitUntilClickable();
            clickOn(bestBuyPage.getSignInButton());
        } catch (Exception e) {
            clickWithJS(bestBuyPage.getSignInButton());
        }
    }

    @Step("user signs in with valid credentials")
    public void userSignsInWithValidCredentials(String email, String password) {
        signInPage.logIn(email, password);
    }

    @Step("user ensures that user logged in")
    public void ensureThatUserLoggedIn() {
        try {
            bestBuyPage.getSignedInAccounButton().waitUntilClickable();
            clickOn(bestBuyPage.getSignedInAccounButton());
        } catch (Exception e) {
            clickWithJS(bestBuyPage.getSignedInAccounButton());
        }
        assertTrue(signInPage.getSignOutButton().isDisplayed());
    }

    @Step("user clicks on sign in with Google")
    public void userClicksOnSignInWithGoogle() {
        clickOn(signInPage.getSignInWithGoogleButton());
    }

    @Step("user logs in with Google account with valid credentials")
    public void userLogsInWithGoogleAccount(String email, String password) {
        String currentWindow = signInPage.getDriver().getWindowHandle();
        switchToNewWindow(currentWindow);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        typeInto(signInPage.getGoogleEmailBox(), email);
        clickOn(signInPage.getGoogleEmailNext());
        typeInto(signInPage.getGooglePassword(), password);
        clickOn(signInPage.getGooglePasswordNext());
        String currentWindow2 = signInPage.getDriver().getWindowHandle();
        switchToNewWindow(currentWindow2);
        wait(10);
        if (signInPage.getLastPass().isCurrentlyVisible()) {
            typeInto(signInPage.getLastEmail(), email);
            signInPage.getLastPass().typeAndEnter("test_user12");
        }
    }

    @Step("user clicks on main menu button")
    public void userClicksOnMenu() {
        clickOn(bestBuyPage.mainButton("Menu"));
    }

    @Step("user selects department under main menu")
    public void userSelectsDepartmentUnderMainMenu(String department) {
        clickOn(bestBuyPage.mainButton(department));
    }

    @Step("user selects type under department")
    public void userSelectsTypeUnderDepartment(String type) {
        clickOn(bestBuyPage.mainButton(type));
    }

    @Step("user select item type")
    public void userSelectsItemType(String itemType) {
        clickOn(bestBuyPage.itemType(itemType));
    }

    @Step("user searches a brand")
    public void userSearchesBrand(String brand) {
        typeInto(bestBuyPage.getSearchBrand(), brand);
    }

    @Step("user selects searched brand")
    public void userSelectsSearchedBrand() {
        clickOn(bestBuyPage.getSearchedBrand());
    }

    @Step("user saves second item")
    public void userSavesSecondItem() {
        wait(5);
        expectedItemName = bestBuyPage.getItemsList().get(1).getText();
        System.out.println(expectedItemName);
        clickOn(bestBuyPage.getItemsList().get(1));
        clickOn(bestBuyPage.getSaveItem());
    }

    @Step("user navigates to saved items tab")
    public void userNavigatesToSavedItemsTab() {
        clickOn(bestBuyPage.getSavedItems());
    }

    @Step("user ensures that expected item is on the saved items tab")
    public void userEnsuresThatItemIsInTheSavedItemsTab() {
        wait(5);
        assertEquals(expectedItemName, bestBuyPage.getProductTitleInSavedItem().getText());
    }
}
