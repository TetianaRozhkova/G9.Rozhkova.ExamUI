package pages;

import data.TestData;
import libs.Util;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MainPage extends CommonActionsWithElements {

    @FindBy(xpath = "//h1[@class ='mr-4 text-xl font-medium']")
    private WebElement headerWithTextYazz;
    @FindBy(xpath = "//button[@class='n-button n-button--primary-type n-button--medium-type button hidden md:flex button--center']//div[@class='n-badge n-badge--dot badge badge--dot-medium badge--dot-placement-top-right']")
    private WebElement buttonFilters;
    @FindBy(xpath = "//div[text ()='Тип оператора']//..//div[text()='Гіди']")
    private WebElement fieldGuides;
    @FindBy(xpath = "//div[@class='flex select-none items-center space-x-1.5 whitespace-nowrap rounded-sm border text-sm cursor-pointer border-transparent bg-primary-1 px-2 py-1 mb-1 mr-1']")
    private WebElement fieldGuidesInSelected;
    @FindBy(xpath = "//button[@class='n-button n-button--primary-type n-button--medium-type button min-w-full xs:min-w-[240px] button--center h-11']")
    private WebElement buttonShowNPropositions;
    @FindBy(xpath = "//div[@class='pointer-events-auto relative flex w-full flex-col bg-white overflow-hidden rounded shadow-lg']")
    private WebElement modalWindowFilters;
    @FindBy(xpath = "//button[@class='n-button n-button--primary-type n-button--medium-type button hidden md:flex button--center']//sup[@class='n-badge-sup']")
    private WebElement redCircleNearButtonFilters;
//список тікетів пропозицій
    @FindBy(xpath = "//a[@class='flex h-full flex-col']")
    private List<WebElement> listOfTicketsOffers;
//елементи в середині кожного тікета пропозиції
    private String elementWithTextFishingWithGuideInTicketOffer = ".//*[text()='Риболовля з гідом']";
    private String elementWithPriceTextInTicketOffer = ".//span[@class='whitespace-nowrap text-base font-medium']";
    private String elementWithCurrencyTextInTicketOfferPrice = ".//div[@class='flex flex-wrap items-baseline text-sm']";
    private String elementWithCityTextInTicketOffer = ".//div[@class='min-w-0 flex-1 text-sm text-gray-7 truncate']";

    @FindBy(xpath = "//span[@class = 'rounded-sm border border-gray-4 mr-1.5 h-4 fi-ua']")
    private WebElement buttonUkrLanguage;
    @FindBy(xpath = "//div[text()='English']")
    private WebElement fieldEngLanguage;
    @FindBy(xpath = "//span[@class='rounded-sm border border-gray-4 mr-1.5 h-4 fi-gb']")
    private WebElement buttonEngLanguage;
    @FindBy(xpath = "//footer[@class='sticky inset-x-0 bottom-0 z-50']//button[2]")
    private WebElement buttonCurrency;
    @FindBy(xpath = "//div[contains(text(),'RON')]")
    private WebElement fieldRonCurrency;
    @FindBy(xpath = "//div[@class='pointer-events-auto relative flex w-full flex-col bg-white overflow-hidden rounded shadow-lg']")
    private WebElement modalWindowCurrency;
    @FindBy(xpath = "//footer//button[@class='n-button n-button--primary-type n-button--medium-type button button--center']//div[@class='flex max-w-24 items-center xs:max-w-44']")
    private WebElement buttonLocation;
    @FindBy(xpath = "//div[@class='n-popover n-popover-shared max-w-[calc(100vw-32px)] xs:max-w-[500px]']//div[6]/button/span")
    private WebElement buttonKyiv;
    @FindBy(xpath = "//div[@class='n-popover n-popover-shared max-w-[calc(100vw-32px)] xs:max-w-[500px]']//div[10]/button/span")
    private WebElement buttonLviv;
    @FindBy(xpath = "//div[@class='space-y-4']")
    private WebElement modalWindowLocation;
    @FindBy(xpath = "//button[@class='n-button n-button--default-type n-button--small-type n-button--ghost button button--justify h-8']")
    private WebElement buttonSort;
    @FindBy(xpath = "//div[contains(text(), 'Від дешевих до дорогих')]")
    private WebElement dropDownCheapToExpensive;
    @FindBy(xpath = "//sup[@class='n-badge-sup']")
    private WebElement redCircleInButtonSort;


    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openMainPage() {
        try {
            webDriver.get(baseUrl);
            logger.info("Main page was opened " + baseUrl);
        } catch (Exception e) {
            logger.error("Can not open Main page" + e);
            Assert.fail("Can not open Main page" + e);
        }
    }

    public MainPage checkIsRedirectOnMainPage() {
        checkUrlWithPattern();
        Assert.assertTrue("Invalid page Not Main page", isTextYazzDisplayed());
        Assert.assertTrue("Invalid page Not Main page", isButtonFiltersDisplayed());
        return this;
    }

    public boolean isTextYazzDisplayed() {
        return isElementDisplayed(headerWithTextYazz, "Header with text 'Yazz'");
    }

    public boolean isButtonFiltersDisplayed() {
        return isElementDisplayed(buttonFilters, "Button 'Фільтри'");
    }

    public void clickOnButtonFilters() {
        clickOnElement(buttonFilters, "Button 'Фільтри'");
    }

    public void clickOnFieldGuides() {
        clickOnElement(fieldGuides, "Field 'Гіди'");
    }

    public void checkIsFieldGuidesInSelected() {
        checkElementIsDisplayed(fieldGuidesInSelected, "In select Field 'Гіди'");
    }

    public MainPage clickOnButtonShowNPropositions() {
        clickOnElement(buttonShowNPropositions, "Button 'Показати N пропозицій'");
        return this;
    }

    public MainPage waitTillModalWindowFiltersIsClosed() {
        webDriverWait_10.withMessage("Modal windowFilters is not closed")
                .until(ExpectedConditions.invisibilityOf(modalWindowFilters));
        return this;
    }

    public MainPage checkIsRedCircleNearButtonFiltersDisplayed() {
        checkElementIsDisplayed(redCircleNearButtonFilters, "'Red Circle Near Button Filters'");
        return this;
    }

    public void rememberTextFromButtonShowNPropositions() {
        String textFromButtonShowNPropositions = buttonShowNPropositions.getText();
        logger.info("Text from Button 'Показати N пропозицій' is: " + textFromButtonShowNPropositions);
        TestData.textFromButtonShowNPropositions = textFromButtonShowNPropositions;
    }

    public void waitTextInButtonShowNPropositionsChanged() {
        webDriverWait_10.until(ExpectedConditions
                .not(ExpectedConditions.textToBePresentInElement(buttonShowNPropositions, TestData.textFromButtonShowNPropositions)));
    }

    public MainPage checkTextFishingWithGuideIsPresentInTicketOffer() {
        for (int i = 0; i < 4; i++) {
            Assert.assertTrue("Element with text 'Риболовля з гідом' is not present in ticket offer",
                    listOfTicketsOffers.get(i).findElement(By.xpath(elementWithTextFishingWithGuideInTicketOffer)).isDisplayed());
            logger.info("Element with text 'Риболовля з гідом' is present in ticket offer: " + listOfTicketsOffers.get(i).getText());
        }
        return this;
    }

    public MainPage clickOnButtonUkrLanguage() {
        clickOnElement(buttonUkrLanguage, "'Button Ukr Language'");
        return this;
    }

    public MainPage clickOnFieldEnglish() {
        clickOnElement(fieldEngLanguage, "Field 'English'");
        return this;
    }

    public MainPage checkIsButtonEngLanguageDisplayed() {
        checkElementIsDisplayed(buttonEngLanguage, "'Button Eng Language'");
        return this;
    }

    public MainPage checkIsTitleYazzFishingInUkraineDisplayed() {
        Assert.assertTrue("Ukr language is not changed to Eng", headerWithTextYazz.getText().contains("Yazz — fishing in Ukraine"));
        logger.info("Ukr language is changed to Eng");
        return this;
    }

    public MainPage clickOnButtonCurrency() {
        clickOnElement(buttonCurrency, "'Button Currency'");
        return this;
    }

    public MainPage clickOnFieldRON() {
        clickOnElement(fieldRonCurrency, "Field 'RON' Currency");
        return this;
    }

    public MainPage checkCurrencyTextIsPresentInTicketOfferPrice(String currencyName) {
        Util.waitABit(1);
        for (int i = 0; i < 4; i++) {
            String textInElement = listOfTicketsOffers.get(i).findElement(By.xpath(elementWithCurrencyTextInTicketOfferPrice)).getText();
            Assert.assertTrue("Currency '" + currencyName + "' is not present in ticket offer price ", textInElement.contains(currencyName));
            logger.info("Currency '" + currencyName + "' is present in ticket offer price " + textInElement);
        }
        return this;
    }

    public MainPage checkIsModalWindowCurrencyIsDisplayed() {
        checkElementIsDisplayed(modalWindowCurrency, "'Modal Window Currency'");
        return this;
    }

    public MainPage checkIsModalWindowCurrencyIsNotDisplayed() {
        webDriverWait_10.withMessage("Modal windowCurrency is not closed").until(ExpectedConditions.invisibilityOf(modalWindowCurrency));
        return this;
    }

    public MainPage clickOnButtonLocation() {
        clickOnElement(buttonLocation, "'Button Location'");
        return this;
    }

    public MainPage clickOnFieldKyiv() {
        clickOnElement(buttonKyiv, "Field 'Київ'");
        return this;
    }

    public MainPage checkCityTextIsPresentInTicketOffer(String cityName) {
        Util.waitABit(2);
        for (int i = 0; i < 4; i++) {
            String textInElement= listOfTicketsOffers.get(i).findElement(By.xpath(elementWithCityTextInTicketOffer)).getText();
            Assert.assertTrue("Text '"+ cityName +"' is not present in ticket offer " + textInElement, textInElement.contains(cityName));
            logger.info("Text '" + cityName + "' is present in ticket offer " + textInElement);
        }
        return this;
    }

    public MainPage clickOnFieldLviv() {
        clickOnElement(buttonLviv, "Field 'Львів'");
        return this;
    }

    public MainPage checkIsModalWindowLocationIsDisplayed() {
        checkElementIsDisplayed(modalWindowLocation, "'Modal Window Location'");
        return this;
    }

    public MainPage checkIsModalWindowLocationIsNotDisplayed() {
        webDriverWait_10.withMessage("Modal windowLocation is not closed").until(ExpectedConditions.invisibilityOf(modalWindowLocation));
        return this;
    }

    public MainPage clickOnButtonSort() {
        clickOnElement(buttonSort, "Button 'Sort'");
        return this;
    }

    public MainPage clickOnDropdownCheapToExpensive() {
        clickOnElement(dropDownCheapToExpensive, "Dropdown 'Від дешевих до дорогих'");
        return this;
    }

    public MainPage checkIsRedCircleInButtonSortDisplayed() {
        checkElementIsDisplayed(redCircleInButtonSort, "'Red Circle In Button Sort'");
        return this;
    }

    public MainPage checkIsTicketsOffersSortedFromCheapToExpensive() {
        Util.waitABit(1);
        for (int i = 0; i < 4; i++) {
            String currentTicketOfferPrice = listOfTicketsOffers.get(i).findElement(By.xpath(elementWithPriceTextInTicketOffer)).getText().replace(" грн", "");
            String nextTicketOfferPrice = listOfTicketsOffers.get(i + 1).findElement(By.xpath(elementWithPriceTextInTicketOffer)).getText().replace(" грн", "");
            Assert.assertTrue("Tickets offers are not sorted from cheap to expensive: currentTicketOfferPrice " + currentTicketOfferPrice + "> nextTicketOfferPrice of " + nextTicketOfferPrice, Integer.parseInt(currentTicketOfferPrice) <= Integer.parseInt(nextTicketOfferPrice));
            logger.info("Tickets offers are sorted from cheap to expensive: currentTicketOfferPrice of "+ currentTicketOfferPrice + " <= nextTicketOfferPrice of " + nextTicketOfferPrice);
        }
        return this;
    }
}
