package com.framework.android.screens.topics;

import org.junit.Assert;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.MobileUtil;

public class TopicWidget {
	MobileActions mobileActions = new MobileActions();
	
	public void topicswidgetPage() throws InterruptedException {
		mobileActions.swipeUpFindElement(20,MobileUtil.returnByBasedOnPageNameAndObjectName("Topics", "btn_followedtopicHeading"));
		String bfrtxt=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Topics", "btn_followedtopicHeading"),"topic heading which we followed");
		mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("Topics", "txt_followedkoocontent"),"followed koo content");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Topics", "btn_followedtopicHeading"),"topic heading which we followed");
		String aftrtxt=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Topics", "txt_followedtopicHeading"),"topic heading which we followed");
		Assert.assertEquals(bfrtxt, aftrtxt);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "backButton_arrow"),"back button");
		
		
	}
	public void topicsAddTopictoYourFeed() throws InterruptedException {
		
		mobileActions.swipeUpFindElement(30,MobileUtil.returnByBasedOnPageNameAndObjectName("Topics", "txt_addTopicsToYourFeed"));
		//mobileActions.swipeUsingIDAndSwipeCount("header_text", 30);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Topics", "btn_+toFollow"),"+ button to follow");
		Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("Topics", "btn_popupforTopicFollow"),"mail layout"));
		
	}

}
