package com.framework.android.screens.exploreScrenPages;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.MobileUtil;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class TopicsTabAndElementsPage {
    MobileActions mobileActions = new MobileActions();

    /**
     * This method is to verify five profile images
     * @param tabName
     * @throws IOException
     */
    public void verifyNERTagsAndKooCreationPage(String tabName) throws IOException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("HashTagScreen", "hashtag_screen_tab",
                tabName),"Click on Tab = "+tabName);
        List<WebElement> nerTags = DriverFactory.getInstance().getMobileDriver().findElements
                (MobileUtil.returnByBasedOnPageNameAndObjectName("TopicsTab", "ner_tags"));
        for (int i = 0; i <nerTags.size(); i++){
            Assert.assertTrue(!nerTags.get(i).getText().startsWith("#"),
                    "NER tags is not starting with # which is correct");
            Assert.assertTrue(!nerTags.get(i).getText().contains("#"),
                    "NER tags is not containing # which is correct");
        }
    }

    /**
     * Verify Plus Koo button
     */
    public void verifyPlusKooButton(){
        Assert.assertTrue(mobileActions.isDisplayed(MobileUtil.returnByBasedOnPageNameAndObjectName("Elements", "plusKooButton"),
                "Plus Koo button is visible for # post"));
    }

    /**
     * This method is to click on plus koo button
     * @throws IOException
     */
    public void clickPlusKooButton() throws IOException {
        mobileActions.click(MobileUtil.returnByBasedOnPageNameAndObjectName("Elements", "plusKooButton"),
                "Plus Koo button is visible for # post");
    }
}
