package Sample.DeviceTest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DeviceTest extends BaseTest {

	@Test
	public void skipLoginIfDisplayed()
	{
		if(commonMethods.isElementDisplayed(By.id("com.flipkart.android:id/btn_msignup")))
				{
					commonMethods.clickOnElement(By.id("com.flipkart.android:id/btn_skip"));
				}
	}
	
	@Test(dependsOnMethods="skipLoginIfDisplayed")
	public void searchProduct()
	{
		commonMethods.clickOnElement(By.id("com.flipkart.android:id/search_widget_textbox"));
		commonMethods.clickOnElement(By.id("com.flipkart.android:id/search_autoCompleteTextView"));
		commonMethods.sendKeysToElement(By.id("com.flipkart.android:id/search_autoCompleteTextView"),"iPhone 6");
		commonMethods.clickOnElement(By.xpath("//android.widget.TextView[@text='iphone 6 in Mobiles']"));
		//commonMethods.generateKeysEvenet(Keys.ENTER);
		Assert.assertEquals("Apple iPhone 6 (Gold, 32 GB)",
				commonMethods.getElementText(By.xpath("//android.view.ViewGroup[@index='2']//android.widget.TextView[@index='2']")),
				"Failed to Compare Text");
		
	}
	
}
