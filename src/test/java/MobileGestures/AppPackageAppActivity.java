package MobileGestures;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppPackageAppActivity {
	
	
	@Test
	public void appPackage() throws MalformedURLException, URISyntaxException {
		
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Vamsiphone");
		options.setApp("//Users//vamsisatya//eclipse-workspace//MobileApplication//src//test//java//resources//ApiDemos-debug.apk");
		
		AndroidDriver driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		
		//Activity activity=new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies}");
		((JavascriptExecutor)driver).executeScript("mobile:startActivity",ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies}\n"
				+ ""));
		
		driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id=\"android:id/checkbox\"]\n"+ "")).click();
		driver.findElement(By.xpath("	\n"+ "//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout\n"+ "")).click();
		
		driver.findElement(By.id("android:id/edit")).sendKeys("vamsi");
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]\n"+ "")).click();
		
		
	}
}
