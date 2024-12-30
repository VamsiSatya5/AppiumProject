package MobileGestures;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class LongPress {
	
	
	@Test
	public void longPressGesture() throws MalformedURLException, URISyntaxException {
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Vamsiphone");
		options.setApp("//Users//vamsisatya//eclipse-workspace//MobileApplication//src//test//java//resources//ApiDemos-debug.apk");
		
		AndroidDriver driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]\n"
				+ "")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Expandable Lists\"]\n"
				+ "")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"1. Custom Adapter\"]\n"
				+ "")).click();
		
		WebElement element=driver.findElement(By.xpath("	\n"+ "//android.widget.TextView[@text=\"People Names\"]\n"+ ""));
		((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),"duration",2000
			));
		
		String text=driver.findElement(AppiumBy.androidUIAutomator("	\n"	+ "new UiSelector().text(\"Sample menu\")")).getText();
		Assert.assertEquals(text, "Sample menu");
		
		
		driver.quit();
		
		
		
	}

	


}
