package com.framework.android.testcases.registrationAndLoginFlowTests;

import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.android.utils.MobileActions;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ SuiteEvent.class, MobileEvent.class })
public class LoginKooTest {
    @Test(description = "[TC_010, TC_020, TC_021] Verify user is ale to login Koo application successfully",
            groups = {"regression", "registration_and_login"})
    public void verifyUserLoginWithOTP() throws Exception {
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser("English",ConfigReader.getValue("UserName"));
    }
}
