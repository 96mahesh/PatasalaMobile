package com.framework.android.screens.kooCreationPages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.MobileUtil;
import com.framework.utilities.ReportManager;

public class KooCreationCreateThreadPage {
    MobileActions mobileActions = new MobileActions();

    public void CreateThread(String language, String buttonText) throws IOException, InterruptedException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"), "Plus Button");
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"),
                ConfigReader.getValue("KooPostText"));
        Thread.sleep(3000);
       // if (mobileActions.isEnabled(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_threadkoo"), "Thread koo button")) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_threadkoo"), "Thread Koo Button");
      //  }

        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"),
                ConfigReader.getValue("KooPostText"));
        mobileActions.click(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_ScheduleKoo2"),
                "Schedule Koo Button");
        String toast=DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//android.widget.Toast")).getText();
        System.out.println(toast);
        ReportManager.logInfo("The toast message is "+ toast);
        Thread.sleep(5000);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_draft"),
				"Draft Button");
        String toast1=DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//android.widget.Toast")).getText();
        System.out.println(toast1);
        ReportManager.logInfo("The toast message is "+ toast1);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", buttonText),
                "clicked on post button");
        boolean isNativeButton = mobileActions.getElementSizeUsingFindElements(
                By.xpath("//android.widget.TextView[@content-desc='negativeButton']")).size() > 0;
        if (isNativeButton) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_no"),
                    "clicked on no button");
        }
    }
}
