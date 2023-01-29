package pages;

import utils.BaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class PastePage extends BaseUtils {

    @FindBy(xpath = "//ol [@class='bash']")
    private WebElement inputAreaNewPaste;

    @FindBy(xpath = "//div[@class='left']//a")
    private WebElement selectedSyntaxArchive;

    private final By expirationResultTenMinutes =
            By.xpath("//li[contains(text(), '10 Minutes')]");

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement postFormTitle;

    public PastePage() {
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver.getTitle();
    }

    public String getPasteData() {
        return inputAreaNewPaste.getText();
    }
    public String getSyntax() {
    return selectedSyntaxArchive.getText();
    }
}
