package com.framework.android.screens.topics;

import org.junit.Assert;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.MobileUtil;

public class TopicsTab {
	MobileActions mobileActions = new MobileActions();
	
	public void topicsTab(String topicsTabText) {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Topics", "btn_topicsTab",topicsTabText),"topics tab");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Topics", "btn_+intopics"),"+ button to follow");
		String bfrtxt=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Topics", "txt_followedtopicHeadinginTopic"),"topic heading which we followed");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Topics", "btn_>intopics"),"> button in topics page");
		String aftrtxt=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Topics", "txt_afterfollowedtopicHeadinginTopic"),"topic heading which we followed");
		Assert.assertEquals(bfrtxt, aftrtxt);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "backButton_arrow"),"back button");
		
	}

}
