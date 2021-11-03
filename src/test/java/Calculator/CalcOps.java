package Calculator;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class CalcOps {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		System.out.println("Driver Configuratios");
		// APPIUM Server Details
		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		// Declaring Desired Capabilities
		DesiredCapabilities cap = new DesiredCapabilities();

		// Setting Desired Capabilities
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "12");
		cap.setCapability("appPackage", "com.google.android.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");

		// Driver creation
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, cap);
		System.out.println("Driver Details" + driver);

		SessionId sesId = driver.getSessionId();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.print("Session Id = " + sesId);
		Thread.sleep(1000);

		// Mobile Element
		driver.findElement(By.xpath("//android.widget.Button[@text='9']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='+']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='5']")).click();
		driver.findElement(By.xpath("//android.widget.Button[@text='=']")).click();

		Thread.sleep(1000);
		String Result = driver.findElement(By.xpath("//android.widget.TextView")).getAttribute("text");
		System.out.print("\n\n");
		System.out.print("Result = " + Result);

		for (int i = 0; i < 60; i++) {
			Thread.sleep(5000);
		}

		System.out.print("\n" + "Execution Completed" + "\n");
	}

}
