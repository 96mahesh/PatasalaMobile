package com.framework.android.screens.topicsPage;

import com.framework.android.utils.MobileActions;
import com.framework.utilities.DriverFactory;
import com.framework.utilities.MobileUtil;
import com.framework.utilities.ReportManager;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TopicsTabPage {
    MobileActions mobileActions = new MobileActions();

    /**
     * This method is to verify topics tab on third or fourth position of home page tabs
     * @param expectedTopicsTab
     * @param index
     * @return
     */
    public TopicsTabPage verifyTopicTabOnThirdOrFourthPosition(String expectedTopicsTab, int index) {
        List<WebElement> allTabs = DriverFactory.getInstance().getMobileDriver().findElements
                (MobileUtil.returnByBasedOnPageNameAndObjectName("TopicTab", "homePageAllTabs"));
        Assert.assertTrue(allTabs.get(index).getText().equalsIgnoreCase(expectedTopicsTab) ||
                        allTabs.get(index + 1).getText().equalsIgnoreCase(expectedTopicsTab),
                "Topics tab is not visible on third or fourth position of home page tabs");
        ReportManager.logInfo("Topics tab is visible on third or fourth position of home page tabs");
        ReportManager.logPass("Topics tab is visible on third or fourth position of home page tabs");
        return this;
    }
}
