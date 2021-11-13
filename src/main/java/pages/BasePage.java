package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.maven.plugin.AbstractMojo;


public class BasePage {
    protected static WebDriver driver;
    BasePage(){
        driver = getWebDriver();
    }

    private WebDriver getWebDriver(){
        WebDriverManager.chromedriver().setup();
        WebDriver chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        return chromeDriver;
    }

    public void openUrl(String url){
        driver.get(url);
    }

    public void sendTextToSearchArea(String text, By elementLocator){
        WebElement webElement = driver.findElement(elementLocator);
        webElement.sendKeys(text);
        webElement.sendKeys(Keys.ENTER);
    }

    public WebElement findWebElementBySelector(By elementLocator){
        return driver.findElement(elementLocator);
    }

    public void clickWebElement(WebElement webElement){
        webElement.click();
    }

    protected static WebElement waitForElementToBeVisible(By locator) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 20, 500);
        return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void closeDriver(){
        driver.close();
    }

}
