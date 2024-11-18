package com.framework.android.testcases.searchScreenTests;

import com.framework.android.screens.onboardingFlowPages.ScreensPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.screens.userBlockPages.UserBlockPage;
import com.framework.android.utils.CommonHelper;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class SearchScreenTest {

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_609, TC_610, TC_611, TC_613, TC_623] Verify 3 categories should be showing on landing screen (i) Recent Searches (ii) Trending Tags (iii) Most Followed people. Of which recent search will show only if user has searched anything.",
            groups = {"regression", "search_screen"})
    public void verifySearchScreenAndRecentSearch(String language) throws Exception {
        if((language.equalsIgnoreCase("English")) || (language.equalsIgnoreCase("Hindi"))){
            LanguageDataProvider.setCurrentLanguage(language);
            LoginKooPage loginKooPage = new LoginKooPage();
            loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
            ScreensPage screensPage = new ScreensPage();
            CommonHelper.clickOnSearchIcon();
            screensPage.verifyTrendingTagHeading(LanguageDataProvider.getLanguageDataValue("TrendingTagsHeading"));
            screensPage.verifyTrendingTags("#");
            screensPage.verifyMostFollowedPeopleAndHeading(LanguageDataProvider.getLanguageDataValue("MostFollowedPeopleHeading"));
            screensPage.verifyRecentSearch(ConfigReader.getValue("autoTestUserID"),LanguageDataProvider.getLanguageDataValue("RecentSearchHeading"),ConfigReader.getValue("autoTestUser"));
        }
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_614, TC_618] Verify typing keywords, suggestions should show of tags & profiles, with 'See all Results' button at the bottom.",
            groups = {"regression", "search_screen"})
    public void verifySeeAllResultsLink(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        ScreensPage screensPage = new ScreensPage();
        CommonHelper.clickOnSearchIcon();
        CommonHelper.enterValueInSearchBar("#India");
        CommonHelper.clickOnSearchBarField();
        screensPage.verifySearchAllResultsLink();
        screensPage.clickOnSearchAllResultLink();
        screensPage.verifySearchAllResultSubTabs(LanguageDataProvider.getLanguageDataValue("SearchAllResultSubTabs"));
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_621] Verify no search results text should show when there are no results to show, in all the tabs.",
            groups = {"regression", "search_screen"})
    public void verifyNoResultFoundMessage(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        ScreensPage screensPage = new ScreensPage();
        CommonHelper.clickOnSearchIcon();
        CommonHelper.enterValueInSearchBar(RandomStringUtils.randomAlphabetic(10));
        CommonHelper.clickOnSearchBarField();
        CommonHelper.clickEnterButton();
        screensPage.verifyNoResultFoundMessage(LanguageDataProvider.getLanguageDataValue("NoResultFoundMessage"));
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_619, TC_620] Verify All tabs contains top 5 trending tags, top 5 profile results & some koos in search results, and people should contain all profile reuslts, hashtags should contain all trending tags results & koo should contain all koos results.",
            groups = {"regression", "search_screen"})
    public void verifyAllTabsDataOnSearchResults(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("userNameAuto"));
        ScreensPage screensPage = new ScreensPage();
        CommonHelper.clickOnSearchIcon();
        CommonHelper.enterValueInSearchBar("#Modi");
        Thread.sleep(2000);
        CommonHelper.clickOnSearchBarField();
        CommonHelper.clickEnterButton();
        String tabName = LanguageDataProvider.getLanguageDataValue("SearchAllResultTabs");
        // Click on All Tab and verify data
        screensPage.clickOnTab(tabName.split(", ")[0]);
        screensPage.verifyDataInAllSubTab("#Modi");

        // Click on People tab and verify data
        screensPage.clickOnTab(tabName.split(", ")[1]);
        screensPage.verifyProfileResults();

        // Click on HashTags tab and verify data
        screensPage.clickOnTab(tabName.split(", ")[2]);
        screensPage.verifyTrendingTags("#Modi");

        // Click on Koos tab and verify data
        screensPage.clickOnTab(tabName.split(", ")[3]);
        screensPage.verifyKoos();
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_624] Verify pagination for search results upon scrolling",
            groups = {"regression", "search_screen"})
    public void verifyPaginationOnSearchResult(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("userNameAuto"));
        ScreensPage screensPage = new ScreensPage();
        CommonHelper.clickOnSearchIcon();
        CommonHelper.enterValueInSearchBar("modi");
        CommonHelper.clickOnSearchBarField();
        Thread.sleep(2000);
        CommonHelper.hideKeyboard();
        screensPage.verifyPagination(10);
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_612] Verify user should be able to follow profiles in followed people section & followed profile should disappear after relaunch.",
            groups = {"regression", "search_screen"})
    public void verifyUserCanFollowProfile(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        UserBlockPage userBlockPage = new UserBlockPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("userNameAuto"));
        ScreensPage screensPage = new ScreensPage();
        CommonHelper.clickOnSearchIcon();
        screensPage.clickFollowPeople();
        userBlockPage.verifyNoButton(LanguageDataProvider.getLanguageDataValue("NoButtonLeft"), language);
        userBlockPage.clickOkButton();
    }
}
