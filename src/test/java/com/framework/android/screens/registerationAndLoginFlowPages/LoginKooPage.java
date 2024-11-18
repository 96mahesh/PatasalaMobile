package com.framework.android.screens.registerationAndLoginFlowPages;

import com.codoid.products.exception.FilloException;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.MobileUtil;
import com.framework.utilities.ReportManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class LoginKooPage {
	MobileActions mobileActions = new MobileActions();

	/**
	 * This method is to login on Koo application
	 *
	 * @param mobileNumber
	 * @throws InterruptedException
	 * @throws IOException
	 * @throws FilloException
	 */
	public void loginValidUser(String language, String mobileNumber)
			throws InterruptedException, IOException, FilloException {
		
		mobileActions.clickUsingCoordinates(967, 2060);
		if(language.equalsIgnoreCase("English")) {
			boolean isTextBox = mobileActions.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "MobNo_txt"));
			if (isTextBox) {
				System.out.println("Already you on login screen");
			}else {
				mobileActions.swipeUsingText(language);
				mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "app_Language", language),
						"Checked language successfully " + language);
			}
		}else {
			mobileActions.swipeUsingText(language);
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "app_Language", language),
					"Checked language successfully " + language);
		}
		mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "MobNo_txt"),
				mobileNumber);
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

	}
}
