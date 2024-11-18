package com.framework.android.testcases.peopleTabTests;

import com.framework.android.screens.homeScreenTabsPages.CarouselsPage;
import com.framework.android.screens.homeScreenTabsPages.HomeScreenTabPage;
import com.framework.android.screens.peopleTabPages.PeopleTabPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.CommonHelper;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class PeopleTabTest {

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_122] Verify Discover Relevant People widget on tap & should contain all the different tiles of carousels.",
            groups = {"regression", "people_tab"})
    public void verifyDiscoverPeopleWidget(String language) throws Exception {
        if (!(language.equalsIgnoreCase("English")) && !(language.equalsIgnoreCase("Hindi")) && !(language.equalsIgnoreCase("Portuguese"))) {
            LanguageDataProvider.setCurrentLanguage(language);
            LoginKooPage loginKooPage = new LoginKooPage();
            HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
            PeopleTabPage peopleTabPage = new PeopleTabPage();
            loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
            homeScreenTabPage.clickOnAnyTabFromHomePage(LanguageDataProvider.getLanguageDataValue("PeopleTabText"));
            peopleTabPage.verifyDiscoverRelevantPeopleWidget(LanguageDataProvider.getLanguageDataValue("DiscoverRelevantPeopleHeading"));
        }
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_124, TC_125] Verify different carousels on people tab & tapping on arrow button user should enter people detail screen.",
            groups = {"regression", "people_tab"})
    public void verifyPeopleDetailPageAndFollowUFollowFunctionality(String language) throws Exception {
        if (!(language.equalsIgnoreCase("Tamil")) && !(language.equalsIgnoreCase("Portuguese"))) {
            LanguageDataProvider.setCurrentLanguage(language);
            LoginKooPage loginKooPage = new LoginKooPage();
            HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
            PeopleTabPage peopleTabPage = new PeopleTabPage();
            CarouselsPage carouselsPage = new CarouselsPage();
            loginKooPage.loginValidUser(language, ConfigReader.getValue("autoNewUser"));
            homeScreenTabPage.clickOnAnyTabFromHomePage(LanguageDataProvider.getLanguageDataValue("PeopleTabText"));
            peopleTabPage.verifyPeopleDetailPage(LanguageDataProvider.getLanguageDataValue("PeopleYouCanFollowHeading"));
            carouselsPage.clickOnFollowButtonFromCarousel();
            CommonHelper.clickOnSmallCrossButton();
            carouselsPage.clickOnUnFollowButtonFromCarousele();
            carouselsPage.verifyUnfollowButtonFunctionality();
        }
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_126, TC_127, TC_129, TC_128] Verify Find Friends & Invite Friends buttons on people tab along with infinite blip.",
            groups = {"regression", "people_tab"})
    public void verifyFindYourFriendsAndInviteButtonFunctionality(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
        PeopleTabPage peopleTabPage = new PeopleTabPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("autoNewUser"));
        homeScreenTabPage.clickOnAnyTabFromHomePage(LanguageDataProvider.getLanguageDataValue("PeopleTabText"));
        peopleTabPage.verifyFindYourFriendsAndInviteButton(LanguageDataProvider.getLanguageDataValue("FindYourFriendsOnKooButtonText"),
                LanguageDataProvider.getLanguageDataValue("YourFriendsHeading"),
                LanguageDataProvider.getLanguageDataValue("InviteButtonText"));
        peopleTabPage.clickOnInviteButtonAndVerifyAlertPopUp(LanguageDataProvider.getLanguageDataValue("InviteButtonText"));
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_130] Verify following cagoule in people tab:\n" +
                    " (a) People You May Know (Friends/Contacts) (b) People you can follow (c) Popular (d) Journalists (e) News Paper & Channels (f) Poets & Authors (Writers) (g) Politicians (h) Entertainment (i) New Folks (j) Govt Services (k) Govt Officials (l) Recently joined (m) Sports (n) Interesting accounts (o) COVID Worriors (p) Popular (unlimited carousel)",
            groups = {"regression", "people_tab"})
    public void verifyPeopleTabSectionHeadings(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
        PeopleTabPage peopleTabPage = new PeopleTabPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("autoNewUser"));
        homeScreenTabPage.clickOnAnyTabFromHomePage(LanguageDataProvider.getLanguageDataValue("PeopleTabText"));
        String[] allHeadings = LanguageDataProvider.getLanguageDataValue("PeopleTabSectionHeadings").split(",");
        peopleTabPage.verifyPeopleTabSectionHeadings(allHeadings);
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_132] Verify profiles in carousel should shuffle on refresh: (i) After staying 2 seconds on carousel header (ii) Scrolling all profiles in that carousel (iii) Should reset profiles on Relogin, Language switch & Account switch.",
            groups = {"regression", "people_tab"})
    public void verifyProfileShouldRefreshOnPeopleTab(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
        PeopleTabPage peopleTabPage = new PeopleTabPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("autoNewUser"));
        homeScreenTabPage.clickOnAnyTabFromHomePage(LanguageDataProvider.getLanguageDataValue("PeopleTabText"));
        peopleTabPage.verifyProfileShouldChangedAfterRefresh();
    }

}
