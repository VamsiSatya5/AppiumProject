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

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class ScrollGesture  {
	
	@Test
	public void scrollGesture() throws MalformedURLException, URISyntaxException {
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Vamsiphone");
		options.setApp("//Users//vamsisatya//eclipse-workspace//MobileApplication//src//test//java//resources//ApiDemos-debug.apk");
		
		AndroidDriver driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(),options);
		
		driver.findElement(By.xpath("	\n"+ "//android.widget.TextView[@content-desc=\"Views\"]\n"+ "")).click();
		
		//Using Android Ui Automator
		
		//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));
		
		//WebElement element=driver.findElement(By.xpath("	\n"+ "//android.widget.TextView[@content-desc=\"WebView\"]\n"+ ""));
		
		boolean scrollmore;
		
		do {
		
		scrollmore=(Boolean)((JavascriptExecutor)driver).executeScript("mobile: scrollGesture",ImmutableMap.of("top",100,"width",200,"height",200,"left",100,"direction","down","percent",3.0));
		
		}while(scrollmore);
	}

}
