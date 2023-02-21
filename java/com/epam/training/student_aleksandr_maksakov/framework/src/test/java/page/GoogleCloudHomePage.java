package page;

import service.TestDataReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class GoogleCloudHomePage extends AbstractPage {

    @FindBy(xpath = "//input[contains(@class, 'devsite-search-field')]")
    public WebElement searchButton;

    private final By searchBox =
            By.xpath("//input[@role ='searchbox']");

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public GoogleCloudHomePage openPage() {
        driver.get(TestDataReader.getTestData("googleCloudURL"));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
        return this;
    }

    public GoogleCloudSearchResultsPage inputSearch() {
        searchButton.click();
        driver.findElement(searchBox).sendKeys(TestDataReader.getTestData("hurtMePlentySearchText"), Keys.ENTER);
        return new GoogleCloudSearchResultsPage(driver);
    }
}
