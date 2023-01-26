import utils.BaseUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PastePage;




public class BringItOnTest extends BaseUtils {
    @Test (description = "Home page opened", priority = 1)
    public void homePageOpened() {
        new HomePage().openPage();
    }

    @Test (description = "Text inserted", priority = 2)
    public void textInput() {
        new HomePage().inputText(prop.getProperty("bringItOnText"));
    }

    @Test (description = "Syntax Selected", priority = 3)
    public void selectSyntax() {
        new HomePage().selectSyntax();
    }

    @Test (description = "Expiration Date Selected", priority = 4)
    public void selectExpirationDate() {
        new HomePage().selectExpirationDate();
    }

    @Test (description = "Title inserted", priority = 5)
    public void inputTitle() {
        new HomePage().inputTitle(prop.getProperty("bringItOnTitle"));
    }

    @Test (description = "New Paste Created", priority = 6)
    public void creatingNewPaste() {
        String Title = new HomePage().createNewPaste().getTitle();
        Assert.assertEquals(Title, prop.getProperty("bringItOnTitle") + " - Pastebin.com");
    }

    @Test (description = "Syntax is the same as chosen", priority = 7)
    public void syntaxVerification() {
        String Syntax = new PastePage().getSyntax();
        Assert.assertEquals(Syntax, prop.getProperty("bringItOnSyntax"));
    }

    @Test (description = "Code is the same as inserted", priority = 8)
    public void pasteVerification() {
        String PasteData = new PastePage().getPasteData();
        Assert.assertEquals(PasteData, prop.getProperty("bringItOnText"));
    }

}
