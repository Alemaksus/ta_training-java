package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YopMailGeneratorPage extends AbstractPage {

    @FindBy(xpath = "//button[@id='cprnd']")
    public WebElement copyEmailButton;
    @FindBy(xpath = "//span[text() = 'Check Inbox']")
    public WebElement checkInboxButton;

    public YopMailGeneratorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void copyGeneratedEmail() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(copyEmailButton)).click();
    }

    public YopMailInboxPage checkInbox() {
        checkInboxButton.click();
        return new YopMailInboxPage(driver);
    }
}
