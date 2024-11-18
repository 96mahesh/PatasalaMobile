package com.framework.android.testcases.kooCardTests;

import com.framework.android.screens.homeScreenTabsPages.HomeScreenTabPage;
import com.framework.android.screens.kooCardPages.KooCardPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.screens.userBlockPages.UserBlockPage;
import com.framework.android.utils.CommonHelper;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
import org.apache.commons.lang.RandomStringUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class KooCardTest {
    String hashKey = "#";
    String atTheRate = "@";

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_295] Verify user is able to see Username on the top, profile image left to it, & handle below the name & profesion next to handle separated by a dot. Dot is not shown if profession is not added.",
            groups = {"regression", "kooCard"})
    public void verifyUserNameHandleProfessionFieldsOnEditProfile(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        KooCardPage kooCardPage = new KooCardPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        CommonHelper.clickOnProfile();
        CommonHelper.clickOnEditButtonFromProfilePage();
        kooCardPage.verifyUserNameHandleProfessionFields();
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_296] Verify timestamp on top right corner, option on koo card button next to it & 'Exclusive' tag below these. Tapping on exclisive user should land on Exclusive tab.",
            groups = {"regression", "kooCard"})
    public void verifyTimeStampOnRightOfKooCard(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        KooCardPage kooCardPage = new KooCardPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        kooCardPage.verifyTimeStampOnRightOfKooCard();
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_297] Verify \"+Follow\" button in blue on OON koos on feed & \"+\" icon with placeholder icon for OON koos on every where else on the app.",
            groups = {"regression", "kooCard"})
    public void verifyPlusFollowButtonOnRightSideOfKoo(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        KooCardPage kooCardPage = new KooCardPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        kooCardPage.verifyPlusFollowButtonOnRightSideOfKoo();
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_298] Verify tapping on follow button on OON koos, user should be followed & View Koos From button should be displayed.",
            groups = {"regression", "kooCard"})
    public void verifyUserShouldBeFollowedAndViewKooButton(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        KooCardPage kooCardPage = new KooCardPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("userNameAuto"));
        kooCardPage.verifyOnClickPlusFollowButtonUserShouldBeFollowedAndViewKooBtn();
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_299] Verify Save Koos icon on top right corner next to timestamp and tapping on it koo should be saved and same should show in Saved Koos tab.",
            groups = {"regression", "kooCard"})
    public void verifySaveKooIconAndUserCanSaveKoo(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        KooCardPage kooCardPage = new KooCardPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("userNameAuto"));
        CommonHelper.clickOnProfile();
        kooCardPage.verifySaveKooIcon();
        kooCardPage.verifyUserCanSaveKoo(LanguageDataProvider.getLanguageDataValue("RemoveSaveKooText"));
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_301, TC_302] Verify koo title below the name & handle, media attached below the title & reaction buttons at the bottom.",
            groups = {"regression", "kooCard"})
    public void verifyKooTitleMediaReactionBar(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        KooCardPage kooCardPage = new KooCardPage();
        HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("userNameAuto"));
        String kooText = "AutoKoo_" + RandomStringUtils.randomAlphabetic(10);
        CommonHelper.createAndPostKooWithAttachment(language, kooText, LanguageDataProvider.getLanguageDataValue("PostButtonText"));
        CommonHelper.clickOnViewPostedKooButtonAfterPostingKooOrComment();
        kooCardPage.verifyKooTitle(kooText);
        kooCardPage.verifyKooMedia();
        homeScreenTabPage.verifyReactionBarIcons();
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_308] Verify hashtags with '#' before the text & mentions with '@' before the text on koo card & should be in blue colour.",
            groups = {"regression", "hashtag_details_screen"})
    public void verifyHashTagAndAtTheRateBeforeText(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        KooCardPage kooCardPage = new KooCardPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        kooCardPage.createKooWithHashTagAndAtTheRate(language, hashKey, atTheRate, LanguageDataProvider.getLanguageDataValue("PostButtonText"));
        CommonHelper.clickOnViewPostedKooButtonAfterPostingKooOrComment();
        kooCardPage.verifyKooTitleStartsWithHashTagAndAtTheRate(hashKey, atTheRate);
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_310] Verify user should be able to see all types on Media, Texts & Poll koos on koo card:\n" +
                    " Audio, Video, Image, Youtube video, Weblink, GIF.",
            groups = {"regression", "hashtag_details_screen"})
    public void verifyUserCanSeeAllTypesOfMedia(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        KooCardPage kooCardPage = new KooCardPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        kooCardPage.verifyKooImage().verifyWebLinkOnKoo();
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_303, TC_304] Verify Reaction count on Like Comment & Rekoo should be showing exactly as the reaction received on koo.",
            groups = {"regression", "kooCard"})
    public void verifyLikeCommentRekooCount(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        KooCardPage kooCardPage = new KooCardPage();
        UserBlockPage userBlockPage = new UserBlockPage();
        String expectedCount = "1";
        loginKooPage.loginValidUser(language, ConfigReader.getValue("user1_verifyLikeCommentRekooCount"));
        String kooText = "AutoKoo_" + RandomStringUtils.randomAlphabetic(10);
        CommonHelper.createAndPostKoo(language, kooText, LanguageDataProvider.getLanguageDataValue("PostButtonText"));
        CommonHelper.clickOnProfile();
        CommonHelper.clickOnThreeDotsOProfilePage();
        CommonHelper.clickSettingsButton();
        CommonHelper.logOutUser();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("user2_verifyLikeCommentRekooCount"));
        CommonHelper.clickOnSearchIcon();
        CommonHelper.enterValueInSearchBar(ConfigReader.getValue("userHandleName_1_verifyLikeCommentRekooCount"));
        CommonHelper.clickOnSearchBarField();
        CommonHelper.clickEnterButton();
        userBlockPage.clickOnSearchedUser(ConfigReader.getValue("userName_1_verifyLikeCommentRekooCount"));
        kooCardPage.clickOnKooPost(kooText);
        kooCardPage.verifyLikeCount(expectedCount);
        kooCardPage.verifyReKooCount(expectedCount);
        String commentText = "AutoKoo_" + RandomStringUtils.randomAlphabetic(10);
        kooCardPage.verifyCommentCount(commentText, expectedCount);
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_306] Verify language switch button on MLK koos, tapping on which language is switched & respective content is shown.",
            groups = {"regression", "kooCard"})
    public void verifyLanguageSwitchBtnOnMLKKoo(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        KooCardPage kooCardPage = new KooCardPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("userNameAuto"));
        String kooText = "This is my multi language testing koo";
        List<String> languages = Arrays.asList("Hindi_checkBox",
                "Kannada_checkBox",
                "Tamil_checkBox",
                "Telugu_checkBox",
                "Marathi_checkBox",
                "Bengali_checkBox",
                "Gujarati_checkBox",
                "Portuguese_checkBox");
        CommonHelper.createAndPostMLKKoo(language, kooText, LanguageDataProvider.getLanguageDataValue("PostButtonText"),
                languages);
        CommonHelper.clickOnViewPostedKooButtonAfterPostingKooOrComment();

        kooCardPage.clickOnMLKButtonToSwitchLanguageAndVerifyKooTextChanged(language);
    }
}