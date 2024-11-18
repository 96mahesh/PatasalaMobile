package com.framework.android.screens.logoutAndDelete;

import java.io.IOException;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.MobileUtil;

public class MultiAccountInLogout {
	MobileActions mobileActions = new MobileActions();
	
	public void multiAccount(String mobileNumber) throws IOException, InterruptedException {
		
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_profile"),
                "profile button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "threeDots"),
                "three dots");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "settings"),
                "settings button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("RegistrationFlow", "addAccount"),
                "add account button");
		mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "MobNo_txt"),
				mobileNumber);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "OTP_btn"),
				"Click on get OTP Button");
		String existingusermsg=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "verificationMsg"),
				"Already user added message");
		System.out.println(existingusermsg);
		
		
}
	
}