package com.framework.android.testcases.logoutAndDeleteTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.android.screens.kooRewardsProgramPages.MultiAccount;
import com.framework.android.screens.logoutAndDelete.DeleteAccount;
import com.framework.android.screens.logoutAndDelete.LogoutAccount;
import com.framework.android.screens.logoutAndDelete.MultiAccountInLogout;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;

@Listeners({SuiteEvent.class, MobileEvent.class})

public class LogOutAndDeleteTest {
	
	

	    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
	            description = "[TC_654, TC_655, TC_656] Verify Logout button in settings screen & tapping on user should land on confirmation popup with \"Logout\" button, tapping user logs out and \"Cancel\" button, tapping popup disappears.",
	            groups = {"regression", "logOut_DeleteTest"})
	    public void verifyLogoUtAccount(String language) throws Exception {
	        LanguageDataProvider.setCurrentLanguage(language);
	        LoginKooPage loginKooPage = new LoginKooPage();
            loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
	        LogoutAccount logoutAndDeleteAcc=new LogoutAccount();
	        logoutAndDeleteAcc.logout(language);
	    }
	    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
	            description = "[TC_658] Verify on tapping Delete button confirmation popup should show with \"Delete\" button, tapping user gets message \"This account will be deleted in 30 days\" & \"Cancel\" button tapping popup disappears.",
	            groups = {"regression", "logOut_DeleteTest"})
	    public void verifyDeleteAccount(String language) throws Exception {
	        LanguageDataProvider.setCurrentLanguage(language);
	        LoginKooPage loginKooPage = new LoginKooPage();
            loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
	        DeleteAccount DeleteAcc=new DeleteAccount();
	        DeleteAcc.delete(language);
	    }
	    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
	            description = "[TC_663] Verify if user adds already added child account there should be a toast message stating \"This account is already added\".",
	            groups = {"regression", "logOut_DeleteTest"})
	    public void verifyMultiAccount(String language) throws Exception {
	        LanguageDataProvider.setCurrentLanguage(language);
	        LoginKooPage loginKooPage = new LoginKooPage();
            loginKooPage.loginValidUser(language, ConfigReader.getValue("ChildUserNumber"));
            MultiAccountInLogout multi=new MultiAccountInLogout();
            multi.multiAccount(ConfigReader.getValue("ChildUserNumber"));
	    }

}
