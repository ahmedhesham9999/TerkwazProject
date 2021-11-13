package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.HttpCommandExecutor;

import javax.swing.*;

public class InternetHerokuAppPage extends BasePage{
    // Upload Locators
    By fileUpload_link_linkText = By.cssSelector("a[href='/upload']");
    By chooseFile_input_id = By.id("file-upload");
    By upload_input_id = By.id("file-submit");
    By fileUploaded_text_xpath = By.xpath("//div[@id='content']//h3");
    By uploadedFiles_div_id = By.id("uploaded-files");

    // Dynamic Loading Locators
    public By dynamicLoad_anchor_cssSelector = By.cssSelector("a[href='/dynamic_loading']");
    public By exampleTwo_anchor_cssSelector = By.cssSelector("a[href='/dynamic_loading/2']");
    public By start_button_xpath = By.xpath("//div[@id='start']//button");
    public By finish_div_id = By.id("finish");

    public InternetHerokuAppPage() { super(); }

    public void clickFileUpload(){
        findWebElementBySelector(fileUpload_link_linkText).click();
    }
    private WebElement getChooseFileElement(){

        return waitForElementToBeVisible(chooseFile_input_id);
    }
    public void clickChooseFile(){
        getChooseFileElement().click();
    }
    public void uploadFileFromDirectory(){
        getChooseFileElement().sendKeys("C:\\\\Users\\\\user\\\\Desktop\\\\test.png");
    }

    public void clickButtonUsingAction(){
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(chooseFile_input_id);
        actions.moveToElement(element).click();
    }

    // Dynamic Loading Functions
    private WebElement getResultContainer(){
       return waitForElementToBeVisible(finish_div_id);
    }

    public String getResultText(){
        return getResultContainer().getText();
    }
}
