import org.testng.Assert;
import utils.BaseUtils;
import org.testng.annotations.Test;
import pages.HomePage;

public class ICanWinTest extends BaseUtils {

    @Test (description = "Home page opened", priority = 1)
    public void homePageOpened() {
        new HomePage().openPage();
    }

    @Test (description = "Text inserted", priority = 2)
    public void textInput() {
        new HomePage().inputText(prop.getProperty("iCanWinText"));
    }

    @Test (description = "Expiration Date Selected", priority = 3)
    public void selectExpirationDate() {new HomePage().selectExpirationDate();}

    @Test (description = "Title inserted", priority = 4)
    public void inputTitle() {
        new HomePage().inputTitle(prop.getProperty("iCanWinTitle"));
        //Assert.assertTrue(HomePage.postFormTitle = config.iCanWinTitle, "Form title is empty");
    }


}