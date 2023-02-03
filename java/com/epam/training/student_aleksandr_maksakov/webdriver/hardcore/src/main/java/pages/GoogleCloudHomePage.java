package pages;

import utils.BaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.concurrent.TimeUnit;

public class GoogleCloudHomePage extends BaseUtils {
    @FindBy(xpath = "//input[contains(@class, 'devsite-search-field')]")
    public WebElement searchButton;
    private final By searchBox =
            By.xpath("//input[@role ='searchbox']");
    public GoogleCloudHomePage() {
        PageFactory.initElements(driver, this);
    }
    public void openPage() {
        driver.get(prop.getProperty("googleCloudURL"));
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }
    public void inputSearch() {
        searchButton.click();
        driver.findElement(searchBox).sendKeys(prop.getProperty("hurtMePlentySearchText"), Keys.ENTER);
    }
}
