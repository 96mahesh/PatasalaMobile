package com.framework.android.screens.kooCreationPages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.codoid.products.exception.FilloException;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.MobileUtil;

public class kooCreationScreensPage {

	MobileActions mobileActions = new MobileActions();
	int Count, countOfLanguages;

	public void kooCreationHomePage(String language) throws IOException, InterruptedException, FilloException {
		 LoginKooPage loginKooPage = new LoginKooPage();
         loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));

	}

	public void verifyScheduleAndDraftButtons() throws IOException, InterruptedException {

		String Text = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "tab_feed"),
				"Feed tab");
		System.out.println(Text);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"), "Plus Button");
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_Schedule"), "Schedule Button"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_draft"), "Draft Button"));
	}

	public void verifyPost(String language, String buttonText) throws IOException, InterruptedException {

		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_languages"),
				"selected languages");
		List<WebElement> elements = DriverFactory.getInstance().getMobileDriver()
				.findElements(By.xpath("//android.widget.TextView[contains(@content-desc,'language_tab')]"));
		List<String> languages = new ArrayList<String>();
		for (int i = 0; i < elements.size(); i++) {
			languages.add(elements.get(i).getText());
			System.out.println(languages.get(i));
		}
		Count = elements.size();
		System.out.println(Count);

		if (Count == 1) {
			Assert.assertTrue(mobileActions.isDisplayed(
					MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", buttonText),
					"Post Button"));
			mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"),
					ConfigReader.getValue("KooPostText"));

			int i = ConfigReader.getValue("KooPostText").length();
			System.out.println(i);

			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", buttonText),
					"clicked on post button");
			boolean isNativeButton = mobileActions.getElementSizeUsingFindElements(
					By.xpath("//android.widget.TextView[@content-desc='negativeButton']")).size() > 0;
			if (isNativeButton) {
				mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_no"),
						"clicked on no button");
				mobileActions.isDisplayed(
						MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_postHeader"),
						"post header text");
				mobileActions.swipeUsingID("tvWhatsAppStatus");
				mobileActions.isDisplayed(
						MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_shareonWhatsp"),
						"Share on whatsapp button");
				mobileActions.isDisplayed(
						MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_shareonFacebook"),
						"Share on Facebook button");
				mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_reKoo"),
						"Rekoo button");
				mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "rekoo_popup"),
						"rekoo popup message");
				mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "rekoo_no"),
						"No Rekoo comment button");
				mobileActions.swipeDown(2);

			} else {
				mobileActions.isDisplayed(
						MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_postHeader"),
						"post header text");
				mobileActions.swipeUsingID("tvWhatsAppStatus");
				mobileActions.isDisplayed(
						MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_shareonWhatsp"),
						"Share on whatsapp button");
				mobileActions.isDisplayed(
						MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_shareonFacebook"),
						"Share on Facebook button");
				mobileActions.swipeDown(3);

			}

		}
	}

	public void verifyRemove() throws IOException, InterruptedException {

		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_remove"),
				"remove language");
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_undo"), "undo Button"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_undo"), "Undo Button");
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_remove"), "Remove Button"));

	}

	public void verifyAttachmentElements() throws IOException {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"), "Plus Button");

		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_add_image"), "add image Button"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_add_video"), "add video Button"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_add_link"), "add link Button"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_add_poll"), "add poll Button"));
	}

	public void verifyNextAndPreview(String language, String nextButtonText, String previewButtonText) throws IOException, InterruptedException {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_addlanguage_plus"),
				"Add Languages Plus Button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "checkbox_selectLanguage"),
				"select language");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_done_"),
				"Clicked on done button");
		List<WebElement> listOfElements = DriverFactory.getInstance().getMobileDriver()
				.findElements(By.xpath("//android.widget.TextView[contains(@content-desc,'language_tab')]"));
		countOfLanguages = listOfElements.size();
		System.out.println(countOfLanguages);

		if (countOfLanguages > 1) {
			Assert.assertTrue(mobileActions.isDisplayed(
					MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_next", nextButtonText),
					"Next Button"));
			mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"),
					ConfigReader.getValue("KooPostText"));
			mobileActions.click(
					MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_next", nextButtonText),
					"Next Button");
//            Assert.assertTrue(mobileActions.isDisplayed(
//                    MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_preview", previewButtonText),
//                    "Ready To Post!"));
		}
	}

}
