package utility;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class Confunction {

public static boolean IsDisplayOrNot(WebElement element){
		try{
			return element.isDisplayed();
			}catch(NoSuchElementException e){
			return false;
		}
		
}}
