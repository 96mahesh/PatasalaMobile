package com.framework.android.testcases.registrationAndLoginFlowTests;

import com.framework.android.screens.registerationAndLoginFlowPages.GoogleEmailPopUpPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.CommonHelper;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class GoogleEmailPopUpTest {
    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_030, TC_029, TC_041, TC_020, TC_013, TC_031, TC_032] Verify tapping on 'Sign in with Google' button \"All the\" " +
                    "google accounts on the device shows on a popup & tapping on any 1 user should Directly" +
                    " login without OTP flow.",
            groups = {"regression", "registration_and_login"})
    public void verifyRegistrationPage(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        GoogleEmailPopUpPage googleEmailPopUpPage = new GoogleEmailPopUpPage();
        googleEmailPopUpPage.verifyAllGmailAccounts(language, LanguageDataProvider.getLanguageDataValue("SignInGoogleText"));
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_034] Verify registered email popup should not be shown wile adding multiple/child account.",
            groups = {"regression", "registration_and_login"})
    public void verifyRegisteredEmailPopUpNotDisplayWhileAddingMultiChildAccount(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        GoogleEmailPopUpPage googleEmailPopUpPage = new GoogleEmailPopUpPage();
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        googleEmailPopUpPage.verifyRegistrationPopUpNotDisplayForMultiChildAccount(0);
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_033] Verify Google sign-in opiton & functioanlity for multiple/child account.",
            groups = {"regression", "registration_and_login"})
    public void verifyChildAccountFromAddAccount(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        GoogleEmailPopUpPage googleEmailPopUpPage = new GoogleEmailPopUpPage();
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("autoNewUser_03"));
        CommonHelper.clickOnProfile();
        CommonHelper.clickOnThreeDotsOProfilePage();
        CommonHelper.clickSettingsButton();
        googleEmailPopUpPage.clickOnAddAccount();
        googleEmailPopUpPage.loginChildUser(ConfigReader.getValue("autoChildUser"));
        CommonHelper.clickOnProfile();
        googleEmailPopUpPage.verifyChildAccountAdded();
        googleEmailPopUpPage.verifyChildUserLoggedOut(LanguageDataProvider.getLanguageDataValue("AccountsSectionEditProfileSubHeading"));
    }
}
