package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PendingVerificationPage {
    private WebDriver driver;
    private By statusAlert = By.cssSelector("div[class='alert alert-info']");

    public PendingVerificationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertText() {
        return driver.findElement(statusAlert).getText();
    }
}
