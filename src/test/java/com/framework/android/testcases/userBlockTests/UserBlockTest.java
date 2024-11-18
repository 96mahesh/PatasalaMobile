package com.framework.android.testcases.userBlockTests;

import com.codoid.products.exception.FilloException;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.screens.userBlockPages.UserBlockPage;
import com.framework.android.utils.CommonHelper;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class UserBlockTest {

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_625] Verify user is able to block/unblock others in public profile screen & from opitons on koo card.",
            groups = {"regression", "user_block"})
    public void verifyUserBlockUnblockButtons(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        UserBlockPage userBlockPage = new UserBlockPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        userBlockPage.swipeUpToElementView(ConfigReader.getValue("userProfileName"));
        CommonHelper.swipeUp(userBlockPage,1);
        userBlockPage.clickOnViewMoreDots(ConfigReader.getValue("userProfileName"));

        // Unblock the user first if it's already blocked
        if(userBlockPage.getBlockUnBlockButtonText().equalsIgnoreCase(LanguageDataProvider.getLanguageDataValue("UnblockButton"))){
            userBlockPage.clickButton(LanguageDataProvider.getLanguageDataValue("UnblockButton"));
            userBlockPage.clickOkButton();
            userBlockPage.clickOnViewMoreDots(ConfigReader.getValue("userProfileName"));
        }
        userBlockPage.verifyBlockUnBlockButton(language, LanguageDataProvider.getLanguageDataValue("BlockButton"));
        userBlockPage.clickButton(LanguageDataProvider.getLanguageDataValue("BlockButton"));
        userBlockPage.verifyBlockUnBlockPopUpText(LanguageDataProvider.getLanguageDataValue("BlockPopUpHeading"), language);
        userBlockPage.verifyNoButton(LanguageDataProvider.getLanguageDataValue("NoButtonLeft"), language);
        userBlockPage.verifyOkButton(LanguageDataProvider.getLanguageDataValue("OkButtonRight"), language);
        userBlockPage.clickOkButton();
        userBlockPage.clickOnViewMoreDots(ConfigReader.getValue("userProfileName"));
        userBlockPage.verifyBlockUnBlockButton(language, LanguageDataProvider.getLanguageDataValue("UnblockButton"));
        userBlockPage.clickButton(LanguageDataProvider.getLanguageDataValue("UnblockButton"));
        userBlockPage.verifyBlockUnBlockPopUpText(LanguageDataProvider.getLanguageDataValue("UnBlockPopUpHeadingText"), language);
        userBlockPage.clickOkButton();
        userBlockPage.clickOnViewMoreDots(ConfigReader.getValue("userProfileName"));
        userBlockPage.verifyBlockUnBlockButton(language, LanguageDataProvider.getLanguageDataValue("BlockButton"));
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_628, TC_629] Verify user should be able to see all the profiles blocked in Manage Blocked user screen in settings screen with \"Unblock\" button.\n" +
                    " - On tapping unblock button state should change to View Profile and respective user koos should show on koo card.\n" +
                    " - On tapping View Profile button or profile picture or username it should navigate to respective profile screen.",
            groups = {"regression", "user_block"})
    public void verifyManageBlockedUserSection(String language) throws FilloException, IOException, InterruptedException {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        UserBlockPage userBlockPage = new UserBlockPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        userBlockPage.clickSearchButton();
        userBlockPage.verifySearchedUser(ConfigReader.getValue("autoTestUserID"), ConfigReader.getValue("autoTestUser"));
        userBlockPage.clickOnSearchedUser(ConfigReader.getValue("autoTestUser"));
        userBlockPage.clickOnThreeDots();
        // Unblock the user first if it's already blocked
        if(userBlockPage.getBlockUnBlockButtonText().equalsIgnoreCase(LanguageDataProvider.getLanguageDataValue("UnblockButton"))){
            userBlockPage.clickButton(LanguageDataProvider.getLanguageDataValue("UnblockButton"));
            userBlockPage.clickOkButton();
            userBlockPage.clickOnThreeDots();
        }
        userBlockPage.clickButton(LanguageDataProvider.getLanguageDataValue("BlockButton"));
        userBlockPage.clickOkButton();
        userBlockPage.clickOnThreeDots();
        userBlockPage.verifyBlockUnBlockButton(language, LanguageDataProvider.getLanguageDataValue("UnblockButton"));
        userBlockPage.clickOnCloseButton();
        CommonHelper.verifyAndClickOnBackButtonOnProfilePage();
        CommonHelper.clickOnHomeButton();
        userBlockPage.verifyManagedBlocked(language, LanguageDataProvider.getLanguageDataValue("ManageBlockedUser"),
                ConfigReader.getValue("autoTestUser"), LanguageDataProvider.getLanguageDataValue("BlockButton"));
        CommonHelper.logOutUser();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        userBlockPage.clickSearchButton();
        userBlockPage.verifySearchedUser(ConfigReader.getValue("autoTestUserID"), ConfigReader.getValue("autoTestUser"));
        CommonHelper.clickOnCancelLinkFromSearchBar();
        userBlockPage.verifyUnblockedUserNotDisplayUnderManageBlockedUser(ConfigReader.getValue("autoTestUser"),
                0);
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_626, TC_630, TC_622, TC_092] Verify after blocking the user, blocked user should not be able to see/react to user's koo anywhere on the app.",
            groups = {"regression", "user_block"})
    public void verifyBlockedUserShouldNotVisible(String language) throws FilloException, IOException, InterruptedException {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        UserBlockPage userBlockPage = new UserBlockPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("userNameAuto"));
        userBlockPage.clickSearchButton();
        userBlockPage.verifySearchedUser(ConfigReader.getValue("autoTestUserID"), ConfigReader.getValue("autoTestUser"));
        userBlockPage.clickOnSearchedUser(ConfigReader.getValue("autoTestUser"));
        userBlockPage.clickOnThreeDots();
        // Unblock the user first if it's already blocked
        if(userBlockPage.getBlockUnBlockButtonText().equalsIgnoreCase(LanguageDataProvider.getLanguageDataValue("UnblockButton"))){
            userBlockPage.clickButton(LanguageDataProvider.getLanguageDataValue("UnblockButton"));
            userBlockPage.clickOkButton();
            userBlockPage.clickOnThreeDots();
        }
        userBlockPage.clickButton(LanguageDataProvider.getLanguageDataValue("BlockButton"));
        userBlockPage.clickOkButton();
        userBlockPage.clickOnThreeDots();
        userBlockPage.verifyBlockUnBlockButton(language, LanguageDataProvider.getLanguageDataValue("UnblockButton"));
        userBlockPage.clickOnCloseButton();
        CommonHelper.verifyAndClickOnBackButtonOnProfilePage();
        CommonHelper.clickOnHomeButton();
        userBlockPage.clickOnSettings();
        CommonHelper.logOutUser();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("autoBlockedUser"));
        userBlockPage.clickSearchButton();
        userBlockPage.verifyBlockedUserShouldNotDisplay(ConfigReader.getValue("userID"),
                ConfigReader.getValue("userProfileName"));

        // Now, unblock that previously blocked user
        CommonHelper.clickOnCancelLinkFromSearchBar();
        CommonHelper.clickOnHomeButton();
        userBlockPage.clickOnSettings();
        CommonHelper.logOutUser();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("userNameAuto"));
        userBlockPage.clickSearchButton();
        userBlockPage.verifySearchedUser(ConfigReader.getValue("autoTestUserID"), ConfigReader.getValue("autoTestUser"));
        userBlockPage.clickOnSearchedUser(ConfigReader.getValue("autoTestUser"));
        userBlockPage.clickOnThreeDots();
        userBlockPage.clickButton(LanguageDataProvider.getLanguageDataValue("UnblockButton"));
        userBlockPage.clickOkButton();
        userBlockPage.clickOnThreeDots();
        userBlockPage.verifyBlockUnBlockButton(language, LanguageDataProvider.getLanguageDataValue("BlockButton"));
        userBlockPage.clickOnCloseButton();
        CommonHelper.verifyAndClickOnBackButtonOnProfilePage();
        CommonHelper.clickOnHomeButton();
        userBlockPage.clickOnSettings();
        CommonHelper.logOutUser();


        // Now, again login that previously unblocked user and verify TC_630
		/*
		 * loginKooPage.loginValidUser(language,
		 * ConfigReader.getValue("autoBlockedUser")); userBlockPage.clickSearchButton();
		 * userBlockPage.verifySearchedUser(ConfigReader.getValue("autoTestUserID"),
		 * ConfigReader.getValue("autoTestUser"));
		 * userBlockPage.clickOnSearchedUser(ConfigReader.getValue("autoTestUser"));
		 * userBlockPage.verifyUnblockedUserReactOnKoo(ConfigReader.getValue(
		 * "autoTestUser"),LanguageDataProvider.getLanguageDataValue(
		 * "CommentsSectionHeading"));
		 */   }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_631] Verify pagination in Manage blocked users screen.",
            groups = {"regression", "user_block"})
    public void verifyPaginationForBlockedUsers(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        UserBlockPage userBlockPage = new UserBlockPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("autoBlockedUser_02"));
        userBlockPage.clickOnSettings();
        userBlockPage.verifyPagination();
    }
}
