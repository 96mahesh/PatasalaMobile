package com.framework.android.testcases.registrationAndLoginFlowTests;

import com.framework.android.screens.registerationAndLoginFlowPages.ProductExplainerPage;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class ProductExplainerTest {

    @Test(dataProvider = "Languages",dataProviderClass = LanguageDataProvider.class,
            description = "[TC_022] Verify Login with Email button in phone number screen & tapping on it user should enter Email login screen.",
            groups = {"regression", "registration_and_login"})
    public void verifyEmailLoginScreen(String language) throws IOException, InterruptedException {
        LanguageDataProvider.setCurrentLanguage(language);
        ProductExplainerPage productExplainerPage = new ProductExplainerPage();
        productExplainerPage.verifyEmailLoginScreen(language,
                LanguageDataProvider.getLanguageDataValue("SignIn_Email_Page"));
    }

    @Test(dataProvider = "Languages",dataProviderClass = LanguageDataProvider.class,
            description = "[TC_023, TC_024] Verify Captcha popup when on tapping Get OTP button, on Email login screen.",
            groups = {"regression", "registration_and_login"})
    public void verifyCaptchaPopUpAfterSignInWithEmail(String language) throws IOException, InterruptedException {
        LanguageDataProvider.setCurrentLanguage(language);
        ProductExplainerPage productExplainerPage = new ProductExplainerPage();
        productExplainerPage.verifyCaptchaPopUpAfterEnteringEmailOnLoginPage(language, ConfigReader.getValue("adminEmail"));
    }

    @Test(dataProvider = "Languages",dataProviderClass = LanguageDataProvider.class,
            description = "[TC_026] Verify language change icon on top right corner in Phone & Email login screens.",
            groups = {"regression", "registration_and_login"})
    public void verifyLanguageChangeButtonOnEmailLoginScreen(String language) throws IOException, InterruptedException {
        LanguageDataProvider.setCurrentLanguage(language);
        ProductExplainerPage productExplainerPage = new ProductExplainerPage();
        productExplainerPage.verifyLanguageChangeButtonOnSignInEmailPage(language);
    }

    @Test(dataProvider = "Languages",dataProviderClass = LanguageDataProvider.class,
            description = "[TC_027] Verify user is able to login with international numbers & captcha should be show on tapping Get OTP button",
            groups = {"regression", "registration_and_login"})
    public void verifyCaptchaForInternationalLogin(String language) throws IOException, InterruptedException {
        LanguageDataProvider.setCurrentLanguage(language);
        ProductExplainerPage productExplainerPage = new ProductExplainerPage();
        productExplainerPage.verifyCaptchaForInternationalLogin(ConfigReader.getValue("UserName"));
    }

    @Test(dataProvider = "Languages",dataProviderClass = LanguageDataProvider.class,
            description = "[TC_027] Verify user is able to login with international numbers & captcha should be show on tapping Get OTP button",
            groups = {"regression", "registration_and_login"})
    public void verifyUserCanLoginWithEmail(String language) throws IOException, InterruptedException {
        LanguageDataProvider.setCurrentLanguage(language);
        ProductExplainerPage productExplainerPage = new ProductExplainerPage();

        productExplainerPage.verifyCaptchaForInternationalLogin(ConfigReader.getValue("UserName"));
    }
}
