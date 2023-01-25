package pages;

import utils.BaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage extends BaseUtils {
    @FindBy(xpath = "//textarea[@id='postform-text']")
    public WebElement inputAreaNewPaste;

    @FindBy(xpath = "//span[contains(@id, 'select2-postform-expiration-container')]")
    public WebElement expirationContainer;

    public By expirationResultTenMinutes = By.xpath("//li[contains(text(), '10 Minutes')]");

    @FindBy(xpath = "//input[@id='postform-name']")
    public static WebElement postFormTitle;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void openPage() {
        driver.get(prop.getProperty("homePageUrl"));
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }

    public void inputText(String text) {
        inputAreaNewPaste.sendKeys(text);
    }

    public void selectExpirationDate() {
        expirationContainer.click();
        driver.findElement(expirationResultTenMinutes).click();
    }

    public void inputTitle(String title) {
        postFormTitle.sendKeys(title);
    }
}