package com.framework.android.testcases.kooCreationTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.android.screens.kooCreationPages.KooCreationCreateThreadPage;
import com.framework.android.screens.kooCreationPages.kooCreationScreensPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;


@Listeners({SuiteEvent.class, MobileEvent.class})

public class KooCreationCreateThreadTest {

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_514, TC_515, TC_505, TC_512] Verify tapping on '+' button, a thread should be added, given there is text/media content in parent thread koo.", groups = {
            "regression", "koo_creation"})
    public void verifyKooCreationThread(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
         KooCreationCreateThreadPage CreateThread = new KooCreationCreateThreadPage();
        CreateThread.CreateThread(language,LanguageDataProvider.getLanguageDataValue("PostButtonText"));
    }
}
