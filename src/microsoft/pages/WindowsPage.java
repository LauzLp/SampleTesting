package microsoft.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * 
 * @author Laura López
 *
 */
public abstract class WindowsPage {
	
	@FindBy(how=How.ID, using="c-shellmenu_50")
	@CacheLookup
	private WebElement buttonWindows;
	
	@FindBy(how=How.XPATH, using="//li[2]//div[1]//ul[1]")
	@CacheLookup
	private WebElement dropDownList;
		
	@FindBy(how=How.ID, using="search")
	@CacheLookup
	private WebElement buttonSearch;
	
	@FindBy(how=How.ID, using="cli_shellHeaderSearchInput")
	@CacheLookup
	private WebElement textboxSearch;
	
	@FindBy(how=How.XPATH, using="//div[@id='R1MarketRedirect-1']//button[@class='c-glyph glyph-cancel']")
	@CacheLookup
	private WebElement cancelButton;
				
				
	public WebElement getButtonWindows() {
		return this.buttonWindows;
	}
	
	public WebElement getDropDownListObject() {
		return this.dropDownList;
	}
	
	public List<WebElement> getDropDownList(){
		List<WebElement> list = this.dropDownList.findElements(By.tagName("li"));
		return list;		
	}
	
	public WebElement getButtonSearch() {
		return this.buttonSearch;
	}
	
	public WebElement getTextBoxSearch() {
		return this.textboxSearch;
	}
	
	public WebElement getCancelButton() {
		return this.cancelButton;
	}
	
}
