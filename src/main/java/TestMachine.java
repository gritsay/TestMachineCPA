
import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


/**
 * Created by gritsay on 8/19/15.
 */
public class TestMachine {
    private AppiumDriver driver;

    @BeforeMethod
    public void setupTest() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "iOS");
        capabilities.setCapability(CapabilityType.VERSION, "8.4");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone 5s");
        String appPath = "/Users/gritsay/Desktop/carpoolarabia_ios.app";
        capabilities.setCapability("app", appPath);
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
        System.out.println("tuta\n");
        System.out.println("out ");

        List<Object> asd = driver.findElementsByClassName("UIATextField");

        System.out.println("out "+ asd.toString());
        WebElement firstTF = (WebElement)asd.get(0);
        firstTF.sendKeys("12");
        WebElement secondTF = (WebElement)asd.get(1);
        secondTF.sendKeys("2");
        driver.findElementByName("Button").click();
        List<Object> labels = driver.findElementsByClassName("UIAStaticText");
        if(labels.get(0) != null) {
            WebElement label = (WebElement) labels.get(0);
            System.out.println("label:" + labels.toString());
            int answer = Integer.parseInt(label.getText());
            System.out.println("integer:" + answer);
            junit.framework.Assert.assertEquals(14, answer);
        }
    }
}
