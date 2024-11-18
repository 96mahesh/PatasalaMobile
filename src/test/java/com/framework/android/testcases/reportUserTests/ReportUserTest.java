package com.framework.android.testcases.reportUserTests;

import com.framework.android.screens.homeScreenTabsPages.HomeScreenTabPage;
import com.framework.android.screens.peopleTabPages.PeopleTabPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.android.utils.MobileActions;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.MobileUtil;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class ReportUserTest {

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_389] Verify Report user option in options on Koo card & report options should be in app language.",
            groups = {"regression", "people_tab"})
    public void verifyReportUserOptions(String language) throws Exception {
        if (language.equalsIgnoreCase("English")) {
            LanguageDataProvider.setCurrentLanguage(language);
            LoginKooPage loginKooPage = new LoginKooPage();
            HomeScreenTabPage homeScreenTabPage = new HomeScreenTabPage();
            PeopleTabPage peopleTabPage = new PeopleTabPage();
            loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
            homeScreenTabPage.clickOnAnyTabFromHomePage(LanguageDataProvider.getLanguageDataValue("PeopleTabText"));
            String val = peopleTabPage.verifyNavigateToFirstPeopleProfileFromPeopleTab();
            System.out.println("val:"+val);
            
            MobileActions mobileActions = new MobileActions();
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "peopleTabProfile"), "People Profile Name");
            Thread.sleep(50000);
            val = DriverFactory.getInstance().getMobileDriver().getPageSource();
            mobileActions.click(By.xpath("//android.widget.ImageButton[@resource-id='com.koo.app:id/layoutOptionMenu']"), "OptionMenu");
            Thread.sleep(20000);
            System.out.println(val);
            
        }
    }   
}
