package testcases;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import pages.InternetHerokuAppPage;

public class InternetHerokuAppPageTest {
    InternetHerokuAppPage internetHerokuAppPage = new InternetHerokuAppPage();

    @Test
    public void tc001_CheckFileGotUploaded(){
        internetHerokuAppPage.openUrl("https://the-internet.herokuapp.com");
        internetHerokuAppPage.clickFileUpload();
//        internetHerokuAppPage.clickChooseFile();
        internetHerokuAppPage.clickButtonUsingAction();
        internetHerokuAppPage.uploadFileFromDirectory();
    }

    @Test
    public void tc002_CheckDynamicLoading(){
        internetHerokuAppPage.openUrl("https://the-internet.herokuapp.com");
        internetHerokuAppPage.clickWebElement(internetHerokuAppPage.findWebElementBySelector(internetHerokuAppPage.dynamicLoad_anchor_cssSelector));
        internetHerokuAppPage.clickWebElement(internetHerokuAppPage.findWebElementBySelector(internetHerokuAppPage.exampleTwo_anchor_cssSelector));
        internetHerokuAppPage.clickWebElement(internetHerokuAppPage.findWebElementBySelector(internetHerokuAppPage.start_button_xpath));
        Assert.assertEquals(internetHerokuAppPage.getResultText(),"Hello World!");
    }

    @AfterTest
    public void closeBrowser(){
        internetHerokuAppPage.closeDriver();
    }

}
