import utils.BaseUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import java.util.Objects;

public class HardcoreTest extends BaseUtils {
    @Test (description = "Home page opened", priority = 1)
    public void homePageOpened() throws InterruptedException {
        new GoogleCloudHomePage().openPage();
    }
    @Test (description = "Text inserted into search and pressed Enter", priority = 2)
    public void textInput() {new GoogleCloudHomePage().inputSearch();}
    @Test (description = "Pricing Calculator search result chosen", priority = 3)
    public void selectResultInSearchPage() {
        new GoogleCloudSearchResultsPage().clickOnSearchResult();
    }
    @Test (description = "Input number of instances", priority = 4)
    public void inputNumberOfInstances() {
        new GoogleCloudPrisingCalculatorPage().inputInstances();}
    @Test (description = "OS chosen", priority = 5)
    public void chooseOs() {new GoogleCloudPrisingCalculatorPage().chooseOS();}
    @Test (description = "VM Class chosen", priority = 6)
    public void chooseVmClass() {new GoogleCloudPrisingCalculatorPage().chooseVMClass();}
    @Test (description = "Series chosen", priority = 7)
    public void chooseSeries() {new GoogleCloudPrisingCalculatorPage().chooseSeries();}
    @Test (description = "Choose instance type", priority = 8)
    public void instanceTypeChosen() {new GoogleCloudPrisingCalculatorPage().chooseInstanceType();}
    @Test (description = "Add GPU", priority = 9)
    public void addGpu() {new GoogleCloudPrisingCalculatorPage().addGpus();}
    @Test (description = "Add SSD", priority = 10)
    public void chooseSsd() {new GoogleCloudPrisingCalculatorPage().chooseSsd();}
    @Test (description = "Choose location", priority = 11)
    public void chooseLocation() {new GoogleCloudPrisingCalculatorPage().chooseDatabaseLocation();}
    @Test (description = "Choose committed usage", priority = 12)
    public void chooseCommittedUsage() {new GoogleCloudPrisingCalculatorPage().chooseCommittedUsage();}
    @Test (description = "Click add to Estimate button", priority = 13)
    public void clickAddToEstimateButton() {
        new GoogleCloudPrisingCalculatorPage().clickAddToEstimateButton();}
    @Test (description = "Click Email button", priority = 14)
    public void clickEmailButton() {
        new GoogleCloudPrisingCalculatorPage().clickEmailButton();
    }
    @Test(description = "Copy Generated Email", priority = 15)
    public void getGeneratedEmail() {
        openNewTab();
        new YopMailHomePage().openPage();
        new YopMailHomePage().generateNewEmail();
        new YopMailGeneratorPage().copyGeneratedEmail();
    }
    @Test (description = "Paste Generated Email to the field", priority = 16)
    public void inputEmail() {
        switchToAnotherTab();
        new GoogleCloudPrisingCalculatorPage().inputCopiedEmail();
    }
    @Test (description = "Click Send Email button", priority = 17)
    public void sendEmail() {
        new GoogleCloudPrisingCalculatorPage().clickSendEmailButton();
    }
    @Test(description = "Navigate to the Inbox", priority = 18)
    public void checkEmail() {
        switchToAnotherTab();
        new YopMailGeneratorPage().checkInbox();
    }
    @Test(description = "Compare results from the mail", priority = 19)
    public void compareResults() throws InterruptedException {
        while (Objects.equals(new YopMailInboxPage().getMailCount(), "0 mail")){
            new YopMailInboxPage().refreshPage();
        }
        String MailResult = new YopMailInboxPage().getEmailText();
        switchToAnotherTab();
        String GoogleResult = new GoogleCloudPrisingCalculatorPage().getTotalEstimatedCostText();
        GoogleResult = GoogleResult.split("USD ")[1];
        GoogleResult = GoogleResult.split(" per 1")[0];
        MailResult = MailResult.split("USD ")[1];
        Assert.assertEquals(GoogleResult, MailResult);
    }
}
