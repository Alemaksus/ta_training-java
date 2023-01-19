package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GeneralUtils {

    private static final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);

    public static void scrollToElement(WebElement element, WebDriver driver) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -window.innerHeight / 4);", element);
    }

    public static void waitForElementLocated(String xpath, WebDriver driver) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));
    }
}
