package com.framework.android.testcases.settingsScreenTests;

import com.framework.android.screens.onboardingFlowPages.ScreensPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.screens.settingsScreenPages.SettingsScreenPage;
import com.framework.android.screens.userBlockPages.UserBlockPage;
import com.framework.android.utils.CommonHelper;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class SettingsScreenTest {

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_647, TC_649, TC_650, TC_651] Verify settings button should be present in own profile screen.",
            groups = {"regression", "settings_screen"})
    public void verifySettingsScreen(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        UserBlockPage userBlockPage = new UserBlockPage();
        SettingsScreenPage settingsScreenPage = new SettingsScreenPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        CommonHelper.clickOnProfile();
        userBlockPage.clickOnThreeDots();
        settingsScreenPage.verifySettingsButton(LanguageDataProvider.getLanguageDataValue("SettingsButton"));
        settingsScreenPage.clickSettingsButton();
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("AccountsHeadingOnSettingPage"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("OthersHeadingOnSettingsPage"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("AccountsSectionEditProfileSubHeading"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("AccountsSectionLanguageSubHeading"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("AccountsSectionThemeSubHeading"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("AccountsSectionShareKooProfileSubHeading"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("AccountsSectionApplySelfSubHeading"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("AccountsSectionApplyEminenceSubHeading"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("AccountsSectionMigrateTwitterSubHeading"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("AccountsSectionAddAccountSubHeading"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("AccountsSectionManageAccountSubHeading"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("AccountsSectionLogoutSubHeading"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("AccountsSectionDeleteSubHeading"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("OthersSectionNotificationsSubHeading"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("OthersSectionWhatsappUpdateSubHeading"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("OthersSectionVideoAutoPLaySubHeading"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("OthersSectionAutoPLayImagesSubHeading"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("OthersSectionTranslationSubHeading"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("OthersSectionKooRewardsSubHeading"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("OthersSectionHelpSubHeading"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("OthersSectionPrivacyPolicySubHeading"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("OthersSectionAboutUsSubHeading"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("OthersSectionResourceCenterSubHeading"));
        settingsScreenPage.verifySectionsHeadingAndSubLinksHeadings(LanguageDataProvider.getLanguageDataValue("OthersSectionPlayStoreCompSubHeading"));
    }


    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_652] Verify all the the options in settings screen.",
            groups = {"regression", "settings_screen"})
    public void verifyAllSettingsActions(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        UserBlockPage userBlockPage = new UserBlockPage();
        ScreensPage screensPage = new ScreensPage();
        SettingsScreenPage settingsScreenPage = new SettingsScreenPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        CommonHelper.clickOnProfile();
        userBlockPage.clickOnThreeDots();
        settingsScreenPage.verifySettingsButton(LanguageDataProvider.getLanguageDataValue("SettingsButton"));
        settingsScreenPage.clickSettingsButton();

        // Verify Edit Profile Action
        settingsScreenPage.clickOnLink(LanguageDataProvider.getLanguageDataValue("AccountsSectionEditProfileSubHeading"));
        settingsScreenPage.verifyEditProfileAction(LanguageDataProvider.getLanguageDataValue("EditProfileHeading"));
        CommonHelper.clickOnBackArrow();

        // Verify Share Your Koo profile Action
        settingsScreenPage.clickOnLink(LanguageDataProvider.getLanguageDataValue("AccountsSectionShareKooProfileSubHeading"));
        settingsScreenPage.verifyShareYourKooProfileAction(LanguageDataProvider.getLanguageDataValue("ShareYourKooProfilePopUpHeading"));
        CommonHelper.clickOnNoOrCancelButton();

        // Verify Apply for self verification Action
        settingsScreenPage.clickOnLink(LanguageDataProvider.getLanguageDataValue("AccountsSectionApplySelfSubHeading"));
        settingsScreenPage.verifyApplyForSelfVerificationAction(LanguageDataProvider.getLanguageDataValue("ApplyForSelfVerificationPageHeading"));
        CommonHelper.clickOnBackArrow();

        // Verify Apply For Eminence Action
        settingsScreenPage.clickOnLink(LanguageDataProvider.getLanguageDataValue("AccountsSectionApplyEminenceSubHeading"));
        settingsScreenPage.verifyApplyForEminenceAndHelpAction("https://forms.zohopublic.in");
        CommonHelper.clickOnCrossButton();

        // Verify Migrate From Twitter Action
        settingsScreenPage.clickOnLink(LanguageDataProvider.getLanguageDataValue("AccountsSectionMigrateTwitterSubHeading"));
        settingsScreenPage.verifyMigrateFromTwitterAction(LanguageDataProvider.getLanguageDataValue("MigrateFromTwitterPopUpHeading"));
        settingsScreenPage.clickCloseButtonForMigrateFromTwitterPopUp(LanguageDataProvider.getLanguageDataValue("MigrateFromTwitterCloseButtonText"));

        // Verify Manage Account Action
        settingsScreenPage.clickOnLink(LanguageDataProvider.getLanguageDataValue("AccountsSectionManageAccountSubHeading"));
        settingsScreenPage.verifyManageAccountAction(LanguageDataProvider.getLanguageDataValue("ManageAccountPageHeading"));
        CommonHelper.clickOnBackArrow();

        // Verify Logout Action
        settingsScreenPage.clickOnLink(LanguageDataProvider.getLanguageDataValue("AccountsSectionLogoutSubHeading"));
        settingsScreenPage.verifyLogOutAction(LanguageDataProvider.getLanguageDataValue("LogOutPopUpText"));
        CommonHelper.clickCancelButtonOnLogOutAndDeleteAccountPopUp();

        // Verify Delete Action
        settingsScreenPage.clickOnLink(LanguageDataProvider.getLanguageDataValue("AccountsSectionDeleteSubHeading"));
        settingsScreenPage.verifyDeleteAction(LanguageDataProvider.getLanguageDataValue("DeletePopUpText"));
        CommonHelper.clickCancelButtonOnLogOutAndDeleteAccountPopUp();

        // Verify Notifications Action
        settingsScreenPage.clickOnLink(LanguageDataProvider.getLanguageDataValue("OthersSectionNotificationsSubHeading"));
        settingsScreenPage.verifyNotificationsAction(LanguageDataProvider.getLanguageDataValue("NotificationsPageHeading"));
        CommonHelper.clickOnBackArrow();

        // Verify Help Action
        settingsScreenPage.clickOnLink(LanguageDataProvider.getLanguageDataValue("OthersSectionHelpSubHeading"));
        settingsScreenPage.verifyApplyForEminenceAndHelpAction("https://info.kooapp.com");
        CommonHelper.clickOnCrossButton();

        // Verify Privacy policy page link
        settingsScreenPage.clickOnLink(LanguageDataProvider.getLanguageDataValue("OthersSectionPrivacyPolicySubHeading"));
        settingsScreenPage.verifyApplyForEminenceAndHelpAction("https://info.kooapp.com");
        CommonHelper.clickOnCrossButton();

        // Verify About Us
        settingsScreenPage.clickOnLink(LanguageDataProvider.getLanguageDataValue("OthersSectionAboutUsSubHeading"));
        settingsScreenPage.verifyApplyForEminenceAndHelpAction("https://info.kooapp.com");
        //settingsScreenPage.verifyPrivacyPolicyAndAboutUsAction("About Us");
        CommonHelper.clickOnCrossButton();

        // Verify Play Store Compliance
		/*
		 * settingsScreenPage.clickOnLink(LanguageDataProvider.getLanguageDataValue(
		 * "OthersSectionPlayStoreCompSubHeading"));
		 * settingsScreenPage.verifyApplyForEminenceAndHelpAction(
		 * "https://info.kooapp.com"); settingsScreenPage.
		 * verifyPrivacyPolicyAndAboutUsAction("Play Store Compliance");
		 * CommonHelper.clickOnCrossButton();
		 */
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_652] Verify all the the options in settings screen.",
            groups = {"regression", "settings_screen"})
    public void verifyChangeInEnglishActions(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        UserBlockPage userBlockPage = new UserBlockPage();
        SettingsScreenPage settingsScreenPage = new SettingsScreenPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        CommonHelper.clickOnProfile();
        userBlockPage.clickOnThreeDots();
        settingsScreenPage.clickSettingsButton();

        // Verify Change In English functionality
        settingsScreenPage.verifyChangeInEnglishText(language,LanguageDataProvider.getLanguageDataValue("ChangeInEnglish"));
        settingsScreenPage.verifyChangeInEnglishAction(language,LanguageDataProvider.getLanguageDataValue("ChangeInEnglish"),LanguageDataProvider.getLanguageDataValue("FeedTabText"));
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_648] Verify the first language on the list should be shown based on the location of the user & rest as per default linsting.",
            groups = {"regression", "settings_screen"})
    public void verifyLanguageAsPerUserLocation(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        SettingsScreenPage settingsScreenPage = new SettingsScreenPage();
        settingsScreenPage.setLocation();
    }
}