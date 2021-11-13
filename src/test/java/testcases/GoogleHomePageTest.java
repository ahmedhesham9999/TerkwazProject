package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.GoogleHomePage;

public class GoogleHomePageTest {
    GoogleHomePage googleHomePage = new GoogleHomePage();

    @Test()
    public void tc001_checkThirdSearchResult(){
        googleHomePage.openUrl("https://www.google.com/");
        googleHomePage.sendTextToSearchArea("Selenium webdriver",googleHomePage.searchArea_textArea_xpath);
        Assert.assertTrue(googleHomePage.getThirdResultText().contains("What is selenium WebDriver"));
    }

    @AfterTest
    public void closeBrowser(){
        googleHomePage.closeDriver();
    }
}
