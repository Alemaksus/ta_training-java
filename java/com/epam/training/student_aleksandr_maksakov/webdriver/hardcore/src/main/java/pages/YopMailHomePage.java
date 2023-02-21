package pages;

import utils.BaseUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class YopMailHomePage extends BaseUtils {
    @FindBy(xpath = "//h3[contains(text(), 'Random Email')]")
    public WebElement randomEmailGeneratorButton;
    public YopMailHomePage() {
        PageFactory.initElements(driver, this);
    }
    public void openPage() {
        driver.get(prop.getProperty("yopMailUrl"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }
    public void generateNewEmail() {
        randomEmailGeneratorButton.click();
    }
}
