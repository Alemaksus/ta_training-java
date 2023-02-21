package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Objects;

public class YopMailInboxPage extends AbstractPage {

    @FindBy(id = "refresh")
    public WebElement refreshButton;
    @FindBy(id = "nbmail")
    public WebElement mailCount;

    private final By totalEstimatedCostMail =
            By.xpath("//body[contains(@class, 'bodymail')]//h2");
    private final By mailFrame =
            By.xpath("//iframe[@name='ifmail']");

    public YopMailInboxPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String getEmailText() {
        driver.switchTo().frame(driver.findElement(mailFrame));
        return  driver.findElement(totalEstimatedCostMail).getText();
    }

    public String getMailCount() {return  mailCount.getText();}

    public void refreshPage() {
        refreshButton.click();
    }

    public void waitForTheEmail() throws InterruptedException {
        int i = 0;
        while (Objects.equals(new YopMailInboxPage(driver).getMailCount(), "0 mail") & i != 10) {
            Thread.sleep(2000);
            new YopMailInboxPage(driver).refreshPage();
            i++;
        }
    }
}
