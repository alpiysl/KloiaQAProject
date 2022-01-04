package com.kloia.pages;

import com.kloia.utilities.BrowserUtils;
import lombok.Getter;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Getter
public class BestBuyPage extends BrowserUtils {
    private static final Logger logger = Logger.getLogger(BestBuyPage.class);

    @FindBy(xpath = "(//*[normalize-space()='United States'])[1]")
    private WebElementFacade selectUnitedStates;

    @FindBy(xpath = "(//button[@aria-label='Close'])[2]")
    private WebElementFacade closeSignUpPopUp;

    @FindBy(css = "#gh-search-input")
    private WebElementFacade searchBox;

    @FindBy(css = ".search-title")
    private WebElementFacade searchTitle;

    @FindBy(css = ".header-search-button")
    private WebElementFacade submitButton;

    @FindBy(xpath = "//button[normalize-space()='Account']")
    private WebElementFacade accountButton;

    @FindBy(xpath = "//button[contains(normalize-space(),'Hi')]")
    private WebElementFacade signedInAccounButton;

    @FindBy(xpath = "//*[normalize-space()='Sign In']")
    private WebElementFacade signInButton;

    @FindBy(id = "brand_facet-search-bar-input")
    private WebElementFacade searchBrand;

    @FindBy(css = ".c-button-link.button")
    private WebElementFacade searchedBrand;

    @FindBy(css = ".sku-title")
    private List<WebElementFacade> itemsList;

    @FindBy(xpath = "(//button[@class='save-for-later-save'])[1]")
    private WebElementFacade saveItem;

    @FindBy(xpath = "//button[contains(@class,'savedItem')]")
    private WebElementFacade savedItems;

    @FindBy(css = "a.v-line-clamp")
    private WebElementFacade productTitleInSavedItem;

    public WebElementFacade mainButton(String button){
        return $("//button[normalize-space()='"+button+"']");
    }

    public WebElementFacade itemType(String itemType){
        return $("//a[normalize-space()='"+itemType+"']");
    }
}
