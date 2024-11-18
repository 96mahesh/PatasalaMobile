package com.framework.android.testcases.hashTagDetailScreenTests;

import com.codoid.products.exception.FilloException;
import com.framework.android.screens.hashTagDetailScreenPages.HashTagCreationPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class HashTagCreationTest {

    String hashKey = "#";
    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_427, TC_608] Verify user should enter Hashtag detail screen:\n" +
                    " - tapping on any hashtag on koo card from any screen on app.\n" +
                    " - tapping on hashtags in trending tags screen.",
            groups = {"regression", "hashtag_details_screen"})
    public void verifyHashTagPopUp(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        HashTagCreationPage hashTagCreationPage = new HashTagCreationPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        hashTagCreationPage.verifyHashTagPopUpOnKooCreation(hashKey);
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_427] Verify user should enter Hashtag detail screen:\n" +
                    " - tapping on any hashtag on koo card from any screen on app.\n" +
                    " - tapping on hashtags in trending tags screen.",
            groups = {"regression", "hashtag_details_screen"})
    public void verifyHashTagPopUpOnSearch(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        HashTagCreationPage hashTagCreationPage = new HashTagCreationPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        hashTagCreationPage.verifyHashTagPopUpOnSearch(hashKey);
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_428, TC_429, TC_309] Verify respective hashtag should be shown as screen header text along with back button & share button.",
            groups = {"regression", "hashtag_details_screen"})
    public void verifyBackAndShareButtonOnHashTag(String language) throws FilloException, IOException, InterruptedException {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        HashTagCreationPage hashTagCreationPage = new HashTagCreationPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        hashTagCreationPage.clickHashTagExploreIcon();
        hashTagCreationPage.getHeadingOfHashPost();
        hashTagCreationPage.clickHashTagPost();
        hashTagCreationPage.verifyBackButton();
        hashTagCreationPage.verifyShareButton();
        hashTagCreationPage.verifyHeadingOfHashTagPost();
        hashTagCreationPage.verifyHashTagOnPost();
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_430] Verify user should be able to share hashtag from this screen & tapping hashtag shared link, user should land on respective hashtag.",
            groups = {"regression", "hashtag_details_screen"})
    public void verifyShareButtonOnHashTagAndSharePopUp(String language) throws FilloException, IOException, InterruptedException {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        HashTagCreationPage hashTagCreationPage = new HashTagCreationPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        hashTagCreationPage.clickHashTagExploreIcon();
        hashTagCreationPage.getHeadingOfHashPost();
        hashTagCreationPage.clickHashTagPost();
        hashTagCreationPage.verifyShareButton();
      //  hashTagCreationPage.verifyShareHashTagPopUp(LanguageDataProvider.getLanguageDataValue("ShareYourKooProfilePopUpHeading"));
    }
}
