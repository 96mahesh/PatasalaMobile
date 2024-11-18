package com.framework.android.screens.kooCreationPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.MobileUtil;

public class KooCreationScheduleKooPage {
    MobileActions mobileActions = new MobileActions();

    public void ScheduleKoo(String language, String Schedulekoo, String ViewScheduleKoo, String Schedulekoomessage,
                            String upcoming, String publish, String draft, String buttonText,String nextButtonText) throws IOException, InterruptedException {

        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"), "Plus Button");
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"),
                ConfigReader.getValue("KooPostText"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_Schedule"),
                "Schedule Button");
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_ScheduleKoo", Schedulekoo),
                "Schedule Koo Button"));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation",
                "btn_ViewScheduledKoos", ViewScheduleKoo), "View Scheduled Koos Button"));
        mobileActions.click(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_ScheduleKoo", Schedulekoo),
                "Schedule Koo Button");
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_ScheduleKoo1"),
                "Schedule Koo Button"));
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_skipandpost"),
                "Skip and Post Button"));
//        String scheduleKooMessage = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation",
//                "btn_ScheduleKoomessage", Schedulekoomessage), "Schedule Koo message");
//        System.out.println(scheduleKooMessage);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_ScheduleKoo1"),
                "Schedule Koo button");
        boolean isNativeButton = mobileActions
                .getElementSizeUsingFindElements(By.xpath("//android.widget.TextView[@content-desc='negativeButton']"))
                .size() > 0;
        if (isNativeButton) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_no"),
                    "clicked on no button");
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_okScheduleKoo"),
                    "ok Schedule Koo button");
        } else {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_okScheduleKoo"),
                    "ok Schedule Koo button");
            mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"),
                    "Plus Button");
        }
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"), "Plus Button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_Schedule"),
                "Schedule Button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_ViewScheduledKoos",
                ViewScheduleKoo), "View Scheduled Koos Button");
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_upcoming", upcoming),
                "Upcoming Button"));
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_published", publish),
                "published Button"));
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_draft1", draft), "Drafts Button"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "menu_hamberger"),
                "hamberger menu");
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_editkoo"), "edit Koo Button"));
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_deletekoo"), "delete Koo Button"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_editkoo"),
                "edit Koo Button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_yes"), "Yes Button");
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_Schedule"), "Schedule Button"));
        Thread.sleep(10000);
		boolean isBtn = mobileActions
				.isElmPresent(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", buttonText));
		if (isBtn) {
			Assert.assertTrue(mobileActions.isDisplayed(
					MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", buttonText),
					"Post Button"));
		} else {
			Assert.assertTrue(mobileActions.isDisplayed(
					MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_next", nextButtonText),
					"Next Button"));
		}

	
    }
}
