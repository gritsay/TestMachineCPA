import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

/**
 * Created by gritsay on 8/21/15.
 */
public class TestMachineAndroid {
    Random rnd = new Random();
    private AppiumDriver driver;
    private String phoneField = generateRandomName("123456785", 5);
    private String testPass = generateRandomName("Pupirishka", 7);
    private String name = generateRandomName("Vladislav", rnd.nextInt(10));
    private String secondName = generateRandomName("Sedinkin", rnd.nextInt(10));
    private String e_mail = "test_mail@test.com";
    private String receivedCode_ = "1234";
    private String homeAddress_ = "New York";

    @BeforeMethod
    public void setupTest() throws MalformedURLException {
        System.out.printf(phoneField + " " + testPass + " " + name + " " + secondName);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "TestApplicationAndroid");
        capabilities.setCapability("platformName", "Android");
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
        System.out.println("IM HERE!!!");

        WebElement testClick = driver.findElement(By.id("com.carpoolarabia.android.developers:id/driverButton"));
        testClick.click();

        /*Sing Up*/

        WebElement testSignUpInSecondView = driver.findElement(By.id("com.carpoolarabia.android.developers:id/signUpButton"));
        testSignUpInSecondView.click();

        /*Enter phone and password for sign up with 5 sec sleep*/

        WebElement phoneTextField = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.carpoolarabia.android.developers:id/phoneEditText")));
        phoneTextField.sendKeys(phoneField);
        WebElement testPassword = driver.findElement(By.id("com.carpoolarabia.android.developers:id/passwordEditText"));
        testPassword.sendKeys(testPass);
        //driver.hideKeyboard();
        WebElement testSignUp = driver.findElement(By.id("com.carpoolarabia.android.developers:id/signupButton"));
        testSignUp.click();

        /*Verify entries*/
        WebElement receiveCode = driver.findElement(By.id("com.carpoolarabia.android.developers:id/sendButton"));
        receiveCode.click();
        WebElement receivedCode = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.carpoolarabia.android.developers:id/codeEditText")));
        receivedCode.sendKeys(receivedCode_);
        //driver.hideKeyboard();
        WebElement verifyButton = driver.findElement(By.id("com.carpoolarabia.android.developers:id/verifyButton"));
        verifyButton.click();

        /*SignUp Activity*/

        /*Take a photo*/
        WebElement updatePhoto = driver.findElement(By.id("com.carpoolarabia.android.developers:id/pictureImageView"));
        updatePhoto.click();
        WebElement makeNewPhoto = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.carpoolarabia.android.developers:id/cameraButton")));
        makeNewPhoto.click();
        WebElement captureImage = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.carpoolarabia.android.developers:id/capture_image_button")));
                //WebElement captureImage = driver.findElement(By.id("com.carpoolarabia.android.developers:id/capture_image_button"));
        captureImage.click();
        WebElement confirmPhoto = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.carpoolarabia.android.developers:id/save_photo")));
        confirmPhoto.click();

        WebElement firstName = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.carpoolarabia.android.developers:id/firstEditText")));
        firstName.sendKeys(name);
        WebElement lastName = driver.findElement(By.id("com.carpoolarabia.android.developers:id/lastEditText"));
        lastName.sendKeys(secondName);
        WebElement email = driver.findElement(By.id("com.carpoolarabia.android.developers:id/emailEditText"));
        email.sendKeys(e_mail);
        //WebElement age = driver.findElement(By.id("com.carpoolarabia.android.developers:id/phone"));
        //age.sendKeys(age_);
        //driver.hideKeyboard();
        WebElement registration = driver.findElement(By.id("com.carpoolarabia.android.developers:id/createButton"));
        registration.click();

        /**/
        WebElement map = driver.findElementByXPath("//android.widget.LinearLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]/android.widget.FrameLayout[2]/android.widget.RelativeLayout[1]/android.widget.FrameLayout[1]/android.widget.FrameLayout[1]/android.view.View[1]");
        map.click();
        WebElement homeAddress = (new WebDriverWait(driver, 5)).until(ExpectedConditions.presenceOfElementLocated(By.id("com.carpoolarabia.android.developers:id/editText")));
        homeAddress.sendKeys(homeAddress_);
        //driver.hideKeyboard();
        WebElement homeLocation = driver.findElement(By.id("com.carpoolarabia.android.developers:id/setButton"));
        homeLocation.click();
    }
    public String generateRandomName(String currentName, int lenght){
        Random rnd = new Random();
        char[] text = new char[lenght];
        for (int i = 0; i < lenght; i++){
            text[i] = currentName.charAt(rnd.nextInt(currentName.length()));
        }
        return new String(text);
    }
}
