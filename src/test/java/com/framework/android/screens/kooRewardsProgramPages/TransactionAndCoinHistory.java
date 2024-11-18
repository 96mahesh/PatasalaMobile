package com.framework.android.screens.kooRewardsProgramPages;

import java.io.IOException;

import org.testng.Assert;

import com.framework.android.screens.kooCreationPages.kooCreationScreensPage;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.MobileUtil;

public class TransactionAndCoinHistory {

	MobileActions mobileActions = new MobileActions();
	//String actualValue;
	public void verifyCoinAndTransactionButtons(String language) throws IOException, InterruptedException {
		
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_earnCashOnKoo1"),
				"Earn Cash On koo button");
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_kooRewardCentreHeading"),
				"Koo Reward Center page Heading"));
		mobileActions.swipeUsingID("layerCoins");
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_kooCoinHistory"),
				"Koo coin History button"));
	}
	
	public void verifyCoinHistoryPage(String earned,String redeemed,String balance) throws IOException {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_kooCoinHistory"),
				"Koo coin History button");
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_coinHistoryHeading"),
				"Koo coin History Heading"));
//		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_earned",earned),
//				"Earned Heading"));
//		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_redeemed",redeemed),
//				"Redeemed Heading"));
//		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_balance",balance),
//				"Balance Heading"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_backArrow"),
				"Back button");
		}
	public void verifyTransacetionHistoryPage(String earned,String redeemed,String balance) throws IOException {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_transactionHistory"),
				"Koo transaction History button");
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_transactionHeading"),
				"Koo transaction History Heading"));
//		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_earned",earned),
//				"Earned Heading"));
//		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_redeemed",redeemed),
//				"Redeemed Heading"));
//		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_balance",balance),
//				"Balance Heading"));
		
	}
}
