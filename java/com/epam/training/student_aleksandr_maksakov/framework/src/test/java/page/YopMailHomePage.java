package page;

import service.TestDataReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class YopMailHomePage extends AbstractPage {
    @FindBy(xpath = "//h3[contains(text(), 'Random Email')]")
    public WebElement randomEmailGeneratorButton;

    public YopMailHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public YopMailHomePage openPage() {
        driver.get(TestDataReader.getTestData("yopMailUrl"));
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        return this;
    }

    public YopMailGeneratorPage generateNewEmail() {
        randomEmailGeneratorButton.click();
        return new YopMailGeneratorPage(driver);
    }
}