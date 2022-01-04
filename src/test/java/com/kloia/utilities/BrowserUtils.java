package com.kloia.utilities;

import com.kloia.pages.PageInitialize;
import lombok.NoArgsConstructor;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@NoArgsConstructor
public class BrowserUtils extends PageInitialize {

    public void switchToNewWindow(String oldWindowHandle) {
        Set<String> windows = getDriver().getWindowHandles();
        for (String w : windows) {
            if (!w.equals(oldWindowHandle)) {
                getDriver().switchTo().window(w);
                break;
            }
        }
    }

    public void wait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickWithJS(WebElementFacade element) {
        getJavascriptExecutorFacade().executeScript("arguments[0].scrollIntoView(true);", element);
        getJavascriptExecutorFacade().executeScript("arguments[0].click();", element);
    }

}
