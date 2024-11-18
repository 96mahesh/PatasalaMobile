package com.framework.android.testcases.topicsTests;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.screens.topics.TopicWidget;
import com.framework.android.screens.topics.TopicsTab;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
@Listeners({SuiteEvent.class, MobileEvent.class})
public class TopicWidgetTest {
		
		@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
		            description = "[TC_156, TC_144, TC_145, TC_147] Verify Followed Topics widget should show on feed after following atleast one topic with View Koos button, tapping on which users goes to topics detail screen.",
		            groups = {"regression", "Topics"})
		    public void verifyTopicWidgetPage(String language) throws Exception {
		        LanguageDataProvider.setCurrentLanguage(language);
		        LoginKooPage loginKooPage = new LoginKooPage();
	            loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
	            TopicWidget topic=new TopicWidget();
	            topic.topicswidgetPage();
		}
		@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
	            description = "[TC_155] Verify Followed Topics widget should show on feed after following atleast one topic with View Koos button, tapping on which users goes to topics detail screen.",
	            groups = {"regression", "Topics"})
		public void verifyTopicWidget(String language) throws InterruptedException, IOException, FilloException {
	            LanguageDataProvider.setCurrentLanguage(language);
		        LoginKooPage loginKooPage = new LoginKooPage();
	            loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
	            TopicWidget topic=new TopicWidget();
	            topic.topicsAddTopictoYourFeed();
		        
		    }
		@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
	            description = "[TC_134, TC_135, TC_137, TC_138, TC_139] Verify topics tab should be in 3rd/4th position in home screen tabs for English & Hindi users only.",
	            groups = {"regression", "Topics"})
		public void verifyTopicTabPage(String language) throws InterruptedException, IOException, FilloException {
	            LanguageDataProvider.setCurrentLanguage(language);
		        LoginKooPage loginKooPage = new LoginKooPage();
	            loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
	            TopicsTab topics=new TopicsTab();
	            topics.topicsTab(LanguageDataProvider.getLanguageDataValue("TopicsTabText"));
		        
		    }

}
