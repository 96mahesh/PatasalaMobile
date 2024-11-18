package com.framework.android.screens.profileScreenPages;

import java.io.IOException;

import com.framework.android.screens.kooCreationPages.kooCreationScreensPage;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.MobileUtil;

public class FollowersAndFollowingPage {
	MobileActions mobileActions = new MobileActions();
	public void verifyfollowersandfollowing(String language,String follow) throws IOException, InterruptedException {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_profile"),
				"profile button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_followers"),
				"followers button");
		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_followersheading"),
				"followers heading");
		String followersText=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_followersheading"),
				"followers heading");
		System.out.println("followers heading text is "+ followersText);
		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_all"),
				"all heading");
		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_latest"),
				"latest heading");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_latest"),
				"latest heading");
//		String beforefollow=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_follow",follow),
//				"follow button");
//		System.out.println("before following " + beforefollow);
//		mobileActions.Click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_follow", follow),
//				"follow button");
//		String afterfollow=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_follow1InPublicProfile"),
//				"follow button");
//		System.out.println("after following " + afterfollow);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_backArrow"),
				"back button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_following"),
				"following button");
		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_followingheading"),
				"following heading");
		String followingText=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_followingheading"),
				"following heading");
		System.out.println("following heading text is "+ followingText);
		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_all"),
				"all heading");
		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_latest"),
				"latest heading");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_backArrow"),
				"back button");
		
	}

}
