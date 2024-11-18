package com.framework.android.screens.profileScreenPages;

import java.io.IOException;

import com.framework.android.screens.kooCreationPages.kooCreationScreensPage;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.MobileUtil;

public class SelfVerificationPage {
	MobileActions mobileActions = new MobileActions();

	public void selfverificationpage(String language)
			throws IOException, InterruptedException {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_profile"),
				"profile button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_selfVerifyTag"), "Profile Self Verify Tag");
		mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_editAadhar"),ConfigReader.getValue("AadharcardNumber"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_getOTP"), "Get OTP");
		String ErrorMsg=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_errorMsg"));
		System.out.println(ErrorMsg);
	}
}
