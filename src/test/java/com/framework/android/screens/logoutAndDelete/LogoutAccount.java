package com.framework.android.screens.logoutAndDelete;

import java.io.IOException;

import org.testng.Assert;

import com.framework.android.screens.kooCreationPages.kooCreationScreensPage;
import com.framework.android.utils.CommonHelper;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.MobileUtil;

public class LogoutAccount {
	MobileActions mobileActions = new MobileActions();
	String actualText;
	public void logout(String language) throws IOException, InterruptedException {
		
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_profile"),
                "profile button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "threeDots"),
                "three dots");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "settings"),
                "settings button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "logOutUser"),
                "Logout user");
		actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "logOutPopUpHeading"),
	                "Get text of LogOut popup heading");
		System.out.println(actualText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "cancelButtonOnLogOutPopUp"),
                "cancel button");
		CommonHelper.logOutUser();
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "select_languages"),
        "select language heading"));
		
	}
}
