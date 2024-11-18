package com.framework.android.screens.editProfilePages;

import java.io.IOException;

import com.framework.android.screens.kooCreationPages.kooCreationScreensPage;
import org.testng.Assert;
import com.framework.android.utils.MobileActions;
import com.framework.utilities.MobileUtil;

public class EditProfile {
    MobileActions mobileActions = new MobileActions();

    public void editProfilePage(String language)
            throws IOException, InterruptedException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_profile"),
                "profile button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_editprofile"),
                "Edit button");
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "txt_editprofile"),
                "Edit profile text"));
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "txt_nameHeading"),
                "Name Heading text"));
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "txt_handleHeading"),
                "Handle Heading text"));
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "txt_professionHeading"),
                "Profession Heading text"));
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "txt_currentlocationHeading"),
                "Current Location Heading text"));
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "txt_locationHeading"),
                "Location Heading text"));
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "txt_bioHeading"), "Bio Heading text"));
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "txt_dobHeading"), "Date of Birth Heading text"));
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "txt_websiteHeading"),
                "Website Heading text"));
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "txt_emailHeading"),
                "Email Heading text"));
        mobileActions.swipeUsingID("float_mobile");
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "txt_mblHeading"), "Mobile Heading text"));
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "txt_genderHeading"),
                "Gender Heading text"));
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "txt_maritalstatusHeading"),
                "Marital status heading text"));
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_backArrow"),
                "Back Arrow");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "btn_addMoreImageIcon"),
                "More Image Icon");
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "txt_addPhotos"),
                "Add Photos Text"));
        String Text = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("EditProfile", "txt_addPhotos"),
                "Add Photos Text");
        System.out.println(Text);
    }
}
