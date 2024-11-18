package com.framework.android.testcases.kooCreationTests;

import com.framework.android.screens.kooCreationPages.KooCreationScheduleKooPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;


@Listeners({SuiteEvent.class, MobileEvent.class})

public class KooCreationScheduleTest {


    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_496, TC_497, TC_498, TC_500, TC_501, TC_502, TC_504, TC_506] Verify tapping on schedule, popup shouod open with (i) Schedule Koo (ii) View Scheduled Koos options.", groups = {
            "regression", "koo_creation"})

    public void verifyKooCreationSchedule(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        KooCreationScheduleKooPage KooCreationSchedule = new KooCreationScheduleKooPage();
        KooCreationSchedule.ScheduleKoo(language, LanguageDataProvider.getLanguageDataValue("ScheduleKooText"), LanguageDataProvider.getLanguageDataValue("ViewScheduledKoosText"), LanguageDataProvider.getLanguageDataValue("ScheduleKooMessage"), LanguageDataProvider.getLanguageDataValue("UpcomingButton"), LanguageDataProvider.getLanguageDataValue("PublishedButton"), LanguageDataProvider.getLanguageDataValue("DraftButton"), LanguageDataProvider.getLanguageDataValue("PostButtonText"),LanguageDataProvider.getLanguageDataValue("NextButtonText"));

    }

}

