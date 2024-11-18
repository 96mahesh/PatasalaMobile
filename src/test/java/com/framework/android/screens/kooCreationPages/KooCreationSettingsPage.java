package com.framework.android.screens.kooCreationPages;

import java.io.IOException;

import org.testng.Assert;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.MobileUtil;

public class KooCreationSettingsPage {
    MobileActions mobileActions = new MobileActions();

    public void verifyPreferences(String language) throws IOException, InterruptedException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"), "Plus Button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_settings"),
                "Settings Button");
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_comment_preferences"),
                "Comment Preferances"));
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_keyboard_preferences"),
                "Keyboard Preferances"));

    }

    public void verifyPreferencesCheckBoxes(String everyone, String peopleyoufollow, String noone, String autotranslation) {
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "chkbox_everyone", everyone),
                "everyone Checkbox"));
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "chkbox_peopleyoufollow", peopleyoufollow),
                "people you follow checkbox"));
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "chkbox_noone", noone), "no one checkbox"));
        Assert.assertTrue(mobileActions.isDisplayed(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "chkbox_auto_transliteration_keyboard", autotranslation),
                "auto trasnliteration keyboard"));
    }
}
