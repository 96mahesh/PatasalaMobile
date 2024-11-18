package com.framework.android.testcases.onBoardingFlowTests;

import com.codoid.products.exception.FilloException;
import com.framework.android.screens.onboardingFlowPages.ScreensPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class ScreensTest {
    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_038, TC_058] Verify after entering OTP: (i) New user should get a) Name update screen b) " +
                    "Profile picture update screen & (ii) Old user should navigate to feed.",
            groups = {"regression", "onboarding_flow"})
    public void verifyAfterLoginValidUserRedirectsOnFeedTab(String language) throws IOException, InterruptedException, FilloException {
        LanguageDataProvider.setCurrentLanguage(language);
        ScreensPage screensPage = new ScreensPage();
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        screensPage.verifyFeedPageForExistingUser(language, LanguageDataProvider.getLanguageDataValue("FeedTabText"));
    }
}
