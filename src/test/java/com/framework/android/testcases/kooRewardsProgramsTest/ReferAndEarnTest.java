package com.framework.android.testcases.kooRewardsProgramsTest;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.framework.android.screens.kooRewardsProgramPages.MultiAccount;
import com.framework.android.screens.kooRewardsProgramPages.ReferAndEarn;
import com.framework.android.screens.kooRewardsProgramPages.RewardCentre;
import com.framework.android.screens.kooRewardsProgramPages.TransactionAndCoinHistory;
import com.framework.android.screens.kooRewardsProgramPages.WithdrawFlow;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
@Listeners({SuiteEvent.class, MobileEvent.class})
public class ReferAndEarnTest {
	
	

	    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
	            description = "[TC_189, TC_190, TC_191,] Verify Refer button & text on reward centre widget on feed screen.", groups = {
	            "regression", "Koo_Rewards"})
	    public void verifyReferAndEarnPage(String language) throws IOException, InterruptedException, FilloException {
	        LanguageDataProvider.setCurrentLanguage(language);
	        LoginKooPage loginKooPage = new LoginKooPage();
            loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
	        ReferAndEarn referAndEarn = new ReferAndEarn();
	        referAndEarn.verifyReferNowButton(language);
	        referAndEarn.verifyreferTitle(LanguageDataProvider.getLanguageDataValue("ReferTitle"));
	        referAndEarn.verifyreferSubTitle(LanguageDataProvider.getLanguageDataValue("ReferSubTitle"));
	        referAndEarn.verifyReferNowbuttonWithFollowingLinks();
	        referAndEarn.verifyFollowingLinks();
	    }
	    
	    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
	            description = "[TC_166, TC_167, TC_168] Verify Coin & Transaction history button in reward centre & tapping on it user enters respective screen.", groups = {
	            "regression", "Koo_Rewards"})
	    public void verifyTransactionAndCoinPage(String language) throws IOException, InterruptedException, FilloException {
	        LanguageDataProvider.setCurrentLanguage(language);
	        LoginKooPage loginKooPage = new LoginKooPage();
            loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
	        TransactionAndCoinHistory history=new TransactionAndCoinHistory();
	        history.verifyCoinAndTransactionButtons(language);
	        history.verifyCoinHistoryPage(LanguageDataProvider.getLanguageDataValue("Earned"),LanguageDataProvider.getLanguageDataValue("Redeemed"),LanguageDataProvider.getLanguageDataValue("Balance"));
	        history.verifyTransacetionHistoryPage(LanguageDataProvider.getLanguageDataValue("Earned"),LanguageDataProvider.getLanguageDataValue("Redeemed"),LanguageDataProvider.getLanguageDataValue("Balance"));
	    }
	    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
	            description = "[TC_170] Verify withdraw button in reward center tapping user should navigate to respective screen.", groups = {
	            "regression", "Koo_Rewards"})
	    public void verifywithdrawPage(String language) throws IOException, InterruptedException, FilloException {
	        LanguageDataProvider.setCurrentLanguage(language);
	        LoginKooPage loginKooPage = new LoginKooPage();
            loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
	        WithdrawFlow withdraw=new WithdrawFlow();
	        withdraw.verifyWithDrawbutton(language);
	    }
	    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
	            description = "[TC_161, TC_162, TC_163]Verify all the streaks in Reward Centre screen, with exact values & streaks schould be same in all screens.", groups = {
	            "regression", "Koo_Rewards"})
	    public void verifyRewardsPage(String language) throws IOException, InterruptedException, FilloException {
	        LanguageDataProvider.setCurrentLanguage(language);
	        LoginKooPage loginKooPage = new LoginKooPage();
            loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
	        RewardCentre rewardCentre=new RewardCentre();
	        rewardCentre.verifyRewardCentre(language);
	       // rewardCentre.verifyRewardAmount();
	        rewardCentre.verifywithdrawAmount();
	    }
	    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
	            description = "[TC_182, TC_220, TC_277, TC_278, TC_657, TC_659, TC_660, TC_668, TC_669, TC_670, TC_671, TC_673, TC_674, TC_675] Verify reward program should not work for child account and should show banner for the same on feed.", groups = {
	            "regression", "Notification_Screen"})
	    public void verifymultiAccount(String language) throws IOException, InterruptedException, FilloException {
	        LanguageDataProvider.setCurrentLanguage(language);
	        LoginKooPage loginKooPage = new LoginKooPage();
            loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
	        MultiAccount multiaccount=new MultiAccount();
	        multiaccount.multiAccount(language);
	    }

}
