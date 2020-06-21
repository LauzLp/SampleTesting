package microsoft.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

/**
 * 
 * @author Laura López
 *
 */
public abstract class CartPage {
	
	@FindBy(how=How.XPATH, using="//section[@class='_3a6I5TkT']//span[2]")
	@CacheLookup
	private WebElement unitPrice;
	
	@FindBy(how=How.XPATH, using="//span[@class='_3fnVqdke c-paragraph-4']//span//span[2]")
	@CacheLookup
	private WebElement summaryPrice;
	
	@FindBy(how=How.XPATH, using="//span[2]//strong[1]")
	private WebElement total;
	
	@FindBy(how=How.TAG_NAME, using="Select")
	@CacheLookup
	private WebElement quantity;
	
	public WebElement getUnitPrice() {
		return this.unitPrice;
	}
	
	public WebElement getSummaryPrice() {
		return this.summaryPrice;
	}
	
	public WebElement getTotal() {
		return this.total;
	}
	
	public WebElement getWEQuantityList() {
		return this.quantity;
	}
	
	public Select getQuantityList() {
		return new Select(this.quantity);
	}

}
