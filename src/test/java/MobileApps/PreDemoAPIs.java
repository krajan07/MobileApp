package MobileApps;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.remote.SessionId;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class PreDemoAPIs {
	
	static 	AndroidDriver<MobileElement> driver; 
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		System.out.println("Driver Configuratios");
		//APPIUM Server Details
		URL url = new URL ("http://127.0.0.1:4723/wd/hub");	
		
		//Declaring Desired Capabilities
		DesiredCapabilities cap = new DesiredCapabilities() ;

		//Setting Desired Capabilities
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","12");
		cap.setCapability("appPackage","com.touchboarder.android.api.demos");
		cap.setCapability("appActivity","com.touchboarder.androidapidemos.MainActivity");
		
		//Driver creation
		driver = new AndroidDriver<MobileElement>(url, cap);
		System.out.println("Driver Details" + driver);
		
		SessionId sesId = driver.getSessionId();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.print("Session Id = " + sesId);
		Thread.sleep(1000);
			
		String locValue = "//android.widget.Button[@text='Continue']";
		checkAndClick(locValue);
		Thread.sleep(1000);
		locValue = "//android.widget.Button[@text='OK']";
		checkAndClick(locValue);
		Thread.sleep(1000);
		locValue = "//android.widget.TextView[@text='OK']";
		checkAndClick(locValue);
		Thread.sleep(1000);
		locValue = "//android.widget.TextView[@text='API Demos']";
		checkAndClick(locValue);
		Thread.sleep(1000);
		//locValue = "//android.widget.TextView[@text='Views']";
		//checkAndClick(locValue);
		//Thread.sleep(1000);		
		
		clickView("Views");
		clickView("Controls");
		clickView("01. Light Theme");
		driver.hideKeyboard();
		
		//COLLECT THE ELEMENTS OF THE PAGE
		MobileElement Textbox1 = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.touchboarder.android.api.demos:id/edit']"));
		MobileElement Textbox2 = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.touchboarder.android.api.demos:id/edit2']"));
		MobileElement Checkbox1 = driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id='com.touchboarder.android.api.demos:id/check1']"));
		MobileElement Checkbox2 = driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id='com.touchboarder.android.api.demos:id/check2']"));
		MobileElement RadioButton1 = driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.touchboarder.android.api.demos:id/radio1']"));
		MobileElement RadioButton2 = driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.touchboarder.android.api.demos:id/radio2']"));
		MobileElement Star = driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id='com.touchboarder.android.api.demos:id/star']"));
		MobileElement ToggleButton1 = driver.findElement(By.xpath("//android.widget.ToggleButton[@resource-id='com.touchboarder.android.api.demos:id/toggle1']"));
		MobileElement ToggleButton2 = driver.findElement(By.xpath("//android.widget.ToggleButton[@resource-id='com.touchboarder.android.api.demos:id/toggle2']"));
		
		//Send Input to text box
		Textbox1.sendKeys("My");
		Textbox2.sendKeys("Theme1");
	  /*System.out.println("Textbox1 " + Textbox1.getAttribute("text"));
		System.out.println("Textbox2 " + Textbox2.getAttribute("text"));
		
		System.out.println("Checkbox1 " + Checkbox1.getAttribute("checked"));
		System.out.println("Checkbox2 " + Checkbox2.getAttribute("checked"));
		System.out.println("RadioButton1 " + RadioButton1.getAttribute("checked"));
		System.out.println("RadioButton2 " + RadioButton2.getAttribute("checked"));
		System.out.println("Star " + Star.getAttribute("checked"));
		System.out.println("ToggleButton1 " + ToggleButton1.getAttribute("checked"));
		System.out.println("ToggleButton2 " + ToggleButton2.getAttribute("checked"));
	  */
		if(Checkbox1.getAttribute("checked").equals("false")) {
			Checkbox1.click();
		}
		Thread.sleep(300);
		if(Checkbox2.getAttribute("checked").equals("false")) {
			Checkbox2.click();
		}
		Thread.sleep(300);
		if(RadioButton1.getAttribute("checked").equals("false")) {
			RadioButton1.click();
		}
		Thread.sleep(300);
		if(RadioButton2.getAttribute("checked").equals("false")) {
			RadioButton2.click();
		}
		Thread.sleep(300);
		if(Star.getAttribute("checked").equals("false")) {
			Star.click();
		}
		Thread.sleep(300);
		if(ToggleButton1.getAttribute("checked").equals("false")) {
			ToggleButton1.click();
		}
		Thread.sleep(300);
		if(ToggleButton2.getAttribute("checked").equals("false")) {
			ToggleButton2.click();
		}
		Thread.sleep(300);
	  /*System.out.println("Textbox1 " + Textbox1.getAttribute("text"));
		System.out.println("Textbox2 " + Textbox2.getAttribute("text"));
		System.out.println("Checkbox1 " + Checkbox1.getAttribute("checked"));
		System.out.println("Checkbox2 " + Checkbox2.getAttribute("checked"));
		System.out.println("RadioButton1 " + RadioButton1.getAttribute("checked"));
		System.out.println("RadioButton2 " + RadioButton2.getAttribute("checked"));
		System.out.println("Star " + Star.getAttribute("checked"));
		System.out.println("ToggleButton1 " + ToggleButton1.getAttribute("checked"));
		System.out.println("ToggleButton2 " + ToggleButton2.getAttribute("checked"));
	*/
		
		MobileElement Spinner = driver.findElement(By.xpath("//android.widget.Spinner[@resource-id='com.touchboarder.android.api.demos:id/spinner1']"));
		MobileElement Selected = Spinner.findElement(By.id("android:id/text1"));
		System.out.println(Selected.getAttribute("text"));
		Spinner.click();
		Thread.sleep(300);
		List<MobileElement> SpinnerList = driver.findElements(By.xpath("//android.widget.CheckedTextView"));
		for(MobileElement SelectText : SpinnerList) {
			System.out.println(SelectText.getAttribute("text")+ " : " + SelectText.getAttribute("checked"));
			if(SelectText.getAttribute("text").equals("Saturn")) {
				SelectText.click();
				break;
			}
		}
		Thread.sleep(1000);
		Selected = Spinner.findElement(By.id("android:id/text1"));
		System.out.println(Selected.getAttribute("text"));	
	}
	
	private static void clickView(String elemClick) {
		MobileElement parent = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']"));
		List<MobileElement> lstViews = parent.findElements(By.xpath("//android.widget.TextView"));
		System.out.println("\nInformtion is getting displayed for the element " + elemClick + "\r");
		for (MobileElement view : lstViews) {
			System.out.println(view.getAttribute("text"));
			if (view.getAttribute("text").equals(elemClick)) {
				view.click();
				break;
			}
		}
	}
	
	public static void checkAndClick(String locValue) {
		
		List<MobileElement> lstElems = driver.findElements(By.xpath(locValue));
		if (lstElems.size()>0) {
			lstElems.get(0).click();
		}
	}
	
}