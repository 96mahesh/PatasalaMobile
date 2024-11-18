package com.framework.android.testcases.kooCreationTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.android.screens.kooCreationPages.KooCreationDeleteKooPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class KooCreationDeleteKooTest {

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_562, TC_603, TC_604] Verify if user edits original language content, same should be translated to child languages.", groups = {
            "regression", "koo_creation"})

    public void verifyDeleteKoo(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        KooCreationDeleteKooPage kooCreationDeleteKooPage = new KooCreationDeleteKooPage();
        kooCreationDeleteKooPage.Deletekoo(language, LanguageDataProvider.getLanguageDataValue("NextButtonText"), LanguageDataProvider.getLanguageDataValue("PreviewButtonText"), LanguageDataProvider.getLanguageDataValue("PostButtonText"));
    }
}
