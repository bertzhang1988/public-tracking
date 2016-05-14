package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ChatWindowPage {
	 WebDriver driver;
     public ChatWindowPage(WebDriver driver)
     {
        this.driver = driver;
        PageFactory.initElements(driver,this);
       
     }                                
     
    @FindBy(how = How.XPATH, using =".//*[@id='q6r0']") //"html/body/form/table/tbody/tr[2]/td/input[1]")
    //@FindBy(how = How.ID, using = "q6r0")
    public WebElement TrackingRadioButton;


    @FindBy(how = How.ID, using = "q10")
    public WebElement TrakingNumberInputBar;
    
    
}
