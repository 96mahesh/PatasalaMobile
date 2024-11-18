package com.framework.android.testcases.ProfileScreensTests;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.framework.android.screens.profileScreenPages.ElementsPage;
import com.framework.android.screens.profileScreenPages.FollowersAndFollowingPage;
import com.framework.android.screens.profileScreenPages.InformationPage;
import com.framework.android.screens.profileScreenPages.PinnedKoos;
import com.framework.android.screens.profileScreenPages.SelfVerificationPage;
import com.framework.android.screens.profileScreenPages.TabsPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class InformationTest {

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_230, TC_231, TC_233, TC_204, TC_205, TC_206, TC_207, TC_208, TC_209, TC_210, TC_211, TC_212, TC_213, TC_214, TC_215, TC_216, TC_217, TC_218, TC_219, TC_241, TC_242, TC_244] Verify on tapping profile icon in home screen user enters own profile screen.", groups = {
            "regression", "Profile_Screen"})
    public void verifyInformationPage(String language) throws IOException, InterruptedException, FilloException {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        InformationPage information = new InformationPage();
        information.informationPage(language, LanguageDataProvider.getLanguageDataValue("PeopleTabText"));
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_221, TC_224, TC_225, TC_227, TC_246] Verify Follow button on public profile screen on the top bar, on scrolling the screen if user not followed the account.", groups = {
            "regression", "Profile_Screen"})
    public void verifyElements(String language) throws IOException, InterruptedException, FilloException {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        ElementsPage element = new ElementsPage();
        element.elements(language, LanguageDataProvider.getLanguageDataValue("PeopleTabText"));
        element.newUserLogin(language);
        element.verifyNokKoosInNewUser();
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_236, TC_238, TC_240] Verify appropriate error messages in aadhaar & OTP screens.", groups = {
            "regression", "Profile_Screen"})
    public void verifySelfVerification(String language) throws IOException, InterruptedException, FilloException {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        SelfVerificationPage selfverification = new SelfVerificationPage();
        selfverification.selfverificationpage(language);
    }
    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_243, TC_245, TC_250, TC_251, TC_252, TC_254, TC_255, TC_256, TC_257, TC_258, TC_259, TC_260, TC_261] Verify MLK's on koo card with language switch option in own/public profile.", groups = {
            "regression", "Profile_Screen"})
    public void verifyKoosTab(String language) throws IOException, InterruptedException, FilloException {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        TabsPage tabs = new TabsPage();
        tabs.threadKooCreation(language,LanguageDataProvider.getLanguageDataValue("PostButtonText"));
        tabs.mlkKooCreation(language,  LanguageDataProvider.getLanguageDataValue("NextButtonText"), LanguageDataProvider.getLanguageDataValue("PreviewButtonText"),LanguageDataProvider.getLanguageDataValue("PostButtonText"));
        tabs.likestab();
        tabs.rekoostab();
        tabs.mentionstab();
        tabs.savedkoostab();
    }
    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_268, TC_269, TC_271, TC_272, TC_273] Verify tapping on followers/follwojg button in profile screen user lands on respective screen.", groups = {
            "regression", "Profile_Screen"})
    public void verifyFollowingFollowersTab(String language) throws IOException, InterruptedException, FilloException {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        FollowersAndFollowingPage page = new FollowersAndFollowingPage();
           page.verifyfollowersandfollowing(language,LanguageDataProvider.getLanguageDataValue("FollowTabText"));
    
    }
    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_280, TC_281] Verify only one Koo should be pinned at a time.", groups = {
            "regression", "Profile_Screen"})
    public void verifypinnedKoo(String language) throws IOException, InterruptedException, FilloException {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        PinnedKoos pin = new PinnedKoos();
           pin.verifyPinnedKoos(language);
    
    }
    
    
}
