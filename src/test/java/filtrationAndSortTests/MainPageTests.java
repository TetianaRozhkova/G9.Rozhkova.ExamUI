package filtrationAndSortTests;

import baseTest.BaseTest;
import libs.Util;
import org.junit.Before;
import org.junit.Test;

public class MainPageTests extends BaseTest {
    @Before
    public void setPreconditions() {
        pageProvider.getMainPage().openMainPage();
        pageProvider.getMainPage().checkIsRedirectOnMainPage();
    }

    @Test
    public void TC001_FiltrationByGuidesDueToModalWindowFilters() {
        pageProvider.getMainPage().clickOnButtonFilters();
        pageProvider.getMainPage().rememberTextFromButtonShowNPropositions();
        pageProvider.getMainPage().clickOnFieldGuides();
        pageProvider.getMainPage().checkIsFieldGuidesInSelected();
        pageProvider.getMainPage().waitTextInButtonShowNPropositionsChanged();
        pageProvider.getMainPage().clickOnButtonShowNPropositions();
        pageProvider.getMainPage().waitTillModalWindowFiltersIsClosed().checkIsRedCircleNearButtonFiltersDisplayed()
                .checkTextFishingWithGuideIsPresentInTicketOffer();
    }

    @Test
    public void TC002_ChangeUkrLanguageToEngOnMainPage() {
        pageProvider.getMainPage()
                .clickOnButtonUkrLanguage()
                .clickOnFieldEnglish();
        Util.waitABit(1);
        pageProvider.getMainPage().checkIsButtonEngLanguageDisplayed()
                .checkIsTitleYazzFishingInUkraineDisplayed();
    }

    @Test
    public void TC003_ChangeCurrencyOnMainPageFromUAHToRON() {
        pageProvider.getMainPage()
                .checkCurrencyTextIsPresentInTicketOfferPrice("грн")
                .clickOnButtonCurrency()
                .checkIsModalWindowCurrencyIsDisplayed()
                .clickOnFieldRON()
                .checkIsModalWindowCurrencyIsNotDisplayed()
                .checkCurrencyTextIsPresentInTicketOfferPrice("RON");
    }

    @Test
    public void TC004_ChangeCityOnMainPageFromKyivToLviv() {
        pageProvider.getMainPage()
                .clickOnButtonLocation()
                .clickOnFieldKyiv()
                .checkCityTextIsPresentInTicketOffer("Київ")
                .clickOnButtonLocation()
                .checkIsModalWindowLocationIsDisplayed()
                .clickOnFieldLviv()
                .checkIsModalWindowLocationIsNotDisplayed()
                .checkCityTextIsPresentInTicketOffer("Львів");
    }

    @Test
    public void TC005_SortTicketsOffersFromCheapToExpensive() {
        pageProvider.getMainPage()
                .checkCurrencyTextIsPresentInTicketOfferPrice("грн")
                .clickOnButtonSort()
                .clickOnDropdownCheapToExpensive()
                .checkIsRedCircleInButtonSortDisplayed()
                .checkIsTicketsOffersSortedFromCheapToExpensive();
    }
}
