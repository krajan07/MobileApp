package MobileApps;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import javax.xml.transform.Source;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.testng.annotations.AfterTest;


public class GoogleMap {
	static 	AndroidDriver<MobileElement> driver;
	
	 
 
  @BeforeClass
  public void beforeClass() throws InterruptedException, MalformedURLException {
	 // this.driver=driver;
	  System.out.println("Driver Configuratios");
		//APPIUM Server Details
		URL url = new URL ("http://127.0.0.1:4723/wd/hub");	
		System.out.println("URL" + url);
		//Declaring Desired Capabilities
		DesiredCapabilities cap = new DesiredCapabilities() ;
		//Setting Desired Capabilities
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","12");
		//cap.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");	
		cap.setCapability("appPackage", "com.google.android.apps.maps");
		cap.setCapability("appActivity", "com.google.android.maps.MapsActivity");

		//Driver creation
		driver = new AndroidDriver<MobileElement>(url, cap);
		System.out.println("Driver Details" + driver);
		SessionId sesId = driver.getSessionId();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.print("Session Id = " + sesId);
		Thread.sleep(1000);  
		driver.findElement(By.xpath("//android.widget.Button[@text='SKIP']")).click();
		Thread.sleep(3000);

  }
  
  @Test
  public void testZoomOutMaps() throws InterruptedException {
		int height = driver.manage().window().getSize().getHeight();
		int width = driver.manage().window().getSize().getWidth();
		int startX = (int) (width*0.5);
		int startY = (int) (height*0.5);
		int endX = startX - 200;
		int endY = startY - 200;
		int startX2 = startX+50;
		int startY2 = startY+50;
		int endX2 = startX + 350;
		int endY2 = endY + 350;
		System.out.println(startX);
		System.out.println(startY);
		TouchAction action1 = new TouchAction(driver);
		action1.press(PointOption.point(startX, startY)).release().perform();
		Thread.sleep(3000);
		action1.press(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release();
		TouchAction action2 = new TouchAction(driver);
		action2.press(PointOption.point(startX2, startY2)).moveTo(PointOption.point(endX2, endY2)).release();
		MultiTouchAction action = new MultiTouchAction(driver);
		action.add(action1);
		action.add(action2);
		action.perform();
		Thread.sleep(3000);
		
	}

  @AfterTest
  public void tearDown() throws Exception {
	//close the app
      driver.quit();
	}

}
