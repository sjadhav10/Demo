package Sample.DeviceTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

AndroidDriver driver;
CommonMethods commonMethods;

@BeforeTest
public void initialize() throws MalformedURLException
{
	System.out.println("Initializing Driver");
	DesiredCapabilities cap = new DesiredCapabilities();
	cap.setCapability("deviceName","Lenovo");
	cap.setCapability("platform","ANDROID");
	cap.setCapability("appPackage","com.flipkart.android");
	cap.setCapability("appActivity","com.flipkart.android.activity.HomeFragmentHolderActivity");
	driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"),cap);
	System.out.println("Driver initialized");
	commonMethods = new CommonMethods(driver); 
	}

@AfterTest
public void tearDown()
{
	driver.quit();
}
}
