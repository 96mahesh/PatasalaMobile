package com.framework.android.testcases.kooCreationTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.android.screens.kooCreationPages.KooCreationEditingAndTranslationPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class KooCreationEditingAndTranslationTest {
    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_562] Verify if user edits original language content, same should be translated to child languages.", groups = {
            "regression", "koo_creation"})
    public void verifyEditngAndTransltion(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        KooCreationEditingAndTranslationPage editAndTranslation = new KooCreationEditingAndTranslationPage();
        editAndTranslation.EditingAndTranslation(language, LanguageDataProvider.getLanguageDataValue("NextButtonText"), LanguageDataProvider.getLanguageDataValue("PreviewButtonText"), LanguageDataProvider.getLanguageDataValue("PostButtonText"));
    }
}