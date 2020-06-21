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
public abstract class SearchPage {
	
	@FindBy(how=How.ID, using="coreui-productplacement-30l7ywa_0")
	@CacheLookup
	private WebElement firstItem;
	
	@FindBy(how=How.XPATH, using="(//span[contains(text(),'$')])[1]")
	@CacheLookup
	private WebElement price1;
	
	@FindBy(how=How.XPATH, using="(//span[contains(text(),'$')])[2]")
	@CacheLookup
	private WebElement price2;
	
	@FindBy(how=How.XPATH, using="(//span[contains(text(),'$')])[3]")
	@CacheLookup
	private WebElement price3;
	
	public WebElement getFirstItem() {
		return this.firstItem;
	}
	
	public WebElement getPrice1() {
		return this.price1;
	}
	
	public WebElement getPrice2() {
		return this.price2;
	}
	
	public WebElement getPrice3() {
		return this.price3;
	}
		
}
