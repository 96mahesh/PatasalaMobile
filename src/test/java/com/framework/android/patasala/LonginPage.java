package com.framework.android.patasala;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.MobileUtil;

public class LonginPage {

	MobileActions action = new MobileActions();

	public void clickOnDone(String language) throws InterruptedException {
		Thread.sleep(20000);
//		if (language.equalsIgnoreCase("English")) {
//			Thread.sleep(5000);
//			action.clickUsingCoordinates(967, 2060);
//		}
		
		action.click(MobileUtil.returnByBasedOnPageNameAndObjectName("WelcomeScreen", "DoneBtn"), "DoneBtn Clicking");
		
	}
	
	public void clickOnPnoneNumberField() {
		action.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "enterPhoneNumber_field"),
				"Enter Mobile Number");
	}

	public void enterUserNo(String phoneNumber) {
		action.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "enterPhoneNumber_field"),
				phoneNumber);
	}
	
	public void clickOnGetOtp() throws InterruptedException {
		//action.clickUsingCoordinates(529, 1963);
		action.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "OtpButton_LanguageChange"),"OtpButton Clicking");
	}
	
	public void waitVisibleofAttribute() {
		action.getAttribute(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "getEnter_Otp"), "content-desc","Enter OTP");
	}
	
	public void enterOtpValues(String passOtp) {
		String otp[] = passOtp.split(" ");
		action.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "clickAnd_EnterOtp1"),"Enter otp1 Number");				
		action.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "clickAnd_EnterOtp1"),otp[0]);
		action.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "clickAnd_EnterOtp2"),otp[1]);				
		action.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "clickAnd_EnterOtp3"),otp[2]);				
		action.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "clickAnd_EnterOtp4"),otp[3]);				
	}
	
	public void waitForVisibleHelloArun() {
		
	}
	public void getStudentName() throws InterruptedException {	
		Thread.sleep(5000);
//		String attributeName = action.getTagName(
//				MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "get_HelloHaranTag_name"),"content-desc",
//				"Hello Aran");
		String attributeName = action.getTagName(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "get_HelloHaranTag_name", "HelloHaran"), "Display Tag");
		System.out.println(attributeName);
	}
	
	public void clickOnStudent() throws InterruptedException {
		Thread.sleep(5000);
		action.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "clickOnStudent"), "Clicking On Studen");
	}
	public void getCityName() {
		String SityName = action.getTagName(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "getCityName", "City Name"), "Get City Tag");
		System.out.println(SityName);
	}
	public void getStudentTag() {
		String studentTag = action.getTagName(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "getOnStudentTag", "Students"), "Get Student Tag");
		System.out.println(studentTag);
	}
	
	public void clickOnSelectClassDropDown() {
		
		action.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "clickOnSelectClassnDD"), "Clicking select class dd");
	}
	
	public void scrollIngDown() throws Exception {
		action.swipeUpFindElement(2, MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "clickOnCecClass"));
	}
	
	public void clickOnCECclass() {
		action.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "clickOnCecClass"), "Clicking CEC class");
	}
	
	public void clickOnLkgclass() {
		action.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "clickOnLKGClass"), "Clicking LKG class");
	}
	
	public void clickOnRefress() throws InterruptedException {
		action.clickUsingCoordinates(1001,731);
		System.out.println("=================> Referess clicking");
	}
	
	public void clickonOneStudent() throws Exception {
		//action.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "clickOnLKGStudent"), "click on one student name");
		action.clickUsingCoordinates(393,908);
		System.out.println("=================> student name clicking");
	}
	
	public void getLkgStudentName()throws Exception {
		Thread.sleep(3000);
		String stdname = action.getTagName(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "getStudentName"), "get the Student name");
		System.out.println(stdname);
	}
	
	public void clickOnChangePhoto() {
		action.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "clickOnChangeOhoto"), "click on change Photo");
	}
	
	public void getChangePhototag() throws Exception {
		Thread.sleep(2000);
		String picname = action.getTagName(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "getchangeOhotoTag"), "Getting change photoname");
		System.out.println(picname);
	}
	
	public void clickOnTackPhoto() {
		action.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "clickOnTakePhoto"), "click on Take Photo");
	}
	
	public void clickOnPhotoButton() {
		action.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "clickOnPhoto"), "click on Photo");
	}
	
	public void clickOnpopupCamera() throws InterruptedException {
		action.clickUsingCoordinates(691,1262);
	}
	
	public void clickOnAllow() throws InterruptedException {
		action.clickUsingCoordinates(717,1372);
	}
	
	public void clickOnConformBtn() throws Exception {
		action.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "clickOnConform"), "click on conform");
	}
	
	public void clickOnSubmitBtn() throws Exception {
		action.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "clickOnSubmit"), "click on conform");
	}
	
	public void getTostmessage() throws Exception {
		Thread.sleep(2000);
		action.getToastMsg(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "getTostMsg"), "name");   
	}
	
	public void clickOnRemovieBtn() throws Exception {
		action.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HomeScreen", "clickOnRemovie"), "click on Removie");
	}
	
	
	
	
	
	
	// mobileActions.clickUsingCoordinates(965, 2179);

}