package com.framework.android.screens.userBlockPages;

import com.framework.android.utils.CommonHelper;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.MobileUtil;
import com.framework.utilities.ReportManager;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class UserBlockPage {
    MobileActions mobileActions = new MobileActions();
    String actualText;
    String testValue;

    /**
     * This method is to click on view more dots for koo except current user koo's
     *
     * @throws IOException
     * @throws InterruptedException
     */
    public void clickOnViewMoreDots(String userName) {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "viewMore_options",userName));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "viewMore_options",userName),
                "Click on three dots for view more options on koo card");
    }

    /**
     * This method is to swipe up
     */
    public void swipeUpToElementView(String userName) throws InterruptedException {
        mobileActions.swipeUpFindElement(50, MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "viewMore_options",userName));
    }

    /**
     * This method is to get block / unblock button text
     * @return
     */
    public String getBlockUnBlockButtonText(){
        return mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "blockUnblockButton"),
                "Get block/ unblock button text");
    }
    /**
     * This method is to verify Block and Unblock button
     *
     * @param language
     * @param expected_ButtonText
     */
    public void verifyBlockUnBlockButton(String language, String expected_ButtonText) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "blockUnblockButton"),
                "Block/Unblock button is visible for koo for language = " + language + " and button text is = " + expected_ButtonText),
                expected_ButtonText);
        ReportManager.logPass(expected_ButtonText + " button is visible successfully for language = " + language);
    }

    /**
     * This method is to click on block/ unblock button
     *
     * @param blockButtonText
     * @throws IOException
     */
    public void clickButton(String blockButtonText) {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "blockUnblockButtonWithText", blockButtonText));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "blockUnblockButtonWithText", blockButtonText),
                "Click on block button");
        ReportManager.logInfo("Click on button " + blockButtonText);
    }

    /**
     * This method is to verify block unblock popup text
     *
     * @param blockPopUpText_expected
     */
    public void verifyBlockUnBlockPopUpText(String blockPopUpText_expected, String language) {
        Assert.assertEquals(mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "blockUnblockPopUpText"),
                "Block popup text is correct " + blockPopUpText_expected),blockPopUpText_expected);
        ReportManager.logPass("Block popup text is correct " + blockPopUpText_expected);
        ReportManager.logPass("Validated Block PopUp heading text for language = " + language);
    }

    /**
     * This method is to verify No button text
     *
     * @param noButtonText_expected
     */
    public void verifyNoButton(String noButtonText_expected, String language) {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "noButton"));
        actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "noButton"),
                "Get text of No button");
        Assert.assertEquals(actualText, noButtonText_expected, "No button text is correct");
        ReportManager.logPass("Validated No button text for language = " + language);
    }

    /**
     * This method is to verify Ok button text
     *
     * @param okButtonText_expected
     */
    public void verifyOkButton(String okButtonText_expected, String language) {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "okButton"));
        actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "okButton"),
                "Get text of Ok button");
        Assert.assertEquals(actualText, okButtonText_expected, "Ok button text is correct");
        ReportManager.logPass("Validated Ok button text for language = " + language);
    }

    /**
     * This method is to click on ok button
     */
    public void clickOkButton() {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "okButton"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "okButton"),
                "Click on Ok button");
        ReportManager.logPass("Clicked on Ok button successfully");
    }

    /**
     * This method is to click on Search button from footer bar
     *
     * @throws IOException
     */
    public void clickSearchButton() {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "search_icon"),
                "Click on Search icon");
        ReportManager.logPass("Clicked on Search button successfully");
    }

    /**
     * This method is to verify searched user result
     *
     * @param userName
     * @throws IOException
     */
    public void verifySearchedUser(String userID, String userName) {
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "searchBar_field"),
                userID);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "searchBar_field"),
                "Click on search bar field");
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "searchedUserResult"));
        actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "searchedUserResult"),
                "Get text of Searched user that is = " + userName);
        Assert.assertTrue(actualText.contains(userName), "Searched user is not showing correct result");
        ReportManager.logPass("Verified search user is showing under search bar");
    }

    /**
     * This method is to click on searched user result
     *
     * @param userName
     * @throws IOException
     */
    public void clickOnSearchedUser(String userName) {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "searchedUserName", userName),
                "Click on searched user");
        ReportManager.logPass("Clicked on searched user");
    }

    /**
     * This method is to click on three dots from profile of user
     *
     * @throws IOException
     */
    public void clickOnThreeDots() {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "threeDots"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "threeDots"),
                "Click on three dots");
        ReportManager.logPass("Clicked on three dots successfully");
    }

    /**
     * This method is to click on Close button from settings
     *
     * @throws IOException
     */
    public void clickOnCloseButton() {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "closeButton"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "closeButton"),
                "Click on Back button");
        ReportManager.logPass("Clicked on Close button successfully");
    }

    /**
     * This method is to verify blocked user is visible under manage blocked user section/ page
     *
     * @param language
     * @param expectedText
     * @param userName
     * @param buttonText
     * @throws IOException
     */
    public void verifyManagedBlocked(String language, String expectedText, String userName, String buttonText) throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "profile_icon"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "profile_icon"),
                "Click on Profile icon");
        clickOnThreeDots();
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "settings"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "settings"),
                "Click on Settings");
        actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "manageBlockedUser"),
                "Get text of Manage Blocked User link for language = " + language);
        Assert.assertEquals(actualText, expectedText, "Manage blocked user link text is not proper expected is = " +
                expectedText + " Actual is = " + actualText);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "manageBlockedUser"),
                "Click on Manage Blocked link");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "searchedUserName", userName),
                "Blocked user is displaying successfully under manage blocked use page"));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "unblockButton"),
                "Now, unblock button is displaying successfully for blocked user"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "unblockButton"),
                "Click on unblock button");
        if(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "okButton"),
                "Pop Up is displaying")){
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "okButton"),
                    "Click on OK button");
        }
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "viewProfileButton"),
                "Now, View profile button is displaying successfully for after clicking on unblock button"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "viewProfileButton"),
                "Click on View Profile button");
        actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "profileName"),
                "Get text of profile name of user for language = " + language);
        Assert.assertEquals(actualText, userName, "User profile page is not opened expected is = " +
                userName + " Actual is = " + actualText);
        clickOnThreeDots();
        Assert.assertEquals(mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "blockUnblockButton"),
                "Block/Unblock button is visible for user for language = " + language + " and button text is = " + buttonText),
                buttonText);
        ReportManager.logPass(buttonText + " button is visible successfully for language = " + language);
        clickOnCloseButton();
        CommonHelper.verifyAndClickOnBackButtonOnProfilePage();
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "backButton_arrow"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "backButton_arrow"),
                "Click on Back button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "backButton_arrow"),
                "Click on Back button");
        CommonHelper.verifyAndClickOnBackButtonOnProfilePage();
        CommonHelper.clickOnHomeButton();
        clickOnSettings();
    }

    /**
     * this method is to verify unblocked user is not visible under manage blocked user section
     * @param userName
     * @throws IOException
     */
    public void verifyUnblockedUserNotDisplayUnderManageBlockedUser(String userName, int expectedSize) throws IOException {
        CommonHelper.clickOnHomeButton();
        clickOnSettings();
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "manageBlockedUser"),
                "Click on Manage Blocked link");
        List<WebElement> actualSize = DriverFactory.getInstance().getMobileDriver()
                .findElements(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "searchedUserName",userName));
        Assert.assertEquals(actualSize.size(),expectedSize,
                "UnBlocked user is not displaying successfully under manage blocked use page");
        ReportManager.logPass(" Unblocked user is not displaying under manage blocked section");
    }

    /**
     * This method is to click on settings button
     * @throws IOException
     */
    public void clickOnSettings() {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "profile_icon"),
                "Click on Profile icon");
        clickOnThreeDots();
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "settings"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "settings"),
                "Click on Settings");
        ReportManager.logInfo("Click on Settings");
    }

    /**
     * This method is to verify blocked user should not able to see that user with whom he/ she got blocked in search result
     * @param userID
     * @param userName
     * @throws IOException
     */
    public void verifyBlockedUserShouldNotDisplay(String userID, String userName) throws InterruptedException {
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "searchBar_field"),
                userID);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "searchBar_field"),
                "Click on search bar field");
        Thread.sleep(4000);
        List<WebElement> elements = DriverFactory.getInstance().getMobileDriver()
                .findElements(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "searchedUserFrame"));
        for(int i = 0; i <elements.size(); i++){
            String actualUserName = elements.get(i).getText();
            System.out.println("Actual UserName is = "+actualUserName);
            System.out.println("Expected UserName is = "+userName);
            Assert.assertNotEquals(actualUserName,userName,
                    "Actual username is equals to blocked username which is not correct");
            ReportManager.logInfo("Verified blocked user is not able to search that user which user blocked this user, the actual username is = "+actualUserName+
                    " expected username is = "+userName);
        }
        ReportManager.logPass("Verified blocked user is not able to search that user which user blocked this user");
    }

    /**
     * This method is to verify unblocked user can comment on koo post
     * @throws IOException
     * @throws InterruptedException
     */
    public void verifyUnblockedUserReactOnKoo(String userName, String commentSectionHeading) throws InterruptedException {
        mobileActions.swipeUpFindElement(10, MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "viewComment_icon"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "viewComment_icon"),
                "Click on View Comment Icon");
        mobileActions.swipeUpFindElement(10, MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "write_comment"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "write_comment"),
                "Click on Write Comment Input field");
        testValue = RandomStringUtils.randomAlphabetic(10)+"_AutoComment";
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "write_commentSection"),
                testValue,"Enter value in comment section");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "button_post"),
                "Click on post button");
        Thread.sleep(5000);
        //mobileActions.swipeUpFindElement(10, MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "commentHolder"));
        //mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "commentHolder"));
        /*mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "commentHolder"),
                "Click on View comment button");*/
        mobileActions.swipeDown(3);
        mobileActions.swipeUpFindElement(10, MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "postedCommentWithSpecificUser",userName));
        actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "posted_comment",commentSectionHeading),
                "Get actual posted comment = "+actualText);
        Assert.assertEquals(actualText, testValue,
                "Expected comment and actual posted comment is not showing correct, expected is ="+testValue+
                        " actual is = "+actualText);
    }

    /**
     * This method is to verify number of blocked users on manage blocked section along with pagination
     * @param expectedSizeOfBlockedUsers
     * @throws IOException
     */
    public void verifyPagination() {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "manageBlockedUser"),
                "Click on Manage Blocked link");
        List<WebElement> element = DriverFactory.getInstance().getMobileDriver()
                .findElements(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "multipleBlockedUsers"));
        int size_FirstPageUsers = element.size();
        mobileActions.swipeUp(2);
        List<WebElement> elements = DriverFactory.getInstance().getMobileDriver()
                .findElements(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "multipleBlockedUsers"));
        int size_SecondPageUsers = elements.size();
        Assert.assertTrue(size_FirstPageUsers==size_SecondPageUsers,
                "Number of blocked users are not correct");
        //Assert.assertEquals(size_FirstPageUsers+size_SecondPageUsers,expectedSizeOfBlockedUsers,"Number of blocked users are not correct");
        ReportManager.logPass("Verified number of blocked users on manage blocked section along with pagination");
    }
}