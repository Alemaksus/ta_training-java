package test;

import model.VirtualMachine;
import page.*;
import service.TestDataReader;
import service.VMCreator;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HurtMePlentyTest extends CommonConditions {
    @Test(description = "Compare Google Calculator with manual estimation")
    public void checkGoogleCalculatorResults() {
        VirtualMachine VM = VMCreator.withCredentialsFromProperty();
        GoogleCloudPrisingCalculatorPage page = new GoogleCloudPrisingCalculatorPage(driver);

        new GoogleCloudHomePage(driver)
                .openPage()
                .inputSearch()
                .clickOnSearchResult()
                .switchToInnerFrame()
                .createVM(VM)
                .clickAddToEstimateButton();

        SoftAssert softAssertion = new SoftAssert();
        softAssertion.assertEquals(page.getRegion(),
                TestDataReader.getTestData("hurtMePlentyRegion"),"Regions match");
        softAssertion.assertEquals(page.getCommittedTerms(),
                TestDataReader.getTestData("hurtMePlentyCommitmentTerm"),"Committed Terms match");
        softAssertion.assertEquals(page.getProvisioningModel(),
                TestDataReader.getTestData("hurtMePlentyVMClass"),"Provisioning Model match");
        softAssertion.assertEquals(page.getInstanceType(),
                TestDataReader.getTestData("hurtMePlentyInstanceType"),"Instance Type match");
        softAssertion.assertEquals(page.getSsd(),
                TestDataReader.getTestData("hurtMePlentyLocalSSD"),"SSD match");
    }
}