package com.framework.android.screens.profileScreenPages;

import java.io.IOException;
import org.testng.Assert;
import com.framework.android.screens.kooCreationPages.KooCreationCreateThreadPage;
import com.framework.android.screens.kooCreationPages.kooCreationScreensPage;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.MobileUtil;

public class TabsPage {
	MobileActions mobileActions = new MobileActions();

	public void mlkKooCreation(String language, String nextButtonText, String previewButtonText, String buttonText)
			throws IOException, InterruptedException {
		kooCreationScreensPage homePage = new kooCreationScreensPage();
//		homePage.kooCreationHomePage(language);
		mobileActions.swipeDown(3);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_backArrow"),
				"back button");
		homePage.verifyScheduleAndDraftButtons();
		homePage.verifyNextAndPreview(language, nextButtonText, previewButtonText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", buttonText),
				"clicked on post button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_profile"),
				"profile button");
		mobileActions.swipeUp(1);
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_profileHeader"),
				"latest Post header"));
		String Text1 = mobileActions
				.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_msgPosted"));
		System.out.println("Text in one language is " + Text1);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_bengaliLang"),
				"second language in MLK koo");
		String Text2 = mobileActions
				.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_msgPosted"));
		System.out.println("Text in second language is " + Text2);
		Assert.assertNotEquals(Text1, Text2);
		mobileActions.swipeDown(1);
	}

	public void threadKooCreation(String language, String buttonText) throws IOException, InterruptedException {
		KooCreationCreateThreadPage threadPage = new KooCreationCreateThreadPage();
		threadPage.CreateThread(language,buttonText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_profile"),
				"profile button");
		mobileActions.swipeUp(1);
		mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_expandThreadKoo"),
				"expand this thread koo button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_expandThreadKoo"),
				"expand this thread koo button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_threadkooCommentbox"),
				"comment button");
		mobileActions.sendKeys(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_commentinThreadKoo"),
				ConfigReader.getValue("KooPostText"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", buttonText),
				"clicked on post button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_backArrow"),
				"back button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_expandThreadKoo"),
				"expand this thread koo button");
		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_comments"),
				"comments heading");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_backArrow"),
				"back button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfComments"),
				"comments tab");
		mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_showThisThreadInCommentsTab"),
				"show this thread button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "btn_rekoo"),
				"Rekoo Button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "btn_rekooyes"),
				"Rekoo Yes Button");
		mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"),
                ConfigReader.getValue("KooPostText"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", buttonText),
                "clicked on post button");
//		mobileActions.isDisplayed(
//				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_rekoowithComments"),
//				"rekoo with comments heading");
//		mobileActions.swipeDown(3);
//		mobileActions.Click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_threeDots"),
//				"Three Dots Button");
//		mobileActions.Click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "settings"),
//				"Settings Button");
//		CommonHelper.logOutUser();

	}

	public void likestab() throws IOException {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfLikes"),
				"likes tab");
		mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_likedProfileHeader"),
				"liked post");
	}

	public void rekoostab() throws IOException {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfReKoos"),
				"rekoos tab");
		mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_rekoowithComments"),
				"you have rekooed this heading");
	}

	public void mentionstab() throws IOException {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfMentions"),
				"Mentions Tab");
		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_profileHeader"),
				"mentioned profile heading");

	}

	public void savedkoostab() throws IOException {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfSaved"),
				"Saved tab");
//		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_saved"),
//				"saved button");
		String time=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_kooSavedTime"));
	System.out.println("koo saved time " + time);
	}

}