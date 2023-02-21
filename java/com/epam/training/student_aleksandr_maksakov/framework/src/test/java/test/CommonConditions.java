package test;

import driver.DriverSingleton;
import util.TestListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class CommonConditions{

    protected WebDriver driver;

    public void openNewTab(){
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public void switchToAnotherTab(){
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    @BeforeClass()
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }
}
