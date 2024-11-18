package com.framework.android.screens.onboardingFlowPages;

import com.framework.android.utils.CommonHelper;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.MobileUtil;
import com.framework.utilities.ReportManager;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;


public class ScreensPage {
    MobileActions mobileActions = new MobileActions();
    String actualValue;
    SoftAssert softAssert = new SoftAssert();

    /**
     * This method is to verify Feed page for existing user
     *
     * @param language
     * @param expectedFeedText
     */
    public void verifyFeedPageForExistingUser(String language, String expectedFeedText) {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "feedTab_Text",expectedFeedText));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "feedTab_Text",
                expectedFeedText), "Feed tab text is correct for language = "
                + language + " Expected Text is = " + expectedFeedText));
        ReportManager.logPass("Feed tab text is correct for language = "
                + language + " Expected Text is = " + expectedFeedText);
    }

    /**
     * This method is to verify Trending Tags heading on Search
     *
     * @param expectedValue
     */
    public void verifyTrendingTagHeading(String expectedValue) {
        actualValue = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "trendingTagHeading"));
        Assert.assertEquals(actualValue, expectedValue, "Actual Trending Tags heading is not correct");
    }

    /**
     * This method is to verify trending tags
     *
     * @param hashTag
     */
    public void verifyTrendingTags(String hashTag) {
        List<WebElement> elements = DriverFactory.getInstance().getMobileDriver()
                .findElements(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "trendingTags"));
        for (int i = 0; i < elements.size(); i++) {
            actualValue = elements.get(i).getText();
            softAssert.assertTrue(actualValue.startsWith(hashTag), "Trending tags are not starting with hash tag");
        }
        softAssert.assertAll();
    }

    /**
     * This method is to verify Most Followed People ad heading on Search
     *
     * @param expectedValue
     */
    public void verifyMostFollowedPeopleAndHeading(String expectedValue) {
        actualValue = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "mostFollowedPeopleHeading"));
        Assert.assertEquals(actualValue, expectedValue, "Actual Most Followed People heading is not correct");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "followButton"),
                "Verify most followed people displaying"));
    }

    /**
     * This method is to verify recent searches from search bar
     *
     * @param value
     * @param recentSearchHeading_Expected
     * @throws IOException
     */
    public void verifyRecentSearch(String value, String recentSearchHeading_Expected, String userName) throws IOException {
        CommonHelper.enterValueInSearchBar(value);
        CommonHelper.clickOnSearchBarField();
        CommonHelper.clickEnterButton();
        CommonHelper.clickOnHomeButton();
        CommonHelper.clickOnSearchIcon();
        CommonHelper.clickOnBackArrowFromSearchBar();
        CommonHelper.clickOnCancelLinkFromSearchBar();
        actualValue = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "recentSearchHeading"));
        Assert.assertEquals(actualValue, recentSearchHeading_Expected, "Actual Recent Searches heading is not correct");
        actualValue = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "recentSearchValue"));
        Assert.assertEquals(actualValue, value, "Actual Recent Searches value is not correct");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "recentSearchValue"), "Click on recent searched value");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "searchedUserFrame"), "Click on recent searched value");
        actualValue = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "searchedUserFrame"));
        Assert.assertEquals(actualValue, userName, "Actual username is not correct");
    }

    /**
     * This method is to verify search all result link
     */
    public void verifySearchAllResultsLink() throws IOException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "leftSearchIcon"), "Click on left search icon");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "searchAllResultLink"),
                "Verify Search all result link"));
    }

    /**
     * This method is to click on search all result link
     *
     * @throws IOException
     */
    public void clickOnSearchAllResultLink() throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "searchAllResultLink"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "searchAllResultLink"),
                "Click on search all result link");
    }

    /**
     * This method is to verify search all result tabs
     * @param expectedTabText
     */
    public void verifySearchAllResultSubTabs(String expectedTabText) throws InterruptedException {
        List<WebElement> elements = DriverFactory.getInstance().getMobileDriver()
                .findElements(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "searchAllResultTabs"));
        for (int i = 0; i < elements.size(); i++) {
            Thread.sleep(3000);
            actualValue = elements.get(i).getText();
            softAssert.assertEquals(actualValue,expectedTabText.split(", ")[i], "Tabs are not showing correct");
            ReportManager.logInfo("Verified sub tab of searched keyword and actual value is = "+actualValue+" Expected values is = "
            +expectedTabText.split(", ")[i]);
        }
        softAssert.assertAll();
    }

    /**
     * This method is to verify no result found message
     * @param expectedMessage
     */
    public void verifyNoResultFoundMessage(String expectedMessage){
        actualValue = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "noResultFoundMessage"));
        Assert.assertEquals(actualValue, expectedMessage, "No Result Found message is not correct");
    }

    /**
     * This method is to click on ta name
     * @param tabName
     * @throws IOException
     */
    public void clickOnTab(String tabName) throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "tabForSearchResult",tabName));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "tabForSearchResult",tabName),
                "Click on tab = "+tabName);
    }

    /**
     * This method is to verify data in All sub tab
     * @param expectedValue
     */
    public void verifyDataInAllSubTab(String expectedValue){
        List<WebElement> elements = DriverFactory.getInstance().getMobileDriver()
                .findElements(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "trendingTags"));
        for (int i = 0; i < elements.size(); i++) {
            actualValue = elements.get(i).getText();
            softAssert.assertTrue(actualValue.contains(expectedValue), "Verify all tas contains searched keyword with hashtag");
        }
        softAssert.assertAll();
    }

    /**
     * This method is to verify all profile results
     */
    public void verifyProfileResults(){
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "profileResults"),
                "Verify profile results"));
    }

    /**
     * This method is to verify data for koo tab
     */
    public void verifyKoos(){
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "kooResults"),
                "Verify Koos results"));
    }

    /**
     * This method is to verify pagination
     * @param expectedPageSize
     * @return
     */
    public ScreensPage verifyPagination(int expectedPageSize){
        List<WebElement> list_1 = DriverFactory.getInstance().getMobileDriver()
                .findElements(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "pagination"));
        int size_FirstPage = list_1.size();
        mobileActions.swipeUp(1);
        List<WebElement> list_2 = DriverFactory.getInstance().getMobileDriver()
                .findElements(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "pagination"));
        int size_SecondPage = list_2.size();
        Assert.assertTrue((size_FirstPage+size_SecondPage)>=expectedPageSize,
                "Number of pages are not correct");
        ReportManager.logPass("Verified number of pagination");
        return this;
    }

    /**
     * This method is to click on follow button for specific user and then again click on follow button
     * @throws IOException
     */
    public ScreensPage clickFollowPeople() throws IOException {
        String userName = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "searchedUserResult"));
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "userFollowButton",userName));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "userFollowButton",userName),
                "Click on follow button for = "+userName);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Screens", "userFollowButton",userName),
                "Click on follow button again for = "+userName);
        return this;
    }
}