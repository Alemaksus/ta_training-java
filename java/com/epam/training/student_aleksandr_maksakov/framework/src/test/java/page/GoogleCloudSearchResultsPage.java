package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GoogleCloudSearchResultsPage extends AbstractPage {

    @FindBy(xpath = "//div[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']")
    public WebElement searchResultPricingCalculator;

    public GoogleCloudSearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public GoogleCloudPrisingCalculatorPage clickOnSearchResult() {
        searchResultPricingCalculator.click();
        return new GoogleCloudPrisingCalculatorPage(driver);
    }
}