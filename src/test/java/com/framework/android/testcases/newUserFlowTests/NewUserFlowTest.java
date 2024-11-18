package com.framework.android.testcases.newUserFlowTests;

import com.codoid.products.exception.FilloException;
import com.framework.android.screens.newFlowUserPages.NewUserFlowPage;
import com.framework.android.screens.onboardingFlowPages.ScreensPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.CommonHelper;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class NewUserFlowTest {
    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_059, TC_063, TC_049, TC_052, TC_066] Verify Feed Structure without Selecting Interest:\n" +
                    " (a) Rewards Widget (IN languages).\n" +
                    " (b) Infinite People carousel in the first position(50 profiles).\n" +
                    " (b) Top 50 Bulk Follow button followed by Segment Bulk Follow button along with blink(Kn & Hi).\n" +
                    " (c) Koo Team Video koo.\n" +
                    " (d) Sample feed.\n" +
                    " (e) End of Feed Banner with Follow People button.",
            groups = {"regression", "newUser_flow"})
    public void verifyTopFiftyBulkFollowButtonOnFeedTab(String language) throws IOException, InterruptedException, FilloException {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        NewUserFlowPage newUserFlowPage = new NewUserFlowPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("autoNewUserForOnBoarding"));
        newUserFlowPage.verifyTopFiftyBulkFollowButton();
        newUserFlowPage.clickFollowAllButton();
        newUserFlowPage.verifySelectUnSelectFollowUser("checked");
        newUserFlowPage.verifyFollowAPeopleButton();
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_060, TC_061, TC_062, TC_064, TC_065, TC_066, TC_067, TC_068, TC_069] Verify Feed Structure without Selecting Interest:\n" +
                    " (a) Rewards Widget (IN languages).\n" +
                    " (b) Infinite People carousel in the first position(50 profiles).\n" +
                    " (b) Top 50 Bulk Follow button followed by Segment Bulk Follow button along with blink(Kn & Hi).\n" +
                    " (c) Koo Team Video koo.\n" +
                    " (d) Sample feed.\n" +
                    " (e) End of Feed Banner with Follow People button.",
            groups = {"regression", "newUser_flow"})
    public void verifyBulkFollowAndSBF(String language) throws IOException, InterruptedException, FilloException {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        NewUserFlowPage newUserFlowPage = new NewUserFlowPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("autoNewUserForOnBoarding"));
        newUserFlowPage.clickContinueButton().clickContinueButton();
        newUserFlowPage.verifyReferNowButton();
        newUserFlowPage.verifyFollowAllButton().verifyExploreAllButton().verifySegmentBulkFollow();
        newUserFlowPage.verifyAllUserFollowed(0, "50");
        CommonHelper.clickOnBackArrow();
        newUserFlowPage.verifySegmentBulkFollowAction(5);
    }
}
