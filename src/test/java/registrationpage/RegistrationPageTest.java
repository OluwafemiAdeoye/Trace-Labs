package registrationpage;

import base.BaseTest;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.PendingVerificationPage;
import utils.JsonReader;

import java.io.IOException;

public class RegistrationPageTest extends BaseTest {
    WebDriver driver;

    @DataProvider(name = "RegistrationCredentials")
    public Object[][] passData() throws IOException, ParseException {
        return JsonReader.getJSONData(System.getProperty("user.dir") + "/resources/testData/TestData.json", "Registrtaion Credentials", 4);
    }

    @Test(dataProvider = "RegistrationCredentials")
    public void testUserregistration(String username, String emailAddress, String password, String confirmPassword) throws InterruptedException {
        registrationPage.setUsername(username);
//        Assert.assertEquals(registrationPage.getUsernameAlert(), "Username is invalid.");
        Thread.sleep(3000);
        registrationPage.setEmailAddress(emailAddress);
//        WebDriverWait wait = new WebDriverWait(driver,30);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(registrationPage.setEmailAddress())));
        Thread.sleep(3000);
        registrationPage.setPassword(password);
        Thread.sleep(3000);
        registrationPage.setConfirmPassword(confirmPassword);
        Thread.sleep(3000);
        registrationPage.setTermsAndConditionsCheckbox();
        Thread.sleep(3000);
        registrationPage.setReCAPTCHACheckbox();
        Thread.sleep(3000);
        PendingVerificationPage pendingVerificationPage = registrationPage.clickCreateAccountButton();
        Assert.assertTrue(pendingVerificationPage.getAlertText()
                        .contains("Your account registration has been submitted and is pending email verification "),
                "Your registration is pending activation. Please check your email to activate your account.");
    }
}
