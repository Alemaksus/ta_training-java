package pages;

import utils.BaseUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class PastePage extends BaseUtils {

    @FindBy(xpath = "//textarea[@id='postform-text']")
    public WebElement inputAreaNewPaste;

    @FindBy(xpath = "//div[@class='left']//a")
    public WebElement selectedSyntaxArchive;

    public final By expirationResultTenMinutes =
            By.xpath("//li[contains(text(), '10 Minutes')]");

    @FindBy(xpath = "//input[@id='postform-name']")
    public WebElement postFormTitle;

    public PastePage() {
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver.getTitle();
    }

    public String getPasteData() {
        return inputAreaNewPaste.getText();
    }
    public String getSyntax() {
    return selectedSyntaxArchive.getText();
    }
}
