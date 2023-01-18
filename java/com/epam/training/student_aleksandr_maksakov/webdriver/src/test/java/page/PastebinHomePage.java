package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.GeneralUtils;
public class PastebinHomePage extends AbstractPage{
    private static final String HOMEPAGE_URL = "https://pastebin.com";
    @FindBy(xpath = "//textarea[@id='postform-text']")
    private WebElement textAreaForCode;

    @FindBy(xpath = "//span[@id='select2-postform-expiration-container']")
    private WebElement pasteExpirationDropdown;

    @FindBy(xpath = "//input[@id='postform-name']")
    private WebElement textAreaForPasteName;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createNewPasteButton;

    private String select10MinutesPasteExpiration = "//li[text()='10 Minutes']";

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }
    @Override
    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }
    public PastebinHomePage writeCodeToTextArea(String code) {
        GeneralUtils.scrollToElement(textAreaForCode, driver);
        textAreaForCode.sendKeys(code);
        return this;
    }
    public PastebinHomePage selectPasteExpiration() {
        GeneralUtils.scrollToElement(pasteExpirationDropdown, driver);
        pasteExpirationDropdown.click();
        driver.findElement(By.xpath(select10MinutesPasteExpiration)).click();
        return this;
    }
    public PastebinHomePage writePasteName(String pasteName) {
        textAreaForPasteName.sendKeys(pasteName);
        return this;
    }
    public PastebinPageNewPaste createNewPaste() {
        createNewPasteButton.click();
        return new PastebinPageNewPaste(driver);
    }
}
