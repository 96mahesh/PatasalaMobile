package com.framework.android.screens.chats;

import java.io.IOException;
import org.junit.Assert;
import org.openqa.selenium.By;

import com.framework.android.screens.kooCreationPages.kooCreationScreensPage;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.MobileUtil;

public class ChatsPage {
	MobileActions mobileActions = new MobileActions();

    public void chatPage(String language,String followingbtn,String others)
            throws IOException, InterruptedException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "chat_icon"),
                "chat button");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "btn_followingInChat",followingbtn),
                "following button"));
        Assert.assertTrue( mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "btn_othersInChat",others),
                "others button"));
        
        mobileActions.click(By.id("com.koo.app:id/tv_start_conversation"), "start_conversation");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "btn_channelIconInChat"),
                "public profile button in chat");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "btn_followsYou"),
                "follows you button"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "backButton"),
                "back button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "btn_othersInChat",others),
                "others button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "btn_channelIconInChat"),
                "public profile button in chat");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "logOutUser_popup"),
                "follow button"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "backButton"),
                "back button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "btn_messagechatbox"),
                "message chat box button");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "txt_messageheadingInChat"),
                "new message text"));
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "btn_searchInChat"),
               ConfigReader.getValue("search"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "btn_selectProfile"),
                "selecting profile from the list");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "btn_request"),
                "request button"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "btn_backInChat"),
                "back button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "btn_settingsInChat"),
                "settings button");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "btn_onOffChat"),
                "enable or disable button"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "back_button"),
                "back button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "btn_followingInChat",followingbtn),
                "following button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "btn_profileinChat"),
                "profile button");
        String sendmsgtxt=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "txt_sendmsg"),
                "send message");
        System.out.println(sendmsgtxt);
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "txt_sendmsg"),
        		ConfigReader.getValue("KooPostText"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "btn_sendInChat"),
                "send button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "btn_profileImageinChat"),
                "profile image");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "txt_profilelink"),
                "profile view"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "back_icon"),
                "back button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "btn_threedotsinChat"),
                "three dots in chat conversation");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("Chats", "txt_blockInChat"),
                "block text"));
}
}

