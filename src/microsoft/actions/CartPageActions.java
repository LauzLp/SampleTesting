package microsoft.actions;

import org.openqa.selenium.WebDriver;

import microsoft.pages.CartPage;
import microsoft.utils.IActions;

public class CartPageActions extends CartPage implements IActions {

	private WebDriver driver;

	public CartPageActions(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@Override
	public void clickElement(int option) {

	}

	public void selectElementFromList(String s) {
		getQuantityList().selectByVisibleText(s);
	}

	@Override
	public String getTextFromElement(int option) {
		String text = "";

		switch (option) {
		case 1:
			text = getUnitPrice().getText();
			break;
		case 2:
			text = getSummaryPrice().getText();
			break;
		case 3:
			text = getTotal().getText();
			break;
		}
		return text;
	}

	@Override
	public void writeOnTextBox(String text) {

	}

	@Override
	public void maximizePage() {
		driver.manage().window().maximize();
	}

}
