package page;

import org.openqa.selenium.WebDriver;

public class PastebinPageNewPaste extends AbstractPage {

    public PastebinPageNewPaste(WebDriver driver) {
        super(driver);
    }
    @Override
    public PastebinPageNewPaste openPage() {
        return this;
    }
}
