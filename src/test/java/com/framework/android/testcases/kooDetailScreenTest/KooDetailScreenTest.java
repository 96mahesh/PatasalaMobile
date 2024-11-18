package com.framework.android.testcases.kooDetailScreenTest;

import com.codoid.products.exception.FilloException;
import com.framework.android.screens.kooDetailScreenPages.KooDetailScreenPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.CommonHelper;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class KooDetailScreenTest {

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_407, TC_307] Verify on tapping any koo title or the left side on koo card user enters koo detail screen.",
            groups = {"regression", "koo_detail_screen"})
    public void verifyKooDetailScreenPage(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        KooDetailScreenPage kooDetailScreenPage = new KooDetailScreenPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        kooDetailScreenPage.verifyKooDetailScreen();
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_408, TC_413] Verify back button & koo bird icon functionality on top bar & hard refresh on the screen.",
            groups = {"regression", "koo_detail_screen"})
    public void verifyBackButtonAndBirdIconFunctionality(String language) throws FilloException, IOException, InterruptedException {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("userNameAuto"));
        CommonHelper.clickOnProfile();
        CommonHelper.verifyProfileUserName(ConfigReader.getValue("userProfileName"));
        CommonHelper.verifyAndClickOnBackButtonOnProfilePage();
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_423, TC_424, TC_425, TC_426, TC_419, TC_422, TC_305] Verify user can hide comments in koo details screen but options on comment card.",
            groups = {"regression", "koo_detail_screen"})
    public void verifyUserCanHideComments(String language) throws FilloException, IOException, InterruptedException {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        KooDetailScreenPage kooDetailScreenPage = new KooDetailScreenPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("userNameAuto"));
        String kooText = "AutoKoo_" + RandomStringUtils.randomAlphabetic(10);
        String commentText = "AutoComment_" + RandomStringUtils.randomAlphabetic(10);
        CommonHelper.createAndPostKoo(language, kooText, LanguageDataProvider.getLanguageDataValue("PostButtonText"));
        kooDetailScreenPage.verifyHideCommentAndEyeIcon(kooText, commentText, LanguageDataProvider.getLanguageDataValue("PostButtonText"), LanguageDataProvider.getLanguageDataValue("CommentsSectionHeading"));
        kooDetailScreenPage.verifyUserCanUnHideComment(LanguageDataProvider.getLanguageDataValue("CommentsSectionHeading"));
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_411] Verify reaction bar on comments & exact count should be shown.",
            groups = {"regression", "koo_detail_screen"})
    public void verifyReactionBarOnCommentsAndExactCountOfComments(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        KooDetailScreenPage kooDetailScreenPage = new KooDetailScreenPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("userNameAuto"));
        kooDetailScreenPage.verifyExactCountOfComments();
        CommonHelper.clickOnBackArrow();
        CommonHelper.clickOnHomeButton();
        String kooText = "AutoKoo_" + RandomStringUtils.randomAlphabetic(10);
        String commentText = "AutoComment_" + RandomStringUtils.randomAlphabetic(10);
        CommonHelper.createAndPostKoo(language, kooText, LanguageDataProvider.getLanguageDataValue("PostButtonText"));
        kooDetailScreenPage.verifyReactionBarOnComments(LanguageDataProvider.getLanguageDataValue("CommentsSectionHeading"),
                commentText, LanguageDataProvider.getLanguageDataValue("PostButtonText"), kooText);
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_414] Verify 10 comments should load with 'View more comments' pagination button for comments.",
            groups = {"regression", "koo_detail_screen"})
    public void verifyViewMoreOptionOnComments(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        KooDetailScreenPage kooDetailScreenPage = new KooDetailScreenPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("userNameAuto"));
        kooDetailScreenPage.verifyViewMoreOptionOnComments();
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_417, TC_313] Verify video should continue to play on entering/exiting full koo detail screen.",
            groups = {"regression", "koo_detail_screen"})
    public void verifyVideoContinuePlayInKooDetailPage(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        KooDetailScreenPage kooDetailScreenPage = new KooDetailScreenPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("userNameAuto"));
        kooDetailScreenPage.verifyVideoContinuePlayOnKooDetailPage(0);
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_412, TC_311, TC_312] Verify user should be able to participate on poll & big button should show if it is OON koo.",
            groups = {"regression", "koo_detail_screen"})
    public void verifyUserCanSeeAndParticipateOnPollKooAndBigFollowButton(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        KooDetailScreenPage kooDetailScreenPage = new KooDetailScreenPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("userNameAuto"));
        String kooText = "AutoKoo_" + RandomStringUtils.randomAlphabetic(10);
        String pollOneText = "AutoKoo_" + RandomStringUtils.randomAlphabetic(10);
        String pollTwoText = "AutoKoo_" + RandomStringUtils.randomAlphabetic(10);
        kooDetailScreenPage.createPollKoo(language, kooText, pollOneText, pollTwoText,
                LanguageDataProvider.getLanguageDataValue("PostButtonText"));
        CommonHelper.clickOnProfile();
        CommonHelper.clickOnThreeDotsOProfilePage();
        CommonHelper.clickSettingsButton();
        CommonHelper.logOutUser();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("autoNewUserForPollKoo"));
        CommonHelper.clickOnSearchIcon();
        CommonHelper.enterValueInSearchBar(ConfigReader.getValue("userID"));
        CommonHelper.clickOnSearchBarField();
        CommonHelper.clickEnterButton();
        CommonHelper.clickSearchedProfileFromSearchResult(ConfigReader.getValue("userProfileName"));
        kooDetailScreenPage.verifyUserCanParticipateOnPollAndBigFollowButton(kooText, pollOneText, "100%");
    }
}
