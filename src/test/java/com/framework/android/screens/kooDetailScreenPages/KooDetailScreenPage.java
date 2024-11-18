package com.framework.android.screens.kooDetailScreenPages;

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

public class KooDetailScreenPage {
    MobileActions mobileActions = new MobileActions();
    String actualText;

    SoftAssert softAssert = new SoftAssert();

    /**
     * This method is to verify koo detail page
     *
     * @throws IOException
     */
    public void verifyKooDetailScreen() throws IOException, InterruptedException {
        CommonHelper.clickOnProfile();
        mobileActions.swipeUpFindElement(10, MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "title"));
        actualText = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "title"),
                "Get Koo title ");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "title"),
                "Click on Koo Card Title");
        Assert.assertEquals(actualText, mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "title"),
                "verify Koo title "), "Koo Detail page is not opened");
    }

    /**
     * This method is to verify user can hide comment
     *
     * @param kooText
     * @param commentText
     * @param postButton
     * @param commentSectionHeading
     * @throws InterruptedException
     * @throws IOException
     */
    public void verifyHideCommentAndEyeIcon(String kooText, String commentText, String postButton, String commentSectionHeading) throws InterruptedException, IOException {
       Thread.sleep(5000);
    	mobileActions.swipeUp(1);
    	mobileActions.swipeUpFindElement(10, MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "postedCommentIcon", kooText));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "writeCommentsBar"),
                "Click on Write your comment field");
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"),
                commentText, "Enter value in write comments");
        mobileActions.click(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", postButton),
                "Click on Post Button");
        Thread.sleep(5000);
        mobileActions.swipeUpFindElement(10, MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "postedKooText", kooText));
        mobileActions.click(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "postedCommentIcon", kooText),
                "Click on View Comment Button");
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "viewMoreForComments"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "viewMoreForComments"),
                "Click on two dots for view more options on comments");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "hideUnHideComment"),
                "Click on Hide Comments");
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "okButton"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "okButton"),
                "Click on Hide button");
        ReportManager.logPass("Clicked on Ok button successfully");
        try {
            mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "posted_comment", commentSectionHeading),
                    "Comment section is not displaying along with posted/ hided comment");
        } catch (Exception e) {
            ReportManager.logPass("Hided comment is not visible");
            ReportManager.logInfo("Hided comment is not visible");
        }
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "hideCommentEyeIcon"),
                "UnHide comment eye symbol is showing "));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "hideCommentEyeIcon"),
                "Verify hidden comment eye icon is showing"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "hideCommentEyeIcon"),
                "Click on Hide Comment Eye button");
        String actualHidedComment = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "title"),
                "Get Koo title ");
        Assert.assertEquals(actualHidedComment, commentText, "Hide Comment is not showing under Hide Comments section");
    }

    /**
     * This method is to verify user can un hide comment
     *
     * @param commentSectionHeading
     * @throws IOException
     */
    public void verifyUserCanUnHideComment(String commentSectionHeading) throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "menu_drafthamberger"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "menu_drafthamberger"),
                "Click on two dots for view more options on comments");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "hideUnHideComment"),
                "Click on UnHide Comments");
        CommonHelper.clickOnBackArrow();
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("ExploreScreen", "posted_comment", commentSectionHeading),
                "UnHided comment is displaying"));
    }

    /**
     * This method is to verify exact count of comments
     *
     * @return
     * @throws IOException
     * @throws InterruptedException 
     */
    public KooDetailScreenPage verifyExactCountOfComments() throws IOException, InterruptedException {
    	mobileActions.swipeUp(1);
        mobileActions.swipeUsingID("comment_holder_constraint");
        String countOfCommentsOnKoo = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "commentTextCount"),
                "Get count of exact comments below the koo");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "btn_comment"),
                "Click on comment icon from below the koo");
        mobileActions.swipeUpFindElement(5, MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "commentTextCountForKoo"));
        String countOfCommentsAfterClickingOnKoo = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "commentTextCountForKoo"),
                "Get new count of exact comments below the koo");
        Assert.assertEquals(countOfCommentsOnKoo, countOfCommentsAfterClickingOnKoo,
                "Exact count of comments is not correct");
        ReportManager.logInfo("Verified count of comments on koo and count of comments under comments section, " +
                "count of koo comments = "+countOfCommentsOnKoo+
                "count of comments under comments section = "+countOfCommentsAfterClickingOnKoo);
        return this;
    }

    /**
     * This method is to verify reaction bar on comments
     *
     * @param commentsSectionHeading
     * @return
     */
    public KooDetailScreenPage verifyReactionBarOnComments(String commentsSectionHeading, String commentText, String postButton, String kooText) throws IOException, InterruptedException {
    	 Thread.sleep(5000);
    	mobileActions.swipeUp(1);
    	mobileActions.swipeUpFindElement(10, MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "postedCommentIcon", kooText));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "writeCommentsBar"),
                "Click on Write your comment field");
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"),
                commentText, "Enter value in write comments");
        mobileActions.click(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", postButton),
                "Click on Post Button");
        Thread.sleep(5000);
        mobileActions.swipeUpFindElement(10, MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "postedKooText", kooText));
        mobileActions.click(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "postedCommentIcon", kooText),
                "Click on View Comment Button");
        Thread.sleep(2000);
        //mobileActions.swipeUsingText(commentsSectionHeading);
        softAssert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "likeReactionBelowCommentSection",
                commentsSectionHeading), "Like reaction is displaying under comments section"));
        softAssert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "commentReactionBelowCommentSection",
                commentsSectionHeading), "Comment reaction is displaying under comments section"));
        softAssert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "rekooReactionBelowCommentSection",
                commentsSectionHeading), "Rekoo reaction is displaying under comments section"));
        softAssert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "whatsAppReactionBelowCommentSection",
                commentsSectionHeading), "Whats App reaction is displaying under comments section"));
        softAssert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "shareReactionBelowCommentSection",
                commentsSectionHeading), "Share reaction is displaying under comments section"));
        softAssert.assertAll();
        return this;
    }

    /**
     * This method is to verify view more link on comments page
     *
     * @return
     * @throws IOException
     */
    public KooDetailScreenPage verifyViewMoreOptionOnComments() throws IOException {
        mobileActions.swipeUsingID("comment_textview");
        String countOfCommentsOnKoo = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "commentTextCount"),
                "Get count of exact comments below the koo");
        if(!countOfCommentsOnKoo.equalsIgnoreCase("")){
            if (Integer.parseInt(countOfCommentsOnKoo) > 10) {
                mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "btn_comment"),
                        "Click on comment icon from below the koo");
                mobileActions.swipeUsingID("more_tv_layout");
                Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "viewMoreLink"),
                        "View more option is visible for comments"));
                ReportManager.logPass("Verified view more option is visible for comments to see more comments");
            } else {
                mobileActions.swipeUsingID("comment_textview");
                String countOfCommentsOnKoo1 = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "commentTextCount"),
                        "Get count of exact comments below the koo");
                if (Integer.parseInt(countOfCommentsOnKoo) > 10) {
                    mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCard", "btn_comment"),
                            "Click on comment icon from below the koo");
                    mobileActions.swipeUsingID("more_tv");
                    Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "viewMoreLink"),
                            "View more option is visible for comments"));
                    ReportManager.logPass("Verified view more option is visible for comments to see more comments");
                }
                ReportManager.logInfo("Comments are less than 10");
            }
        }
        return this;
    }

    /**
     * Verify video is playing after clicking on koo and user is on koo detail page
     *
     * @param expectedSize
     * @return
     * @throws IOException
     */
    public KooDetailScreenPage verifyVideoContinuePlayOnKooDetailPage(int expectedSize) throws IOException {
        mobileActions.swipeUsingID("play");
        mobileActions.swipeUp(2);
        // click koo
        /*mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "kooText"),
                "Click on koo and navigates to koo details page");*/
        List<WebElement> listOfPlayButton = DriverFactory.getInstance().getMobileDriver().findElements
                (MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "playButtonOnVideo"));
        Assert.assertEquals(listOfPlayButton.size(), expectedSize,
                "Play button is visible on video means the video is not continuing playing on koo detail page, which is incorrect");
        ReportManager.logInfo("Play button is not visible on video means the video is continuing playing on koo detail page");
        return this;
    }

    /**
     * This method is to create poll koo
     *
     * @param language
     * @param kooText
     * @param pollOneText
     * @param pollTwoText
     * @param postButton
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public KooDetailScreenPage createPollKoo(String language, String kooText, String pollOneText, String pollTwoText, String postButton) throws IOException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"), "Plus Button");
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"), kooText);
        mobileActions.click(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "pollKooIcon"),
                "Click on Poll Koo Button");
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen",
                "pollKooTextField", "2"), pollOneText);
        mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen",
               "pollKooTextField", "3"), pollTwoText);
        mobileActions.click(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", postButton),
                "Click on Post Button");
        if (language.equalsIgnoreCase("English")) {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_okScheduleKoo"),
                    "Click ok yes button");
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "languageDoneButton"),
                    "Click on Done button");
        }
        return this;
    }

    /**
     * This method is to verify user can participate on poll koo and big follow button
     * @param kooText
     * @param pollOneText
     * @param expectedPercentage
     * @return
     * @throws IOException
     */
    public KooDetailScreenPage verifyUserCanParticipateOnPollAndBigFollowButton(String kooText, String pollOneText, String expectedPercentage) throws IOException {
        mobileActions.swipeUsingText(kooText);
        mobileActions.swipeUp(1);
        mobileActions.click(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "profileIDOnSearchResult", pollOneText),
                "Click on Poll One Text Button");
        String actualPercentage = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "pollPercentage"),
                "Get percentage of participated koo");
        Assert.assertEquals(actualPercentage, expectedPercentage, "Percentage of participated koo is not correct");
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("KooDetailScreen", "bigFollowButton"),
                "Big Follow button is visible after participating poll"));
        return this;
    }
}