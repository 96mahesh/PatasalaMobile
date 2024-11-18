package com.framework.android.screens.kooCardPages;

import com.codoid.products.exception.FilloException;
import com.framework.android.utils.CommonHelper;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.ExcelDataReader;
import com.framework.utilities.MobileUtil;
import com.framework.utilities.ReportManager;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class KooCardPage {
    MobileActions mobileActions = new MobileActions();
    SoftAssert softAssert = new SoftAssert();

    /**
     * This method is to verify Name, Handle and profession fields on Edit profile page
     *
     * @return
     */
    public KooCardPage verifyUserNameHandleProfessionFields() {
        mobileActions.swipeUsingID("float_name");
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "nameField"));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "nameField"),
                "Verify Name field on Edit Profile page"));
        ReportManager.logPass("Verify Name field on Edit Profile page");

        mobileActions.swipeUsingID("float_handle");
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "handleField"));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "handleField"),
                "Verify Handle field on Edit Profile page"));
        ReportManager.logPass("Verify Handle field on Edit Profile page");

        mobileActions.swipeUsingID("float_profession");
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "professionField"));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "professionField"),
                "Verify Profession field on Edit Profile page"));
        ReportManager.logPass("Verify Profession field on Edit Profile page");
        return this;
    }

    /**
     * This method is to verify time stamp on right side of koo card
     *
     * @return
     */
    public KooCardPage verifyTimeStampOnRightOfKooCard() {
        mobileActions.swipeUsingID("koo_time_creation_tv");
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "kooCreationTimeStamp"));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "kooCreationTimeStamp"),
                "Verify Time Stamp on right side of koo card"));
        ReportManager.logPass("Verify Time Stamp on right side of koo card");
        return this;
    }

    /**
     * This method is to verify + follow button on right side of koo on feed page
     *
     * @return
     */
    public KooCardPage verifyPlusFollowButtonOnRightSideOfKoo() {
        mobileActions.swipeUsingID("tvFollowStatus");
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "plusFollowButton"));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "plusFollowButton"),
                "verify + follow button on right side of koo on feed page"));
        ReportManager.logPass("verify + follow button on right side of koo on feed page");
        return this;
    }

    /**
     * This method is to verify + follow button on right side of koo on feed page
     *
     * @return
     */
    public KooCardPage verifyOnClickPlusFollowButtonUserShouldBeFollowedAndViewKooBtn() {
        mobileActions.swipeUsingID("tvFollowStatus");
        mobileActions.swipeUp(1);
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "plusFollowButton"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "plusFollowButton"),
                "Click on + follow button for koo card from feed page");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow", "miniPillButton"),
                "verify View Koo button is showing"));
        ReportManager.logPass("verify View Koo button is showing");

        // Now, verify user is followed
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "menu_drafthamberger"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "menu_drafthamberger"),
                "Click on two dots for view more options on Koo card");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_followingInPublicProfile"),
                "Click on following button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_yes"),
                "Click on Yes Button to unfollow the user");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "plusFollowButton"),
                "verify + follow button on right side of koo on feed page"));
        ReportManager.logPass("verify + follow button on right side of koo on feed page");
        return this;
    }

    /**
     * This method is to Verify Save Koo button on koo card
     *
     * @return
     */
    public KooCardPage verifySaveKooIcon() {
        mobileActions.swipeUsingID("btnAddToFavorite");
        mobileActions.swipeUp(1);
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_saved"));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_saved"),
                "Verify Save Koo button on koo card"));
        ReportManager.logPass("Verify Save Koo Icon");
        return this;
    }

    /**
     * This method is to verify user can save the koo and remove the saved koo
     *
     * @return
     */
    public KooCardPage verifyUserCanSaveKoo(String removeSavedKooText) {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_saved"),
                "Click on Save koo button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "btn_dots"),
                "Click on two dots on koo");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "saveKooRemoveKooText",
                        removeSavedKooText),
                "Verify Remove Save Koo button on koo card after saving the koo"));

        // Now, unsaved the koo
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "addToFavoriteButton"),
                "Click on Remove Save Koo button");
        return this;
    }

    /**
     * This method is to verify posted koo title
     *
     * @param expectedKooTitle
     * @return
     */
    public KooCardPage verifyKooTitle(String expectedKooTitle) {
        Assert.assertEquals(mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard",
                        "title"), "Get actual title of posted koo"),
                expectedKooTitle, "Actual posted koo and expected koo title is not correct");
        ReportManager.logPass("Verified Actual posted koo and expected koo title is correct");
        return this;
    }

    /**
     * This method is to verify koo image/ media
     *
     * @return
     */
    public KooCardPage verifyKooMedia() {
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard",
                        "image"), "Verify koo media image is displaying"),
                "Koo Image media is not showing");
        ReportManager.logPass("Verified Koo Image media is showing");
        return this;
    }

    public KooCardPage createKooWithHashTagAndAtTheRate(String language, String hashTag, String atTheRate, String postButton) {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"), "Click on Plus Button");
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"), hashTag);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "hasTag_PopUp"),
                "Click on first hashtag result from popup");
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"), atTheRate);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "atTheRatePopUp"),
                "Click on first @ at the rate result from popup");
        mobileActions.click(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", postButton),
                "Click on Post Button");
        if (language.equalsIgnoreCase("English")) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_okScheduleKoo"),
                    "Click ok Schedule Koo button");
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "languageDoneButton"),
                    "Click on Done button");
        }
        return this;
    }

    /**
     * This method is to verify koo tile starts with hashtag and at the rate
     *
     * @param hashTag
     * @param atTheRate
     * @return
     */
    public KooCardPage verifyKooTitleStartsWithHashTagAndAtTheRate(String hashTag, String atTheRate) {
        String actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard",
                "title"), "Get actual title of posted koo");
        String[] array = actualText.split(" ");
        Assert.assertTrue(array[0].startsWith(hashTag),
                "Hash Tag is showing successfully before the koo text");
        ReportManager.logPass("Verified Hash Tag is showing successfully before the koo text");
        Assert.assertTrue(array[1].startsWith(atTheRate),
                "at the rate @ is showing successfully before the koo text");
        ReportManager.logPass("Verified at the rate @ is showing successfully before the koo text");
        return this;
    }

    /**
     * This method is to Verify Save Koo button on koo card
     *
     * @return
     */
    public KooCardPage verifyWebLinkOnKoo() {
        mobileActions.swipeUsingID("link_preview_link");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "webLink"),
                "Verify Web Link on Koo"));
        ReportManager.logPass("Verified Web Link on Koo");
        return this;
    }

    /**
     * This method is to Verify Save Koo button on koo card
     *
     * @return
     */
    public KooCardPage verifyKooImage() {
        mobileActions.swipeUsingID("single_image");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "kooImage"),
                "Verify Image on Koo"));
        ReportManager.logPass("Verified Image on Koo");
        return this;
    }

    /**
     * This method is to click on koo title as per the specific koo post title
     *
     * @param kooText
     * @return
     */
    public KooCardPage clickOnKooPost(String kooText) {
        mobileActions.swipeUsingText(kooText);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "kooTitle", kooText),
                "Click on Koo Title");
        return this;
    }

    /**
     * This method is to like koo and verify count
     *
     * @param expectedLikeCount
     * @return
     */
    public KooCardPage verifyLikeCount(String expectedLikeCount) {
        CommonHelper.clickOnLikeIcon();
        String actualLikeCount = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "likeCount"));
        Assert.assertEquals(actualLikeCount, expectedLikeCount, "Like count is not correct expected is = " + expectedLikeCount
                + " actual is showing = " + actualLikeCount);
        ReportManager.logPass("Verified Like count is correct expected is = " + expectedLikeCount +
                "                +  actual is showing =  " + actualLikeCount);
        return this;
    }

    /**
     * This method is to do rekoo and verify count
     *
     * @param expectedReKooCount
     * @return
     */
    public KooCardPage verifyReKooCount(String expectedReKooCount) {
        CommonHelper.clickOnReKooIconAndNoReKooButton();
        String actualReKooCount = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "reeKooCount"));
        Assert.assertEquals(actualReKooCount, expectedReKooCount, "ReKoo count is not correct expected is = " + expectedReKooCount
                + " actual is showing = " + actualReKooCount);
        ReportManager.logPass("Verified ReKoo count is correct expected is = " + expectedReKooCount
                + " actual is showing = " + actualReKooCount);
        return this;
    }

    /**
     * This method is to write comment and verify comment count
     *
     * @param commentText
     * @param expectedCommentCount
     * @return
     */
    public KooCardPage verifyCommentCount(String commentText, String expectedCommentCount) {
        CommonHelper.clickOnCommentIconAndPostComment(commentText);
        CommonHelper.clickOnRefreshIconToRefreshComments();
        String actualCommentCount = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "commentTextCountForKoo"));
        Assert.assertEquals(actualCommentCount, expectedCommentCount, "Comment count is not correct expected is = " + expectedCommentCount
                + " actual is showing = " + actualCommentCount);
        ReportManager.logPass("Verified Comment count is correct expected is = " + expectedCommentCount
                + " actual is showing = " + actualCommentCount);
        return this;
    }

    /**
     * This method is to click on switch button for multiple language
     *
     * @return
     */
    public KooCardPage clickOnMLKButtonToSwitchLanguageAndVerifyKooTextChanged(String language) throws FilloException {
        LinkedHashMap<String, String> availableLanguages = ExcelDataReader.getLanguagesFromHomePage("AvailableLanguages");
        List<String> mlkKooText = ExcelDataReader.getMLKTextFromExcelSheet();
        for (Map.Entry<String, String> entry : availableLanguages.entrySet()) {
            for (int i = 0; i < mlkKooText.size(); i++) {
                WebElement elementsOne = DriverFactory.getInstance().getMobileDriver()
                        .findElement(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "mlkButton",
                                entry.getValue()));
                mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "mlkButton",
                                entry.getValue()),
                        "Click on multi select language button to switch language");
                String actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard",
                        "title"));

                softAssert.assertEquals(actualText, mlkKooText.get(i),
                        "After click on change language button for MLK Koo the text is not changed, this is not correct. " +
                                "The expected test is  = " + mlkKooText.get(i) + " but actual text is showing = " + actualText);

                ReportManager.logInfo("After click on change language button for MLK Koo the text is changed, " +
                        "The expected test is  = " + mlkKooText.get(i + 1) + " but actual text is showing = " + actualText);
                softAssert.assertEquals(actualText, mlkKooText.get(i + 1),
                        "After click on change language button for MLK Koo the text is not changed, this is not correct. " +
                                "The expected test is  = " + mlkKooText.get(i + 1) + " but actual text is showing = " + actualText);

                ReportManager.logInfo("After click on change language button for MLK Koo the text is changed, " +
                        "The expected test is  = " + mlkKooText.get(i + 1) + " but actual text is showing = " + actualText);
                int a = i++;
                break;
            }
            //mobileActions.swipeLeftOrRight(elementsOne, "LEFT");
        }
        softAssert.assertAll();
        return this;
    }
}
