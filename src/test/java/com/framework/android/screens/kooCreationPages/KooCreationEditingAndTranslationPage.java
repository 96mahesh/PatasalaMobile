package com.framework.android.screens.kooCreationPages;

import java.io.IOException;

import org.testng.Assert;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.MobileUtil;

public class KooCreationEditingAndTranslationPage {

	MobileActions mobileActions = new MobileActions();

	public void EditingAndTranslation(String language, String nextButtonText, String previewButtonText,String buttonText)
			throws IOException, InterruptedException {
		kooCreationScreensPage homePage = new kooCreationScreensPage();
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"), "Plus Button");
		homePage.verifyNextAndPreview(language, nextButtonText, previewButtonText);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_mlkeditkoo1"),
				"mlk edit Koo Button");
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_next", nextButtonText),
				"Next Button"));
		mobileActions.clearAndSendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"),
				ConfigReader.getValue("EditPost"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_next", nextButtonText),
				"Next Button");
		String Text1 = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_editText1"),
				"Edited text");
		System.out.println(Text1);
		String Text2 = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_editText2"),
				"Edited text");
		System.out.println(Text2);
	}

}
