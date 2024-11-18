package com.framework.android.screens.kooCreationPages;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.ConfigReader;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.MobileUtil;
import com.framework.utilities.ReportManager;

import net.thucydides.core.annotations.findby.By;

public class KooCreationCreateKoo {
	MobileActions mobileActions = new MobileActions();
	int countOfLanguages;
	public void verifyCreateKoowithoutTitle(String language,String buttonText) throws IOException, InterruptedException {
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_plus"), "Plus Button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", buttonText),
                "clicked on post button");
        
        boolean isTextView=DriverFactory.getInstance().getMobileDriver().findElements(org.openqa.selenium.By.xpath("//android.view.View[@content-desc=\"koo_create_textField\"]")).size()>0;
       if(isTextView) {
    	 String errormsg1= mobileActions.getText(org.openqa.selenium.By.xpath("//android.view.View[@content-desc=\"koo_create_textField\"]"),"Text Error message");
    	  System.out.println(errormsg1);
          ReportManager.logInfo("Error Message is " + errormsg1);
       }
       else {
        String errormsg2=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_errorMsg"));
        System.out.println(errormsg2);
        ReportManager.logInfo("Error Message is " + errormsg2);
       }
	}
	
	public void verifypollOption(String buttonText) throws IOException {
		mobileActions.click(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_add_poll"), "add poll Button");
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_post", buttonText),
                "clicked on post button");
		//String errormsginpoll;
		boolean isTextViewinpoll=DriverFactory.getInstance().getMobileDriver().findElements(org.openqa.selenium.By.xpath("//android.view.View[@content-desc=\"koo_create_textField\"]")).size()>0;
	       if(isTextViewinpoll) {
	    	 String  errormsginpoll1= mobileActions.getText(org.openqa.selenium.By.xpath("//android.view.View[@content-desc=\"koo_create_textField\"]"));
	    	   System.out.println(errormsginpoll1);
	           ReportManager.logInfo("Error Message is " + errormsginpoll1);
	       }
	       else {
		String errormsginpoll2=mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_errorMsg"));
		System.out.println(errormsginpoll2);
        ReportManager.logInfo("Error Message is " + errormsginpoll2);
	       }
		
        mobileActions.click(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_add_image"), "add Image Button");
        String toast = DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//android.widget.Toast")).getText();
		System.out.println(toast);
	    ReportManager.logInfo("The toast message is "+ toast);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_editProfileClose"),
                "Close poll button");
	}
	public void verifyGIF() throws IOException, InterruptedException {
		mobileActions.swipeElementAndroid(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_add_image"), "LEFT", MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_addGIF"), 2);
		mobileActions.click(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_addGIF"), "add GIF Button");
		Thread.sleep(5000);
		mobileActions.click(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_addGIFImage"), "add GIF");
		mobileActions.click(
                MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_add_poll"), "add poll Button");
		String toast1 = DriverFactory.getInstance().getMobileDriver().findElement(By.xpath("//android.widget.Toast")).getText();
		System.out.println(toast1);
	    ReportManager.logInfo("The toast message is "+ toast1);
	    mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_editProfileClose"),
                "Close GIF button");
	}
	public void verifylanguagetranslation() throws IOException, InterruptedException {
		mobileActions.sendKeys(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_Message"),
                ConfigReader.getValue("KooPostText"));
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_addlanguage_plus"),
                "Add Languages Plus Button");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "checkbox_selectLanguage"),
                "select language");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "checkbox_selectLanguage1"),
                "select language");
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_done_"),
                "Clicked on done button");
        List<WebElement> listOfElements = DriverFactory.getInstance().getMobileDriver()
                .findElements(By.xpath("//android.widget.TextView[contains(@content-desc,'language_tab')]"));
        countOfLanguages = listOfElements.size();
        System.out.println(countOfLanguages);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_language2"),
                "Clicked on second selected language button");
        Thread.sleep(2000);
        String Text1 = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_posted"),
				"Edited text");
		System.out.println("Text1 is " + Text1);
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_language3"),
                "Clicked on third selected language button");
        Thread.sleep(2000);
        String Text2 = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_posted"),
				"Edited text");
		System.out.println("Text2 is " +Text2);
		mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "btn_language1"),
                "Clicked on first selected language button");
		Thread.sleep(2000);
		String Text3 = mobileActions.getText(MobileUtil.returnByBasedOnPageNameAndObjectName("KooCreation", "txt_posted"),
				"Edited text");
		System.out.println("Text3 is " +Text3);
		Assert.assertNotSame(Text1, Text2, Text3);
	}
	
	

}
