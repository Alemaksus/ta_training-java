package test;

import model.VirtualMachine;
import page.*;
import service.VMCreator;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HardcoreTest extends CommonConditions {
    @Test(description = "Email result matches Google calculator")
    public void compareEmailResultWithCalculator() throws InterruptedException {
        VirtualMachine VM = VMCreator.withCredentialsFromProperty();
        new GoogleCloudHomePage(driver)
                .openPage()
                .inputSearch()
                .clickOnSearchResult()
                .switchToInnerFrame()
                .createVM(VM)
                .clickAddToEstimateButton()
                .clickEmailButton();
        openNewTab();
        new YopMailHomePage(driver)
                .openPage()
                .generateNewEmail()
                .copyGeneratedEmail();
        switchToAnotherTab();
        new GoogleCloudPrisingCalculatorPage(driver)
                .switchToInnerFrame()
                .inputCopiedEmail();
//                .clickSendEmailButton();
        switchToAnotherTab();
        new YopMailGeneratorPage(driver)
                .checkInbox()
                .waitForTheEmail();

        String mailResult = new YopMailInboxPage(driver).getEmailText();
        switchToAnotherTab();
        String googleResult = new GoogleCloudPrisingCalculatorPage(driver).getTotalEstimatedCostText();
        googleResult = googleResult.replaceAll("\\D.", "");
        mailResult = mailResult.replaceAll("\\D.", "");
        Assert.assertEquals(googleResult, mailResult, "Email result matches Google calculator");
    }
}
