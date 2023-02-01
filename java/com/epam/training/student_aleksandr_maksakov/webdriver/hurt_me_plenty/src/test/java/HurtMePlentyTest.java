import utils.BaseUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class HurtMePlentyTest extends BaseUtils {
    @Test (description = "Home page opened", priority = 1)
    public void homePageOpened() {
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
    @Test (description = "Series chosen", priority = 6)
    public void chooseSeries() {new GoogleCloudPrisingCalculatorPage().chooseSeries();}
    @Test (description = "Choose instance type", priority = 7)
    public void instanceTypeChosen() {new GoogleCloudPrisingCalculatorPage().chooseInstanceType();}

    @Test (description = "Add GPU", priority = 8)
    public void addGpu() {new GoogleCloudPrisingCalculatorPage().addGpus();}

    @Test (description = "Add SSD", priority = 9)
    public void chooseSsd() {new GoogleCloudPrisingCalculatorPage().chooseSsd();}

    @Test (description = "Choose location", priority = 10)
    public void chooseLocation() {new GoogleCloudPrisingCalculatorPage().chooseDatabaseLocation();}

    @Test (description = "Choose committed usage", priority = 11)
    public void chooseCommittedUsage() {new GoogleCloudPrisingCalculatorPage().chooseCommittedUsage();}

    @Test (description = "Click add to Estimate button", priority = 12)
    public void clickAddToEstimateButton() {new GoogleCloudPrisingCalculatorPage().clickAddToEstimateButton();}
    @Test (description = "Compare results", priority = 13)
    public void checkResults() {
        Assert.assertTrue(new GoogleCloudPrisingCalculatorPage().compareRegion() &
                new GoogleCloudPrisingCalculatorPage().compareCommittedTerms() &
                new GoogleCloudPrisingCalculatorPage().compareProvisioningModel() &
                new GoogleCloudPrisingCalculatorPage().compareInstanceType() &
                new GoogleCloudPrisingCalculatorPage().compareSsd());}
}
