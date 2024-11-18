package com.framework.android.screens.settingsScreenPages;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.MobileUtil;
import com.framework.utilities.ReportManager;
import org.openqa.selenium.html5.Location;
import org.testng.Assert;

import java.io.IOException;

public class SettingsScreenPage {
    MobileActions mobileActions = new MobileActions();
    String actualText;

    /**
     * This method is to verify settings button
     *
     * @param expectedText
     */
    public SettingsScreenPage verifySettingsButton(String expectedText) {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "settings"));
        actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "settings"),
                "Get text of Settings button");
        Assert.assertEquals(actualText, expectedText, "Settings button text is correct");
        ReportManager.logPass("Validated Settings button text = " + actualText);
        return this;
    }

    /**
     * This method is to click on settings button
     *
     * @return
     * @throws IOException
     */
    public SettingsScreenPage clickSettingsButton() throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "settings"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "settings"),
                "Click on Settings button");
        return this;
    }

    /**
     * This method is to verify sections on settings page
     *
     * @param expectedHeading
     * @return
     */
    public SettingsScreenPage verifySectionsHeadingAndSubLinksHeadings(String expectedHeading) throws InterruptedException {
        mobileActions.swipeUpFindElement(10,
                MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "settingsSectionHeading", expectedHeading));
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "settingsSectionHeading", expectedHeading));
        mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "settingsSectionHeading", expectedHeading),
                "Verify Settings page sections and it's sub heading = " + expectedHeading);
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "settingsSectionHeading", expectedHeading),
                "Verify Settings page sections and it's sub heading = " + expectedHeading));
        System.out.println("Verify Settings page sections and it's sub heading = " + expectedHeading);
        ReportManager.logPass("Verify Settings page sections and it's sub headings = " + expectedHeading);
        return this;
    }

    /**
     * This method is to click on link on settings page
     *
     * @param linkName
     * @throws InterruptedException
     */
    public SettingsScreenPage clickOnLink(String linkName) throws InterruptedException, IOException {
        mobileActions.swipeUpFindElement(10,
                MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "settingsSectionHeading", linkName));
        Thread.sleep(5000);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "settingsSectionHeading", linkName),
                "Click on link = " + linkName);
        return this;
    }

    /**
     * This method is to verify Edit Profile page
     *
     * @param expectedTextOfEditProfileHeading
     * @return
     * @throws InterruptedException
     * @throws IOException
     */
    public SettingsScreenPage verifyEditProfileAction(String expectedTextOfEditProfileHeading) throws InterruptedException, IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "editProfileHeading"));
        actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "editProfileHeading"),
                "Get text of Edit Profile link");
        Assert.assertEquals(actualText, expectedTextOfEditProfileHeading, "Edit Profile page is displaying successfully = " + expectedTextOfEditProfileHeading);
        return this;
    }

    /**
     * This method is to verify Share koo profile action
     *
     * @param expectedTextOfShareKooPopUpHeading
     * @return
     */
    public SettingsScreenPage verifyShareYourKooProfileAction(String expectedTextOfShareKooPopUpHeading) {
        boolean shareKooPopUpHeading = mobileActions.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "shareKooPopUpHeading"));
        if(shareKooPopUpHeading){
            mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "shareKooPopUpHeading"));
            actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "shareKooPopUpHeading"),
                    "Get text of Share koo popup heading");
            Assert.assertEquals(actualText, expectedTextOfShareKooPopUpHeading, "Share koo popup is displaying successfully = " + expectedTextOfShareKooPopUpHeading);
        } else {
            Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "shareKooPopUp"),
                    "Verify share koo pop up"));
            ReportManager.logInfo("Verify share koo pop up");
        }
        return this;
    }

    /**
     * This method is to verify Apply For Self Verification action
     *
     * @param expectedHeading
     * @return
     */
    public SettingsScreenPage verifyApplyForSelfVerificationAction(String expectedHeading) {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "applySelfVerificationPageHeading"));
        actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "applySelfVerificationPageHeading"),
                "Get text of Self Verification page heading");
        Assert.assertEquals(actualText, expectedHeading, "ESelf Verification page heading is displaying successfully = " + expectedHeading);
        return this;
    }

    /**
     * This method is to verify Apply For Self Eminence action
     *
     * @param expectedURL
     * @return
     */
    public SettingsScreenPage verifyApplyForEminenceAndHelpAction(String expectedURL) {
        boolean value = mobileActions.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "applySelfEminenceAndHelp"));
        if(value){
            mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "applySelfEminenceAndHelp"));
            actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "applySelfEminenceAndHelp"),
                    "Get text of Self Verification page heading");
			/*
			 * Assert.assertEquals(actualText, expectedURL,
			 * "Koo Account of Eminence - Application Form page is not correct expected url is = "
			 * + expectedURL +"Actual url is = "+actualText);
			 */
        } else {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "continueBtnForBrowserPermission"),
                    "Click on continue button to grant browser permission");
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "continueBtnForBrowserPermission"),
                    "Click on ok got it button to grant browser permission");
        }

        return this;
    }

    /**
     * This method is expectedHeading verify Migrate From Twitter action
     *
     * @param expectedHeading
     * @return
     */
    public SettingsScreenPage verifyMigrateFromTwitterAction(String expectedHeading) {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "migrateFromTwitterPopUpHeading", expectedHeading));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "migrateFromTwitterPopUpHeading", expectedHeading),
                "Migrate From Twitter page is displaying successfully = " + expectedHeading));
        return this;
    }

    /**
     * This method is click on close button from migrate from twitter popup
     *
     * @param buttonText
     * @return
     */
    public SettingsScreenPage clickCloseButtonForMigrateFromTwitterPopUp(String buttonText) throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "migrateFromTwitterCloseButton", buttonText));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "settingsSectionHeading", buttonText),
                "Click on close button = " + buttonText);
        return this;
    }

    /**
     * This method is to verify Manage Account action
     *
     * @param expectedHeading
     * @return
     */
    public SettingsScreenPage verifyManageAccountAction(String expectedHeading) {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "manageAccountAndNotificationsPageHeading"));
        actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "manageAccountAndNotificationsPageHeading"),
                "Get text of Manage Account page heading");
        Assert.assertEquals(actualText, expectedHeading, "Manage Account page is displaying successfully = " + expectedHeading);
        return this;
    }

    /**
     * This method is to verify Logout action
     *
     * @param expectedHeading
     * @return
     */
    public SettingsScreenPage verifyLogOutAction(String expectedHeading) {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "logOutPopUpHeading"));
        actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "logOutPopUpHeading"),
                "Get text of LogOut popup heading");
        Assert.assertEquals(actualText, expectedHeading, "Logout popup is displaying successfully = " + expectedHeading);
        return this;
    }

    /**
     * This method is to verify Delete action
     *
     * @param expectedHeading
     * @return
     */
    public SettingsScreenPage verifyDeleteAction(String expectedHeading) {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "deletePopUPText", expectedHeading));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "deletePopUPText", expectedHeading),
                "Delete account popup is displaying successfully = " + expectedHeading));
        return this;
    }

    /**
     * This method is to verify Logout action
     *
     * @param expectedHeading
     * @return
     */
    public SettingsScreenPage verifyNotificationsAction(String expectedHeading) {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "manageAccountAndNotificationsPageHeading"));
        actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "manageAccountAndNotificationsPageHeading"),
                "Get text of Notifications page heading");
        Assert.assertEquals(actualText, expectedHeading, "Notifications page is displaying successfully = " + expectedHeading);
        return this;
    }

    /**
     * This method is to verify Privacy Policy action
     *
     * @param expectedHeading
     * @return
     */
    public SettingsScreenPage verifyPrivacyPolicyAndAboutUsAction(String expectedHeading) {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "privacyPolicyAndAboutUsPage", expectedHeading));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "privacyPolicyAndAboutUsPage", expectedHeading),
                "Page is displaying successfully = " + expectedHeading));
        return this;
    }

    /**
     * This method is to verify change in english text for all languages except english
     *
     * @param language
     * @param expectedText
     * @return
     */
    public SettingsScreenPage verifyChangeInEnglishText(String language, String expectedText) throws InterruptedException {
        if (!language.equalsIgnoreCase("English")) {
            mobileActions.swipeUpFindElement(10,
                    MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "changeInEnglishText", expectedText));
            mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "changeInEnglishText", expectedText));
            Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "changeInEnglishText", expectedText),
                    "Verify Change in english for all languages except English displaying successfully = " + expectedText));
        }
        return this;
    }

    /**
     * This method is to click on change in english button
     *
     * @param language
     * @param changeInEnglishText_Expected
     * @return
     * @throws IOException
     */
    public SettingsScreenPage verifyChangeInEnglishAction(String language, String changeInEnglishText_Expected, String expectedFeedText) throws IOException, InterruptedException {
        if (!language.equalsIgnoreCase("English")) {
            mobileActions.swipeUpFindElement(10,
                    MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "changeInEnglishText", changeInEnglishText_Expected));
            mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "switchButton", changeInEnglishText_Expected));
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "switchButton", changeInEnglishText_Expected),
                    "Click on change in english button for language = " +language);
            mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "feedTab_Text", expectedFeedText));
            Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "feedTab_Text",
                    expectedFeedText), "Feed tab text is not correct for language = "
                    + language + " Expected Text is = " + expectedFeedText));
        }
        return this;
    }

    public SettingsScreenPage setLocation(){
        DriverFactory.getInstance().getMobileDriver().setLocation(new Location(17.387140, 78.491684, 524));
        return this;
    }
}