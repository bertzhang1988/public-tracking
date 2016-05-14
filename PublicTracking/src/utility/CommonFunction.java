package utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Page.ChatWindowPage;
import Page.NotificationPage;
import Page.ShipmentSearchPage;
import Page.ShipmentSearchPage2;

public class CommonFunction {/* verify the help icon, chat icon, printer icon, email icon, flag icon*/
	static WebDriver driver;
	static ShipmentSearchPage2 page;

public static void VerifyHelpIcon(WebDriver driver){
	   page= new  ShipmentSearchPage2(driver);
	   (new WebDriverWait(driver, 50))
		  .until(ExpectedConditions.elementToBeClickable(page.HelpIcon));
	   page.HelpIcon.click();
		(new WebDriverWait(driver, 5))
		  .until(ExpectedConditions.visibilityOf(page.ShipmentSearchHelpTitle));
		Assert.assertTrue(page.ShipmentSearchHelpTitle.isDisplayed());
		page.ShipmentSearchHelpCancel.click();
	}	

public static void VerifyWhatIsProNumLink(WebDriver driver){
	   page= new  ShipmentSearchPage2(driver);
	   (new WebDriverWait(driver, 50))
		  .until(ExpectedConditions.elementToBeClickable(page.ProNumLink));
	   page.ProNumLink.click();
		(new WebDriverWait(driver, 5))
		  .until(ExpectedConditions.visibilityOf(page.ProNumDefin));
		Assert.assertTrue(page.ProNumDefin.isDisplayed());
		page.CloseButton.click();
	}	
public static void  printButtonFunctionality(WebDriver driver, String PrintCommand) throws InterruptedException, AWTException {
	Robot rb = new Robot();
    page= new  ShipmentSearchPage2(driver);
    (new WebDriverWait(driver, 50))
	  .until(ExpectedConditions.elementToBeClickable(page.PrintIcon));
  
if(page.ShipmentDetailTitle.isDisplayed()){
   
	Actions a=new Actions(driver);
    a.moveToElement(page.PrintIcon).clickAndHold();
    a.perform();  
    rb.keyPress(KeyEvent.VK_ENTER);
	rb.keyRelease(KeyEvent.VK_ENTER);
	a.release();
	a.perform();
	//page.PrintIcon.click();
	Thread.sleep(2000);
	if(PrintCommand.equalsIgnoreCase("PRINT")){
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("the track information is printing, please check the printer");
	}else if(PrintCommand.equalsIgnoreCase("CANCEL")){
		rb.keyPress(KeyEvent.VK_CANCEL);
		rb.keyRelease(KeyEvent.VK_CANCEL);
		System.out.println("the track information printing command gets cancelled");
	}else{
		System.out.println("please give a correct command, only accept print or cancel");
	}
		}
      Thread.sleep(2000);    
}


public static void EmailFunctionality(WebDriver driver,String EmailOne,String EmailTwo, String EmailThree){
     	
page= new  ShipmentSearchPage2(driver);
	(new WebDriverWait(driver, 50))
	  .until(ExpectedConditions.elementToBeClickable(page.EmailIcon));
 page.EmailIcon.click();	
 page.FirstEmailInputBar.clear(); 
 page.FirstEmailInputBar.sendKeys(EmailOne);
 page.SecondEmailInputBar.clear();
 page.SecondEmailInputBar.sendKeys(EmailTwo);
 page.ThirdEmailInputBar.clear();
 page.ThirdEmailInputBar.sendKeys(EmailThree);
 page.SendEmailButton.click();
 //System.out.println(page.EmailSendedSucPrompt.getText());
 page.CancelMark.click();
}

public static void VerifyFlagIcon(WebDriver driver){
    
    page= new  ShipmentSearchPage2(driver);
    String GetProNum;
   if(page.TitleReference1.getText().equalsIgnoreCase("PRO #:")){
	   GetProNum =page.NumberReference1.getText();
	   }else{
		   GetProNum=page.NumberReference2.getText();
       }
    (new WebDriverWait(driver, 50))
	  .until(ExpectedConditions.elementToBeClickable(page.NotificationIcon));	
	page.NotificationIcon.click();
	String ShipmentSearchPageHandle= driver.getWindowHandle();
	Set<String> handles=driver.getWindowHandles();
	for(String hd:handles){
		if(!hd.equals(ShipmentSearchPageHandle)){
			driver.switchTo().window(hd);
		}
	}
	Assert.assertEquals("my.yrc.com: Shipment Status and Document Notification | YRC", driver.getTitle());
	NotificationPage NotiPage=new NotificationPage( driver);
	Assert.assertEquals(NotiPage.ProNumberInputBar.getAttribute("value"), GetProNum.replace("-", ""));
	(new WebDriverWait(driver, 50))
	  .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("html/body/div[2]/table/tbody/tr[2]/td/table/tbody/tr/td/div/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr/td[1]/span"))));	
     driver.close();
     driver.switchTo().window(ShipmentSearchPageHandle);
  
}

public static void VerifyChatIcon(WebDriver driver){
    page= new  ShipmentSearchPage2(driver);
    String GetProNum;
   if(page.TitleReference1.getText().equalsIgnoreCase("PRO #:")){
	   GetProNum =page.NumberReference1.getText();
	   }else{
		   GetProNum=page.NumberReference2.getText();
       }
   
 (new WebDriverWait(driver, 50))
  	  .until(ExpectedConditions.elementToBeClickable(page.ChatIcon));	
	page.ChatIcon.click();
	
	String ShipmentSearchPageHandle= driver.getWindowHandle();
	Set<String> handles=driver.getWindowHandles();
	for(String hd:handles){
		if(!hd.equals(ShipmentSearchPageHandle)){
			driver.switchTo().window(hd);
		           }
	            }
	 driver.manage().window().maximize();
	 ChatWindowPage CWP=new ChatWindowPage(driver);
	 Assert.assertEquals("Chat Window", driver.getTitle());
	 driver.switchTo().frame("initialtextFrame");
	 Assert.assertTrue(CWP.TrackingRadioButton.isSelected());
	 Assert.assertEquals(CWP.TrakingNumberInputBar.getAttribute("value"), GetProNum);
       driver.close();
       driver.switchTo().window(ShipmentSearchPageHandle);
}
public static void VerifyPatternOfProNumber(WebDriver driver,String ProNumber)  {
	String PureProNumber;
	page = new ShipmentSearchPage2(driver);	
	    //page.PROTab.click();
		
		//(new WebDriverWait(driver, 3))
		 // .until(ExpectedConditions.elementToBeClickable(page.FindShipmentButton));
	    page.TrackNumInputBar.clear();
	    String ProNumberPattern="(\\d{9}[\\dxX]?)";
	    page.TrackNumInputBar.sendKeys(ProNumber);
	    PureProNumber=ProNumber.replace("-", "");//remove all hyphens when judge
	   if(PureProNumber.matches(ProNumberPattern)){
		   if(PureProNumber.length()==10){
			  if(Integer.parseInt(PureProNumber.substring(3, 9))%11==1)
			      {
				   if(PureProNumber.substring(9).equalsIgnoreCase("x"))
				   {
					   Assert.assertTrue(page.FindShipmentButton.isEnabled());
				   }else
				   {
					   Assert.assertFalse(page.FindShipmentButton.isEnabled());
					   Assert.assertTrue(page.TrackNumInputPrompt.isDisplayed());
					   Assert.assertEquals("Invalid PRO Number", page.TrackNumInputPrompt.getText());
				   }
			      }else if(Integer.parseInt(PureProNumber.substring(3, 9))%11==0){ 
					   if(PureProNumber.substring(9).equalsIgnoreCase("0")){
						   Assert.assertTrue(page.FindShipmentButton.isEnabled());
				       }else{
					   Assert.assertFalse(page.FindShipmentButton.isEnabled());
					   Assert.assertTrue(page.TrackNumInputPrompt.isDisplayed());
					   Assert.assertEquals("Invalid PRO Number", page.TrackNumInputPrompt.getText());
				       }
				   
			      }else{ 
			    	  if(11-(Integer.parseInt(PureProNumber.substring(3, 9))%11)==(PureProNumber.charAt(9)-'0'))
			           {
					    Assert.assertTrue(page.FindShipmentButton.isEnabled());
				       }else{
					    Assert.assertFalse(page.FindShipmentButton.isEnabled());
					    Assert.assertTrue(page.TrackNumInputPrompt.isDisplayed());
					    Assert.assertEquals("Invalid PRO Number", page.TrackNumInputPrompt.getText());
				             }
			    	    } 
			  }else{ 
			           Assert.assertTrue(page.FindShipmentButton.isEnabled());
		           }
		   
	   }else if(PureProNumber.equals(""))
	   {    
		   Assert.assertFalse(page.FindShipmentButton.isEnabled());
		   //Assert.assertTrue(page.FindShipmentButton.isEnabled());
		   System.out.println(page.TrackNumInputPrompt.getText());
	   }else{ 
	     Assert.assertFalse(page.FindShipmentButton.isEnabled());
	     Assert.assertTrue(page.TrackNumInputPrompt.isDisplayed());
	     Assert.assertEquals("Invalid PRO Number", page.TrackNumInputPrompt.getText());
	   }
	  
	}
}
