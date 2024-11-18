package com.framework.android.screens.registerationAndLoginFlowPages;

import com.framework.android.utils.CommonHelper;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.MobileUtil;
import com.framework.utilities.ReportManager;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class GoogleEmailPopUpPage {
    MobileActions mobileActions = new MobileActions();

    /**
     * This method is to verify add profile page and registration page
     *
     * @param language
     * @param buttonText
     * @throws IOException
     * @throws InterruptedException
     */
    public void verifyAllGmailAccounts(String language, String buttonText) throws IOException, InterruptedException {
        mobileActions.swipeUpFindElement(2, MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "app_Language", language));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "app_Language", language),
                "Checked " + language + " language successfully");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "signInGoogle_button", buttonText),
                "clicked " + buttonText + " button successfully for language = " + language);
        Thread.sleep(4000);
        // Registered email popup is ot showing on browser stack
        try {
            Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen",
                    "chooseAccount_button"), "Verify Choose Account popup is displaying"));
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "select_account"),
                    "Select google account successfully");
            Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen",
                    "profile_registration"), "Verify User Registration Or Add Profile image page is displaying for language = " + language));
        } catch (Exception e) {
            System.out.println("Gmail login popup is not visible");
        }
    }

    /**
     * This method is to click on add account button
     *
     * @return
     * @throws IOException
     */
    public GoogleEmailPopUpPage clickOnAddAccount() throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("RegistrationFlow", "addAccount"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("RegistrationFlow", "addAccount"),
                "Click on Add Account button");
        return this;
    }

    /**
     * This method is to verify choose account popup should not display while addig multi child account
     * @param expectedSize
     * @return
     * @throws IOException
     */
    public GoogleEmailPopUpPage verifyRegistrationPopUpNotDisplayForMultiChildAccount(int expectedSize) throws IOException {
        CommonHelper.clickOnProfile();
        CommonHelper.clickOnThreeDotsOProfilePage();
        CommonHelper.clickSettingsButton();
        clickOnAddAccount();

        List<WebElement> actualSizeOfChooseAccountElements = DriverFactory.getInstance().getMobileDriver().findElements
                (MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "chooseAccount_button"));
        Assert.assertEquals(actualSizeOfChooseAccountElements.size(),expectedSize,
                "Verify Choose Account popup is not displaying on add account page");
        return this;
    }

    /**
     * This method is to verify child account added successfully
     * @return
     * @throws IOException
     */
    public GoogleEmailPopUpPage verifyChildAccountAdded() throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("RegistrationFlow", "expandProfile"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("RegistrationFlow", "expandProfile"),
                "Click on Expand profile icon");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("RegistrationFlow",
                "addAccountLink"),
                "Verify Add Account link is visible"));
        return this;
    }

    /**
     * Verify child account got logged out successfully
     * @param expectedHeading
     * @return
     * @throws IOException
     */
    public GoogleEmailPopUpPage verifyChildUserLoggedOut(String expectedHeading) throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("RegistrationFlow", "expandProfile"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("RegistrationFlow", "expandProfile"),
                "Click on Expand profile icon");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("RegistrationFlow", "settingsIcon"),
                "Click on Settings icon");
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "logOutUser"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "logOutUser"),
                "Logout user");
        CommonHelper.clickOnProfile();
        CommonHelper.clickOnThreeDotsOProfilePage();
        CommonHelper.clickSettingsButton();
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
     * This method is to login child user from add account
     * @param mobileNumber
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public GoogleEmailPopUpPage loginChildUser(String mobileNumber) throws IOException, InterruptedException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "MobNo_txt"));
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "MobNo_txt"),
                mobileNumber);
        Thread.sleep(9000);
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "otp_text"),
                ConfigReader.getValue("Password"));
        Thread.sleep(5000);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "verify_btn"),
                "Click on Verify button");
        return this;
    }
}