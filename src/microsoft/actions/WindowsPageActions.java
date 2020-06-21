package microsoft.actions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import microsoft.pages.*;
import microsoft.utils.*;

public class WindowsPageActions extends WindowsPage implements IActions {

	private WebDriver driver;

	public WindowsPageActions(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@Override
	public void clickElement(int option) {
		switch (option) {
		case 1:
			getButtonWindows().click();
			break;
		case 2:
			getButtonSearch().click();
			break;
		case 3:
			getCancelButton().click();
			break;
		}
	}

	@Override
	public String getTextFromElement(int option) {
		String text = "";
		try {
		

		switch (option) {
		case 1:
			List<WebElement> list = getDropDownList();
			int size = list.size();

			for (int n = 0; n < size; n++) {
				text += (n + 1) + ") " + list.get(n).getText() + "\n";
			}

		}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return text;
	}

	@Override
	public void writeOnTextBox(String text) {
		getTextBoxSearch().sendKeys(text);
	}

	@Override
	public void maximizePage() {
		driver.manage().window().maximize();
	}
}
