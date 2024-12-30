package MobileGestures;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;

public class MisceallanousAppiumApplication {
	
	@Test
	public void rotation() throws MalformedURLException, URISyntaxException {
	
	UiAutomator2Options options=new UiAutomator2Options();
	options.setDeviceName("Vamsiphone");
	options.setApp("//Users//vamsisatya//eclipse-workspace//MobileApplication//src//test//java//resources//ApiDemos-debug.apk");
	
	AndroidDriver driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
	
	
	
	driver.findElement(AppiumBy.accessibilityId("Preference")).click();
	driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]\n"+ "")).click();
	driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id=\"android:id/checkbox\"]\n"+ "")).click();
	
	//DeviceRotation landscape=new DeviceRotation(0, 0, 90);
	//driver.rotate(landscape);
	
	
	
	driver.findElement(By.xpath("	\n"+ "//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout\n"+ "")).click();
	String title=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]\n"+ "")).getText();
	Assert.assertEquals(title,"WiFi settings");
	driver.findElement(By.id("android:id/edit")).sendKeys("vamsi");
	driver.pressKey(new KeyEvent(AndroidKey.ENTER));
	driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]\n"+ "")).click();
	
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	driver.pressKey(new KeyEvent(AndroidKey.HOME));
	
	
	driver.quit();
	
	}

}
