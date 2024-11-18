package com.framework.android.testcases.registrationAndLoginFlowTests;

import com.codoid.products.exception.FilloException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.android.screens.registerationAndLoginFlowPages.LanguagesSelectionPage;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;

import java.io.IOException;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class LanguageSelectionTest {

    @Test(description = "[TC_004, TC_008, TC_009] Verify user should able to see Language selection screen with below options:" +
            "Available Languages: English, Kannada, Hindi, Tamil, Marathi,Telugu, Bengla, Gujarati, Assamees, Punjabi & Hausa.",
            groups = {"regression", "registration_and_login"})
    public void verifyAvailableLanguagesInEnglish() throws Exception {
        LanguagesSelectionPage languagesSelectionPage = new LanguagesSelectionPage();
        languagesSelectionPage.verifyAvailableLanguagesInEnglishLanguage();
    }

    @Test(description = "[TC_004, TC_008] Verify user should able to see Language selection screen with below options:" +
            "Available Languages: English, Kannada, Hindi, Tamil, Marathi,Telugu, Bengla, Gujarati, Assamees, Punjabi & Hausa.",
            groups = {"regression", "registration_and_login"})
    public void verifyAvailableLanguagesInSameLanguage() throws Exception {
        LanguagesSelectionPage languagesSelectionPage = new LanguagesSelectionPage();
        languagesSelectionPage.verifyAllAvailableLanguagesInSameLanguage();
    }

    @Test(description = "[TC_005] Verify check box on available language & only selected language should be checked in the box.",
            groups = {"regression","registration_and_login"})
    public void verifyCheckBoxesForAvailableLanguages() throws FilloException, IOException, InterruptedException {
        LanguagesSelectionPage languagesSelectionPage = new LanguagesSelectionPage();
        languagesSelectionPage.verifyCheckBoxesForAvailableLanguages();
    }

    @Test(description = "[TC_006, TC_026] Verify on selecting Hindi language, user should get rewards banner screen with continue tapping " +
            "should land on login OR should auto disappear after 5 seconds.",
            groups = {"regression", "registration_and_login"})
    public void verifyRewardBannerForHindiAndVerifyLoginPageHeading() throws FilloException, IOException, InterruptedException {
        LanguagesSelectionPage languagesSelectionPage = new LanguagesSelectionPage();
        languagesSelectionPage.verifySelectedLanguageDisplayingAndRewardBanner();
    }
}