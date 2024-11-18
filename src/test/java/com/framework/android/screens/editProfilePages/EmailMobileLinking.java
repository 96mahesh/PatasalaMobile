package com.framework.android.screens.editProfilePages;

import java.io.IOException;

import org.testng.Assert;

import com.framework.android.screens.kooCreationPages.kooCreationScreensPage;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.MobileUtil;
import com.framework.utilities.ReportManager;

public class EmailMobileLinking {
	MobileActions mobileActions = new MobileActions();
	
	public void verifyEmailLinking(String language) throws IOException, InterruptedException {
	mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_profile"),
            "profile button");
    mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_editprofile"),
            "Edit button");
    mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_editProfileName"),
            "Edit Profile Name button");
    Assert.assertTrue(mobileActions.isDisplayed(
            MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_editProfileSaveChanges"),
            "Save Changes button"));
    mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_backArrow"),
            "Back Button");
    mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_editProfileHandle"),
            "Edit Profile Handle button");
    Assert.assertTrue(mobileActions.isDisplayed(
            MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_editProfileSaveChanges"),
            "Save Changes button"));
    mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_backArrow"),
            "Back Button");
    mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_editProfileProfession"),
            "Edit Profile Profession button");
    Assert.assertTrue(mobileActions.isDisplayed(
            MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_editProfileSaveChanges"),
            "Save Changes button"));
    Assert.assertTrue(mobileActions.isDisplayed(
            MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_editProfileDelete"),
            "Delete button"));
    mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_backArrow"),
            "Back Button");
    mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_editProfileBio"),
            "Edit Profile Bio button");
    Assert.assertTrue(mobileActions.isDisplayed(
            MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_editProfileSaveChanges"),
            "Save Changes button"));
    Assert.assertTrue(mobileActions.isDisplayed(
            MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_editProfileDelete"),
            "Delete button"));
    mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_backArrow"),
            "Back Button");
    mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_editProfileDOB"),
            "Edit Profile DOB button");
    Assert.assertTrue(mobileActions.isDisplayed(
            MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_editProfileSaveChanges"),
            "Save Changes button"));
    mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_backArrow"),
            "Back Button");
    mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_editProfileWebsite"),
            "Edit Profile Website button");
    Assert.assertTrue(mobileActions.isDisplayed(
            MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_editProfileSaveChanges"),
            "Save Changes button"));
    Assert.assertTrue(mobileActions.isDisplayed(
            MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_editProfileDelete"),
            "Delete button"));
    mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_backArrow"),
            "Back Button");
    mobileActions.swipeUp(1);
    mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "txt_mail"),
            "Email box");
    Assert.assertTrue(mobileActions.isDisplayed(
            MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "txt_enterEmailHeading"),
            "Email Heading text"));
    mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "txt_enterEmail"),
            ConfigReader.getValue("InvalidEmail"));
    mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "getOTP_inEMail"),
            "get OTP Button");
    
    mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "captcha_popup"), "captcha_popup");
    String verificationMsg=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "verificationMsg"),
            "verification msg");
    System.out.println(verificationMsg);
    ReportManager.logInfo("Verification Message is " + verificationMsg);

}
	
}