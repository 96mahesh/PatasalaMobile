package com.framework.android.testcases.homeScreenTabTests;

import com.framework.android.screens.homeScreenTabsPages.HomeScreenTabPage;
import com.framework.android.screens.homeScreenTabsPages.ViewKoosFromPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class ViewKoosFromTest {

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_103] Verify following any profile from feed & topics from topics tab, View Koos From button should be shown with profile icons of followed users. And only View Koo button shows following user with not profile image.",
            groups = {"regression", "homeTab_screen"})
    public void verifyViewKoosFromButton(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        ViewKoosFromPage viewKoosFromPage = new ViewKoosFromPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        viewKoosFromPage.verifyViewKoosFromButton();
        viewKoosFromPage.verifyViewKoosFromProfileImage();
        viewKoosFromPage.unfollowProfile();
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_104] Verify profile icons should add next to one another on following user & maximum of 5 will show at once.",
            groups = {"regression", "homeTab_screen"})
    public void verifyFiveProfileIcons(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        ViewKoosFromPage viewKoosFromPage = new ViewKoosFromPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        viewKoosFromPage.verifyFiveProfileIcons(5);
    }

}
