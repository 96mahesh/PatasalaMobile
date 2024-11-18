package com.framework.android.screens.profileScreenPages;

import java.io.IOException;
import java.util.List;

import com.framework.android.screens.kooCreationPages.kooCreationScreensPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.MobileUtil;

public class InformationPage {
	MobileActions mobileActions = new MobileActions();

	public void informationPage(String language,String peopleTabText)
			throws IOException, InterruptedException {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_profile"),
				"profile button");
		Thread.sleep(10000);
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "img_profilePic"), "Profile Photo"));
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_profileName"), "Profile Name"));
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_selfVerifyTag"), "Profile Self Verify Tag"));
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_profession"), "Profession Text"));
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_bio"), "Bio Text"));
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_more"), "more button"));
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_backInProfileScreen"), "Back Arrow"));
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_threeDots"), "Three Dots Button"));
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_addImages"), "Add Images Button"));
		String Count=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfProfilePhotos"));
		System.out.println(Count);
		String noOfKoos=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfKoos"));
		System.out.println(noOfKoos);
		String noOfLikes=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfLikes"));
		System.out.println(noOfLikes);
		String noOfComments=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfComments"));
		System.out.println(noOfComments);
		String noOfReKoos=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfReKoos"));
		System.out.println(noOfReKoos);
		mobileActions.swipeElementAndroid(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfKoos1"),"LEFT",MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfSaved"),10);
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfMentions"),
				"Mentions Tab"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfSaved"),
				"Saved tab"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_addImages"),
				"Add Image button");
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "txt_addPhotos"),
				"Add Photos Text"));
		List<WebElement> noofelements=DriverFactory.getInstance().getMobileDriver().findElements
                (MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_addforimage"));
		System.out.println(noofelements.size());
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_backInAddphotos"),
				"Back button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "img_profilePic"), "Profile Photo");
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_editProfilePic"), "Edit Profile Pic Button"));
		String Count1=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfProfilePhotos"));
		System.out.println(Count1);
		mobileActions.swipeRightToLeft(1);
		String Count2=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_noOfProfilePhotos"));
		System.out.println(Count2);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_backInProfilePicturesScreen"),
				"Back button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_more"), "more button");
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_profileNameinMorePopup"),
				"Profile Name Text"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_editinMorePopup"),
				"Edit button"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_professioninMorePopup"),
				"Profession Text"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_bioinMorePopup"),
				"bio Text"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_dateOfJoininMorePopup"),
				"date of join Text"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_socialMedialinksHeadinginMorePopup"),
				"Socia Media Links Text"));
		mobileActions.click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_closeinMorePopup"),
				"Close Button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_backInProfileScreen"), "Back Arrow");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "tab_people",peopleTabText), "people tab");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_arrowInPeopleTab"), "Forward arrow");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_publicProfile"), "public Profile");
		String follow=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_followInPublicProfile"));
		System.out.println(follow);
		mobileActions.swipeUpFindElement(15,MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_pplYouCanFollow"));
		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_pplYouCanFollow"),"people you can follow");
		mobileActions.swipeDown(10);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_followInPublicProfile"),"follow Button");
//		String following=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_follow1InPublicProfile"));
//		System.out.println(following);
//		String pplyoucanFollow=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "txt_pplYouCanFollow"));
//		System.out.println(pplyoucanFollow);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_threeDots"), "Three Dots Button");
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_ShareInPublicProfile"),
				"share button"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_followingInPublicProfile"),
				"follow Button"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_directMsgInPublicProfile"),
				"Direct message button"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_blockMsgInPublicProfile"),
				"block button"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_reportUserInPublicProfile"),
				"Report User Button"));
		mobileActions.click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_closeInPublicProfile"),
				"Close Button");
		
}
}