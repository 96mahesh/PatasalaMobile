package com.framework.android.screens.exploreScrenPages;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.MobileUtil;
import com.framework.utilities.ReportManager;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class ExploreScreenPage {
    MobileActions mobileActions = new MobileActions();
    String actualText;
    String testValue;

    SoftAssert softAssert = new SoftAssert();

    /**
     * Verify Hash Tag icon
     * @throws IOException
     */
    public void verifyHashTagIcon() {
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "hashtagExplore_icon"),
                "HashTag icon is displaying"));
    }

    /**
     * This method is to click on HashTag Icon
     * @throws IOException
     */
    public void clickHashTagIcon() throws IOException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "hashtagExplore_icon"),
                "Click on Hash Tag icon");
    }
    /**
     * Verify Trending and Topics tab on Hash Tag page
     * @param tabName
     * @throws IOException
     */
    public void verifyTrendingTopicTabOnHashTag(String tabName) {
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "hashtag_screen_tab",
                        tabName), "HashTag Trending tab is present that is = "+tabName));
        ReportManager.logInfo("Trending and Topics tabs will be visible for English and Hindi language only");
        ReportManager.logInfo("For other languages only one tab will be visible");
    }

    /**
     * This method is to verify five profile images
     * @param tabName
     * @throws IOException
     */
    public void verifyFiveProfileImagesForHashTag(String tabName, int expectedCount) throws IOException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "hashtag_screen_tab",
                tabName),"Click on Tab = "+tabName);
        List<WebElement> profileImages = DriverFactory.getInstance().getMobileDriver().findElements
                (MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "profileImageFor_hashTagKoo"));
        Assert.assertEquals(profileImages.size(),expectedCount,expectedCount+" profile images are visible");
        ReportManager.logInfo("Verify profile images on # koo post is "+profileImages.size());
    }

    /**
     * This method is to click on Plus icon for hashtag
     * @throws IOException
     */
    public void clickPlusIconForHashTag() throws IOException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "plusIconFor_hashtagKoo"),
                "Click on Plus Icon for hashtag");
    }

    /**
     * This method is to get text of selected hashtag
     * @return
     */
    public String getTextOfSelectedHashTag(){
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "selectedHashTag_attribute"));
        actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "selectedHashTag_attribute"),
                "Get Actual text of HashTag post");
        return actualText;
    }

    /**
     * This method is to click on Plus icon for hashtag
     * @throws IOException
     */
    public void clickPlusIconForNERTag() throws IOException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "plusIconFor_NERTagKoo"),
                "Click on Plus Icon for NER Tag");
    }

    /**
     * This method is to verify koo creation page after clicking on NER tag
     * @return
     */
    public void verifyKooCreationPage(){
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "user_Image"));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "user_Image"),
                "Koo Creation page is displaying after clicking on plus button for NER tag"));
    }

    /**
     * This method is to click on big first image for first hashtag
     * @throws IOException
     */
    public void clickHashTagFirstImage() throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "hashTag_image"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "hashTag_image"),
                "Click on top image for first hashtag");
    }

    /**
     * This method is to get heading of first hashtag after clicking on top image
     * @throws IOException
     */
    public String getHeadingOfFirstHashTag() {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "headingOf_firstHashTag"));
        actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "headingOf_firstHashTag"),
                "Get actual heading of first hashtag after clicking on top image and actual heading is = "+actualText);
        return actualText;
    }

    /**
     * This method is to verify user can comment on koo post
     * @throws IOException
     * @throws InterruptedException
     */
    public void verifyUserReactOnKoo(String commentSectionHeading) throws IOException, InterruptedException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "all_sub_tab"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "all_sub_tab"),
                "Click on All sub tab");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("TopicsTab", "ner_tags"),
                "Click on first koo title");
        mobileActions.swipeUpFindElement(10, MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "write_comment"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "write_comment"),
                "Click on Write Comment field");
        testValue = RandomStringUtils.randomAlphabetic(10)+"_AutoComment";
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "write_commentSection"),
                testValue,"Enter comment");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "button_post"),
                "Click on post button");
         Thread.sleep(5000);
        mobileActions.swipeUsingID("comment_imageview");
        //mobileActions.swipeUpFindElement(10, MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "viewComment_icon"));
        //mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "viewComment_icon"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "viewComment_icon"),
                "Click on View comment button");
        mobileActions.swipeUpFindElement(10, MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "posted_comment",
                commentSectionHeading));
        actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "posted_comment",
                        commentSectionHeading),
                "Get actual posted comment = "+actualText);
        Assert.assertEquals(actualText, testValue,
                "Expected comment and actual posted comment is not showing correct, expected is ="+testValue+
                " actual is = "+actualText);
    }

    /**
     * This method is to click on HashTag Icon
     * @throws IOException
     */
    public ExploreScreenPage verifySuTabsUnderTrendingTas(String trendingTab, String[] allSubTabs) throws IOException, InterruptedException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "tabName",trendingTab),
                "Click on Trending tab = "+trendingTab);
        for(int i = 0; i < allSubTabs.length; i++){
            /*mobileActions.swipeElementAndroid(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "tabName",allSubTabs[i]),
                    "LEFT",MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "tabName", String.valueOf(allSubTabs.length)),
                            i);*/
            softAssert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "tabName",
                            allSubTabs[i]),
                    "Verify sub tab under Trending tab = "+allSubTabs[i]));
            if(allSubTabs[i].equals("New Creators on Koo")){
                break;
            }
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "tabName",
                            allSubTabs[i+1]),
                    "Click on = "+allSubTabs[i+1]);
            Thread.sleep(1000);
        }
        softAssert.assertAll();
        return this;
    }
}