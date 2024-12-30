import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class BaseTest {
	
	public AndroidDriver driver;
	
	
	@BeforeClass
	
	public void configureAppium() throws MalformedURLException, URISyntaxException {
		

		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("Vamsiphone");
		options.setApp("//Users//vamsisatya//eclipse-workspace//MobileApplication//src//test//java//resources//ApiDemos-debug.apk");
		
		driver=new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);

	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
