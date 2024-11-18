package com.framework.android.screens.homeScreenTabsPages;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.MobileUtil;
import com.framework.utilities.ReportManager;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import java.io.IOException;
import java.util.List;

public class CarouselsPage {
    MobileActions mobileActions = new MobileActions();

    /**
     * This method is to verify horizontal swipe
     *
     * @return
     */
    public CarouselsPage verifyHorizontalCarousel(String expectedText) {
    	mobileActions.swipeUp(5);
        mobileActions.swipeUsingText(expectedText);
        mobileActions.swipeUp(1);
        List<WebElement> firstList = DriverFactory.getInstance().getMobileDriver()
                .findElements(MobileUtil.returnByBasedOnPageNameAndObjectName("Carousel", "horizontalCarousel"));
        WebElement elements = DriverFactory.getInstance().getMobileDriver()
                .findElement(MobileUtil.returnByBasedOnPageNameAndObjectName("Carousel", "horizontalCarousel"));
        mobileActions.swipeLeftOrRight(elements, "LEFT");
        List<WebElement> secondList = DriverFactory.getInstance().getMobileDriver()
                .findElements(MobileUtil.returnByBasedOnPageNameAndObjectName("Carousel", "horizontalCarousel"));
        Assert.assertTrue(firstList.size() <= secondList.size());
        ReportManager.logPass("Verified horizontal carousel = "+expectedText);
        ReportManager.logInfo("Verified horizontal carousel = "+expectedText);
        return this;
    }

    /**
     * This method is to click on follow button from carousel
     *
     * @return
     * @throws InterruptedException
     * @throws IOException
     */
    public CarouselsPage clickOnFollowButtonFromCarousel() throws InterruptedException, IOException {
        mobileActions.swipeUpFindElement(5, MobileUtil.returnByBasedOnPageNameAndObjectName("Carousel", "followButton"));
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Carousel", "followButton"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Carousel", "followButton"),
                "Click on Follow button from Carousel");
        return this;
    }

    /**
     * This method is to verify tick button after clicking on follow button
     *
     * @return
     * @throws InterruptedException
     * @throws IOException
     */
    public CarouselsPage verifyFollowUnFollowButtonFunctionality() throws InterruptedException, IOException {
        clickOnFollowButtonFromCarousel();
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Carousel", "tickButton"));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("Carousel", "tickButton"),
                "Verify Tick button after clicking on follow button"));
        return this;
    }

    /**
     * This method is to click on tick button to unfollow action
     *
     * @return
     * @throws IOException
     */
    public CarouselsPage clickOnUnFollowButtonFromCarousele() throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("Carousel", "tickButton"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Carousel", "tickButton"),
                "Click on UnFollow button from Carousel");
        return this;
    }

    /**
     * This method is to verify unfollow button functionality on click on tick button from carousel
     *
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public CarouselsPage verifyUnfollowButtonFunctionality() throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_yes"));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_yes"),
                "Verify Unfollow confirmation popup is showing"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_yes"), "Click on Yes Button");
        return this;
    }


    public CarouselsPage verifyUnfollowButtonFunctionalityForCarousel() {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_follow1InPublicProfile"));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_follow1InPublicProfile"),
                "Verify tick is showing as profile is followed"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_follow1InPublicProfile"),
                "Click on Tick Button to unfollow profile");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_yes"),
                "Verify Unfollow confirmation popup is showing with Yes button"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_yes"),
                "Click on Yes Button to unfollow profile");
        return this;
    }

    /**
     * This method is to verify boosted ico o profile
     * @return
     */
    public CarouselsPage verifyBoostedIcon(String expectedText) {
        mobileActions.swipeUsingText(expectedText);
        mobileActions.swipeUsingID("boosted_profile_icon");
        //mobileActions.swipeUp_FindElement(100, MobileUtil.returnByBasedOnPageNameAndObjectName("Carousel", "boostedProfileIcon"));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("Carousel", "boostedProfileIcon"),
                "Verify Boosted Icon on profile"));
        return this;
    }

    /**
     * This method is to verify People You Can Follow Page after clicking on arrow button
     * @param expectedText
     * @return
     * @throws InterruptedException
     * @throws IOException
     */
    public CarouselsPage verifyPeopleYouCaFollowPage(String expectedText) throws InterruptedException, IOException {
        mobileActions.swipeUpFindElement(5, MobileUtil.returnByBasedOnPageNameAndObjectName("Carousel", "arrowButtonForPeopleYouFollow"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Carousel", "arrowButtonForPeopleYouFollow"),
                "Click on Arrow button from Carousel from People Yu Can follow section");
        Assert.assertEquals(mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Carousel", "peopleYouFollowPageHeading")),
                expectedText,"People you may follow page is not opened correctly");
        return this;
    }

    /**
     * This method is to Click on Boosted Profile Icon
     * @return
     * @throws InterruptedException
     * @throws IOException
     */
    public CarouselsPage clickOnBoostedIcon(String expectedText) {
        mobileActions.swipeUsingText(expectedText);
        mobileActions.swipeUsingID("boosted_profile_icon");
        //mobileActions.swipeUp_FindElement(100, MobileUtil.returnByBasedOnPageNameAndObjectName("Carousel", "followButton"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Carousel", "boostedProfileIcon"),
                "Click on boosted icon");
        return this;
    }

    /**
     * This method is to verify Boosted PopUp Heading
     * @param expectedText
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public CarouselsPage verifyBoostedProfilePopUp(String expectedText) {
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("Carousel", "boostedProfilePopUpHeading",expectedText),
                "Verify boosted profile popup heading"));
        return this;
    }
}
