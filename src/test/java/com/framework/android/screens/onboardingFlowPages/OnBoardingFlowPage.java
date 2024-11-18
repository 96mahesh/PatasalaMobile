package com.framework.android.screens.onboardingFlowPages;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.MobileUtil;
import org.testng.Assert;

import java.io.IOException;

public class OnBoardingFlowPage {
    MobileActions mobileActions = new MobileActions();

    /**
     * This method is to click on continue button
     *
     * @return
     * @throws IOException
     */
    public OnBoardingFlowPage clickContinueButton() throws IOException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "continueButton"),
                "Click on Continue button");
        return this;
    }

    /**
     * This method is to click on camera button
     *
     * @return
     * @throws IOException
     */
    public OnBoardingFlowPage clickCameraButton() throws IOException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "profile_registration"),
                "Click on camera button");
        return this;
    }

    /**
     * This method is to click on camera button from gallery page
     *
     * @return
     * @throws IOException
     */
    public OnBoardingFlowPage clickCameraButtonOnGalleryPage() throws IOException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "cameraIconOnGalleryPage"),
                "Click on camera button from gallery page");
        return this;
    }

    /**
     * This method is to verify selected interest
     *
     * @return
     * @throws IOException
     */
    public OnBoardingFlowPage verifySelectedInterest() {
        String actualInterestValue = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "interestText"),
                "get text of interest");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "interestCheckbox"),
                "Click on interest checkbox");
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "skipButton"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "skipButton"),
                "Click on skip button");
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "skipButton"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "skipButton"),
                "Click on skip button");
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "skipButton"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "skipButton"),
                "Click on skip button");
        String expectedInterestValue = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "kooHeaderForSelectedInterest"),
                "get text of selected interest");
        Assert.assertTrue(actualInterestValue.contains(expectedInterestValue), "Selected interest is not showing correct");
        return this;
    }

    /**
     * Verify topics should be visible
     * @return
     */
    public OnBoardingFlowPage verifyTopicsArrangedInCategories() {
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "topicsArrangedCategories"),
                "Verify topics arranged in categories"));
        return this;
    }

    /**
     * Verify skip button
     * @return
     * @throws InterruptedException
     */
    public OnBoardingFlowPage verifySkipContinueButtonEnableAndFollowProfilePageVisible() throws InterruptedException {
        Thread.sleep(15000);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "skipButton"),
                "Click on skip button");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "followProfilePlusButton"),
                "Verify topics arranged in categories"));
        return this;
    }

    public OnBoardingFlowPage clickContinueButton1() throws IOException, InterruptedException {
        Thread.sleep(500000);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "continueButton"),
                "Click on Continue button");
        return this;
    }

    /**
     * This method is to verify selected topic visible on feed page
     * @return
     */
    public OnBoardingFlowPage verifySelectedTopicFeedIsShowing(){
        String selectedTopic = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "topicElement"),
                "get text of selected topic");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "topicElement"),
                "Click on Topic");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "continueButton"),
                "Click on Continue button");
        mobileActions.swipeUsingID("justification_container");
        String selectedTopicOnFeed = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "selectedTopicOnFeed"),
                "get text of selected topic from feed page");
        Assert.assertTrue(selectedTopicOnFeed.contains(selectedTopic),"Selected topic on feed is not showing correct");
        return this;
    }
}
