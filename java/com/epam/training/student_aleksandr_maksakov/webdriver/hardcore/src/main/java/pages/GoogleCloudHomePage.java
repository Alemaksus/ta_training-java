package pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class GoogleCloudHomePage extends BaseUtils {
    @FindBy(xpath = "//input[contains(@class, 'devsite-search-field')]")
    public WebElement searchButton;
    private final By searchBox =
            By.xpath("//input[@role ='searchbox']");
    public GoogleCloudHomePage() {
        PageFactory.initElements(driver, this);
    }
    public void openPage() throws InterruptedException {
        driver.get(prop.getProperty("googleCloudURL"));
        //Thread.sleep(5000);
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }
    public void inputSearch() {
        searchButton.click();
        driver.findElement(searchBox).sendKeys(prop.getProperty("hurtMePlentySearchText"), Keys.ENTER);
    }
}
