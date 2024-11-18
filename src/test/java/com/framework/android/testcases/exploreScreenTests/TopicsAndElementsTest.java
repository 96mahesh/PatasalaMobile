package com.framework.android.testcases.exploreScreenTests;

import com.framework.android.screens.exploreScrenPages.ExploreScreenPage;
import com.framework.android.screens.exploreScrenPages.TopicsTabAndElementsPage;
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

@Listeners({SuiteEvent.class, MobileEvent.class})
public class TopicsAndElementsTest {

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_446, TC_449, TC_447] Verify Topics tab contains NER tags with images next to it with + button, tapping on which user goes to koo creation screen.",
            groups = {"regression", "explore_screen"})
    public void verifyTopicsTabWithNERTag(String language) throws Exception {
        if (language.equalsIgnoreCase("English") || language.equalsIgnoreCase("Hindi")) {
            LanguageDataProvider.setCurrentLanguage(language);
            LoginKooPage loginKooPage = new LoginKooPage();
            ExploreScreenPage exploreScreenPage = new ExploreScreenPage();
            TopicsTabAndElementsPage topicsTabAndElementsPage = new TopicsTabAndElementsPage();
            loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
            exploreScreenPage.clickHashTagIcon();
            topicsTabAndElementsPage.verifyNERTagsAndKooCreationPage(LanguageDataProvider.getLanguageDataValue("TopicsTabText"));
            exploreScreenPage.clickPlusIconForNERTag();
            exploreScreenPage.verifyKooCreationPage();
        }
        ReportManager.logInfo("This test case will execute only for Hindi and English and verify NER tags");
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_448] Verify +Koo button next to each trending hashtag on the screen & tapping on it user lands on koo creation & respective hashtag is auto loaded.",
            groups = {"regression", "explore_screen"})
    public void verifyPlusKooButton(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        HashTagCreationPage hashTagCreationPage = new HashTagCreationPage();
        ExploreScreenPage exploreScreenPage = new ExploreScreenPage();
        TopicsTabAndElementsPage topicsTabAndElementsPage = new TopicsTabAndElementsPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        exploreScreenPage.clickHashTagIcon();
        String actualText = hashTagCreationPage.getHeadingOfHashPost();
        hashTagCreationPage.clickHashTagPost();
        topicsTabAndElementsPage.verifyPlusKooButton();
        topicsTabAndElementsPage.clickPlusKooButton();
        Assert.assertEquals(actualText, exploreScreenPage.getTextOfSelectedHashTag().trim(),
                "Selected hashtag is not correct");
    }
}
