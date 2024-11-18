package com.framework.android.testcases.kooCreationTests;

import com.framework.android.screens.kooCreationPages.KooCreationCreateKoo;
import com.framework.android.screens.kooCreationPages.KooCreationEditPostedKoo;
import com.framework.android.screens.kooCreationPages.kooCreationScreensPage;
import com.framework.android.screens.registerationAndLoginFlowPages.LoginKooPage;
import com.framework.android.utils.LanguageDataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class KooCreationScreenTest {

    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_452, TC_454, TC_456, TC_457, TC_571, TC_572, TC_460, TC462, TC_458, TC_459, TC_469, TC_471, TC_472, TC_553, TC_591, TC_554, TC_556, TC_557, TC_558] Verify Schedule button & draft button before Post button on top of the screen", groups = {
            "regression", "koo_creation"})

    public void verifyScheduleandDraftButtons(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        kooCreationScreensPage kooCreation = new kooCreationScreensPage();
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        kooCreation.verifyScheduleAndDraftButtons();
        kooCreation.verifyPost(language, LanguageDataProvider.getLanguageDataValue("PostButtonText"));
        kooCreation.verifyAttachmentElements();
        kooCreation.verifyNextAndPreview(language, LanguageDataProvider.getLanguageDataValue("NextButtonText"), LanguageDataProvider.getLanguageDataValue("PreviewButtonText"));
        kooCreation.verifyRemove();
    }
    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_475, TC_477, TC_481, TC_482, TC_485] Verify user is able to post koo with only koo title.", groups = {
            "regression", "koo_creation"})

    public void verifytitle(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        KooCreationCreateKoo kootitle = new KooCreationCreateKoo();
        kootitle.verifyCreateKoowithoutTitle(language, LanguageDataProvider.getLanguageDataValue("PostButtonText"));
        kootitle.verifypollOption(LanguageDataProvider.getLanguageDataValue("PostButtonText"));
        kootitle.verifyGIF();
        kootitle.verifylanguagetranslation();
    }
    @Test(dataProvider = "Languages", dataProviderClass = LanguageDataProvider.class,
            description = "[TC_596, TC_597, TC_598, TC_601, TC_] Verify user should be able to edit koo on tapping edit button from options on koo card.", groups = {
            "regression", "koo_creation"})

    public void verifyEditKoo(String language) throws Exception {
        LanguageDataProvider.setCurrentLanguage(language);
        LoginKooPage loginKooPage = new LoginKooPage();
        loginKooPage.loginValidUser(language, ConfigReader.getValue("UserName"));
        KooCreationEditPostedKoo editkoo=new KooCreationEditPostedKoo();
        editkoo.createKoo(language, LanguageDataProvider.getLanguageDataValue("PostButtonText"));
        editkoo.editMLKkoo(language, LanguageDataProvider.getLanguageDataValue("NextButtonText"), LanguageDataProvider.getLanguageDataValue("PreviewButtonText"),LanguageDataProvider.getLanguageDataValue("PostButtonText") );
        editkoo.editThreadKoo(LanguageDataProvider.getLanguageDataValue("NextButtonText"), LanguageDataProvider.getLanguageDataValue("PostButtonText"));
    }
    
    
}