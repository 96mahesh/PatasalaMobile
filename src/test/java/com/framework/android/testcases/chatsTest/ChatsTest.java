package com.framework.android.testcases.chatsTest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.android.screens.chats.ChatsPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
@Listeners({SuiteEvent.class, MobileEvent.class})
public class ChatsTest {
	
	@Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
	            description = "[TC_632, TC_633, TC_634, TC_635, TC_636, TC_638, TC_640, TC_642, TC_643] Verify 2 sections on chat listing screen (i) Following (ii) Others, which following conatains all followed users chats & others contains non followed users chats.",
	            groups = {"regression", "koo_Chats"})
	    public void verifyChatPage(String language) throws Exception {
	        LanguageDataProvider.setCurrentLanguage(language);
	        LoginKooPage loginKooPage = new LoginKooPage();
            loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
	        ChatsPage chat=new ChatsPage();
	        chat.chatPage(language,LanguageDataProvider.getLanguageDataValue("FollowingTabText"),LanguageDataProvider.getLanguageDataValue("othersInChats"));
	        
	        
	    }
}
