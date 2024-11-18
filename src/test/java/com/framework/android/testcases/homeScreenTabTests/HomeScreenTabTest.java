package com.framework.android.testcases.homeScreenTabTests;

import com.framework.android.screens.homeScreenTabsPages.HomeScreenTabPage;
import com.framework.android.screens.onboardingFlowPages.OnBoardingFlowPage;
import com.framework.android.screens.onboardingFlowPages.ScreensPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.CommonHelper;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class HomeScreenTabTest {
    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_080] Verify Home icon, Trending tag icon, Search icon, Chat icon & Notifications icon on bottom navigation bar.",
            groups = {"regression", "homeTab_screen"})
    public void verifyBottomNavigationBarIcons(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        homeScreenTabPage.verifyHomeIcon()
                .verifySearchIcon()
                .verifyChatIcon()
                .verifyNotificationIcon()
                .verifyTrendingTagIcon();
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_081] Verify the bottom bar icon micro-animation/transitions.(Home, trending, search, chat, notification icons)",
            groups = {"regression", "homeTab_screen"})
    public void verifyBottomNavigationBarIconsTransition(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        CommonHelper.clickOnChatButton();
        homeScreenTabPage.verifyStartConversationButton();
        CommonHelper.clickOnNotificationButton();
        homeScreenTabPage.verifyNotificationPreferencesBtn();
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_083] Verify the following tabs on the home screen: \n" +
                    " Feed, People, Topics, Trending, Entertainment, Business, Cricket, Exclusive, Videos, Polls, Latest, Following, New, Popular & Freinds tab.",
            groups = {"regression", "homeTab_screen"})
    public void verifyTabsOnHeaderForHomePage(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        homeScreenTabPage.verifyRedDotIndicator();
        String[] array = LanguageDataProvider.getLanguageDataValue("HomePageTabs").split(",");
        List<String> expectedTabsTextList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            expectedTabsTextList.add(array[i]);
        }
        homeScreenTabPage.verifyHeaderTabs(expectedTabsTextList);
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_084, TC_091] Verify red dot should be shown on second tab on entering feed & dot should switch as we move on to next tab & disappear at the last tab.",
            groups = {"regression", "homeTab_screen"})
    public void verifyRedDotOnNextTab(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        String[] array = LanguageDataProvider.getLanguageDataValue("HomePageTabs").split(",");
        List<String> expectedTabsTextList = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            expectedTabsTextList.add(array[i]);
        }
        homeScreenTabPage.verifyRedDotOnNextTabAndDisappearForLastTab(expectedTabsTextList, LanguageDataProvider.getLanguageDataValue("LastTabText"));
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_085] Verify Only 5 Tabs are shown for new user in English & Hindi languages; 4 tabs in all other languages. 1st tab Feed; 2nd tab People; 3rd tab Trending; 4th tab Topics (En & Hi), 5th tab Nearby , 6th tab Chatrooms (En & Hi).",
            groups = {"regression", "homeTab_screen"}, enabled = false)
    public void verifyTabsForNewUser(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("autoNewUser"));

        // Expected list for 3 tabs for English and Hindi language
        List<String> expectedThreeTabs = Arrays.asList(LanguageDataProvider.getLanguageDataValue("FeedTabText"),
                LanguageDataProvider.getLanguageDataValue("PeopleTabText"),
                LanguageDataProvider.getLanguageDataValue("TopicsTabText"));

        // Expected list for 4 tabs for all languages except English and Hindi
        List<String> expectedFourTabs = Arrays.asList(LanguageDataProvider.getLanguageDataValue("FeedTabText"),
                LanguageDataProvider.getLanguageDataValue("PeopleTabText"),
                LanguageDataProvider.getLanguageDataValue("TopicsTabText"),
                LanguageDataProvider.getLanguageDataValue("TrendingTabText"));

        if (language.equalsIgnoreCase("English") || language.equalsIgnoreCase("Hindi")) {
            homeScreenTabPage.verifyHeaderTabs(expectedThreeTabs);
        } else {
            homeScreenTabPage.verifyHeaderTabs(expectedFourTabs);
        }
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_093] Verify tapping on bird icon on any home screen tab, user should land on feed & screen should refresh.",
            groups = {"regression", "homeTab_screen"})
    public void verifyKooBirdFunctionality(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
        ScreensPage screensPage = new ScreensPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        homeScreenTabPage.clickOnAnyTabFromHomePage(LanguageDataProvider.getLanguageDataValue("PeopleTabText"));
        CommonHelper.clickOnKooBird();
        screensPage.verifyFeedPageForExistingUser(language, LanguageDataProvider.getLanguageDataValue("FeedTabText"));
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_094] Verify on tapping on tab headers user should navigate to top of the tab.",
            groups = {"regression", "homeTab_screen"})
    public void verifyOnClickOfTabUserRedirectsToTopOfThePage(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        homeScreenTabPage.verifyTopOfThePage(LanguageDataProvider.getLanguageDataValue("FeedTabText"));
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_088] Verify Carousels, Banners, Dynamic Banners & Banner functinality on home screen tabs",
            groups = {"regression", "homeTab_screen"})
    public void verifyBannersOnFeedPage(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("userNameAuto"));
        homeScreenTabPage.verifyDynamicBanner();

        // regexExpression > Is for Piramal Capital & Housing Finance Limited banner
        homeScreenTabPage.verifyBannersOnFeedPage("L");
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_089, TC_090] Verify refresh icon on top right corner & tapping on it screen should refresh & user should go to top of the feed.",
            groups = {"regression", "homeTab_screen"})
    public void verifyTrendingKooPageAndRefreshIconOnTrendingKoo(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        CommonHelper.clickTrendingKooIcon();
        homeScreenTabPage.verifyTrendingKooPageHeading(LanguageDataProvider.getLanguageDataValue("TrendingKooHeading"));
        homeScreenTabPage.clickTrendingKooIcon();
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_095] Verify all followed users koos are shown on feed & are shown in rank feed order.",
            groups = {"regression", "homeTab_screen"})
    public void verifyKoosInRankOnFeedPage(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        homeScreenTabPage.verifyKoosInRankOnFeedPage();
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_409] Verify Reaction bar below the koo content with exact count & all types of media & text should show on koo.",
            groups = {"regression", "homeTab_screen"})
    public void verifyKooTextMediaAndReactionBarIcons(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        homeScreenTabPage.verifyReactionBarIcons();
        CommonHelper.clickOnHomeButton();
        homeScreenTabPage.verifyKooText();
        CommonHelper.clickOnHomeButton();
        homeScreenTabPage.verifyKooMedia();
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_410] Verify comments should show below the koo & tapping user should enter comments detail screen.",
            groups = {"regression", "homeTab_screen"})
    public void verifyCommentsShowsBelowTheKooAndCommentsDetailSection(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("userNameAuto"));
        String kooText = "AutoKoo_" + RandomStringUtils.randomAlphabetic(10);
        String commentText = "AutoComment_" + RandomStringUtils.randomAlphabetic(10);
        CommonHelper.createAndPostKoo(language, kooText, LanguageDataProvider.getLanguageDataValue("PostButtonText"));
        homeScreenTabPage.verifyCommentsDetailSection(LanguageDataProvider.getLanguageDataValue("CommentsSectionHeading"),
                commentText, LanguageDataProvider.getLanguageDataValue("PostButtonText"), kooText);
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_096] Verify OON koos on feed(i) By reactions done by followed users (ii) By content shown from followed topics",
            groups = {"regression", "homeTab_screen"})
    public void verifySelectedTopicShouldVisible(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        OnBoardingFlowPage onBoardingFlowPage = new OnBoardingFlowPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        onBoardingFlowPage.clickContinueButton().clickContinueButton().clickContinueButton1();
        onBoardingFlowPage.verifySelectedTopicFeedIsShowing();
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_087] Verify home screen tabs should show according to score based login & after refresh logic should change.\n" +
                    " (Only for Video, New, Exclusive, Popular, Polls & Latest tabs).",
            groups = {"regression", "homeTab_screen"})
    public void verifyFreshKoosVisibleOnHomeScreen(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        homeScreenTabPage.verifyRefreshedKoo();
    }
}
