package microsoft.actions;

import org.openqa.selenium.WebDriver;

import microsoft.pages.MainPage;
import microsoft.utils.IActions;

/**
 * 
 * @author Laura López
 *
 */
public class MainPageActions extends MainPage implements IActions {
	
	private WebDriver driver;
	public MainPageActions(WebDriver driver) {
		super();	
		this.driver = driver;
	}
	
	@Override
	public void clickElement(int option) {
		switch(option) {
		case 1:
			getItemWindows().click();
			break;
		}
	}
	
	@Override
	public String getTextFromElement(int option) {return "";}
	
	@Override
	public void writeOnTextBox(String text) {};
		
	@Override
	public void maximizePage() {
		driver.manage().window().maximize();
	}
	
}
