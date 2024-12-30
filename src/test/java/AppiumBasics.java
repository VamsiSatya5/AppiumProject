
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics {

	@Test
public void Appiumtest() throws MalformedURLException, URISyntaxException {
		
		/*AppiumDriverLocalService service=new AppiumServiceBuilder().withAppiumJS((new File("//usr//local//lib//node_modules//appium//build//lib//main.js")))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();  //start server*/
		
		//AndroidDriver 
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Vamsiphone");
		options.setApp("//Users//vamsisatya//eclipse-workspace//MobileApplication//src//test//java//resources//ApiDemos-debug.apk");
		
		AndroidDriver driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"3. Preference dependencies\"]\n"+ "")).click();
		driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id=\"android:id/checkbox\"]\n"+ "")).click();
		driver.findElement(By.xpath("	\n"+ "//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[2]/android.widget.RelativeLayout\n"+ "")).click();
		String title=driver.findElement(By.xpath("//android.widget.TextView[@resource-id=\"android:id/alertTitle\"]\n"
				+ "")).getText();
		Assert.assertEquals(title,"WiFi settings");
		driver.findElement(By.id("android:id/edit")).sendKeys("vamsi");
		driver.findElement(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]\n"+ "")).click();
		
		
		
		
		
		
		driver.quit();
		
		//service.stop();//stop server
		
	
}

}

