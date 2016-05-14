package CrossBrowserDemo;

import java.awt.AWTException;
import java.net.MalformedURLException;
import java.net.URL;

import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Page.ShipmentSearchPage2;
import utility.CommonFunction;

public class TestSingleProNum {
	ShipmentSearchPage2 page;
	String MultipleProNumberEntryPattern;
	int max;
	String[] MultipleProNumberArray;
	String[] MultipleProNumberGetArray;
	String[] MultipleProNumberPreviewArray;
  DesiredCapabilities caps;
  WebDriver driver ;
 
  @BeforeClass
  public void SetUp() throws MalformedURLException {
	  caps = new DesiredCapabilities();
	  caps.setCapability("name", "Selenium Test Example");
	    caps.setCapability("build", "1.0");
	    caps.setCapability("browser_api_name", "Chrome43");
	    caps.setCapability("os_api_name", "Win7x64-C1");
	    caps.setCapability("screen_resolution", "1024x768");
	    caps.setCapability("record_video", "true");
	    caps.setCapability("record_network", "true");
	    caps.setCapability("record_snapshot", "false");

	  
	  /*
	  caps = new DesiredCapabilities();
	  caps.setCapability("name", "Selenium Test Example");
	  caps.setCapability("name", "Selenium Test Example");
	  caps.setCapability("name", "Selenium Test Example");
	    caps.setCapability("build", "1.0");
	    caps.setCapability("browser_api_name", "IE10");
	    caps.setCapability("os_api_name", "Win7x64-C2");
	    caps.setCapability("screen_resolution", "1024x768");
	    caps.setCapability("record_video", "true");
	    caps.setCapability("record_network", "true");
	    caps.setCapability("record_snapshot", "false");
	    */
	    
	 // driver = new RemoteWebDriver(new URL("http://Bert.Zhang%40yrcfreight.com:u572009a51020307@hub.crossbrowsertesting.com:80/wd/hub"), caps);
      driver = new RemoteWebDriver(new URL("http://Kamran.Syed%40yrcfreight.com:u986646c5e9558ff@hub.crossbrowsertesting.com:80/wd/hub"), caps);

	  
	  
	  driver.get("https://my.yrc.com/");
	  driver.manage().window().maximize();
	  page = new ShipmentSearchPage2(driver);
	  page.TrackButton.click(); 
	  (new WebDriverWait(driver, 10))
	  .until(ExpectedConditions.elementToBeClickable(page.PRONumberTrackingLink));
      page.PRONumberTrackingLink.click();
  }

  //@Test(priority=1)
  public void VerifyHelpIcon() {
	  CommonFunction.VerifyHelpIcon(driver);
  }
  //@Test(priority=2)
  public void VerifyProNumLink() {
	  CommonFunction.VerifyWhatIsProNumLink(driver);
  }
 
  //@Test(priority=3,dataProvider ="dp2")
  public void VerifySearchSingleProWithoutResult(String ProNumber) {
	  CommonFunction.VerifyPatternOfProNumber(driver, ProNumber);
	 
	  if(page.FindShipmentButton.isEnabled()){
			page.FindShipmentButton.click();			
				(new WebDriverWait(driver, 5))
			  .until(ExpectedConditions.visibilityOf(page.NoShipmentResultPrompt));
			String[] NoResultInformation=page.NoShipmentResultPrompt.findElement(By.tagName("li")).getText().split(" ");		
			String NoResultTrackNum=NoResultInformation[2];
			System.out.println(NoResultTrackNum);
			 System.out.println(page.NoShipmentResultPrompt.findElement(By.tagName("li")).getText());
	        Assert.assertTrue(NoResultTrackNum.replace("-", "").contains(ProNumber.replace("-", "")));
	        System.out.println("the information match the pro number"+"   "+ProNumber);
			}else{
			System.out.println("invalidate data:  "+ProNumber);
		}
	}
  @Test(priority=4,dataProvider ="dp2")
  public void VerifySearchSingleProWithResult(String ProNumber) {
	  CommonFunction.VerifyPatternOfProNumber(driver, ProNumber);
	  //page = new ShipmentSearchPage2(driver);
	  if(page.FindShipmentButton.isEnabled()){
			page.FindShipmentButton.click();		
		(new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOf(page.ShipmentDetailTitle));
	 String numberreference = page.NumberReference1.getText();
	 Assert.assertTrue(numberreference.replace("-", "").indexOf(ProNumber.replace("-", ""))!=-1);
	          System.out.println("the information match the pro number"+"   "+ProNumber);
			}else{
			System.out.println("invalidate data:   "+ProNumber);
		}
	}
  //@Test(priority=5)
  public void VerifyEmailFunction() {
	  CommonFunction.EmailFunctionality(driver,"Bert.Zhang@YRCFreight.com", "Bert.Zhang@YRCFreight.com", "Bert.Zhang@YRCFreight.com");
 
  }
 //@Test(priority=9)
  public void VerifyPrintFunction() throws InterruptedException, AWTException {
	  CommonFunction.printButtonFunctionality(driver,"print"); 
  }

  //@Test(priority=7)
  public void VerifyChatFunction() {
	  CommonFunction.VerifyChatIcon(driver); 
  }
  //@Test(priority=8)
  public void VerifyNotification() {
	  CommonFunction.VerifyFlagIcon(driver);
  }
 
  @AfterClass
  public void afterTest() {
	  driver.close();
  }

  
  @DataProvider(name ="dp2")
  public Object[][] dp2(Method m) {
    if(m.getName().equalsIgnoreCase("VerifySearchSingleProWithResult")){
    	return new Object[][] {
       		 {"123456789"}	  
         	,{"1234567898"}};
    }else {
    	 return new Object[][] {
    	   {"411111111"}, {"433333333"} };
    }
    	
}
  }
