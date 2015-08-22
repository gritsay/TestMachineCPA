import io.appium.java_client.AppiumDriver;
import javafx.application.Application;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by gritsay on 8/21/15.
 */
public class TestMachineAndroid {
    private AppiumDriver driver;
    private String phoneField = "12345678909";
    private String testPass = "qazxsw";

    @BeforeMethod
    public void setupTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "TestApplicationAndroid");
        capabilities.setCapability("platformName", "Android");
//        String appPath = "/Users/gritsay/development/AndroidProjects/CPA_Androind/app/build/outputs/apk/app-debug-unaligned.apk";
//        capabilities.setCapability("app", appPath);
        driver = new AppiumDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities)
        {
            @Override
            public WebElement scrollTo(String s) {
                return null;
            }

            @Override
            public WebElement scrollToExact(String s) {
                return null;
            }
        };
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    @Test
    public void simpleTest() {
        /*Test for main view, click to drivers*/

        WebElement testClick = driver.findElement(By.id("com.carpoolarabia.android.developers:id/driverButton"));
        testClick.click();

        /*Sing Up*/

        WebElement testSignUpInSecondView = driver.findElement(By.id("com.carpoolarabia.android.developers:id/signUpButton"));
        testSignUpInSecondView.click();

        /*Enter phone and password for sign up with 5 sec sleep*/

        WebElement phoneTextField = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.carpoolarabia.android.developers:id/phone")));
        phoneTextField.sendKeys(phoneField);
        WebElement testPassword = driver.findElement(By.id("com.carpoolarabia.android.developers:id/passwordEditText"));
        testPassword.sendKeys(testPass);
        driver.hideKeyboard();
        WebElement testSignUp = driver.findElement(By.id("com.carpoolarabia.android.developers:id/signupButton"));
        testSignUp.click();

        /*SignUp Activity*/

        WebElement updatePhoto = driver.findElement(By.id("com.carpoolarabia.android.developers:id/pictureImageView"));
        updatePhoto.click();
        WebElement makeNewPhoto = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.carpoolarabia.android.developers:id/cameraButton")));
        makeNewPhoto.click();
        WebElement captureImage = driver.findElement(By.id("com.carpoolarabia.android.developers:id/capture_image_button"));
        captureImage.click();
        WebElement firstName = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.carpoolarabia.android.developers:id/firstEditText")));
        firstName.sendKeys("Vladislav");
        WebElement lastName = driver.findElement(By.id("com.carpoolarabia.android.developers:id/lastEditText"));
        lastName.sendKeys("Sedinkin");
        WebElement email = driver.findElement(By.id("com.carpoolarabia.android.developers:id/emailEditText"));
        email.sendKeys("test_mail1@gmail.com");
        WebElement age = driver.findElement(By.id("com.carpoolarabia.android.developers:id/phone"));
        age.sendKeys("121");
        driver.hideKeyboard();
        WebElement registration = driver.findElement(By.id("com.carpoolarabia.android.developers:id/createButton"));
        registration.click();

        /*Verify entries*/
        WebElement receiveCode = driver.findElement(By.id("com.carpoolarabia.android.developers:id/sendButton"));
        receiveCode.click();
        WebElement receivedCode = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.carpoolarabia.android.developers:id/code")));
        receivedCode.sendKeys("2344");
        driver.hideKeyboard();
        WebElement verifyButton = driver.findElement(By.id("com.carpoolarabia.android.developers:id/verifyButton"));
        verifyButton.click();

        /**/
        WebElement map = driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]");
        map.click();
        WebElement homeAddress = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.carpoolarabia.android.developers:id/editText")));
        homeAddress.sendKeys("New York");
        driver.hideKeyboard();
        WebElement homeLocation = driver.findElement(By.id("com.carpoolarabia.android.developers:id/setButton"));
        homeAddress.click();
    }
}
