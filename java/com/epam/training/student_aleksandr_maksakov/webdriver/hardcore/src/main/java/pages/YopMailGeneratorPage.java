package pages;

import utils.BaseUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class YopMailGeneratorPage extends BaseUtils {
    @FindBy(xpath = "///div[@id='egen']")
    public WebElement generatedEmail;
    @FindBy(xpath = "//button[@id='cprnd']")
    public WebElement copyEmailButton;
    @FindBy(xpath = "//span[text() = 'Check Inbox']")
    public WebElement checkInboxButton;
    @FindBy(xpath = "//body")
    public WebElement pageBody;
    public YopMailGeneratorPage() {
        PageFactory.initElements(driver, this);
    }
    public void copyGeneratedEmail() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.elementToBeClickable(copyEmailButton)).click();
        pageBody.sendKeys(Keys.CONTROL + "T");
    }
    public void checkInbox() {
        checkInboxButton.click();
    }
}
