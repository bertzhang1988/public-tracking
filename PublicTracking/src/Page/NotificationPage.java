package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NotificationPage{
	
	WebDriver driver;
    public NotificationPage(WebDriver driver)
    {
       this.driver = driver;
       PageFactory.initElements(driver,this);
      
   }
   
    
   @FindBy(how = How.TAG_NAME, using = "textarea")
   public WebElement ProNumberInputBar;
  
  
   
}
