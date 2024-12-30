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

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DragDrop {
	
	
	@Test
	public void longPressGesture() throws MalformedURLException, URISyntaxException {
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Vamsiphone");
		options.setApp("//Users//vamsisatya//eclipse-workspace//MobileApplication//src//test//java//resources//ApiDemos-debug.apk");
		
		AndroidDriver driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]\n"	+ "")).click();
		
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]\n"	+ "")).click();
		
		
		WebElement source=driver.findElement(By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_1\"]\n"
				+ ""));
		
		// Java
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
		    "elementId", ((RemoteWebElement) source).getId(),
		    "endX", 712,
		    "endY", 712
		));
		
		String result=driver.findElement(By.xpath("	\n"+ "//android.widget.TextView[@resource-id=\"io.appium.android.apis:id/drag_result_text\"]\n"+ "")).getText();
		Assert.assertEquals(result,"Dropped!");
		
		driver.quit();
		
		
		
	}

	


}
