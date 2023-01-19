package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.GeneralUtils;

public class PastebinPageNewPaste extends AbstractPage {

    private String syntaxHighlightingName = "//a[@class='btn -small h_800']";
    private String pageTitleName = "//div[@class='info-top']/child::h1";
    private String linesFromTextAreaForCode = "//div[@class='de1']";

    public PastebinPageNewPaste(WebDriver driver) {
        super(driver);
    }

    public String getSyntaxHighlighting() {
        GeneralUtils.waitForElementLocated(syntaxHighlightingName, driver);
        return driver.findElement(By.xpath(syntaxHighlightingName)).getText().trim();
    }

    public String getPageTitleName() {
        GeneralUtils.waitForElementLocated(pageTitleName, driver);
        return driver.findElement(By.xpath(pageTitleName)).getText().trim();
    }

    public String getCodeFromPaste() {
        GeneralUtils.waitForElementLocated(linesFromTextAreaForCode, driver);
        StringBuilder codeFromPaste = new StringBuilder();
        for (WebElement line : driver.findElements(By.xpath(linesFromTextAreaForCode))) {
            codeFromPaste.append(line.getText());
            codeFromPaste.append("\n");
        }
        return codeFromPaste.toString().trim();
    }

    @Override
    public PastebinPageNewPaste openPage() {
        return this;
    }
}