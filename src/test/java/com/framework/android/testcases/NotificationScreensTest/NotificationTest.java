package com.framework.android.testcases.NotificationScreensTest;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.framework.android.screens.kooRewardsProgramPages.MultiAccount;
import com.framework.android.screens.notificationspages.PanelPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.DriverFactory;


	@Listeners({SuiteEvent.class, MobileEvent.class})
	public class NotificationTest {

	    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
	            description = "[TC_691, TC_694, TC_695, TC_696, TC_697, TC_698, TC_699, TC_700, TC_707, TC_708, TC_709] Verify (i) All (ii) Followers (iii) Mentions (iv) Reactions (v) Others tab in notificaiton panel.", groups = {
	            "regression", "Notification_Screen"})
	    public void verifyPanelPage(String language) throws IOException, InterruptedException, FilloException {
	        LanguageDataProvider.setCurrentLanguage(language);
	        LoginKooPage loginKooPage = new LoginKooPage();
            loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
	        PanelPage panelpage = new PanelPage();
	        panelpage.verifyTabsInNotificationPage(language,LanguageDataProvider.getLanguageDataValue("AllTabInNotification"),LanguageDataProvider.getLanguageDataValue("FollowersTabInNotification") , LanguageDataProvider.getLanguageDataValue("CommentsTabInNotification"), LanguageDataProvider.getLanguageDataValue("MentionsTabInNotifications"), LanguageDataProvider.getLanguageDataValue("ReationsTabInNotifications"),LanguageDataProvider.getLanguageDataValue("OthersTabInNotifications") );
	        panelpage.allTab();
	        panelpage.followersTab(LanguageDataProvider.getLanguageDataValue("FollowersTabInNotification"));
	        panelpage.commentsTab(LanguageDataProvider.getLanguageDataValue("CommentsTabInNotification"));
	        panelpage.mentionsTab(LanguageDataProvider.getLanguageDataValue("CommentsTabInNotification"), LanguageDataProvider.getLanguageDataValue("OthersTabInNotifications"),LanguageDataProvider.getLanguageDataValue("MentionsTabInNotifications") );
	        panelpage.reactionsTab(LanguageDataProvider.getLanguageDataValue("ReationsTabInNotifications"));
	        panelpage.othersTab(LanguageDataProvider.getLanguageDataValue("ReationsTabInNotifications"),LanguageDataProvider.getLanguageDataValue("OthersTabInNotifications"));
	        panelpage.notificationSettingsPage(LanguageDataProvider.getLanguageDataValue("ActivitiesFromPeopleIFollow"));
	    }
	    
	    
	   
	   

}
