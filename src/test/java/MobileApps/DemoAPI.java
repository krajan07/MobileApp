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


public class DemoAPI {
	static 	AndroidDriver<MobileElement> driver;
	
	private static void checkAndClick(String locValue) {
		List<MobileElement> lstElems = driver.findElements(By.xpath(locValue));
		if (lstElems.size()>0) {
			lstElems.get(0).click();
		}
	}
  
  private static void clickView1(String elemClick) {
		MobileElement parent = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']"));
		List<MobileElement> lstViews = parent.findElements(By.xpath("//android.widget.TextView"));
		for (MobileElement view : lstViews) {
			//System.out.println(view.getAttribute("text"));
			if (view.getAttribute("text").equals(elemClick)) {
				view.click();
				break;
			}
		}
	}
  
//Click View
  private void clickView(String element) throws InterruptedException {
		
	  boolean flagView = false;
	  while(!flagView)
	  {
	  MobileElement parent = driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id='android:id/content']"));
	   List<MobileElement> lstViews = parent.findElements(By.xpath("//android.widget.TextView"));
		for (MobileElement view : lstViews) {
			System.out.println(view.getAttribute("text"));
			if (view.getAttribute("text").equals(element)) {
				view.click();
				flagView = true;
				break;
			}
		}
		Thread.sleep(1000);
		if(!flagView) {
			scrollUp();
			
		}
	  }	
}
  
  public boolean isSelected(String id) {
      MobileElement me = driver.findElement(By.id(id));
      boolean status = false;
      if (me.getAttribute("checked").equals("true")) {
          status = true;
      }
      return status;
  }
  
  public boolean isSelected(MobileElement me) {
      
      boolean status = false;
      if (me.getAttribute("checked").equals("true")) {
          status = true;
      }
      return status;
  }
  
 
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
		clickView1("Views");
		//clickView("Controls");
		//clickView("01. Light Theme");
		driver.hideKeyboard();

  }
  	
  @Test
  public void testFirstName() throws InterruptedException {
	  MobileElement Textbox1 = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.touchboarder.android.api.demos:id/edit']"));
	  Textbox1.sendKeys("My");
	  System.out.println("Textbox1 " + Textbox1.getAttribute("text"));
	  Thread.sleep(300);
  }
  
  @Test
  public void testSecondName() throws InterruptedException {
	  MobileElement Textbox2 = driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.touchboarder.android.api.demos:id/edit2']"));
	  Textbox2.sendKeys("TestName");
	  System.out.println("Textbox2 " + Textbox2.getAttribute("text"));
	  Thread.sleep(300);
  }
  
  @Test
  public void CheckBox1() throws InterruptedException {
	  MobileElement Checkbox1 = driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id='com.touchboarder.android.api.demos:id/check1']"));
	  if(Checkbox1.getAttribute("checked").equals("false")) {
			Checkbox1.click();
		}
		Thread.sleep(300);
  }
  
  @Test
  public void CheckBox2() throws InterruptedException {
	  MobileElement Checkbox2 = driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id='com.touchboarder.android.api.demos:id/check2']"));
	  if(Checkbox2.getAttribute("checked").equals("false")) {
		  Checkbox2.click();
		}
		Thread.sleep(300);
  }
  
  @Test
  public void RadioButton1() throws InterruptedException {
	MobileElement RadioButton1 = driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.touchboarder.android.api.demos:id/radio1']"));
	  if(RadioButton1.getAttribute("checked").equals("false")) {
		  RadioButton1.click();
		}
		Thread.sleep(300);
  }
  
  @Test
  public void RadioButton2() throws InterruptedException {
	MobileElement RadioButton2 = driver.findElement(By.xpath("//android.widget.RadioButton[@resource-id='com.touchboarder.android.api.demos:id/radio2']"));
	  if(RadioButton2.getAttribute("checked").equals("false")) {
		  RadioButton2.click();
		}
		Thread.sleep(300);
  }
  
  
  @Test
  public void ToggleButton1() throws InterruptedException {
	MobileElement ToggleButton1 = driver.findElement(By.xpath("//android.widget.ToggleButton[@resource-id='com.touchboarder.android.api.demos:id/toggle1']"));
	  if(ToggleButton1.getAttribute("checked").equals("false")) {
		  ToggleButton1.click();
		}
		Thread.sleep(300);
  }
  
  @Test
  public void ToggleButton2() throws InterruptedException {
	MobileElement ToggleButton2 = driver.findElement(By.xpath("//android.widget.ToggleButton[@resource-id='com.touchboarder.android.api.demos:id/toggle2']"));
	  if(ToggleButton2.getAttribute("checked").equals("false")) {
		  ToggleButton2.click();
		}
		Thread.sleep(300);
  }
  
  @Test
  public void Star() throws InterruptedException {
	MobileElement Star = driver.findElement(By.xpath("//android.widget.CheckBox[@resource-id='com.touchboarder.android.api.demos:id/star']"));	
	  if(Star.getAttribute("checked").equals("false")) {
		  Star.click();
		}
		Thread.sleep(300);
  }
  
  @Test
  public void testSpinner() {
	  clickView1("Views");
      MobileElement spinner = driver.findElement(By.id("com.touchboarder.android.api.demos:id/spinner1"));
      MobileElement selectedTV = spinner.findElement(By.id("android:id/text1"));
      //Getting the default selected value
      System.out.println(selectedTV.getAttribute("text"));
      spinner.click();    
      List<MobileElement> lstTVs = driver.findElements(By.xpath("//android.widget.CheckedTextView"));
      for (MobileElement tv : lstTVs) {
          System.out.println(tv.getAttribute("text")+" "+tv.getAttribute("checked"));
          if (tv.getAttribute("text").equals("Saturn")) {
              tv.click();
              
          }
      }
      selectedTV = spinner.findElement(By.id("android:id/text1"));
      System.out.println(selectedTV.getAttribute("text"));
  }


  @Test
  public void testSeekBar() throws InterruptedException {
	  clickView("Seek Bar");
	  MobileElement seekbar = driver.findElement(By.id("com.touchboarder.android.api.demos:id/seek"));
		int startX = seekbar.getLocation().getX();
		int startY = seekbar.getLocation().getY();


		int width = seekbar.getSize().getWidth();
		int endX = (int) (0.8*width + startX);
		int endY = startY;

		TouchAction action = new TouchAction(driver);
		action.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();

		for (int i = 0; i < 40; i++) {
			Thread.sleep(4000);
		}
  }
  
  @Test
  public void testWebView() throws InterruptedException {
	  clickView("SearchEarPhones");
	  Set<String> contextHandles = driver.getContextHandles();
	  System.out.println(contextHandles.size());
	  for(String cName : contextHandles) {
		  System.out.println(cName);
	  }
	  //driver.context((String) contextHandles.toArray()[]);
		for (int i = 0; i < 20; i++) {
			Thread.sleep(4000);
		}
  }
    
@Test
		public void testScroll() {
			scrollUp();
		}
		public void scrollUp() {
		int height = driver.manage().window().getSize().getHeight();
		int width = driver.manage().window().getSize().getWidth();
		int startX = (int) (0.5 * width);
		int endX = (int) (0.5 * width);
		int startY = (int) (0.90 * height);
		int endY = (int) (0.5 * height);
		TouchAction action = new TouchAction(driver);
		action.longPress(PointOption.point(startX, startY)).moveTo(PointOption.point(endX, endY)).release().perform();
		try {
				Thread.sleep(3000);
			} catch (Exception ex) {
		}
		}
  
  @Test
  public void testDragDrop() throws InterruptedException {
	  clickView("Drag and Drop");
	  MobileElement drag = driver.findElement(By.id("com.touchboarder.android.api.demos:id/drag_dot_3"));
	  MobileElement drop = driver.findElement(By.id("com.touchboarder.android.api.demos:id/drag_dot_2"));		  
    	int startX = drag.getLocation().getX();
		int startY = drag.getLocation().getY();
		//endX = drop
		dragDrop(drag,drop);
		for (int i = 0; i < 40; i++) {
			Thread.sleep(5000);

		}
	}
private void dragDrop(MobileElement source, MobileElement target) {
	//get X and Y for Source
	//get X and Y for Target

	}


	

  @AfterTest
  public void tearDown() throws Exception {
	//close the app
      driver.quit();
	}

}
