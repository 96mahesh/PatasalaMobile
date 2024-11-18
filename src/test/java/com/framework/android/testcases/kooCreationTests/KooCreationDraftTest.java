package com.framework.android.testcases.kooCreationTests;

import com.framework.android.screens.kooCreationPages.KooCreationDraftKooPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;


@Listeners({SuiteEvent.class, MobileEvent.class})

public class KooCreationDraftTest {

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_507, TC_508, TC_509, TC_510, TC_511, TC_513] Verify tapping on draft button user should get popup with: (i) Draft koo (ii) View Drafted koos opitons.", groups = {
            "regression", "koo_creation"})
    public void verifyKooCreationDraft(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        KooCreationDraftKooPage KooCreationDraft = new KooCreationDraftKooPage();
        KooCreationDraft.DraftKoo(language, LanguageDataProvider.getLanguageDataValue("SavetoDraft"), LanguageDataProvider.getLanguageDataValue("ViewDraft"), LanguageDataProvider.getLanguageDataValue("DraftButton"), LanguageDataProvider.getLanguageDataValue("PostButtonText"),LanguageDataProvider.getLanguageDataValue("NextButtonText"));

    }
}
