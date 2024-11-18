package com.framework.android.screens.kooRewardsProgramPages;

import java.io.IOException;

import org.testng.Assert;

import com.framework.android.screens.kooCreationPages.kooCreationScreensPage;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.MobileUtil;
import com.framework.utilities.ReportManager;

public class RewardCentre {
	MobileActions mobileActions = new MobileActions();
	public void verifyRewardCentre(String language) throws IOException, InterruptedException {
		
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_earnCashOnKoo1"),
				"Earn Cash On koo button");
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_kooRewardCentreHeading"),
				"Koo Reward Center page Heading"));
//		mobileActions.swipeUp(1);
//		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_videoHeading"),
//				"Explanatory video Heading"));
//		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_thumbnailLayout"),
//				"Explanatory video"));
	}
//	public void verifyRewardAmount() {
//		mobileActions.swipeUsingID("tvCoinHistory");
//		String withdrawtext=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_money"),
//				"withdraw money details Text");
//		System.out.println(withdrawtext);
//		ReportManager.logInfo("withdraw amount text is " + withdrawtext);
//	}
	public void verifywithdrawAmount() throws IOException {
		mobileActions.swipeUsingID("tvMoneyCount");
		String amount1=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_moneyCountInRewardCentre"),
				"withdraw money details in reward centre page");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_transactionHistory"),
				"Transaction History Button");
		String amount2=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_moneyCountInRewardCentreHistory"),
				"withdraw money details in history page");
		Assert.assertEquals(amount1,amount2);
		ReportManager.logInfo("Verified amount in two different pages "+ amount1+" " + amount2 );
	}
	

}
