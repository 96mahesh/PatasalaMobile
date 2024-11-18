package com.framework.android.screens.hashTagDetailScreenPages;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.MobileUtil;
import org.testng.Assert;

import java.io.IOException;

public class HashTagCreationPage {
    MobileActions mobileActions = new MobileActions();
    String actualText;

    /**
     * Verify Hash Tag popup on What's on your mind koo creation page
     *
     * @param hashTag
     * @throws IOException
     */
    public void verifyHashTagPopUpOnKooCreation(String hashTag) throws IOException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "whatsOnYourMind"),
                "Click on Whats on your mind field");
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"),
                hashTag);
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "hasTag_PopUp"),
                "HashTag popup is displaying for # post"));
    }

    /**
     * Verify Hash Tag popup on search page
     *
     * @param hashTag
     * @throws IOException
     */
    public void verifyHashTagPopUpOnSearch(String hashTag) throws IOException, InterruptedException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "search_icon"),
                "Click on Search icon");
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "searchBar_field"),
                hashTag);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "searchBar_field"), "Click on search bar field");
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "hasTag_PopUp"));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "hasTag_PopUp"),
                "HashTag popup is displaying for # in search bar"));
    }

    /**
     * Click on HashTag Explore icon
     *
     * @throws IOException
     */
    public void clickHashTagExploreIcon() throws IOException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "hashtagExplore_icon"),
                "Click on Hash Tag icon");
    }

    /**
     * This method is to get heading of # post
     * @return
     */
    public String getHeadingOfHashPost() throws InterruptedException {
        mobileActions.swipeUpFindElement(10, MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "hashtag_post"));
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "hashtag_post"));
        actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "hashtag_post"),
                "Get Actual text of HashTag post");
        return actualText;
    }

    /**
     * Click on First HashTag post
     * @throws InterruptedException
     * @throws IOException
     */
    public void clickHashTagPost() throws InterruptedException, IOException {
        mobileActions.swipeUpFindElement(3, MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "hashtag_post"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "hashtag_post"),
                "Click on Hash Tag post from hashtag page");
    }

    /**
     * This method is to verify SHare Hash Tag PopUp
     * @return
     * @throws IOException
     */
    public HashTagCreationPage verifyShareHashTagPopUp(String expectedTextOfShareKooPopUpHeading) throws IOException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "share_hashtag_button"),
                "Click on Share Hash Tag icon");
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "shareKooPopUpHeading"));
        actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("SettingsPage", "shareKooPopUpHeading"),
                "Get text of Share Hash Tag popup heading");
        Assert.assertEquals(actualText, expectedTextOfShareKooPopUpHeading,
                "Share Hash Tag popup is displaying successfully = " + expectedTextOfShareKooPopUpHeading);
        return this;
    }

    /**
     * Verify Back Button on HashTag post
     */
    public void verifyBackButton() {
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "back_arrow_button"),
                "Back Arrow button is present"));
    }

    /**
     * Verify Share button on HashTag post
     */
    public void verifyShareButton() {
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "share_hashtag_button"),
                "Share Post/HashTag button is present"));
    }

    /**
     * This method is to verify heading of hashtag post
     */
    public void verifyHeadingOfHashTagPost() {
        String expectedText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "hashtag_post_heading"),
                "Get Expected text of HashTag post heading");
        Assert.assertEquals(actualText, expectedText, "hashTag heading is not correct actual is displaying = "
                + actualText + ", Expected is = " + expectedText);
    }

    /**
     * Verify hashTag is in the post
     */
    public void verifyHashTagOnPost() {
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "hashtagIn_post"),
                "HashTag is present in post"));
    }
}
