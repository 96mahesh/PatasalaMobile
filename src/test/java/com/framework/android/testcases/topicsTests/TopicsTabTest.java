package com.framework.android.testcases.topicsTests;

import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.screens.settingsScreenPages.SettingsScreenPage;
import com.framework.android.screens.topicsPage.TopicsTabPage;
import com.framework.android.screens.userBlockPages.UserBlockPage;
import com.framework.android.utils.CommonHelper;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class TopicsTabTest {
    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_134] Verify topics tab should be in 3rd/4th position in home screen tabs for English & Hindi users only.",
            groups = {"regression", "topicsTab_home"})
    public void verifyTopicsTabPositionOnHomePage(String language) throws Exception {
        if ((language.equalsIgnoreCase("English")) || (language.equalsIgnoreCase("Hindi"))) {
            LanguageDataProvider.setCurrentLanguage(language);
            LoginKooPage loginKooPage = new LoginKooPage();
            TopicsTabPage topicsTabPage = new TopicsTabPage();
            loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
            topicsTabPage.verifyTopicTabOnThirdOrFourthPosition(LanguageDataProvider.getLanguageDataValue("TopicsTabTextOnHomePage"),
                    2);
        }
    }
}
