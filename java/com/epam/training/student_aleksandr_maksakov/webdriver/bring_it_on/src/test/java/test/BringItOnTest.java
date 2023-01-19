package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.PastebinHomePage;
import page.PastebinPageNewPaste;

public class BringItOnTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void bringItOnTest() {
        String expectedPageTitleName = "how to gain dominance among developers";
        String expectedSyntaxHighlighting = "Bash";
        String expectedCode = "git config --global user.name  \"New Sheriff in Town\"" +
                "\ngit reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")" +
                "\ngit push origin master --force";

        PastebinPageNewPaste newPaste = new PastebinHomePage(driver)
                .openPage()
                .writeCodeToTextArea(expectedCode)
                .selectSyntaxHighlighting()
                .selectPasteExpiration()
                .writePasteName(expectedPageTitleName)
                .createNewPaste();

        Assert.assertEquals(newPaste.getPageTitleName(), expectedPageTitleName);
        Assert.assertEquals(newPaste.getSyntaxHighlighting(), expectedSyntaxHighlighting);
        Assert.assertEquals(newPaste.getCodeFromPaste(), expectedCode);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
