package com.framework.android.screens.kooCreationPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.MobileUtil;

public class KooCreationDraftKooPage {

	MobileActions mobileActions = new MobileActions();

	public void DraftKoo(String language, String savetodrafts, String viewdrafts, String draft, String buttonText,String nextButtonText)
			throws IOException, InterruptedException {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"), "Plus Button");
		mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"),
				ConfigReader.getValue("KooPostText"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_draft"),
				"Draft Button");
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_savetodrafts", savetodrafts),
				"Schedule Koo Button"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_ViewScheduledKoos", viewdrafts),
				"View Scheduled Koos Button"));
		mobileActions.click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_savetodrafts", savetodrafts),
				"Schedule Koo Button");
		boolean isNativeButton = mobileActions
				.getElementSizeUsingFindElements(By.xpath("//android.widget.TextView[@content-desc='negativeButton']"))
				.size() > 0;
		if (isNativeButton) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_no"),
					"clicked on no button");
		} else {
		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"),
					"Plus Button");
		}
		String Text = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "tab_feed"),
				"Feed tab");
		System.out.println(Text);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"), "Plus Button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_draft"),
				"Draft Button");
		mobileActions.click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_ViewScheduledKoos", viewdrafts),
				"View Scheduled Koos Button");
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_draft1", draft), "Drafts Button"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "menu_hamberger"),
				"hamberger menu");
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_editkoo"), "edit Koo Button"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_deletekoo"), "delete Koo Button"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_editkoo"),
				"edit Koo Button");
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_Schedule"), "Schedule Button"));
		Thread.sleep(10000);
		boolean isBtn = mobileActions
				.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", buttonText));
		if (isBtn) {
			Assert.assertTrue(mobileActions.isDisplayed(
					MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", buttonText),
					"Post Button"));
		} else {
			Assert.assertTrue(mobileActions.isDisplayed(
					MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_next", nextButtonText),
					"Next Button"));
		}

	}

}
