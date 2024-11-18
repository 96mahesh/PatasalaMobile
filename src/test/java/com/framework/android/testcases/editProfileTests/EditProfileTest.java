package com.framework.android.testcases.editProfileTests;

import java.io.IOException;

import com.codoid.products.exception.FilloException;
import com.framework.android.screens.editProfilePages.EditProfile;
import com.framework.android.screens.editProfilePages.EmailMobileLinking;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class EditProfileTest {
    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_284, TC_285, TC_287, TC_288] Verify on following options in edit profile screen:\r\n"
                    + " (a) Profile image/palce holder (b) Name (c) Handle (d) Profession (e) Current Location (f) Location (g) Bio\r\n"
                    + " (h) Date of Birth (i) Website (j) Gender (k) Martial Status (l) Social Links (FB, Twitter, LinkedIn, YT)\r\n"
                    + " (m) Qualifications (n) Work experience.", groups = {
            "regression", "Edit_profile"})
    public void verifyEditProfile(String language) throws IOException, InterruptedException, FilloException {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        EditProfile editprofile = new EditProfile();
        editprofile.editProfilePage(language);
    }
    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_292, TC_294] Verify on entering already registered number/mail, user should get \"Email/Mobile already linked\" error message.", groups = {
            "regression", "Edit_profile"})
    public void verifyEmailMobileLinking(String language) throws IOException, InterruptedException, FilloException {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        EmailMobileLinking emaillinking = new EmailMobileLinking();
        emaillinking.verifyEmailLinking(language);
    }
}
