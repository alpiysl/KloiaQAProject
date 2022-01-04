package com.kloia.stepDefs;

import com.kloia.steps.BestBuySteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.util.Map;

public class StepDefinitions {

    @Steps
    BestBuySteps steps;

    @Given("user should be on the {string} page")
    public void userShouldBeOnThePage(String url) {
        steps.userShouldBeOnTheExpectedPage(url);
    }

    @Then("the title should be {string}")
    public void theTitleShouldBe(String title) {
        steps.pageTitleIsExpected(title);
    }

    @When("user searches {string} item")
    public void userSearchesItem(String item) {
        steps.userSearchesAnItem(item);
    }

    @Then("user should get {string} items as a result")
    public void userShouldGetItemsAsAResult(String item) {
        steps.userEnsuresExpectedItemListed(item);
    }

    @And("user navigates to sign in page")
    public void userNavigatesToSignInPage() {
        steps.userNavigatesToSignInPage();
    }

    @When("user signs in with {string} email and {string} password")
    public void userSignsInWithEmailAndPassword(String email, String password) {
        steps.userSignsInWithValidCredentials(email, password);
    }

    @Then("user should be signed in")
    public void userShouldBeSignedIn() {
        steps.ensureThatUserLoggedIn();
    }

    @When("user clicks on sign in with Google")
    public void userClicksOnSignInWithGoogle() {
        steps.userClicksOnSignInWithGoogle();
    }

    @And("user signs in with {string} email and {string} password with Google")
    public void userSignsInWithEmailAndPasswordWithGoogle(String email, String password) {
        steps.userLogsInWithGoogleAccount(email, password);
    }

    @And("user navigates to expected item under menu option")
    public void userNavigatesToExpectedItemUnderMenuOption(Map<String, String> item) {
        steps.userClicksOnMenu();
        steps.userSelectsDepartmentUnderMainMenu(item.get("Department"));
        steps.userSelectsTypeUnderDepartment(item.get("Type"));
        steps.userSelectsItemType(item.get("item Type"));
    }

    @And("user searches {string} brand and selects")
    public void userSearchesBrandAndSelects(String brandName) {
        steps.userSearchesBrand(brandName);
        steps.userSelectsSearchedBrand();
    }

    @When("user saves second item")
    public void userSavesSecondItem() {
        steps.userSavesSecondItem();
    }

    @And("navigates to saved items tab")
    public void navigatesToSavedItemsTab() {
        steps.userNavigatesToSavedItemsTab();
    }

    @Then("user ensures that saved item is shown expected")
    public void userEnsuresThatSavedItemIsShownExpected() {
        steps.userEnsuresThatItemIsInTheSavedItemsTab();
    }
}
