package com.framework.android.screens.kooRewardsProgramPages;

import java.io.IOException;

import org.testng.Assert;

import com.framework.android.screens.kooCreationPages.kooCreationScreensPage;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.MobileUtil;

public class WithdrawFlow {
	MobileActions mobileActions = new MobileActions();
	
	public void verifyWithDrawbutton(String language) throws IOException, InterruptedException {
		
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_earnCashOnKoo"),
				"Earn Cash On koo button");
		mobileActions.swipeUsingID("btnWithdraw");
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_withdraw"),
				"withdraw button"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_withdraw"),
				"withdraw button");
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_skipinWithdraw"),
				"skip button"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "btn_skipinWithdraw"),
				"withdraskipw button");
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooRewardsProgram", "txt_cashWithdraw"),
				"cash withdraw heading"));
	}

}
