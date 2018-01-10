package Sample.DeviceTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import junit.framework.Assert;

public class CommonMethods {
	static AndroidDriver driver;
	static WebDriverWait wait;
	
	public CommonMethods(AndroidDriver driver) {
		this.driver=driver;
		wait = new WebDriverWait(driver, 10);
		
	}

	public void clickOnElement(By by)
	{
		waitForElment(by).click();
		System.out.println("Clicked on element");
	}
	public String getElementText(By by)
	{
		return waitForElment(by).getText();
	}
	
	public void sendKeysToElement(By by, String input)
	{
		waitForElment(by).sendKeys(input);
	}
	
	public void generateKeysEvenet(Keys keys)
	{
		driver.getKeyboard().sendKeys(keys);
	}
	
	public WebElement waitForElment(By by)
	{
		
		AndroidElement element = (AndroidElement) wait.until(ExpectedConditions.presenceOfElementLocated(by));
		return element;
		
	}
	
	public void compareText(String expected,String actual)
	{
		Assert.assertEquals(expected, actual);
	}
	
	public boolean isElementDisplayed(By by)
	{
		try{
		waitForElment(by).isDisplayed();
		return true;
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Element Not found");
			return false;
		}
	}
	
	
}
