package com.framework.android.screens.peopleTabPages;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.MobileUtil;
import com.framework.utilities.ReportManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class PeopleTabPage {
    MobileActions mobileActions = new MobileActions();
    SoftAssert softAssert = new SoftAssert();

    /**
     * This method is to verify discover relevant people widget section
     *
     * @param expectedText
     * @return
     */
    public PeopleTabPage verifyDiscoverRelevantPeopleWidget(String expectedText) {
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "discoverRelevantPeople",
                expectedText), "Verify Discover Relevant Widget section"));
        ReportManager.logPass("Verify Discover Relevant Widget section");
        ReportManager.logInfo("Verify Discover Relevant Widget section");
        return this;
    }

    /**
     * This method is to verify People Detail Page
     * @param expectedText
     * @return
     * @throws IOException
     */
    public PeopleTabPage verifyPeopleDetailPage(String expectedText) throws IOException, InterruptedException {
        mobileActions.swipeUpFindElement(50,MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen",
                "btn_arrowForSpecificSectionUnderPeopleTa",expectedText));
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_arrowForSpecificSectionUnderPeopleTa",expectedText));
        mobileActions.swipeUp(1);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("ProfileScreen", "btn_arrowForSpecificSectionUnderPeopleTa",expectedText),
                "Click on Forward arrow for people you can follow Carousel under people tab");
        Assert.assertEquals(mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("Carousel", "peopleYouFollowPageHeading")),
                expectedText,"People detail page is not opened correctly");
        ReportManager.logPass("People detail page is not opened correctly");
        ReportManager.logInfo("People detail page is not opened correctly");
        return this;
    }

    /**
     * This method is to verify Find Your Friends button and click on it after that verify
     * Your Friend page and Invite contact button
     * @param expectedFindYourFriendBtnText
     * @param yourFriendHeading_expected
     * @param inviteButtonText_expected
     * @return
     * @throws IOException
     */
    public PeopleTabPage verifyFindYourFriendsAndInviteButton(String expectedFindYourFriendBtnText, String yourFriendHeading_expected,
                                                              String inviteButtonText_expected) throws IOException, InterruptedException {
        mobileActions.swipeUsingText(expectedFindYourFriendBtnText);
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "findYourFriendsButton",
                expectedFindYourFriendBtnText));
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "findYourFriendsButton",
                expectedFindYourFriendBtnText), "Verify Find Your Friends on Koo button and expected text is = "+expectedFindYourFriendBtnText));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "findYourFriendsButton",expectedFindYourFriendBtnText),
                "Click on "+expectedFindYourFriendBtnText+" button");
        handlePermissionIfVisible();
        //pushContacts();
        Assert.assertEquals(mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "yourFriendsHeading")),
                yourFriendHeading_expected,"Your Friends page is not opened expected is = "+yourFriendHeading_expected);
        ReportManager.logPass("Your Friends page is not opened expected is = "+yourFriendHeading_expected);
        ReportManager.logInfo("Your Friends page is not opened expected is = "+yourFriendHeading_expected);
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "inviteButton",
                inviteButtonText_expected), "Verify Invite button is showing for Your Friend page and expected text is = "+inviteButtonText_expected));
        ReportManager.logPass("Verify Invite button is showing for Your Friend page and expected text is = "+inviteButtonText_expected);
        ReportManager.logInfo("Verify Invite button is showing for Your Friend page and expected text is = "+inviteButtonText_expected);
        return this;
    }

    /**
     * This method is to click on invite button and verify share with popup
     * @param inviteButtonText_expected
     * @return
     * @throws IOException
     */
    public PeopleTabPage clickOnInviteButtonAndVerifyAlertPopUp(String inviteButtonText_expected) throws IOException {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "inviteButton",
                inviteButtonText_expected));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "inviteButton",inviteButtonText_expected),
                "Click on "+inviteButtonText_expected+" button");
        //Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "alertTitle"),
             //   "Share With popup is opened"));
        ReportManager.logPass(inviteButtonText_expected + "invite Button successfully clicked");
        ReportManager.logInfo(inviteButtonText_expected + "invite Button successfully clicked");
        return this;
    }

    /**
     * Handle permission popup
     * @return
     * @throws IOException
     */
    public PeopleTabPage handlePermissionIfVisible() throws IOException, InterruptedException {
        Thread.sleep(5000);
        List<WebElement> permissionPopUp = DriverFactory.getInstance().getMobileDriver().findElements
                (MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "allowPermission"));
        System.out.println("Size of allow popup is = "+permissionPopUp.size());
        List<WebElement> permissionPopUp_1 = DriverFactory.getInstance().getMobileDriver().findElements
                (MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "allowPermission_1"));
        System.out.println("Size of allow popup is = "+permissionPopUp_1.size());
        if(permissionPopUp.size()>0){
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "allowPermission"),
                    "Click on Allow button for handle permission");
            ReportManager.logInfo("Click on Allow button for handle permission");
        } else {
            mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "allowPermission_1"),
                    "Click on Allow button for handle permission");
        }
        return this;
    }

    public PeopleTabPage pushContacts(){
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("browserstack.uploadMedia", new String[]{"media://90c7a8h8dc82308108734e9a46c24d8f01de12881"});
        return this;
    }

    /**
     * This method is to verify headings on people tab for all sections
     * @param expectedText
     * @return
     */
    public PeopleTabPage verifyPeopleTabSectionHeadings(String[] expectedText) {
        for (int i = 0; i < expectedText.length; i++) {
            mobileActions.swipeUsingText(expectedText[i]);
            mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "peopleTabSectionHeading",
                    expectedText[i]));
            softAssert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "peopleTabSectionHeading",
                    expectedText[i]), " '" + expectedText[i] + "' widget section heading is visible under people tab on home page"));
            ReportManager.logPass(" '" + expectedText[i] + "' widget section heading is visible under people tab on home page");
            ReportManager.logInfo(" '" + expectedText[i] + "' widget section heading is visible under people tab on home page");
        }
        softAssert.assertAll();
        return this;
    }

    /**
     * This method is to verify profile should be refreshed under people tab
     * @return
     * @throws InterruptedException 
     */
    public PeopleTabPage verifyProfileShouldChangedAfterRefresh() throws InterruptedException{
        mobileActions.swipeUp(1);
        String firstProfile = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "peopleTabProfile"));
        mobileActions.swipeUp(2);
        mobileActions.swipeDown(60);
        String refreshedProfile = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "peopleTabProfile"));
        Assert.assertTrue(!firstProfile.equalsIgnoreCase(refreshedProfile),"Profile is not refreshed the old profile was = "
        +firstProfile +" Expected refreshed profile is = "+refreshedProfile);
        ReportManager.logPass("Profile is not refreshed the old profile was = "
                +firstProfile +" Expected refreshed profile is = "+refreshedProfile);
        ReportManager.logInfo("Profile is not refreshed the old profile was = "
                +firstProfile +" Expected refreshed profile is = "+refreshedProfile);
        return this;
    }
    
    /**
     * This method is to verify Navigation to the First People Profile In People Tab
     * @param No
     * @return name of the profile
     */
    public String verifyNavigateToFirstPeopleProfileFromPeopleTab() {
        mobileActions.waitForVisible(MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "peopleTabProfile"));
        String profileName = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "peopleTabProfile"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("peopleTab", "peopleTabProfile"), "People Profile Name");
        return profileName;
    }
    
    
}
