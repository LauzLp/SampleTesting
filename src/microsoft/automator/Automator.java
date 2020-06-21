package microsoft.automator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import microsoft.utils.*;

/**
 * 
 * @author Laura López 
 * 
 */
public class Automator {

	public Automator() {

	}

	private WebDriver driver;
	private WebDriverWait wait;
	private Config config;

	public void start(WebBrowserType browser) {
		try {
			config=new Config();
			switch (browser) {
			case CHROME:
				System.setProperty(config.CHROME_KEYVALUE, modifyIfWindows(config.CHROME_DRIVER));
				driver = new ChromeDriver();				
				break;

			case FIREFOX:
				System.setProperty(config.GECKO_KEYVALUE, modifyIfWindows(config.GECKO_DRIVER));
				driver = new FirefoxDriver();
				break;
			default:
				throw new Exception("Navegador no soportado: " + browser);
			}
			wait = new WebDriverWait(driver, config.MAX_WAIT_TIME);
			driver.get(config.MAIN_URL);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private String modifyIfWindows(String inPath) {
		if (System.getProperty("os.name").toLowerCase().contains("windows")){
			return inPath + ".exe";
		} else {
			return inPath;
		}
	}
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public void closeAllDrivers() {			
		this.driver.close();
		this.driver.quit();
	}
	
	public Config getConfig() {
		return this.config;
	}
					
	public void waitForElement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
		
	public void waitForElementToClick(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
				
	public void waitForElement(WebElement... elements) {									
		wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	}
	
	public void waitForTextInElement(WebElement element, String text) {
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public void waitForTextInElement(Select element, String text) {
		wait.until(ExpectedConditions.textToBePresentInElementValue(element.getFirstSelectedOption(), text));
	}
	
	public void waitForNewPage(String url) {
		wait.until(ExpectedConditions.urlToBe(url));
	}

}
