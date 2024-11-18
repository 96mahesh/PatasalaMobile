package com.framework.android.patasala;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.framework.listeners.MobileEvent;
import com.framework.listeners.SuiteEvent;
import com.framework.utilities.ConfigReader;

@Listeners({ SuiteEvent.class, MobileEvent.class })
public class LoginPageTest {
	
	@Test
	public void loginTest() throws Exception {
		LonginPage  login = new LonginPage();
		login.clickOnDone("English");
		login.clickOnPnoneNumberField();
		login.enterUserNo(ConfigReader.getValue("UserName"));
		login.clickOnGetOtp();
		login.waitVisibleofAttribute();
		login.enterOtpValues(ConfigReader.getValue("passOtp"));
		login.getStudentName();
		login.clickOnStudent();
		login.getCityName();
		login.getStudentTag();
		login.clickOnSelectClassDropDown();
		//login.scrollIngDown();
		//login.clickOnCECclass();
		login.clickOnLkgclass();
		login.clickOnRefress();
		login.clickonOneStudent();
		login.getLkgStudentName();
		login.clickOnChangePhoto();
		//login.getChangePhototag();
		login.clickOnTackPhoto();
		login.clickOnpopupCamera();
		login.clickOnAllow();
		login.clickOnPhotoButton();
		login.clickOnConformBtn();
		login.clickOnSubmitBtn();
		login.getTostmessage();
		login.clickOnChangePhoto();
		login.clickOnRemovieBtn();
		login.clickOnTackPhoto();
	}
}

