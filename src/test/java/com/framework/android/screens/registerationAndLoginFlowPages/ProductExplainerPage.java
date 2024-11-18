package com.framework.android.screens.registerationAndLoginFlowPages;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.MobileUtil;
import com.framework.utilities.ReportManager;
import org.testng.Assert;

import java.io.IOException;

public class ProductExplainerPage {
    MobileActions mobileActions = new MobileActions();

    /**
     * This method is to verify email login screen after clicking on Sign In Email button
     * @param language
     * @param expectedSignInEmail_Page
     * @throws IOException
     * @throws InterruptedException
     */
    public void verifyEmailLoginScreen(String language, String expectedSignInEmail_Page) throws InterruptedException {
        mobileActions.swipeUpFindElement(2, MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "app_Language",language));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "app_Language",language),
                "Checked "+language+" language successfully");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "signIn_Email_Btn"),
                "Clicked Sign In with Email button for = "+language);
        String actualSignInEmail_Page = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "signIn_Email_Heading"));
        Assert.assertEquals(actualSignInEmail_Page, expectedSignInEmail_Page,"Sign In Email page is not opened for = "+language);
    }

    /**
     * This method is to verify Captcha popup after entering email id on sign in email page
     * @param language
     * @param email
     * @throws IOException
     */
    public void verifyCaptchaPopUpAfterEnteringEmailOnLoginPage(String language, String email) throws InterruptedException {
        mobileActions.swipeUpFindElement(2, MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "app_Language",language));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "app_Language",language),
                "Checked "+language+" language successfully");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "signIn_Email_Btn"),
                "Clicked Sign In with Email button for = "+language);
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "enter_email"),
                email);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "continue_email_button"),
                "Click on continue email button for = "+language);
        Thread.sleep(20000);
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen",
                "captcha_popup"),"Verify captcha popup for language = "+ language));
        ReportManager.logPass("Captcha popup is displaying successfully for sign in with email");
    }

    /**
     * This method is to verify Language change icon on sign in email page
     * @param language
     * @throws IOException
     */
    public void verifyLanguageChangeButtonOnSignInEmailPage(String language) throws InterruptedException {
        mobileActions.swipeUpFindElement(2, MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "app_Language",language));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "app_Language",language),
                "Checked "+language+" language successfully");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "signIn_Email_Btn"),
                "Clicked Sign In with Email button for = "+language);
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "back_button"),
                "Verify back button for language change is present on login via email page for language = "+language));
    }

    /**
     * This method is to verify captcha popup for international login
     * @param mobileNumber
     * @throws IOException
     */
    public void verifyCaptchaForInternationalLogin(String mobileNumber) throws InterruptedException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "change_countryCode"),
                "Click on change country code button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "select_countryCode",
                        "United States (US)"), "Selected international country code");
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "MobNo_txt"),
                mobileNumber);
        try{
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "OTP_btn"),
                    "Click on Get OTP button");
        } catch (Exception e){
            System.out.println("Click get OTP button is not present");
            ReportManager.logInfo("Click get OTP button is not present");
        }
        Thread.sleep(5000);
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen",
                "captcha_popup"),"Verify captcha popup for international login"));
    }
}