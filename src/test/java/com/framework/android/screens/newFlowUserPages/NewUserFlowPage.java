package com.framework.android.screens.newFlowUserPages;

import com.framework.android.screens.onboardingFlowPages.OnBoardingFlowPage;
import com.framework.android.utils.CommonHelper;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.MobileUtil;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class NewUserFlowPage {
    MobileActions mobileActions = new MobileActions();

    /**
     * This method is to verify follow all button for bulk follow
     *
     * @return
     */
    public NewUserFlowPage verifyTopFiftyBulkFollowButton() {
        mobileActions.swipeUsingID("tv_follow_all_text");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow", "topFiftyBulkFollowBtn"),
                "Verify follow all button"), "Follow all button is not visible");
        return this;
    }

    /**
     * This method is to click on follow all button
     *
     * @return
     * @throws IOException
     */
    public NewUserFlowPage clickFollowAllButton() throws IOException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow", "topFiftyBulkFollowBtn"),
                "Click on follow all button");
        return this;
    }

    /**
     * This method is to verify user can unfollow the profile
     *
     * @param expectedValue
     * @return
     * @throws IOException
     */
    public NewUserFlowPage verifySelectUnSelectFollowUser(String expectedValue) throws IOException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow", "followAll"),
                "Click on 50+ follow all link");
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow", "suggestedPeople"));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow", "suggestedPeople"),
                "Verify suggested people popup"), "suggested people popup is not visible");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow", "checkBox"),
                "Click on checkbox");
        String actualValue = mobileActions.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow", "checkBox"),
                "checked", "get attribute value of check box");
        Assert.assertEquals(actualValue, expectedValue);
        return this;
    }

    /**
     * This method is to Verify follow people button at last of feed page
     * @return
     */
    public NewUserFlowPage verifyFollowAPeopleButton() {
        mobileActions.swipeUsingID("follow_action_btn");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow", "followPeopleButton"),
                "Verify follow people button at last of feed page"),
                "Verify follow people button at last of feed page");
        return this;
    }

    /**
     * This method is to click on continue button
     *
     * @return
     * @throws IOException
     */
    public NewUserFlowPage clickContinueButton() throws InterruptedException {
        Thread.sleep(30000);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("OnBoardingFlow", "continueButton"),
                "Click on Continue button");
        return this;
    }

    /**
     * This method is to verify refer now button on reward widget for new user
     * @return
     */
    public NewUserFlowPage verifyReferNowButton(){
        mobileActions.swipeUsingID("btn_refer_now_big");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow", "referNowButton"),
                        "Verify refer now button on reward widget for new user"),
                "refer now button is not visible on reward widget for new user");
        return this;
    }

    /**
     * This method is to verify follow all button for new user
     * @return
     */
    public NewUserFlowPage verifyFollowAllButton(){
        mobileActions.swipeUsingID("lay_follow_all");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow", "followAllButton"),
                        "Verify Follow All button for new user without selecting any profile"),
                "Follow all button is not visible on new user");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow", "followAll"),
                        "Verify Follow All 50+ users for new user without selecting any profile"),
                "Follow all 50+ users, button is not visible on new user");
        return this;
    }

    /**
     * This method is to verify explore all button for new user
     * @return
     */
    public NewUserFlowPage verifyExploreAllButton(){
        mobileActions.swipeUsingID("lay_follow_all");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow", "exploreAllProfiles"),
                        "Verify Explore All profiles button for new user without selecting any profile"),
                "Explore all profile button is not visible on new user");
        return this;
    }

    /**
     * This method is to verify segment bulk follow all button for new user
     * @return
     */
    public NewUserFlowPage verifySegmentBulkFollow(){
        mobileActions.swipeUsingID("category_bulk_follow_recyclerview");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow", "segmentBulkFollow"),
                        "Verify Segment Bulk Follow profiles button for new user without selecting any profile"),
                "Segment Bulk Follow profile button is not visible on new user");
        return this;
    }

    public NewUserFlowPage verifyAllUserFollowed(int expectedSizeOfFollowAllBtn, String expectedCountOfFollowedUsers) throws InterruptedException, IOException {
        mobileActions.swipeUsingID("lay_follow_all");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow", "followAllButton"),
                "Click on 50+ follow all link");
        Thread.sleep(30000);
        List<WebElement> followAllButton = DriverFactory.getInstance().getMobileDriver()
                .findElements(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow", "followAllButton"));
        Assert.assertEquals(followAllButton,expectedSizeOfFollowAllBtn,
                "Follow all button is still visible after clicking that button which is not correct");
        CommonHelper.clickOnHomeButton();
        CommonHelper.clickOnProfile();
        String actualCountOfFollowedUsers = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow","allFollowedUsersCount"),
                "Get all followed users count");
        Assert.assertEquals(actualCountOfFollowedUsers,expectedCountOfFollowedUsers,
                "Followed all 50+ users count is not correct on profile page the expected count is  = "+
                expectedCountOfFollowedUsers + " the actual count is showing - "+actualCountOfFollowedUsers);
        return this;
    }

    public NewUserFlowPage verifySegmentBulkFollowAction(int expectedSize){
        mobileActions.swipeUsingID("category_bulk_follow_recyclerview");
        mobileActions.swipeUp(1);
        String actualHeadingOfSBFSection = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow","segmentBulkFollowCategoryText"),
                "Get heading of segment bulk follow widget");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow", "segmentBulkFollowButton"),
                "Click on segment bulk follow all button");
        String actualHeadingOfSBFSection_afterFollowed = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow","segmentBulkFollowCategoryText"),
                "Get heading of segment bulk follow widget after followed");
        Assert.assertTrue(!(actualHeadingOfSBFSection.equalsIgnoreCase(actualHeadingOfSBFSection_afterFollowed)),
        "The SBF category heading is still visible after following, which is incorrect");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow", "miniPillButton"),
                        "Verify Mini pill button is visible after following SBF"),
                "Mini pill button is not visible on new user after doing SBF");

        // Get images size of mini pill popup
        List<WebElement> actualSize = DriverFactory.getInstance().getMobileDriver()
                .findElements(MobileUtil.returnByBasedOnPageNameAndObjectName("NewUserFlow", "smallImagesOnMiniPill"));
        Assert.assertEquals(actualSize,expectedSize,
                "mini pill images size is not correct expected count is  = "+
                        expectedSize + " the actual count is showing - "+actualSize);
        return this;
    }
}
