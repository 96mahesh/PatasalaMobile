package com.framework.android.screens.kooCreationPages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.MobileUtil;

public class KooCreationDeleteKooPage {
    MobileActions mobileActions = new MobileActions();
    int Count, countOfLanguages;

    public void Deletekoo(String language, String nextButtonText, String previewButtonText, String buttonText) throws IOException, InterruptedException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"), "Plus Button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_addlanguage_plus"),
                "Add Languages Plus Button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "checkbox_selectLanguage"),
                "select language");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_done_"),
                "Clicked on done button");
        List<WebElement> listOfElements = DriverFactory.getInstance().getMobileDriver()
                .findElements(By.xpath("//android.widget.TextView[contains(@content-desc,'language_tab')]"));
        countOfLanguages = listOfElements.size();
        System.out.println(countOfLanguages);

        if (countOfLanguages > 1) {
            Assert.assertTrue(mobileActions.isDisplayed(
                    MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_next", nextButtonText),
                    "Next Button"));
            mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"),
                    ConfigReader.getValue("KooPostText"));
            mobileActions.click(
                    MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_next", nextButtonText),
                    "Next Button");
//            Assert.assertTrue(mobileActions.isDisplayed(
//                    MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_preview", previewButtonText),
//                    "Ready To Post!"));
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", buttonText),
                    "clicked on post button");
        }
        mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "tab_feed"),
                "Feed tab");
        mobileActions.swipeUp(1);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_dlthmbrgrmenu"),
                "hamberger menu");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_dltkooinfeed"),
                "delete koo");
       // String toast = mobileActions.getText(By.xpath("//android.widget.Toast"));
		//System.out.println(toast);
        mobileActions.swipeDown(1);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_profile"),
                "profile button");
        mobileActions.swipeUsingID("iv_options_more");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_dlthmbrgrmenu"),
                "hamberger menu");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_dltkooinfeed"),
                "delete koo");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_yesdltkoo"),
                " yes delete koo button");
    }
    }


