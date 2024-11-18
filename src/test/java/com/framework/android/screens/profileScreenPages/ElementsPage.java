package com.framework.android.screens.profileScreenPages;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.framework.android.utils.CommonHelper;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.MobileUtil;
import com.framework.utilities.ReportManager;

public class ElementsPage {
	MobileActions mobileActions = new MobileActions();

	public void elements(String language,String peopleTabText)
			throws IOException, InterruptedException {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "tab_people",peopleTabText), "people tab");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_arrowInPeopleTab"), "Forward arrow");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_publicProfile"), "public Profile");
		mobileActions.swipeUsingID("tvFollow");
		String follow=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_followInPublicProfile"));
		System.out.println(follow);
		mobileActions.swipeDown(2);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_backInProfileScreen"),
				"Back button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_backArrow"),
				"Back button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_profile"),
				"profile button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_threeDots"), "Three Dots Button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "settings"), "Settings Button");
		CommonHelper.logOutUser();

}
	public void newUserLogin(String language) throws IOException, InterruptedException {
		mobileActions.click(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "Chkbox_Select_Language", language),
                language + " language Checkobx");
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "MobNo_txt"),
                ConfigReader.getValue("NewUserNumber"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "OTP_btn"),
                "get OTP Button");
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "lbl_OTP"),
                ConfigReader.getValue("Password"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "verify_btn"),
                "Verify Button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "skipAndContinue"),
                "Skip and Continue Button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "skipAndContinue"),
                "Skip and Continue Button");
        Thread.sleep(10000);
		boolean isNothanks = mobileActions.isElmPresent(By.id("com.android.vending:id/0_resource_name_obfuscated"));
		if (isNothanks) {
			List<WebElement> lstElm = mobileActions.elements(By.id("com.android.vending:id/0_resource_name_obfuscated"));
			for (WebElement webElement : lstElm) {
				if(webElement.getText().equals("NO, THANKS")||webElement.getText().equals("NO THANKS")) {
					webElement.click();
					break;
				}
			}
			
		}
		try {
			Assert.assertTrue(mobileActions.isDisplayed(
					MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "profile_lnk"),
					"Profile link is visible after login"));
			ReportManager.logPass("Logged In Successfully");
		} catch (Exception e) {
			// Retry verify OTP 3 times and then validate profile link
			for (int i = 0; i < 3; i++) {
				mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "otp_text"),
						ConfigReader.getValue("Password"));
				Thread.sleep(5000);
				mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "verify_btn"),
						"Click on Verify button");
			}
			Assert.assertTrue(mobileActions.isDisplayed(
					MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "profile_lnk"),
					"Profile link is visible after login"));
		}
        
	}
	public void verifyNokKoosInNewUser() throws IOException {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "profile_icon"),
                "ProfileIcon");
		mobileActions.swipeUp(1);
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "createFirstKoo"), "Create First Koo button"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "likesKoos"),
                "like button");
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "noKoos"), "No Koos text"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "commentsKoos"),
                "comments button");
		mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "noKoos"));
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "noKoos"), "No Koos text"));
		mobileActions.swipeElementAndroid(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "commentsKoos"), "LEFT",MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "mentionsKoos") , 2);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "mentionsKoos"),
                "mentions button");
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "noKoos"), "No Koos text"));
		
	}
	
}