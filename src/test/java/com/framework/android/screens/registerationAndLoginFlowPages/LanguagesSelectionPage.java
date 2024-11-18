package com.framework.android.screens.registerationAndLoginFlowPages;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.codoid.products.exception.FilloException;
import com.framework.android.utils.TextView;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.ExcelDataReader;
import com.framework.utilities.ReportManager;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.MobileUtil;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LanguagesSelectionPage {
    MobileActions mobileActions = new MobileActions();

    SoftAssert sAssert = new SoftAssert();

    /**
     * THis method is for verification of all available languages
     *
     * @throws FilloException
     */
    public void verifyAvailableLanguagesInEnglishLanguage() throws FilloException, IOException, InterruptedException {
        // Verify Select Languages heading
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "select_languages"),
                "Select Languages"));

        // Verify Available Languages heading
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "available_languages"),
                "Available Languages"));

        LinkedHashMap<String, String> availableLanguages = ExcelDataReader.getLanguagesFromHomePage("AvailableLanguages");

        // Verify all available languages in english language keyword
        for (Map.Entry<String, String> entry : availableLanguages.entrySet()) {
            Thread.sleep(10000);
           boolean backButtonSize = DriverFactory.getInstance().getMobileDriver().findElements
                    (MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "backButton_LanguageChange")).size() > 0;
            ReportManager.logInfo("Get size of back button and size is = "+backButtonSize);
            if (backButtonSize) {
                Thread.sleep(2000);
                mobileActions.click((MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "backButton_LanguageChange")),
                        "Click on Back button");
                Thread.sleep(2000);
                ReportManager.logInfo("When back button is visible the click on it");
            }
            mobileActions.swipeUsingText(entry.getKey());
            sAssert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen","englishTyped_language",entry.getKey()),
                    "Verify available language which is displaying in english language = " + entry.getKey()));
            ReportManager.logInfo("Verify available language which is displaying in english language = " + entry.getKey());
        }
        sAssert.assertAll();
    }

    public void verifyAllAvailableLanguagesInSameLanguage() throws FilloException, InterruptedException, IOException {
        LinkedHashMap<String, String> availableLanguages = ExcelDataReader.getLanguagesFromHomePage("AvailableLanguages");

        // Verify all available languages in english typed keyword
        for (Map.Entry<String, String> entry : availableLanguages.entrySet()) {
            Thread.sleep(15000);
            boolean backButtonSize = DriverFactory.getInstance().getMobileDriver().findElements
                    (MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "backButton_LanguageChange")).size() > 0;
            ReportManager.logInfo("Get size of back button and size is = "+backButtonSize);
            if (backButtonSize) {
                Thread.sleep(2000);
                mobileActions.click((MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "backButton_LanguageChange")),
                        "Click on Back button");
                Thread.sleep(2000);
                ReportManager.logInfo("When back button is visible the click on it");
            }
            if (entry.getValue().equalsIgnoreCase("English") && entry.getValue().equalsIgnoreCase("Hausa")) {
                mobileActions.swipeUsingText(entry.getValue());
                sAssert.assertTrue(TextView.get(entry.getValue(), 2).isDisplayed(),
                        "Verify available language which is displaying in same language typed keyword = " + entry.getValue());
            } else {
                mobileActions.swipeUsingText(entry.getValue());
                sAssert.assertTrue(TextView.get(entry.getValue(), 1).isDisplayed(),
                        "Verify available language which is displaying in same language typed keyword = " + entry.getValue());
            }
        }
        sAssert.assertAll();
    }
    /**
     * This method is to verify checkboxes for available languages
     *
     * @throws FilloException
     */
    public void verifyCheckBoxesForAvailableLanguages() throws FilloException, IOException, InterruptedException {
        LinkedHashMap<String, String> availableLanguages = ExcelDataReader.getLanguagesFromHomePage("AvailableLanguages");
        for (Map.Entry<String, String> entry : availableLanguages.entrySet()) {
            Thread.sleep(15000);
            boolean backButtonSize = DriverFactory.getInstance().getMobileDriver().findElements
                    (MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "backButton_LanguageChange")).size() > 0;
            ReportManager.logInfo("Get size of back button and size is = "+backButtonSize);
            if (backButtonSize) {
                Thread.sleep(2000);
                mobileActions.click((MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "backButton_LanguageChange")),
                        "Click on Back button");
                Thread.sleep(2000);
                ReportManager.logInfo("When back button is visible the click on it");
            }
            mobileActions.swipeUsingText(entry.getKey());
            sAssert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen","checkBoxes_language",entry.getKey()),
                    "Verify checkboxes for available language = " + entry.getKey()));
        }
        sAssert.assertAll();
    }

    /**
     * This method is to click on checkbox
     *
     * @param language
     * @throws IOException
     */
    public void clickCheckBox(String language) throws IOException {
        mobileActions.swipeUsingText(language);
        try{
            mobileActions.click((MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen","checkBoxes_language",language)),
                    "Language checked successfully = " + language);
        } catch (Exception e){
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "backButton_LanguageChange"),
                    "Click on back button");
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen","checkBoxes_language",language),
                    "Language checked successfully = " + language);
        }
    }

    /**
     * This method is to verify selected language is displaying on login page or not
     *
     * @throws FilloException
     * @throws IOException
     */
    public void verifySelectedLanguageDisplayingAndRewardBanner() throws FilloException, IOException, InterruptedException {
        LinkedHashMap<String, String> availableLanguages = ExcelDataReader
                .getLanguagesFromHomePage("AvailableLanguagesHeading");

        for (Map.Entry<String, String> entry : availableLanguages.entrySet()) {
            // Verify if language is hindi then reward banner should display
            if (entry.getKey().equalsIgnoreCase("Hindi")) {
                clickCheckBox(entry.getKey());
				/*
				 * Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.
				 * returnByBasedOnPageNameAndObjectName("HomeScreen", "reward_banner"),
				 * "Verify reward banner is displaying for Hindi language"));
				 */    // mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "reward_banner"));
               // ReportManager.logPass("Verify reward banner for Hindi language");
                String actualHeading = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "login_heading"));
                String expectedHeading = entry.getValue();
                sAssert.assertEquals(actualHeading, expectedHeading,
                        "Login Page Heading is not showing correct as per the selected language which is = " + entry.getKey());
                ReportManager.logPass("Login Page Heading is not showing correct as per the selected language which is = " + entry.getKey());
                mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "backButton_LanguageChange"),
                        "Click on back button");
            } else {
                // Click on first language and verify login page heading should display in the same selected language
                clickCheckBox(entry.getKey());
                String actualHeading = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "login_heading"));
                String expectedHeading = entry.getValue();
                sAssert.assertEquals(actualHeading, expectedHeading,
                        "Login Page Heading is not showing correct as per the selected language which is = " + entry.getKey());
                ReportManager.logPass("Login Page Heading is not showing correct as per the selected language which is = " + entry.getKey());

                // Click on back button
                mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "backButton_LanguageChange"),
                        "Click on back button");
                ReportManager.logPass("Click on back button");
            }
        }
        sAssert.assertAll();
    }
}
