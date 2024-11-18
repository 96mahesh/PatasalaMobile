package com.framework.android.screens.logoutAndDelete;

import java.io.IOException;

import com.framework.android.screens.kooCreationPages.kooCreationScreensPage;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.MobileUtil;

public class DeleteAccount {
	MobileActions mobileActions = new MobileActions();

	public void delete(String language) throws IOException, InterruptedException {
		
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_profile"),
                "profile button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "threeDots"),
                "three dots");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "settings"),
                "settings button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "deleteAccount"),
                "delete button");
		String deletepopup=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "logOutPopUpHeading"),
                "delete popup Heading");
		System.out.println(deletepopup);
		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "cancelButtonOnLogOutPopUp"),
                "Cancel button");
		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "logOutUser_popup"),
                "delete button");
		
}
}