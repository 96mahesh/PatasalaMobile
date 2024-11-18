package com.framework.android.screens.kooRewardsProgramPages;

import java.io.IOException;

import org.testng.Assert;
import com.framework.android.screens.kooCreationPages.kooCreationScreensPage;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.MobileUtil;

public class ReferAndEarn {
	MobileActions mobileActions = new MobileActions();
	//SoftAssert softAssert = new SoftAssert();
	String actualValue;
	
	
	public void verifyReferNowButton(String language) throws IOException, InterruptedException {
		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_referAndNow"),
				"Refer Now button");
	}
	
	public void verifyreferTitle(String expectedValue) {
		 actualValue = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_referTitle"));
	        Assert.assertEquals(actualValue, expectedValue, "Actual Refer Title heading is not correct");
	        			}
	public void verifyreferSubTitle(String expectedValue) {
		actualValue = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_referSubTitle")).trim();
        Assert.assertEquals(actualValue, expectedValue, "Actual Refer Sub Title heading is not correct");
	}
	public void verifyReferNowbuttonWithFollowingLinks() throws IOException {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_referAndNow"),
				"Refer Now button");
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_whatsappinRefer"),
				"Share on Whatsapp button"));
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_shareinRefer"),
				"Share button"));
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_copylink"),
				"Copy link button"));
	}
	public void verifyFollowingLinks() throws IOException {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_whatsappinRefer"),
				"Share on Whatsapp button");
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_sendto"),
				"Send to text"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_backInWhatsp"),
				"back button in Whatsapp");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_shareinRefer"),
				"Share button");
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_Share"),
				"Share Text"));
	}

}
