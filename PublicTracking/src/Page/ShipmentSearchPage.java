package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ShipmentSearchPage {

	

	WebDriver driver;
    public ShipmentSearchPage(WebDriver driver)
    {
       this.driver = driver;
       PageFactory.initElements(driver,this);
      
   }
    
    /*YRC Header*/
    
    //@FindBy(how = How.LINK_TEXT, using = "Track")
    @FindBy(how = How.XPATH, using = "html/body/div[1]/header/div[2]/nav/ul/li[2]/a")
    public WebElement TrackButton;
                                       
    @FindBy(how = How.XPATH, using = "html/body/div[1]/header/div[2]/nav/ul/li[2]/div/nav/ul[1]/li[2]/a")
    public WebElement PRONumberTrackingLink;
    
    @FindBy(how = How.LINK_TEXT, using = "Bill of Lading Number Tracking")
    public WebElement BOLNumberTrackingLink;

    @FindBy(how = How.LINK_TEXT, using = "PO Number Tracking")
    public WebElement PONumberTrackingLink;

    @FindBy(how = How.LINK_TEXT, using = "Booking Number Tracking")
    public WebElement BookingNumberTrackingLink;

    @FindBy(how = How.LINK_TEXT, using = "Load Number Tracking")
    public WebElement LoadNumberTrackingLink;

    @FindBy(how = How.LINK_TEXT, using = "YRC Freight – The Original LTL Carrier Since 1924")
    public WebElement YRCLogo;
    
    /*Shipment search */
    
   @FindBy(how = How.XPATH, using = " html/body/div[3]/div[2]/div/div/div/div[1]/div[1]/h4")
   public WebElement ShipmentSearchTitle;
   
   @FindBy(how = How.XPATH, using = " html/body/div[3]/div[2]/div/div/div/div[1]/div[2]/form/div[2]/div/div/label")
   public WebElement ReferenceTypeLabel;
  
   @FindBy(how =How.ID,using="ember481")
   public WebElement PROTab;
   
   @FindBy(how = How.ID, using = "ember483")
   public WebElement BOLTab ;
   
   @FindBy(how = How.ID, using = "ember485")
   public WebElement POTab;
   
   @FindBy(how = How.ID, using = "ember487")
   public WebElement BookingTab;
   
   @FindBy(how = How.ID, using = "ember489")
   public WebElement LOADTab;
   
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[1]/div[1]/div/a/span")
   public WebElement MultiPROEntryIcon;

   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[1]/div[1]/a/span")
   public WebElement HelpIcon;
    
   @FindBy(how = How.ID, using = "shipmentSearchForm")
   public WebElement ShipmentSearchForm;     
 
   
   @FindBy(how = How.ID, using = "ember521")
   public WebElement TrackProNumInputBar;
   
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[1]/div[2]/form/div[2]/div/div/div/span/input")
   public WebElement TrackNoneProNumInputBar;
   
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[1]/div[2]/form/div[2]/div/div/div[1]/small[2]")
   public WebElement TrackNumInputPrompt;

   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[1]/div[2]/form/div[2]/div/div/label")
   public WebElement TrackNumTypeLabel;
                                     
   @FindBy(how = How.XPATH, using = ".//*[@id='shipmentSearchForm']/div[3]/div/div/button")//"html/body/div[3]/div[2]/div/div/div/div[1]/div[2]/form/div[3]/div/div/button")
   public WebElement FindShipmentButton;

   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[1]/div[2]/form/div[5]/div[1]")
   public WebElement NoteBarBelowFindShipmentButton;
   
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div")
   public WebElement NoShipmentResultPrompt;
  
   @FindBy(how = How.LINK_TEXT, using = "What is a PRO?")
   public WebElement ProNumLink;
  
   /*Shipment search Help*/
   
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[3]/div[2]/div/div[1]/h4")
   public WebElement ShipmentSearchHelpTitle;
   
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[3]/div[2]/div/div[1]/a/span")
   public WebElement ShipmentSearchHelpCancel;
   
   /*pro# defination*/
   
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[1]/div[2]/form/div[5]/div[2]/div[2]/div/div[2]/p")
   public WebElement ProNumDefin;
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[1]/div[2]/form/div[5]/div[2]/div[2]/div/div[3]/button")
   public WebElement CloseButton;
   
   /*Multiple ProNumber Entry Page*/
  
   @FindBy(how = How.CLASS_NAME, using = "glyphicon glyphicon-remove")
   public WebElement CancelIcon;
  
   @FindBy(how =How.ID,using="ember499")
   public WebElement MultipleProEntryInputBar;
   
   @FindBy(how = How.ID, using = "ember502")
   public WebElement SpacesCheckBox ;
   
   @FindBy(how = How.ID, using = "ember503")
   public WebElement TabsCheckBox;
   
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[1]/div[2]/form/div[6]/div[2]/div/div[2]/div[7]/div")
   public WebElement PreviewInformation;
                                    
   @FindBy(how = How.CLASS_NAME, using = "list-unstyled")
  // @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[1]/div[2]/form/div[6]/div[2]/div/div[2]/div[7]/div/ul")
   public WebElement PreviewInformationList;
   
   @FindBy(how = How.CLASS_NAME, using = "btn btn-default")
   public WebElement CancelButton;
   
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[1]/div[2]/form/div[4]/div[2]/div/div[3]/button[2]")
   public WebElement SaveToSearchButton;
   
   /*Shipment select*/
   
  // @FindBy(how = How.XPATH ,using = "html/body/div[3]/div[2]/div/div/div/div[2]/div/div[1]/div[2]/ul")
   @FindBy(how = How.ID, using = "displaySize")
   public WebElement MultipleProNumberList;
                                    
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[2]/div/form/div/div[1]/h4")
   public WebElement SelectShipmentTitle;
  
   @FindBy(how = How.XPATH, using = ".//*[@id='shipmentSelectionPanel']/div[2]/div[1]")
   public WebElement SelectShipmentInformationBar;
   
   @FindBy(how = How.ID, using = "origin")
   public WebElement FromInputBar;
   
   @FindBy(how = How.ID, using = "destination")
   public WebElement ToInputBar;     
   
   @FindBy(how = How.LINK_TEXT, using = "5")
   public WebElement Show5Button;
   
   @FindBy(how = How.LINK_TEXT, using = "25")
   public WebElement Show25Button;

   @FindBy(how = How.LINK_TEXT, using = "50")
   public WebElement Show50Button;
   
   @FindBy(how = How.LINK_TEXT, using = "ALL")
   public WebElement ShowALLButton;
   
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[2]/div/form/div/table")
   public WebElement SelectShipmentTable ;
   
   /*Shipment Detail*/
   
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div")
   public WebElement NotFoundPromptBar;
   
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[1]/div[1]/h4")
   public WebElement ShipmentDetailTitle;
   
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[1]/div[1]/div/a[4]/span")
   public WebElement ChatIcon;
   
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[1]/div[1]/div/a[3]")
   public WebElement PrintIcon;
   
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[1]/div[1]/div/a[2]/span")
   public WebElement EmailIcon;
   
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[1]/div[1]/div/a[1]/span")
   public WebElement NotificationIcon;
   
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[1]/div[2]/div[1]/div[1]/p")
   public WebElement NumberReference1;
                                     
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[1]/div[2]/div[1]/div[2]/p")
   public WebElement NumberReference2;
   
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[1]/div[3]")
   public WebElement BottomNote;
   
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div[2]/div[1]/div/p")
   public WebElement ProNmber;
                                     
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[1]/div[2]/div[1]/div[1]/label")
   public WebElement TitleReference1;
   
   /*Send Email Page*/
   
   @FindBy(how = How.ID, using = "emailAddress1")
   public WebElement FirstEmailInputBar;

   @FindBy(how = How.ID, using = "emailAddress2")
   public WebElement SecondEmailInputBar;
   
   @FindBy(how = How.ID, using = "emailAddress3")
   public WebElement ThirdEmailInputBar;
   
   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/h4")
   public WebElement EmailPageTitle;
   
   @FindBy(how = How.XPATH, using ="html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/form/div[2]/div/button")
   public WebElement SendEmailButton;

   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/div/a/span")
   public WebElement CancelMark;

   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/form/div[1]/div[1]/div/div/small[2]")
   public WebElement EmailPatternPrompt1;

   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/form/div[1]/div[2]/div/div/small")
   public WebElement EmailPatternPrompt2;

   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/form/div[1]/div[3]/div/div/small")
   public WebElement EmailPatternPrompt3;

   @FindBy(how = How.XPATH, using = "html/body/div[3]/div[2]/div/div/div/div[2]/div/div/div[2]/div/div[2]/div/form/div[1]/div[5]")
   public WebElement EmailSendedSucPrompt;



}