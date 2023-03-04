package page;

import model.VirtualMachine;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

public class GoogleCloudPrisingCalculatorPage extends AbstractPage {

    @FindBy(xpath = "//label[contains(text(), 'Number of instances')]/following-sibling::input")
    public WebElement instancesInput;
    @FindBy(xpath = "//label[contains(text(), 'Operating System')]/following-sibling::md-select")
    public WebElement operatingSystemContainer;
    @FindBy(xpath = "//label[contains(text(), 'Provisioning model')]/following-sibling::md-select")
    public WebElement provisioningModelContainer;
    @FindBy(xpath = "//label[contains(text(), 'Series')]/following-sibling::md-select")
    public WebElement seriesContainer;
    @FindBy(xpath = "//label[contains(text(), 'Machine type')]/following-sibling::md-select")
    public WebElement machineTypeContainer;

    @FindBy(xpath = "//md-select[@id='select_127']")
    //    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    public WebElement databaseLocationContainer;
    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
    public WebElement committedUsageContainer;
    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    public WebElement addGPUCheckbox;
    @FindBy(xpath = "//label[contains(text(), 'Local SSD')]/following-sibling::md-select")
    public WebElement localSSDContainer;
    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    public WebElement addEstimateButton;

    private final By gpuTypeContainer =
            By.xpath("//md-select[@ng-model='listingCtrl.computeServer.gpuType']");
    private final By gpuCountContainer =
            By.xpath("//md-select[@ng-model='listingCtrl.computeServer.gpuCount']");
    private final By regionResult=
            By.xpath("//div[@class='md-list-item-text ng-binding' " +
                    "and contains(text(), 'Region')]");
    private final By committedTermResult=
            By.xpath("//div[@class='md-list-item-text ng-binding' " +
                    "and contains(text(), 'Commitment')]");
    private final By provisioningModelResult=
            By.xpath("//div[@class='md-list-item-text ng-binding' " +
                    "and contains(text(), 'Provisioning model')]");
    private final By instanceTypeResult=
            By.xpath("//div[contains(@class, 'md-list-item-text ng-binding')" +
                    " and contains(text(), 'Instance type')]");
    private final By ssdResult=
            By.xpath("//div[contains(@class, 'md-list-item-text') " +
                    "and contains(text(), 'SSD')]");
    private final By totalEstimatedCostSelector=
            By.xpath("//b[contains(@class, 'ng-binding') " +
                    "and contains(text(), 'Total Estimated Cost')]");
    private final By emailButton=
            By.xpath("//button[@id='Email Estimate']");
//    private final By sendEmailButton=
//            By.xpath("//form[@name='emailForm']//button[contains(@class,'cpc-button')]");

    @FindBy(xpath = "//form[@name='emailForm']//button[contains(@class,'cpc-button')]")
    public WebElement sendEmailButton;

    private final By emailField=
            By.xpath("//form[@name='emailForm']//input[@ng-model='emailQuote.user.email']");
    private final By mainIframe=
            By.xpath("//devsite-iframe/iframe");
    private final By myIframe=
            By.xpath("//iframe[@id='myFrame']");

    public GoogleCloudPrisingCalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public GoogleCloudPrisingCalculatorPage switchToInnerFrame(){
        driver.switchTo().frame(driver.findElement(mainIframe));
        driver.switchTo().frame(driver.findElement(myIframe));
        return this;
    }
    public GoogleCloudPrisingCalculatorPage inputInstances(VirtualMachine VM) {
        instancesInput.click();
        instancesInput.sendKeys(VM.getNumberOfInstances());
        return this;
    }

    public GoogleCloudPrisingCalculatorPage chooseOS(VirtualMachine VM) {

        final By operatingSystemSelection =
                By.xpath("//md-option/div[contains(text(),'" + VM.getOS() + "')]");

        operatingSystemContainer.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(operatingSystemSelection)).click();
        return this;
    }

    public GoogleCloudPrisingCalculatorPage chooseVMClass(VirtualMachine VM) {

        final By provisioningModelSelection =
                By.xpath("//md-option/div[contains(text(),'" + VM.getVMClass() + "')]");

        provisioningModelContainer.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(provisioningModelSelection)).click();
        return this;
    }

    public GoogleCloudPrisingCalculatorPage chooseSeries(VirtualMachine VM) {

        final By seriesSelection =
                By.xpath("//md-option[@value='" + VM.getSeries() + "']");

        seriesContainer.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(seriesSelection)).click();
        return this;
    }

    public GoogleCloudPrisingCalculatorPage chooseInstanceType(VirtualMachine VM) {

        final By machineTypeSelection =
                By.xpath("//md-option/div[contains(text(),'" + VM.getInstanceType() + "')]");

        machineTypeContainer.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(machineTypeSelection)).click();
        return this;
    }

    public GoogleCloudPrisingCalculatorPage addGpus(VirtualMachine VM) {

        final By gpuTypeSelector=
                By.xpath("//md-option[@value='" + VM.getTypeOfGPUs() + "']");
        final By gpuCountSelector=
                By.xpath("//md-option[contains(@ng-repeat, 'listingCtrl.supportedGpuNumbers')]" +
                        "/div[contains(text(), '" + VM.getNumberOfGPUs() + "')]");

        addGPUCheckbox.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(gpuTypeContainer)).click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(gpuTypeSelector)).click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(gpuCountContainer)).click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(gpuCountSelector)).click();
        return this;
    }

    public GoogleCloudPrisingCalculatorPage chooseSsd(VirtualMachine VM) {

        final By localSsdSelector=
                By.xpath("//md-option[@ng-repeat='item in " +
                        "listingCtrl.dynamicSsd.computeServer' and @value = '" + VM.getSSD() + "']");

        localSSDContainer.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(localSsdSelector)).click();
        return this;
    }

    public GoogleCloudPrisingCalculatorPage chooseDatabaseLocation(VirtualMachine VM) {

        final By databaseLocationSelector=
                By.xpath("//md-option[@id='select_option_232' and " +
                        "@value='" + VM.getDatabaseLocation() + "']/div");


        databaseLocationContainer.click();

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(databaseLocationSelector)).click();
        return this;
    }

    public GoogleCloudPrisingCalculatorPage chooseCommittedUsage(VirtualMachine VM) {
        final By committedUsageSelector=
                By.xpath("//md-option[@value='" + VM.getCommittedUsage() + "' " +
                        "and @id = 'select_option_132']/div");

        committedUsageContainer.click();
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(committedUsageSelector)).click();
        return this;
    }

    public GoogleCloudPrisingCalculatorPage clickAddToEstimateButton() {
        addEstimateButton.click();
        return this;
    }

    public String getRegion() {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(regionResult)).getText();
    }

    public String getCommittedTerms() {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(committedTermResult)).getText();
    }

    public String getProvisioningModel() {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(provisioningModelResult)).getText();
    }

    public String getInstanceType() {
        return driver.findElement(instanceTypeResult).getText();
    }

    public String getSsd() {
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(ssdResult)).getText();
    }

    public GoogleCloudPrisingCalculatorPage clickEmailButton() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(emailButton)).click();
        return this;
    }

    public GoogleCloudPrisingCalculatorPage clickSendEmailButton() throws InterruptedException {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("window.scrollTo(0,500)", ""); //- it works

        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(sendEmailButton)).click();
        return this;
    }

//        WebElement myElement = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(button));
//    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", myElement);
//a.moveToElement(webElement).build().perform();


//        Actions actions = new Actions(driver);
//        Thread.sleep(2000);
//        actions.moveToElement(sendEmailButton).perform(); - it does not work: with the error:
//        org.openqa.selenium.interactions.MoveTargetOutOfBoundsException: move target out of bounds

//        WebElement element = driver.findElement(sendEmailButton);
//        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
//                .until(ExpectedConditions.elementToBeClickable(element));
//        executor.executeScript("arguments[0].scrollIntoView();", element);




    public GoogleCloudPrisingCalculatorPage inputCopiedEmail() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(emailField)).click();
        driver.findElement(emailField).sendKeys(Keys.CONTROL + "V");
        return this;
    }

    public String getTotalEstimatedCostText() {
        driver.switchTo().frame(driver.findElement(mainIframe));
        driver.switchTo().frame(driver.findElement(myIframe));
        return new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.presenceOfElementLocated(totalEstimatedCostSelector)).getText();
    }

    public GoogleCloudPrisingCalculatorPage createVM(VirtualMachine VM) {
        new GoogleCloudPrisingCalculatorPage(driver)
                .inputInstances(VM)
                .chooseOS(VM)
                .chooseVMClass(VM)
                .chooseSeries(VM)
                .chooseInstanceType(VM)
                .addGpus(VM)
                .chooseSsd(VM)
                .chooseDatabaseLocation(VM)
                .chooseCommittedUsage(VM);
        return this;
    }
}