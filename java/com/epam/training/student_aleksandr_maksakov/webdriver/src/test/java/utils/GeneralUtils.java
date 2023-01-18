package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GeneralUtils {

    public static void scrollToElement(WebElement element, WebDriver driver) {
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0, -window.innerHeight / 4);", element);
    }
}
