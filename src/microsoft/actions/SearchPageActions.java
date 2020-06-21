package microsoft.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import microsoft.pages.SearchPage;


public class SearchPageActions extends SearchPage implements microsoft.utils.IActions {

	private WebDriver driver;

	public SearchPageActions(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@Override
	public void clickElement(int option) {

		switch (option) {
		case 1:
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", getFirstItem());
			break;
		}
	}

	@Override
	public String getTextFromElement(int option) {
		String text="";
		switch (option) {
		case 1:
			text = getPrice1().getText();
			break;
		case 2:
			text = getPrice2().getText();
			break;
		case 3:
			text = getPrice3().getText();
			break;
		}

		return text;
	}

	@Override
	public void writeOnTextBox(String text) {};

	@Override
	public void maximizePage() {
		driver.manage().window().maximize();
	}

}
