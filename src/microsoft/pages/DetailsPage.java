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
public abstract class DetailsPage {
	
	@FindBy(how=How.ID, using="ProductPrice_productPrice_PriceContainer")
	@CacheLookup
	private WebElement price;
	
	@FindBy(how=How.ID, using="buttonPanel_AddToCartButton")
	@CacheLookup
	private WebElement buttonAddToCart;
	
	@FindBy(how=How.XPATH, using="//div[@id='R1MarketRedirect-1']//button[@class='c-glyph glyph-cancel']")
	@CacheLookup
	private WebElement buttonCancel;
	
	public WebElement getPrice() {
		return this.price;
	}

	public WebElement getButtonAddToCart() {
		return this.buttonAddToCart;
	}
	
	public WebElement getButtonCancel() {
		return this.buttonCancel;
	}
}
