package CrossBrowserDemo;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import Page.ShipmentSearchPage;
import Page.ShipmentSearchPage2;

public class TestBolNumber {
	DesiredCapabilities caps;
	WebDriver driver ;
	ShipmentSearchPage2 page;
	@BeforeClass
	  public void SetUp() throws MalformedURLException {
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
		//  driver = new RemoteWebDriver(new URL("http://Bert.Zhang%40yrcfreight.com:u572009a51020307@hub.crossbrowsertesting.com:80/wd/hub"), caps);
		  driver = new RemoteWebDriver(new URL("http://Kamran.Syed%40yrcfreight.com:u986646c5e9558ff@hub.crossbrowsertesting.com:80/wd/hub"), caps);

		  driver.get("https://my.yrc.com/");
		  driver.manage().window().maximize();
		  page = new ShipmentSearchPage2(driver);
		  page.TrackButton.click(); 
		  (new WebDriverWait(driver, 10))
		  .until(ExpectedConditions.elementToBeClickable(page.BOLNumberTrackingLink));
	      page.BOLNumberTrackingLink.click();
	  }

  @Test(priority=1,dataProvider = "dp")
  public void VerifyMultiResultBOLNum(String TrackNumber, String ShowNumberButton) {
	  page.TrackNumInputBar.clear();
      page.TrackNumInputBar.sendKeys(TrackNumber);
      page.FindShipmentButton.click();
          (new WebDriverWait(driver, 60))
  		  .until(ExpectedConditions.visibilityOf(page.ToInputBar));
          Assert.assertTrue(page.ToInputBar.isDisplayed());
          System.out.println("Multiple Result BOL Numbrt:  "+TrackNumber);
          	 // ClickShowButtonAndVerifyNumber(ShowNumberButton);
          	  List<WebElement> AllRadioButton=page.SelectShipmentTable.findElements(By.xpath("//td[1]"));
          	  List<WebElement> AllProNumber=page.SelectShipmentTable.findElements(By.xpath("//td[2]"));
          	   int Ran=(int)(Math.random()*(AllRadioButton.size()-1));
                AllRadioButton.get(Ran).click();
                (new WebDriverWait(driver, 20))
        		  .until(ExpectedConditions.visibilityOf(page.NumberReference1));
                Assert.assertEquals(page.NumberReference1.getText(),TrackNumber);
                Assert.assertEquals(page.NumberReference2.getText(),AllProNumber.get(Ran).getText() );
                System.out.println("the shipment detail information is correct");
                
  } 
  
  @Test(priority=2,dataProvider = "dp")
  public void VerifyFilterResultByCityFunction(String TrackNumber, String ShowNumberButton, String FromCity, String ToCity){
	  page.TrackNumInputBar.clear();
      page.TrackNumInputBar.sendKeys(TrackNumber);
      page.ShipmentSearchTitle.click();
      page.FindShipmentButton.click();
          (new WebDriverWait(driver, 60))
  		  .until(ExpectedConditions.visibilityOf(page.ToInputBar));
      Assert.assertTrue(page.ToInputBar.isDisplayed());
      System.out.println("Multiple Result BOL Numbrt:  "+TrackNumber);
      ClickShowButtonAndVerifyNumber(ShowNumberButton);
      page.FromInputBar.clear();
      page.ToInputBar.clear();
      page.FromInputBar.sendKeys(FromCity);
      List<WebElement> AllFromCity=page.SelectShipmentTable.findElements(By.xpath("//td[4]"));
      if(AllFromCity.size()>=1){
      for(int i=0; i<AllFromCity.size();i++){
    	  Assert.assertTrue(AllFromCity.get(i).getText().toLowerCase().indexOf(FromCity.toLowerCase())!=-1);  }
      System.out.println("All From cities have:  "+FromCity);
      }else{
    	  System.out.println("There is no From city including:  "+FromCity);
      }
      page.ToInputBar.sendKeys(ToCity);
      List<WebElement> AllToCity=page.SelectShipmentTable.findElements(By.xpath("//td[6]"));
      if(AllToCity.size()>=1){
          for(int i=0; i<AllToCity.size();i++){
        	  Assert.assertTrue(AllToCity.get(i).getText().toLowerCase().indexOf(ToCity.toLowerCase())!=-1); }
          System.out.println("All  To cities have:  "+ToCity);
          }else{
        	  System.out.println("There is no To city including:  "+ToCity);
          }    	
  }
@Test(priority=3,dataProvider = "dp")
public void VerifySingleResultBOLNum(String TrackNumber) {
	page.TrackNumInputBar.clear();
    page.TrackNumInputBar.sendKeys(TrackNumber);
    page.FindShipmentButton.click();
    (new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(page.ShipmentDetailTitle));
    Assert.assertTrue(page.ShipmentDetailTitle.isDisplayed());
    Assert.assertEquals(page.NumberReference1.getText(),TrackNumber);     
    System.out.println("Single Result BOL Number:  "+TrackNumber);
    }

@Test(priority=4,dataProvider = "dp")
public void VerifyNoResultBOLNum(String TrackNumber) {
	page.TrackNumInputBar.clear();
    page.TrackNumInputBar.sendKeys(TrackNumber);
    page.FindShipmentButton.click();
    (new WebDriverWait(driver, 60))
	  .until(ExpectedConditions.visibilityOf(page.NoShipmentResultPrompt));
    Assert.assertTrue(page.NoShipmentResultPrompt.isDisplayed());
    System.out.println("No Result BOL Number:  "+TrackNumber);
}

  public void ClickShowButtonAndVerifyNumber(String ShowNumberButton){
	
	  	if(ShowNumberButton.equalsIgnoreCase("5")){
	  		 page.Show5Button.click();
	  		 List<WebElement> AllItemList=page.SelectShipmentTable.findElements(By.tagName("tr"));
	  		 if(AllItemList.size()<=5+1){
	  			 System.out.println("the amount of displayed items is correct ");
	  		 }else{
	  			 System.out.println("the amount of displayed items is incorrect ");
	  		 }
	  	  }else if(ShowNumberButton.equalsIgnoreCase("25")){
	  		 page.Show25Button.click();
	  		 List<WebElement> AllItemList=page.SelectShipmentTable.findElements(By.tagName("tr"));
	  		 if(AllItemList.size()<=25+1){
	  			 System.out.println("the amount of displayed items is correct ");
	  		 }else{
	  			 System.out.println("the amount of displayed items is incorrect ");
	  		 }
	  	  }else if(ShowNumberButton.equalsIgnoreCase("50")){
	  		 page.Show50Button.click();
	  		 List<WebElement> AllItemList=page.SelectShipmentTable.findElements(By.tagName("tr"));
	  		 if(AllItemList.size()<=50+1){
	  			 System.out.println("the amount of displayed items is correct ");
	  		 }else{
	  			 System.out.println("the amount of displayed items is incorrect ");
	  		 }
	  	  }else if(ShowNumberButton.equalsIgnoreCase("ALL")){
	  		  page.SelectShipmentInformationBar.getText();
	  		  page.ShowALLButton.click();
	  		 List<WebElement> AllItemList=page.SelectShipmentTable.findElements(By.tagName("tr"));
	  		 String[] a=page.SelectShipmentInformationBar.getText().split(" ");
	  		 int TotalResult=Integer.parseInt(a[0]);
	  		 //System.out.println(TotalResult);
	  		 if(AllItemList.size()==TotalResult+1){
	  			 System.out.println("the amount of displayed items is correct ");
	  		 }else{
	  			 System.out.println("the amount of displayed items is incorrect ");
	  		 }
	  		
	  	  }
	  }



  @DataProvider(name ="dp")
  public Object[][] dp(Method m) {
    if(m.getName().equalsIgnoreCase("VerifyMultiResultBOLNum")){
	  return new Object[][] {
			  {"1234","5"}
			  //,{"5","50"},{"9444","all"}
			  };
    }else if(m.getName().equalsIgnoreCase("VerifySingleResultBOLNum")){
    	  return new Object[][] {
    			  {"1612355"},{"004430"},{"5555555"}
        };
    }else if(m.getName().equalsIgnoreCase("VerifyFilterResultByCityFunction")){
  	  return new Object[][] {
			  {"1234","all","h","p"},{"1234","all","on","on"},{"1234","all","zh","ro"}};
    }else {
    	return new Object[][] {
  			  {"6555556"},{"12334456787"}
      };
    }
  }
  
  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
