package page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 60;
//    protected final int PAGE_LOAD_TIMEOUT = 35;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}