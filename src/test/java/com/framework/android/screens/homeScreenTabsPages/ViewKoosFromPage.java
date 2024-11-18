package com.framework.android.screens.homeScreenTabsPages;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.MobileUtil;
import com.framework.utilities.ReportManager;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class ViewKoosFromPage {
    MobileActions mobileActions = new MobileActions();

    /**
     * This method is to verify view koos from button after click on follow button from Feed page
     * @return
     * @throws IOException
     */
    public ViewKoosFromPage verifyViewKoosFromButton() throws IOException {
    	mobileActions.swipeUp(25);
        mobileActions.swipeUsingID("com.koo.app:id/iv_options_more");
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "menu_hamberger"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "menu_hamberger"),
                "hamberger menu");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "followButton"),
                "Click on Follow button");
        List<WebElement> noButtonOnPopUp = DriverFactory.getInstance().getMobileDriver().findElements
                (MobileUtil.returnByBasedOnPageNameAndObjectName("UserBlock", "noButton"));
        if(!(noButtonOnPopUp.size()==0)){
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_yes"), "yes button");
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "menu_hamberger"),
                    "hamberger menu");
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "followButton"),
                    "Click on Follow button");
        }
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "viewKoosFromButton"),
                "Verify View Koos From button"));
        return this;
    }

    /**
     * This method is to unfollow profile
     */
    public ViewKoosFromPage unfollowProfile() throws IOException {
        mobileActions.swipeUsingID("iv_options_more");
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "menu_hamberger"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "menu_hamberger"),
                "hamberger menu");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "followButton"),
                "Click on Follow button to Unfollow profile");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_yes"), "Yes Button");
        return this;
    }

    /**
     * This method is to verify profile image which is displaying with View Koo From button
     * @return
     */
    public ViewKoosFromPage verifyViewKoosFromProfileImage() {
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "viewKoosFromProfileImage"),
                "Verify profile image below the View Koos From button"));
        return this;
    }

    /**
     * This method is to verify 5 profile images icons
     * @param profileIconsSize_expected
     * @return
     * @throws IOException
     * @throws InterruptedException
     */
    public ViewKoosFromPage verifyFiveProfileIcons(int profileIconsSize_expected) throws IOException, InterruptedException {
        mobileActions.swipeUp(1);
        mobileActions.swipeUpFindElement(5,
                MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "profileImageOfKoo"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "profileImageOfKoo"),
                "Click on first koo profile");
        List<WebElement> profileImages = DriverFactory.getInstance().getMobileDriver().findElements
                (MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreenTab", "fiveProfileIcons"));
        Assert.assertEquals(profileImages.size(),profileIconsSize_expected,"5 profile images are visible");
        ReportManager.logInfo("Verify profile images on koo "+profileImages.size());
        return this;
    }
}
