package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonActionsWithElements {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected WebDriverWait webDriverWait_10;
    protected String baseUrl = "https://yazz.me/uk";

    public CommonActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
        webDriverWait_10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    protected void clickOnElement(WebElement webElement, String elementName) {
        try {
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info(elementName + " Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);
    }

    protected void checkUrlWithPattern() {
        try {
            Assert.assertTrue("Invalid page \n" + "Expected url: "
                    + baseUrl + "\n Actual url: "
                    + webDriver.getCurrentUrl(), webDriver.getCurrentUrl().matches(baseUrl));
            logger.info("Page was opened with correct URL");
        } catch (Exception e) {
            logger.error("Page was opened with incorrect URL");
            Assert.fail("Page was opened with incorrect URL");
        }
    }

    protected boolean isElementDisplayed(WebElement webElement, String elementName) {
        try {
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement));
            boolean state = webElement.isDisplayed();
            if (state) {
                logger.info(elementName + " Element is displayed");
            } else {
                logger.info(elementName + " Element is not displayed");
            }
            return state;
        } catch (Exception e) {
            logger.info(elementName +" Element is not displayed");
            return false;
        }
    }

    protected void checkElementIsDisplayed(WebElement webElement, String elementName) {
        Assert.assertTrue(elementName + " Element is not displayed", isElementDisplayed(webElement, elementName));
    }
}

