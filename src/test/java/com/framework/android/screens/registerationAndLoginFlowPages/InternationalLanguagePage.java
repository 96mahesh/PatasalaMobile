package com.framework.android.screens.registerationAndLoginFlowPages;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.MobileUtil;
import com.framework.utilities.ReportManager;
import org.testng.Assert;

import java.io.IOException;

public class InternationalLanguagePage {
    MobileActions mobileActions = new MobileActions();

    /**
     * This method is to verify different ways of login
     * @throws IOException 
     */
    public void verifySignInWithPhoneButton(String language) throws InterruptedException, IOException {
        mobileActions.swipeUpFindElement(2, MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "app_Language",
                language));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "app_Language",
                        language),
                "Checked language successfully " + language);
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen",
                        "signInPhone_button"),
                "Verify Sign In Phone button is displaying for = "+language));
    }

    /**
     * This method is to verify Sign In with Google button
     * @param buttonText
     */
    public void verifySignInWithGoogleButton(String language,String buttonText){
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen",
                        "signInGoogle_button",buttonText),
                "Verify Sign In Google button is displaying for = "+language));
    }

    /**
     * This method is to verify Sign In with Email button
     * @param buttonText
     */
    public void verifySignInWithEmailButton(String language, String buttonText){
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen",
                        "signInEmail_button",buttonText),
                "Verify Sign In Email button is displaying for = "+language));
    }

    /**
     * Click on Google Sign In button
     * @throws IOException
     */
    public void verifySignInWithGooglePage(String language, String buttonText) throws IOException, InterruptedException {
        mobileActions.swipeUpFindElement(2, MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "app_Language",
                language));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "app_Language",language),
                "Checked "+language+ " language successfully");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "signInGoogle_button",buttonText),
                "Click on sign in google button");
        Thread.sleep(10000);
        try {
            if(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "chooseAccount_button"),
                    "Choose an account popup is displayed successfully")){
                System.out.println("Choose an account popup is displayed successfully");
                ReportManager.logInfo("Choose an account popup is displayed successfully");
            }
        } catch (Exception e){
            Thread.sleep(30000);
            Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "googleLoginPage_btn"),
                    "Verify google sign in page"));
        }
    }

    /**
     * Verify Resend OTP button and Sign-in with Google button is visible
     * @param language
     * @param mobileNumber
     * @throws IOException
     * @throws InterruptedException
     */
    public void resendOTPOptions(String language, String mobileNumber) throws IOException, InterruptedException {
        Thread.sleep(2000);
        mobileActions.swipeUpFindElement(2, MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "app_Language",
                language));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "app_Language",language),
                "Checked "+language+" language successfully");
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "MobNo_txt"), mobileNumber);
        Thread.sleep(40000);
    }

    /**
     * This method is to verify Resend OTP popup buttons
     * @param expectedButtonText_language
     */
    public void verifyResendOTPOptions(String expectedButtonText_language) throws InterruptedException {
    	mobileActions.hideKeyboard();
        Thread.sleep(30000);
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "resend_otp_option",
                expectedButtonText_language),"Verify Resend OTP button is visible and text is = "+ expectedButtonText_language));
        String actualButtonText_language = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen","resend_otp_option",
                expectedButtonText_language));
        Assert.assertEquals(actualButtonText_language,expectedButtonText_language,
                "Resend OTP buttons on popup are correct");
    }

    /**
     * Verify Error message display for incorrect OTP
     * @param language
     * @param mobileNumber
     * @throws IOException
     * @throws InterruptedException
     */
    public void verifyErrorMessageForIncorrectOTP(String language, String mobileNumber, String expectedErrorMessage, String otpValue) throws IOException, InterruptedException {
        mobileActions.swipeUpFindElement(2, MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "app_Language",
                language));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "app_Language",language),
                "Checked "+language+" language successfully");
        Thread.sleep(5000);
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "MobNo_txt"), mobileNumber);
        Thread.sleep(15000);
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "otp_text"),
                otpValue);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "verify_btn"),
                "Click on Verify button");
        String actualErrorMessage_language = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen","incorrect_otp_message"));
        Assert.assertEquals(actualErrorMessage_language,expectedErrorMessage,
                "Invalid OTP error message is  correct the expected text is = "+expectedErrorMessage+ "And actual text is = "+actualErrorMessage_language);
    }
}
