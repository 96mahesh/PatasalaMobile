package com.framework.android.screens.homeScreenTabsPages;

import com.framework.android.screens.peopleTabPages.PeopleTabPage;
import com.framework.android.utils.CommonHelper;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.MobileUtil;
import com.framework.utilities.ReportManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomeScreenTabPage {
	MobileActions mobileActions = new MobileActions();
	SoftAssert softAssert = new SoftAssert();

	/**
	 * This method is to verify home icon from bottom bar
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyHomeIcon() {
		mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "homeButton"));
		Assert.assertTrue(
				mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "homeButton"),
						"Verify Home icon on bottom bar"));
		return this;
	}

	/**
	 * This method is to verify trending tab fire icon from main page
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyTrendingTagIcon() {
		mobileActions
				.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "trendingTagsIcon"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "trendingTagsIcon"),
				"Verify Trending Tag fire icon on main page"));
		return this;
	}

	/**
	 * This method is to verify search icon from bottom bar
	 *
	 * @return
	 */
	public HomeScreenTabPage verifySearchIcon() {
		mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "search_icon"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "search_icon"),
				"Verify Search icon on bottom bar"));
		return this;
	}

	/**
	 * This method is to verify chat icon from bottom bar
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyChatIcon() {
		mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "chatIcon"));
		Assert.assertTrue(
				mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "chatIcon"),
						"Verify Search icon on bottom bar"));
		return this;
	}

	/**
	 * This method is to verify notification icon from bottom bar
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyNotificationIcon() {
		mobileActions
				.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "notificationIcon"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "notificationIcon"),
				"Verify Notification icon on bottom bar"));
		return this;
	}

	/**
	 * This method is to verify start conversation button
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyStartConversationButton() {
		mobileActions.waitForVisible(
				MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "startConversationButton"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "startConversationButton"),
				"Verify Start Conversation Page"));
		return this;
	}

	/**
	 * This method is to verify start conversation button
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyNotificationPreferencesBtn() {
		mobileActions.waitForVisible(
				MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "notificationPreferenceIcon"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "notificationPreferenceIcon"),
				"Verify Notification page"));
		return this;
	}

	/**
	 * This method is to verify header bar tabs text
	 *
	 * @param expectedTabText
	 * @return
	 */
	public HomeScreenTabPage verifyHeaderTabs(List<String> expectedTabText) {
		for (int i = 0; i < expectedTabText.size(); i++) {
			WebElement elementsOne = DriverFactory.getInstance().getMobileDriver().findElement(MobileUtil
					.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "feedTab_Text", expectedTabText.get(i)));
			mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow",
					"feedTab_Text", expectedTabText.get(i)));
			softAssert.assertTrue(mobileActions.isDisplayed(
					MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "feedTab_Text",
							expectedTabText.get(i)),
					"Verify header bar tab and expected is = " + expectedTabText.get(i)));
			System.out.println("Verify header bar tab and expected is = " + expectedTabText.get(i));
			mobileActions.swipeLeftOrRight(elementsOne, "LEFT");
		}
		softAssert.assertAll();
		ReportManager.logInfo("Verified header bar tab's");
		ReportManager.logPass("Verified header bar tab's");
		return this;
	}

	/**
	 * This method is to verify red dot indicator
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyRedDotIndicator() {
		mobileActions
				.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "redDotIndicator"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "redDotIndicator"),
				"Verify Red Dot Indicator"));
		return this;
	}

	/**
	 * This method is to verify red dot on next tab
	 *
	 * @param expectedTabText
	 * @throws IOException
	 */
	public HomeScreenTabPage verifyRedDotOnNextTabAndDisappearForLastTab(List<String> expectedTabText, String lastTab)
			throws IOException {
		for (int i = 0; i < expectedTabText.size(); i++) {
			mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "feedTab_Text",
					expectedTabText.get(i)), "Click on next tab = " + expectedTabText.get(i));
			if (expectedTabText.get(i).equalsIgnoreCase(lastTab)) {
				try {
					mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab",
							"redDotIndicatorNextTab", expectedTabText.get(i)));
					softAssert.assertTrue(mobileActions.isDisplayed(
							MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "redDotIndicatorNextTab",
									expectedTabText.get(i)),
							"Verify Red Dot Indicator on next tab when it's previous tab is selected"));
				} catch (Exception e) {
					System.out.println("Red Dot is not visible on last tab");
					ReportManager.logInfo("Red Dot is not visible on last tab");
					ReportManager.logPass("Red Dot is not visible on last tab");
				}
			} else {
				softAssert.assertTrue(mobileActions.isDisplayed(
						MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "redDotIndicatorNextTab",
								expectedTabText.get(i)),
						"Verify Red Dot Indicator on next tab when it's previous tab is selected"));
				System.out.println("Verify Red Dot Indicator on next tab when it's previous tab is selected");
			}
		}
		softAssert.assertAll();
		ReportManager.logInfo("Verify Red Dot Indicator on next tab when it's previous tab is selected");
		ReportManager.logPass("Verify Red Dot Indicator on next tab when it's previous tab is selected");
		mobileActions.swipeUp(2);
		return this;
	}

	/**
	 * This method is to click on any tab from home page
	 *
	 * @param tabName
	 * @return
	 * @throws IOException
	 */
	public HomeScreenTabPage clickOnAnyTabFromHomePage(String tabName) throws IOException {
		mobileActions.waitForVisible(
				MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "feedTab_Text", tabName));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "feedTab_Text", tabName),
				"Click on tab = " + tabName);
		return this;
	}

	/**
	 * This method is to swipe down and then click on any tab and verify user lands
	 * on top pf the page
	 *
	 * @param tabName
	 * @return
	 * @throws IOException
	 */
	public HomeScreenTabPage verifyTopOfThePage(String tabName) throws IOException {
		mobileActions.swipeUp(5);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "feedTab_Text", tabName),
				"Click on tab = " + tabName);
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "write_comment"),
				"Verify write your comment search bar is visible on top of the page"));
		return this;
	}

	/**
	 * This method is to verify dynamic banner displaying
	 *
	 * @return
	 * @throws IOException
	 */
	public HomeScreenTabPage verifyDynamicBanner() {
		mobileActions.swipeUsingID("root_single_user_big");
		// mobileActions.swipeUp(1);
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "dynamicBanner"),
				"Verify dynamic banner is displaying"));
		return this;
	}

	/**
	 * This method is to verify banner page is displaying
	 *
	 * @return
	 * @throws IOException
	 */
	public HomeScreenTabPage verifyBannersOnFeedPage(String regexExpression) {
		String actualText = mobileActions
				.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "dynamicBannerText"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "dynamicBannerText"),
				"Click on dynamic banner");
		String expectedText = mobileActions
				.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "profileName"));
		Assert.assertTrue(
				actualText.split("  ")[0].split(regexExpression)[0]
						.contains(expectedText.split("  ")[0].split(regexExpression)[0]),
				"Dynamic banner is not showing correct");
		return this;
	}

	/**
	 * This method is to verify trending koo page after clicking on trending tag
	 * icon from home/ feed page
	 *
	 * @return
	 * @throws IOException
	 */
	public HomeScreenTabPage verifyTrendingKooPageHeading(String expectedTrendingKooPageHeading) {
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab",
				"trendingKooPageHeading", expectedTrendingKooPageHeading),
				"Verify Trending Koo page heading is visible"));
		return this;
	}

	/**
	 * This method is to click on settings button
	 *
	 * @return
	 * @throws IOException
	 */
	public HomeScreenTabPage clickTrendingKooIcon() {
		mobileActions.waitForVisible(
				MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "refreshButtonOnTrendingKooPage"));
		mobileActions.click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "refreshButtonOnTrendingKooPage"),
				"Click on refresh icon on trending koo page");
		return this;
	}

	/**
	 * This method is to verify dynamic banner displaying
	 *
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public HomeScreenTabPage verifyKoosInRankOnFeedPage() throws IOException, InterruptedException {
		mobileActions.swipeUsingID("koo_time_creation_tv");
		String currentKooCreationTimeText = mobileActions
				.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "kooCreationTimeStamp"));
		if (!currentKooCreationTimeText.equalsIgnoreCase("Just Now")) {
			String currentKooCreationTimeText_1 = currentKooCreationTimeText.replaceAll("[^0-9]", "");
			CommonHelper.clickOnHomeButton();
			CommonHelper.clickOnKooBird();
			CommonHelper.clickOnKooBird();
			CommonHelper.clickOnKooBird();
			CommonHelper.clickOnKooBird();
			mobileActions.swipeDown(5);
			Thread.sleep(5000);
			mobileActions.swipeUsingID("koo_time_creation_tv");
			DriverFactory.getInstance().getMobileDriver().manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
			String newKooCreationTimeText = mobileActions
					.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "kooCreationTimeStamp"));
			String newKooCreationTimeText_1 = newKooCreationTimeText.replaceAll("[^0-9]", "");
			Assert.assertTrue(
					Integer.parseInt(newKooCreationTimeText_1) < Integer.parseInt(currentKooCreationTimeText_1),
					"Latest koo is not showing on top. Hence koos are not refreshing after doing the refresh, "
							+ ", the old koo/expected creation time is = " + currentKooCreationTimeText_1
							+ " ,latest koo/actual creation time is = " + newKooCreationTimeText_1
							+ " , the latest koo creation time should be less than the old koo creation time");
			ReportManager.logPass("Latest koo is showing on top. Hence koos are refreshing after doing the refresh"
					+ "the old koo creation time is = " + currentKooCreationTimeText_1
					+ " , latest koo creation time is = " + newKooCreationTimeText_1
					+ " , the latest koo creation time should be less than the old koo creation time");
		} else {
			ReportManager.logInfo("Latest Koo is showing on top and time is = " + currentKooCreationTimeText);
		}

		return this;
	}

	/**
	 * This method is to verify koo text, media, reaction bar icons
	 *
	 * @return
	 * @throws InterruptedException
	 */
	public HomeScreenTabPage verifyReactionBarIcons() throws InterruptedException {
		Thread.sleep(5000);
		mobileActions.swipeUsingID("like_holder_constraint");
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "likeHolderIconOnReactionBar"),
				"Verify Like Holder Icon on reaction bar"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "commentHolderIconOnReactionBar"),
				"Verify Comment Holder Icon on reaction bar"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "rekooHolderIconOnReactionBar"),
				"Verify Re-Koo Holder Icon on reaction bar"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "whatsappShareIconOnReactionBar"),
				"Verify Whats App Share Icon on reaction bar"));
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "shareIconOnReactionBar"),
				"Verify share Icon on reaction bar"));
		return this;
	}

	/**
	 * This method is to verify koo text
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyKooText() {
		mobileActions.swipeUsingID("topic_title_textview");
		Assert.assertTrue(mobileActions.isDisplayed(
				MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "kooText"), "Verify koo text"));
		return this;
	}

	/**
	 * This method is to verify koo media
	 *
	 * @return
	 */
	public HomeScreenTabPage verifyKooMedia() throws InterruptedException {
		mobileActions.swipeUsingID("play");
		Thread.sleep(2000);
		boolean isPlay = mobileActions.isElmPresent(By.id("com.koo.app:id/play"));
		if (isPlay) {
			mobileActions.click(By.id("com.koo.app:id/play"), "Click on Play button to play video");
		}
		mobileActions.swipeUp(1);
		String actualTextOfTimeElapsed = mobileActions
				.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "timeElapsedForVideo"));
		Thread.sleep(2000);
		String expectedTextOfTimeElapsed = mobileActions
				.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "timeElapsedForVideo"));
		int actualTime = Integer.parseInt(actualTextOfTimeElapsed.split(":")[1]);
		int expectedTime = Integer.parseInt(expectedTextOfTimeElapsed.split(":")[1]);
		Assert.assertTrue(actualTime > expectedTime, "Koo Media/ Video is playing and actual time is = " + actualTime
				+ " Expected time is = " + expectedTime);
		return this;
	}

	/**
	 * This method is to verify comment details section
	 * 
	 * @param commentsSectionHeading
	 * @return
	 * @throws IOException
	 */
	public HomeScreenTabPage verifyCommentsDetailSection(String commentsSectionHeading, String commentText,
			String postButton, String kooText) throws IOException, InterruptedException {
		Thread.sleep(5000);
		mobileActions.swipeUp(1);
		mobileActions.swipeUpFindElement(10,
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "postedCommentIcon", kooText));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "writeCommentsBar"),
				"Click on Write your comment field");
		mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"),
				commentText, "Enter value in write comments");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", postButton),
				"Click on Post Button");
		Thread.sleep(5000);
		mobileActions.swipeUpFindElement(10,
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "postedKooText", kooText));
		mobileActions.click(
				MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "postedCommentIcon", kooText),
				"Click on View Comment Button");
		Thread.sleep(2000);
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab",
				"commentsSectionHeading", commentsSectionHeading), "Comment section is not displaying"));
		return this;
	}

	/**
	 * This method is to verify koo's should be refreshed under home tab
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public HomeScreenTabPage verifyRefreshedKoo() throws InterruptedException {
		String oldKoo = mobileActions
				.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "kooDetail"));
		mobileActions.swipeUp(2);
		mobileActions.swipeDown(60);

		ReportManager.logInfo("Refreshed the page multiple times and thenget text of latest koo");
		DriverFactory.getInstance().getMobileDriver().manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		String refreshedKoo = mobileActions
				.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "kooDetail"));

		// Verify Old Koo and New/ Refreshed Koo Text should not same/equal
		ReportManager.logInfo("Verify Old Koo and New/ Refreshed Koo Text should not same/equal");
		Assert.assertTrue(!oldKoo.equalsIgnoreCase(refreshedKoo), "Koo is not refreshed the old koo text was ==== "
				+ oldKoo
				+ ", and Expected refreshed koo text is still same as per the old koo text which is not correct "
				+ refreshedKoo);
		return this;
	}
}
