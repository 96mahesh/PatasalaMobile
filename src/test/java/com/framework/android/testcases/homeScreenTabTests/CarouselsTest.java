package com.framework.android.testcases.homeScreenTabTests;

import com.framework.android.screens.homeScreenTabsPages.CarouselsPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class CarouselsTest {

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_099] Verify horizontal carousel on different home screen tabs and profile cards on them with follow button.",
            groups = {"regression", "homeTab_screen"})
    public void verifyHorizontalCarouselForNewUser(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        CarouselsPage carouselsPage = new CarouselsPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("autoNewUser"));
        carouselsPage.verifyHorizontalCarousel(LanguageDataProvider.getLanguageDataValue("CarouselHeading"));
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_100, TC_101, TC_047] Verify follow/unfollow button functionality & scroll functionality on the carousel with arrow button at the end.",
            groups = {"regression", "homeTab_screen"})
    public void verifyFollowUnfollowButtonFunctionalityFromCarousel(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        CarouselsPage carouselsPage = new CarouselsPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("autoNewUser"));

        // Boosted icon only visible for Piramal Finance profile, if it's followed by logged in user then kindly unfollow it
        carouselsPage.verifyBoostedIcon(LanguageDataProvider.getLanguageDataValue("PeopleYouCanFollowHeading"));

        carouselsPage.verifyFollowUnFollowButtonFunctionality();
        carouselsPage.verifyUnfollowButtonFunctionalityForCarousel();
        carouselsPage.verifyPeopleYouCaFollowPage(LanguageDataProvider.getLanguageDataValue("PeopleYouCanFollowHeading"));
    }

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_102, TC_131, TC_048] Verify Boosted icon on profiles for selected user & on the popup text: following them we can unfollow for next three months.",
            groups = {"regression", "homeTab_screen"})
    public void verifyBoostedPopUpTextOnProfile(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        CarouselsPage carouselsPage = new CarouselsPage();
        if(language.equalsIgnoreCase("English") || language.equalsIgnoreCase("Hindi")){
            loginKooPage.loginValidUser(language, ConfigReader.getValue("autoNewUser"));
            carouselsPage.clickOnBoostedIcon(LanguageDataProvider.getLanguageDataValue("PeopleYouCanFollowHeading"));

            // Boosted icon only visible for Piramal Finance profile, if it's followed by logged in user then kindly unfollow it
            carouselsPage.verifyBoostedProfilePopUp(LanguageDataProvider.getLanguageDataValue("BoostedPopUpHeadingText"));
            carouselsPage.verifyBoostedProfilePopUp(LanguageDataProvider.getLanguageDataValue("BoostedPopUpText"));
        }
    }
}
