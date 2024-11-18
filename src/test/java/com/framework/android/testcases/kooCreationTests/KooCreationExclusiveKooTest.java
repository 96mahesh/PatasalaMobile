package com.framework.android.testcases.kooCreationTests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.android.screens.kooCreationPages.KooCreationExclusiveKooPage;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;


@Listeners({SuiteEvent.class, MobileEvent.class})

public class KooCreationExclusiveKooTest {


    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_495] Verify Exclusive button should show & be in disabled state before selecting. Tapping should show confirmation popup for first time & should change to yellow.", groups = {
            "regression", "koo_creation"})

    public void verifyKooCreationExclusiveKoo(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        KooCreationExclusiveKooPage exclusiveKoo = new KooCreationExclusiveKooPage();
        exclusiveKoo.verifyExclusiveKoo(language, LanguageDataProvider.getLanguageDataValue("ExclusiveKooText"));

    }

}
