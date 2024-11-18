package com.framework.android.testcases.onBoardingFlowTests;

import com.codoid.products.exception.FilloException;
import com.framework.android.screens.onboardingFlowPages.OnBoardingFlowPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.CommonHelper;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class OnBoardingFlowTest {

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_039, TC_040] Verify keyboard should auto open & cursor should be in enter name text filed & user is able to type username.",
            groups = {"regression", "onboarding_flow"})
    public void verifyKeyboardAutoOpenForUpdateNameField(String language) throws IOException, InterruptedException, FilloException {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("autoNewUserForOnBoarding"));
        CommonHelper.enterValueFromKeyboard(RandomStringUtils.randomAlphabetic(40));
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_042, TC_043, TC_046] Verify user is able to enter gallery, select & upload profile image by tapping on camera button.",
            groups = {"regression", "onboarding_flow"})
    public void verifyUserCanUploadProfilePicture(String language) throws IOException, InterruptedException, FilloException {
        LanguageDataProvider.setCurrentLanguage(language);
        OnBoardingFlowPage onBoardingFlowPage = new OnBoardingFlowPage();
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("autoNewUserForOnBoarding"));
        CommonHelper.enterValueFromKeyboard(RandomStringUtils.randomAlphabetic(40));
        onBoardingFlowPage.clickContinueButton()
                .clickCameraButton()
                .clickCameraButtonOnGalleryPage();
        //TODO
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_044, TC_045] Verify new users should get Interest selection screen after profile picture upload screen, should be in user selected language.",
            groups = {"regression", "onboarding_flow"})
    public void verifyUserCanSelectInterest(String language) throws IOException, InterruptedException, FilloException {
        LanguageDataProvider.setCurrentLanguage(language);
        OnBoardingFlowPage userNameUpdatePage = new OnBoardingFlowPage();
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("autoNewUserForOnBoarding"));
        CommonHelper.enterValueFromKeyboard(RandomStringUtils.randomAlphabetic(40));
        userNameUpdatePage.clickContinueButton();
        userNameUpdatePage.verifySelectedInterest();
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_053, TC_054, TC_055, TC_058] Verify topics should be arranged according to respective categories.",
            groups = {"regression", "onboarding_flow"})
    public void verifyTopicsArrangedInCategories(String language) throws IOException, InterruptedException, FilloException {
        LanguageDataProvider.setCurrentLanguage(language);
        OnBoardingFlowPage onBoardingFlowPage = new OnBoardingFlowPage();
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("topicsArrangedUser"));
        onBoardingFlowPage.clickContinueButton();
        onBoardingFlowPage.verifySelectedInterest();
        onBoardingFlowPage.verifySkipContinueButtonEnableAndFollowProfilePageVisible();
        onBoardingFlowPage.verifyTopicsArrangedInCategories();
    }
}
