package microsoft.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * 
 * @author Laura López
 *
 */
public abstract class MainPage {

	@FindBy(how=How.ID, using="shellmenu_1")
	@CacheLookup
	private WebElement itemOffice;
	
	@FindBy(how=How.ID, using="shellmenu_2")
	@CacheLookup
	private WebElement itemWindows;
	
	@FindBy(how=How.ID, using="shellmenu_3")
	@CacheLookup
	private WebElement itemSurface;
	
	@FindBy(how=How.ID, using="shellmenu_4")
	@CacheLookup
	private WebElement itemXbox;
	
	@FindBy(how=How.ID, using="shellmenu_5")
	@CacheLookup
	private WebElement itemDeals;
	
	@FindBy(how=How.ID, using="l1_support")
	@CacheLookup
	private WebElement itemSupport;
	
	public WebElement getItemOffice() {
		return this.itemOffice;
	}
	
	public WebElement getItemWindows() {
		return this.itemWindows;
	}
	
	public WebElement getItemSurface() {
		return this.itemSurface;
	}
	
	public WebElement getItemXbox() {
		return this.itemXbox;
	}
	
	public WebElement getItemDeals() {
		return this.itemDeals;
	}
	
	public WebElement getItemSupport() {
		return this.itemSupport;
	}
	
}
