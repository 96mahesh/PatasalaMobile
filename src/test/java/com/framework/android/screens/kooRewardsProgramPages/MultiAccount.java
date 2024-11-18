package com.framework.android.screens.kooRewardsProgramPages;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.MobileUtil;
import com.framework.utilities.ReportManager;

public class MultiAccount {
	MobileActions mobileActions = new MobileActions();
	public void multiAccount(String language) throws IOException, InterruptedException {
		
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_profile"),
                "profile button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "threeDots"),
                "three dots");
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_manageTopics"), "manage topics button"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_statistics"),
                "statistics button");
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_dailyinstatistics"), "daily button"));
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_weeklyinstatistics"), "weekly button"));
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_monthlyinstatistics"), "monthly button"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "back_button"),
                "back button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "threeDots"),
                "three dots");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "settings"),
                "settings button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("RegistrationFlow", "addAccount"),
                "add account button");
		mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "MobNo_txt"),
				ConfigReader.getValue("ChildUserName"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "OTP_btn"),
				"Click on get OTP Button");
		mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "otp_text"),
				ConfigReader.getValue("Password"));
		mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "verify_btn"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "verify_btn"),
				"Click on Verify button");
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

		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_referTitle"),
				"no rewards program for child koos text");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "profile_icon"),
				"profile icon");
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_childAccountHeading"), "child account heading"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_expandButton"),
				"expand button");
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("RegistrationFlow", "addAccountLink"),
				"add account link"));
		mobileActions.click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_parentProfile"),
				"parent profile button");
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "profile_lnk"),
				"Profile link is visible after login"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "profile_icon"),
				"profile icon");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_switchAccount"),
				"switch account");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "profile_icon"),
				"profile icon");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_settingsInChildAccount"),
				"settings button");
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_language"),
				"language button"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_logout"),
				"logout button");
		
	}

}
