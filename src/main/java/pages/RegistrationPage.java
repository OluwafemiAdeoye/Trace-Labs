package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class RegistrationPage {
    private WebDriver driver;
    private By usernameField = By.id("ContentPlaceHolder1_txtUserName");
    private By getUsernameFieldWarning = By.xpath("//*[@id=\"ContentPlaceHolder1_txtUserName-error\"]");

    private By emailAddressField = By.xpath("//input[@id='ContentPlaceHolder1_txtEmail']");
    private By getEmailAddressFieldWarning = By.id("ContentPlaceHolder1_txtEmail-error");

    private By passwordField = By.xpath("//input[@id='ContentPlaceHolder1_txtPassword']");
    private By confirmPasswordField = By.xpath("//input[@id='ContentPlaceHolder1_txtPassword2']");
    private By termsAndConditionsCheckbox = By.cssSelector("label[for='ContentPlaceHolder1_MyCheckBox'] span:nth-child(1)");
    private By reCAPTCHACheckbox = By.xpath("//div[@class='recaptcha-checkbox-border']");
    private By createAccountButton = By.xpath("//input[@id='ContentPlaceHolder1_btnRegister']");

    public RegistrationPage(EventFiringWebDriver driver) {
        this.driver = driver;
    }

    public void setUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public String getUsernameAlert() {
        return driver.findElement(getUsernameFieldWarning).getText();
    }

    public void setEmailAddress(String emailAddress) {
        driver.findElement(emailAddressField).sendKeys(emailAddress);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void setConfirmPassword(String password) {
        driver.findElement(confirmPasswordField).sendKeys(password);
    }

    public void setTermsAndConditionsCheckbox() {
        driver.findElement(termsAndConditionsCheckbox).click();
    }

    public void setReCAPTCHACheckbox() {
        driver.findElement(reCAPTCHACheckbox).click();
    }

    public PendingVerificationPage clickCreateAccountButton() {
        driver.findElement(passwordField).click();
        return new PendingVerificationPage(driver);
    }
}
