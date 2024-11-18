package com.framework.android.screens.notificationspages;

import java.io.IOException;

import org.testng.Assert;

import com.framework.android.screens.kooCreationPages.kooCreationScreensPage;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.MobileUtil;

public class PanelPage {
	MobileActions mobileActions = new MobileActions();
	public void verifyTabsInNotificationPage(String language,String all,String followers,String comments,String mentions,String reactions,String others) throws IOException, InterruptedException
	{
		mobileActions.click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_notification"),
				"notification button");
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_all",all),
				"all button"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_followers_inNotification",followers),
				"followers button"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_comments_inNotification",comments),
				"comments button"));
		mobileActions.swipeElementAndroid(MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_comments_inNotification",comments),"LEFT",MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_others_inNotification",others),10);
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_mentions_inNotification",mentions),
				"mentions button"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_reactions_inNotification",reactions),
				"reactions button"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_others_inNotification",others),
				"others button"));
		mobileActions.swipeElementAndroid(MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_others_inNotification",others),"RIGHT",MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_all",all),10);
	}
	public void allTab() {
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "txt_alltabsinfotext"),
				"all tabs under text"));
	}
	public void followersTab(String followers) throws IOException {
		mobileActions.click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_followers_inNotification",followers),
				"followers button");
		mobileActions.swipeUsingText("Follows you");
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "txt_followerstabsinfotext"),
				"followers info"));
		System.out.println(mobileActions.getText(
				MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "txt_followerstabsinfotext"),
				"followers info"));
		mobileActions.swipeDown(2);
	}
	public void commentsTab(String comments) throws InterruptedException {
		mobileActions.click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_comments_inNotification",comments),
				"comments button");
		mobileActions.swipeUpFindElement(20, MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_followinComments"));
		String bfrclickonfollow=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_followinComments"));
		System.out.println("before clicking on follow button the text is " +bfrclickonfollow);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_followinComments"),
				"Follow button");
		mobileActions.swipeDown(2);
	}
	public void mentionsTab(String comments,String others,String mentions) throws IOException {
		mobileActions.swipeElementAndroid(MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_comments_inNotification",comments),"LEFT",MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_others_inNotification",others),10);
		mobileActions.click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_mentions_inNotification",mentions),
				"mentions button");
	}
	public void reactionsTab(String reactions) throws IOException {
		mobileActions.click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_reactions_inNotification",reactions),
				"reactions button");
		mobileActions.click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "txt_reactionstabsinfotext"),
				"reactions button");
		System.out.println(mobileActions.getText(
				MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "txt_profileNameinCommentsInnotification"),
				"Profile Name"));
		mobileActions.click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_backArrow"),
				"reactions button");
		
	}
	public void othersTab(String reactions,String others) throws IOException, InterruptedException {
		mobileActions.swipeElementAndroid(MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_reactions_inNotification",reactions),"LEFT",MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_others_inNotification",others),10);
		mobileActions.click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_others_inNotification",others),
				"others button");
		mobileActions.swipeUpFindElement(20, MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "txt_otherstabsinfotext"));
		System.out.println(mobileActions.getText(
				MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "txt_otherstabsinfotext"),
				"Profile Name"));
	}
	public void notificationSettingsPage(String activities) throws IOException, InterruptedException {
		mobileActions.click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "btn_settingsInNotification"),
				"Settings button");
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "txt_notificationPreferances"),
				"notification preferences heading"));
		mobileActions.swipeUpFindElement(9, MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "txt_activities",activities));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("Notifications", "txt_activities",activities),
				"activities heading"));
	}

}
