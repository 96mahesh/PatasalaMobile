package com.framework.android.screens.kooCreationPages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import java.io.IOException;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.MobileUtil;

public class KooCreationEditPostedKoo {
	MobileActions mobileActions = new MobileActions();
	
	public void createKoo(String language,String buttonText) throws IOException, InterruptedException {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"), "Plus Button");
		mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"),
				ConfigReader.getValue("EditPost"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", buttonText),
				"clicked on post button");
		if(language=="English") {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_no"),
				"clicked on no button");
		Thread.sleep(5000);
		}
		Thread.sleep(10000);
		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "tab_feed"),
				"Feed tab");
		mobileActions.swipeUpFindElement(2, MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_like"));
		String beforeeditedkoo=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_editedKoo"));
		System.out.println(beforeeditedkoo);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_dlthmbrgrmenu"),
                "hamberger menu");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_editKoo"),
                "Edit koo button");
		mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"),
				ConfigReader.getValue("KooPostText"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", buttonText),
				"clicked on post button");
		String aftereditedkoo=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_editedKoo"));
		System.out.println(aftereditedkoo);
		assertNotEquals(beforeeditedkoo, aftereditedkoo);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_backArrow"),
				"back button");
		
	}
	
	public void editMLKkoo(String language, String nextButtonText, String previewButtonText,
			String buttonText) throws IOException, InterruptedException {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"), "Plus Button");
		kooCreationScreensPage homePage = new kooCreationScreensPage();
		homePage.verifyNextAndPreview(language, nextButtonText, previewButtonText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", buttonText),
				"clicked on post button");
		mobileActions.swipeUpFindElement(1, MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_like"));
		String beforeeditedkoo=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_editedKoo"));
		System.out.println(beforeeditedkoo);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_dlthmbrgrmenu"),
                "hamberger menu");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_editKoo"),
                "Edit koo button");
		String mLKEditKoo=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_bftEditTxt"));
		System.out.println(mLKEditKoo);
		assertEquals(beforeeditedkoo, mLKEditKoo);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_backinMLK"),
				"back button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_no"),
				"clicked on no button");
		
	}
	public void editThreadKoo(String nextButtonText,String buttonText) {
		mobileActions.swipeDown(2);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"), "Plus Button");
		mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"),
				ConfigReader.getValue("EditPost"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_threadkoo"), "threadkoo Button");
		mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"),
				ConfigReader.getValue("EditPost"));
		mobileActions.click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_next", nextButtonText),
				"Next Button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", buttonText),
				"clicked on post button");
		mobileActions.swipeUsingID("iv_options_more");
//		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_dlthmbrgrmenu"),
//                "hamberger menu");
		String Text1=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_threadkoo1"));
		String Text2=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_threadkoo2"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_dlthmbrgrmenu"),
                "hamberger menu");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_editKoo"),
                "Edit koo button");
		mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"),
				ConfigReader.getValue("KooPostText"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", buttonText),
				"clicked on post button");
		String Text3=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_threadkoo1"));
		String Text4=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_threadkoo2"));
		assertEquals(Text2,Text4 );
		assertNotEquals(Text1, Text3);
		
	}
}
