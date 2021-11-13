package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GoogleHomePage extends BasePage{

    //Locators for the Google HomePage
    public By searchArea_textArea_xpath = By.xpath("//input[@name='q']");
    By thirdResult_span_xpath = By.xpath("//div[@id='rso']/div[3]");
    public GoogleHomePage(){
        super();
    }
    public String getThirdResultText(){
        WebElement thirdElementObject = this.findWebElementBySelector(thirdResult_span_xpath);
        return thirdElementObject.getText();
    }
}
