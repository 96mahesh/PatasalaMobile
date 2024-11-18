package com.framework.android.testcases.registrationAndLoginFlowTests;

import com.framework.android.screens.registerationAndLoginFlowPages.InternationalLanguagePage;
import com.framework.android.utils.LanguageDataProvider;
import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

@Listeners({SuiteEvent.class, MobileEvent.class})
public class InternationalLanguageTest {

    @Test(dataProvider = "Languages",dataProviderClass = LanguageDataProvider.class,
            description = "[TC_012, TC_028, TC_018] Verify (i) Sign-in with Google option on top, (ii) Sign-in with Mobile " +
            "(iii) Sign-in with Email optoins below that.", groups = {"regression", "registration_and_login"})
    public void verifySignInButtonsDisplay(String language) throws IOException, InterruptedException {
        InternationalLanguagePage internationalLanguagePage = new InternationalLanguagePage();
        LanguageDataProvider.setCurrentLanguage(language);
        internationalLanguagePage.verifySignInWithPhoneButton(language);
        internationalLanguagePage.verifySignInWithGoogleButton(language,LanguageDataProvider.getLanguageDataValue("SignInGoogleText"));
        internationalLanguagePage.verifySignInWithEmailButton(language,LanguageDataProvider.getLanguageDataValue("SignInEmailText"));
    }

    @Test(dataProvider = "Languages",dataProviderClass = LanguageDataProvider.class,
            description = "[TC_014, TC_019] Verify choosing options (ii) or (iii) user should land on Mobile number login " +
            "/ Email ID login screens respectively.", groups = {"regression", "registration_and_login"})
    public void verifyEmailLoginScreenDisplay(String language) throws IOException, InterruptedException {
        InternationalLanguagePage internationalLanguagePage = new InternationalLanguagePage();
        LanguageDataProvider.setCurrentLanguage(language);
        internationalLanguagePage.verifySignInWithGooglePage(language,
                LanguageDataProvider.getLanguageDataValue("SignInGoogleText"));
    }

    @Test(dataProvider = "Languages",dataProviderClass = LanguageDataProvider.class,
            description = "[TC_015, TC_025] Verify if the OTP success rate is less, user should get a popup with (i) Resend OTP & (ii) Continue With Google options.",
            groups = {"regression", "registration_and_login"})
    public void verifyResendOTPButtons(String language) throws IOException, InterruptedException {
        LanguageDataProvider.setCurrentLanguage(language);
        InternationalLanguagePage internationalLanguagePage = new InternationalLanguagePage();
        internationalLanguagePage.resendOTPOptions(language,ConfigReader.getValue("UserName"));
        internationalLanguagePage.verifyResendOTPOptions(LanguageDataProvider.getLanguageDataValue("ResendOTPText"));
        internationalLanguagePage.verifyResendOTPOptions(LanguageDataProvider.getLanguageDataValue("SignInGoogleText"));
    }

    @Test(dataProvider = "Languages",dataProviderClass = LanguageDataProvider.class,
            description = "[TC_016] Verify error message for OTP failure & Show 'Sign-In with Google' button for OTP failure.",
            groups = {"regression", "registration_and_login"})
    public void verifyErrorMessageForOTPFailure(String language) throws IOException, InterruptedException {
        LanguageDataProvider.setCurrentLanguage(language);
        InternationalLanguagePage internationalLanguagePage = new InternationalLanguagePage();
        internationalLanguagePage.verifyErrorMessageForIncorrectOTP(language, ConfigReader.getValue("UserName"),
                LanguageDataProvider.getLanguageDataValue("Invalid_OTP_Error_Message"),"000000");
    }
}