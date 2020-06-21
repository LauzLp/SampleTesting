package microsoft.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import microsoft.pages.DetailsPage;
import microsoft.utils.IActions;

public class DetailsPageActions extends DetailsPage implements IActions {

	private WebDriver driver;

	public DetailsPageActions(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@Override
	public void clickElement(int option) {
		switch (option) {
		case 1:
			getButtonAddToCart().click();
			break;
		case 2:
			getButtonCancel().click();
			break;
		case 3:
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", getButtonAddToCart());
		}
	}

	@Override
	public String getTextFromElement(int option) {
		String text = "";

		switch (option) {
		case 1:
			text = getPrice().getText();
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
