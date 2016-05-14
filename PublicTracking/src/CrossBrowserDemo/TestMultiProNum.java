package CrossBrowserDemo;

import java.awt.AWTException;
import java.net.MalformedURLException;
import java.net.URL;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Page.ShipmentSearchPage2;
import utility.CommonFunction;

public class TestMultiProNum {
	ShipmentSearchPage2 page;
	String MultipleProNumberEntryPattern;
	int max;
	String[] MultipleProNumberArray;
	String[] MultipleProNumberGetArray;
	String[] MultipleProNumberPreviewArray;
  DesiredCapabilities caps;
  WebDriver driver ;
 
  @BeforeTest
  public void SetUp() throws MalformedURLException {
	  caps = new DesiredCapabilities();
	  caps.setCapability("build", "1.0");
	    caps.setCapability("browser_api_name", "IE11");
	    caps.setCapability("os_api_name", "Win7x64-Base");
	    caps.setCapability("screen_resolution", "1024x768");
	    caps.setCapability("record_video", "true");
	    caps.setCapability("record_network", "true");
	    caps.setCapability("record_snapshot", "false");
	 // driver = new RemoteWebDriver(new URL("http://Bert.Zhang%40yrcfreight.com:u572009a51020307@hub.crossbrowsertesting.com:80/wd/hub"), caps);
	  driver = new RemoteWebDriver(new URL("http://Kamran.Syed%40yrcfreight.com:u986646c5e9558ff@hub.crossbrowsertesting.com:80/wd/hub"), caps);

	  
	  driver.get("https://my.yrc.com/tools/#/track/shipments?referenceNumberType=PRO");
	  driver.manage().window().maximize();
  } 
@Test(priority=1)
 public void Verify10ProNumInputBar() {
	  page= new  ShipmentSearchPage2(driver);
		 for (int i = 0; i<8; i++){
			 driver.findElement(By.xpath("//*[contains(text(),'Add PRO')]")).click();}
			 for (int j = 0; j<9; j++){
			 int k = j+2;
			 String a = k+"";
			 String xpath = "//*[@id='shipmentSearchForm']/div["+ a +"]/div/div/div[1]/span/input";
			 //System.out.println(xpath);
			 driver.findElement(By.xpath(xpath)).sendKeys(a); }
			 
			 for (int x = 0; x<8; x++){
			 driver.findElement(By.xpath("//*[@id='shipmentSearchForm']/div[2]/div/div/div[2]/button[2]")).click(); } 
 }
  @Test(priority=2,dataProvider ="dp1")
  public void VerifyMultipleEntries(String MultipleProNumber,String SplitApproach) throws InterruptedException, AWTException{
		page= new ShipmentSearchPage2(driver);
		CommonFunction.VerifyHelpIcon(driver);
	    CommonFunction.VerifyWhatIsProNumLink(driver);
		page.MultiPROEntryIcon.click();
		
		//(new WebDriverWait(driver, 3))
		 // .until(ExpectedConditions.elementToBeClickable(multiProPage.SaveToSearchButton));
		
		if(SplitApproach.equalsIgnoreCase("spaces")){
			if(!page.SpacesCheckBox.isSelected()){page.SpacesCheckBox.click();}
			if(page.TabsCheckBox.isSelected()){page.TabsCheckBox.click();}
			MultipleProNumberEntryPattern="[ ,]+";		
		}else if(SplitApproach.equalsIgnoreCase("tabs")){
			if(page.SpacesCheckBox.isSelected()){page.SpacesCheckBox.click();}
			if(!page.TabsCheckBox.isSelected()){page.TabsCheckBox.click();}
			MultipleProNumberEntryPattern="[	,]+";
		}else if(SplitApproach.equalsIgnoreCase("combine")){
			if(!page.SpacesCheckBox.isSelected()){page.SpacesCheckBox.click();}
			if(!page.TabsCheckBox.isSelected()){page.TabsCheckBox.click();}
			MultipleProNumberEntryPattern="[	, ]+";
		}else if(SplitApproach.equalsIgnoreCase("default")){
			if(page.SpacesCheckBox.isSelected()){page.SpacesCheckBox.click();}
			if(page.TabsCheckBox.isSelected()){page.TabsCheckBox.click();}
			 MultipleProNumberEntryPattern="[,]+";	
		}else{
			System.out.println("please select a correct split approach");
		}
		 page.MultipleProEntryInputBar.sendKeys(MultipleProNumber);
		 List<WebElement> AllPreviewProNum=page.PreviewInformationList.findElements(By.tagName("li"));
		MultipleProNumberPreviewArray=new String[AllPreviewProNum.size()];
		for(int i=0;i<AllPreviewProNum.size();i++){	
			MultipleProNumberPreviewArray[i]=AllPreviewProNum.get(i).getText();
			//System.out.println(AllPreviewProNum.size()+" "+AllPreviewProNum.get(i).getText());
			}
		page.SaveToSearchButton.click();
		List<WebElement> AllInputBar=page.ShipmentSearchForm.findElements(By.xpath("//span/input"));
		max=10;
		if(max>AllInputBar.size()){
			max=AllInputBar.size();
		}
		MultipleProNumberArray = new String[max];
		for(int i=0;i<max;i++){
		MultipleProNumberArray[i]=MultipleProNumber.split(MultipleProNumberEntryPattern)[i];
		//for(WebElement IndividualInputBar:AllInputBar)	
		//}
		}
		
		MultipleProNumberGetArray=new String[AllInputBar.size()];
		for(int i=0;i<AllInputBar.size();i++){
			MultipleProNumberGetArray[i]=AllInputBar.get(i).getAttribute("value");
			//System.out.println(AllInputBar.get(i).getAttribute("value"));
			}
			
		    Assert.assertEquals(MultipleProNumberGetArray,MultipleProNumberArray);
		    Assert.assertEquals(MultipleProNumberPreviewArray,MultipleProNumberArray);

			MultipleProNumberGetArray=new String[AllInputBar.size()];
			for(int i=0;i<AllInputBar.size();i++){
				
				MultipleProNumberGetArray[i]=AllInputBar.get(i).getAttribute("value");
				//System.out.println(AllInputBar.get(i).getAttribute("value"));
				}
				Assert.assertEquals(MultipleProNumberGetArray,MultipleProNumberArray);
				List<WebElement> AllInvalidPrompt=page.ShipmentSearchForm.findElements(By.xpath("//div[1]/small[2]"));
				List<WebElement> AllRemoveButton=page.ShipmentSearchForm.findElements(By.xpath("//div[2]/button[2]"));
				for (int i=0;i<AllInputBar.size();i++){
					if(AllInvalidPrompt.get(i).isDisplayed()){
						AllRemoveButton.get(i).click();
					}
				}
				
				page.ShipmentSearchForm.findElement(By.xpath("//form/div/div/div/button")).click();
				//(new WebDriverWait(driver, 50))
				  //.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" html/body/div[3]/div[2]/div/div/div/div[2]/div/div[1]/div[1]/h4")));
				(new WebDriverWait(driver, 50))
				  .until(ExpectedConditions.visibilityOf(page.ProNmber));
				List<WebElement> AllMultipleProNumber=page.MultipleProNumberList.findElements(By.tagName("a"));
				//System.out.println(AllMultipleProNumber.size());
				for(int i=0;i<AllMultipleProNumber.size();i++){
					(new WebDriverWait(driver, 5))
					  .until(ExpectedConditions.elementToBeClickable(AllMultipleProNumber.get(i)));
					AllMultipleProNumber.get(i).click();
					 (new WebDriverWait(driver, 5))
					  .until(ExpectedConditions.visibilityOf(page.ProNmber));
					Assert.assertEquals(page.ProNmber.getText(), AllMultipleProNumber.get(i).getText());
					
					
					
						CommonFunction.printButtonFunctionality(driver,"print");
				
					    
						CommonFunction.EmailFunctionality(driver,"zhtaozhang@gmail.com", "bertzhang0802@gmail.com", "Bert.Zhang@YRCFreight.com");
					    CommonFunction.VerifyChatIcon(driver); 
					    CommonFunction.VerifyFlagIcon(driver);
					
				}
				
	}
@AfterTest
public void afterTest() {
	  driver.close();
}
@DataProvider(name ="dp1")
public Object[][] createData2() {
  
  return new Object[][] {
  		 {"111111111,222222222 3,411111111,5 666666666,2 123456789,444444444,433333333","spaces"}	  
   		  };
  }
}
