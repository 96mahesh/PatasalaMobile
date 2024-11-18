package com.framework.android.testcases.kooCreationTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.android.screens.kooCreationPages.KooCreationSettingsPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;

@Listeners({SuiteEvent.class, MobileEvent.class})

public class KooCreationSettingsTest {
    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_463, TC_464, TC_544, TC_545, TC_546, TC_549] Verify tapping on settings button, Comment Prefrence & Keyboard Preference options should be shown.", groups = {
            "regression", "koo_creation"})
    public void verifyKooCreationSettings(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        KooCreationSettingsPage kooCreationSettings = new KooCreationSettingsPage();
        kooCreationSettings.verifyPreferences(language);
        kooCreationSettings.verifyPreferencesCheckBoxes(LanguageDataProvider.getLanguageDataValue("EveryOneCheckBox"), LanguageDataProvider.getLanguageDataValue("PeopleYouFollow"), LanguageDataProvider.getLanguageDataValue("NoOne"), LanguageDataProvider.getLanguageDataValue("AutoTranslationKeyboard"));
    }
}