package MobileGestures;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class SwipeGesture {
	
	
	@Test
	public void swiping() throws MalformedURLException, URISyntaxException {
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Vamsiphone");
		options.setApp("//Users//vamsisatya//eclipse-workspace//MobileApplication//src//test//java//resources//ApiDemos-debug.apk");
		
		AndroidDriver driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]\n"
				+ "")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Gallery\"]\n"+ "")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"1. Photos\")")).click();
		
		/*((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "left",
			    "percent", 0.75
			));
			*/
		
		WebElement image=driver.findElement(By.xpath("	\n"
				+ "//android.widget.Gallery[@resource-id=\"io.appium.android.apis:id/gallery\"]/android.widget.ImageView[3]\n"
				+ ""));
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) image).getId(),"direction","left","percent",0.5f
			));

		
		driver.quit();
		
	}

}
