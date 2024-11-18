package com.framework.android.screens.profileScreenPages;

import java.io.IOException;

import com.framework.android.screens.kooCreationPages.kooCreationScreensPage;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.MobileUtil;

public class PinnedKoos {
	MobileActions mobileActions = new MobileActions();

	public void verifyPinnedKoos(String language) throws IOException, InterruptedException {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_profile"),
				"profile button");
		mobileActions.swipeUp(2);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "menu_hamberger"),
				"hamberger menu");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_pinToProfile"),
				"pin to profile button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_yes"), "yes button");
		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_pinnedKoo"),
				"pinned koo heading");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "menu_hamberger"),
				"hamberger menu");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_pinToProfile"),
				"unpin to profile button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_yes"), "yes button");

	}

}
