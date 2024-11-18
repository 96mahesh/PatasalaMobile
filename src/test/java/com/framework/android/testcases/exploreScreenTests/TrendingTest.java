package com.framework.android.testcases.exploreScreenTests;

import com.codoid.products.exception.FilloException;
import com.framework.android.screens.exploreScrenPages.ExploreScreenPage;
import com.framework.android.screens.hashTagDetailScreenPages.HashTagCreationPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.ReportManager;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class TrendingTest {
    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_433, TC_079] Verify Hashtag icon on home screen & red dot on the icon And Trending & Topics tabs in Explore screen.",
            groups = {"regression", "explore_screen"})
    public void verifyTrendingAndTopicsTab(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        ExploreScreenPage exploreScreenPage = new ExploreScreenPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        exploreScreenPage.verifyHashTagIcon();
        exploreScreenPage.clickHashTagIcon();
        exploreScreenPage.verifyTrendingTopicTabOnHashTag(LanguageDataProvider.getLanguageDataValue("TrendingTabText"));
        exploreScreenPage.verifyTrendingTopicTabOnHashTag(LanguageDataProvider.getLanguageDataValue("TopicsTabText"));
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_434] Verify Trending tabs contains various sub-tabs like: All, Entertainment, Politics , Sports, and etc..",
            groups = {"regression", "explore_screen"})
    public void verifySubTabsUnderTrendingTab(String language) throws FilloException, IOException, InterruptedException {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        ExploreScreenPage exploreScreenPage = new ExploreScreenPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        exploreScreenPage.clickHashTagIcon();
        String[] allSubTabs = LanguageDataProvider.getLanguageDataValue("TrendingTabSubTabs").split(", ");
        /*for (int i = 0; i <allSubTabs.length; i++){*/
        exploreScreenPage.verifySuTabsUnderTrendingTas(LanguageDataProvider.getLanguageDataValue("TrendingTabText"),
                allSubTabs);
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_435, TC_437, TC_440, TC_449, TC_450] Verify All sub-tab contains top trending hastags in that language with 5" +
                    "profile images below it & an image next to the hashtags with + button.",
            groups = {"regression", "explore_screen"})
    public void verifySelectedHashTagOnKooCreation(String language) throws FilloException, IOException, InterruptedException {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        ExploreScreenPage exploreScreenPage = new ExploreScreenPage();
        HashTagCreationPage hashTagCreationPage = new HashTagCreationPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        exploreScreenPage.clickHashTagIcon();
        if (language.equalsIgnoreCase("English") || language.equalsIgnoreCase("Hindi")) {
            exploreScreenPage.verifyFiveProfileImagesForHashTag(LanguageDataProvider.getLanguageDataValue("TrendingTabText"),5);
        }
        String actualText = hashTagCreationPage.getHeadingOfHashPost();
        exploreScreenPage.clickPlusIconForHashTag();
        Assert.assertEquals(actualText, exploreScreenPage.getTextOfSelectedHashTag().trim(), "Selected hashtag is correct");
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_438, TC_440, TC_445, TC_449, TC_443] Verify trending tags also contains NER tags without the # symbol & tapping on + button user goes to creation.",
            groups = {"regression", "explore_screen"})
    public void verifySelectedNERTagOnKooCreation(String language) throws FilloException, IOException, InterruptedException {
        if (language.equalsIgnoreCase("English") || language.equalsIgnoreCase("Hindi")) {
            LanguageDataProvider.setCurrentLanguage(language);
            LoginKooPage loginKooPage = new LoginKooPage();
            ExploreScreenPage exploreScreenPage = new ExploreScreenPage();
            loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
            exploreScreenPage.clickHashTagIcon();
            exploreScreenPage.clickPlusIconForNERTag();
            exploreScreenPage.verifyKooCreationPage();
        }
        ReportManager.logInfo("This test case will execute only for Hindi and English and verify NER tags");
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_439] Verify the image above the first hashtag, tapping on which user goes to hashtags detail screen of the first hashtag",
            groups = {"regression", "explore_screen"})
    public void verifyFirstHashTagOnClickOfTopImage(String language) throws FilloException, IOException, InterruptedException {
        HashTagCreationPage hashTagCreationPage = new HashTagCreationPage();
        if (language.equalsIgnoreCase("English") || language.equalsIgnoreCase("Hindi")) {
            LanguageDataProvider.setCurrentLanguage(language);
            LoginKooPage loginKooPage = new LoginKooPage();
            ExploreScreenPage exploreScreenPage = new ExploreScreenPage();
            loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
            exploreScreenPage.clickHashTagIcon();
            String actualText = hashTagCreationPage.getHeadingOfHashPost();
            exploreScreenPage.clickHashTagFirstImage();
            Assert.assertEquals(actualText, exploreScreenPage.getHeadingOfFirstHashTag(),
                    "First hashtag is showing correctly after clicking on first top image");
        }
        ReportManager.logInfo("This test case will execute only for Hindi and English and verify NER tags");
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_444, TC_410, TC_105] Verify user is able to react on koos on all the sub-tabs.",
            groups = {"regression", "explore_screen"})
    public void verifyUserCanReactOnKooFromSubTab(String language) throws FilloException, IOException, InterruptedException {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        ExploreScreenPage exploreScreenPage = new ExploreScreenPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        exploreScreenPage.clickHashTagIcon();
        exploreScreenPage.verifyUserReactOnKoo(LanguageDataProvider.getLanguageDataValue("CommentsSectionHeading"));
    }
}
