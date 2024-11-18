package com.framework.android.screens.kooCreationPages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.MobileUtil;
import com.framework.utilities.ReportManager;

public class KooCreationExclusiveKooPage {
    MobileActions mobileActions = new MobileActions();

    public void verifyExclusiveKoo(String language, String exclusive) throws IOException, InterruptedException {

        mobileActions.click(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "Chkbox_Select_Language", language),
                language + " language Checkobx");
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "MobNo_txt"),
                ConfigReader.getValue("ExUserName"));
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

	

        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"), "Plus Button");
        if (mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_exclusive", exclusive), "Exclusive Button")) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_exclusive", exclusive), "Exclusive Button");
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_exclusive_ok"), "Exclusive koo ok Button");
            boolean ExclusiveText = mobileActions.isEnabled(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_exclusive", exclusive), "Exclusive Button");
            System.out.println(ExclusiveText);
        }
    }
}