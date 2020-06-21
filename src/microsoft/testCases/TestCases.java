package microsoft.testCases;

import static org.testng.Assert.*;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.*;

import microsoft.actions.*;
import microsoft.automator.Automator;
import microsoft.utils.*;

/**
 * 
 * @author Laura López
 *
 */
public class TestCases {

	private MainPageActions mainPage;
	private WindowsPageActions windowsPage;
	private SearchPageActions searchPage;
	private DetailsPageActions detailsPage;
	private CartPageActions cartPage;
	private Automator automator;
	
	public TestCases() {			
		automator = new Automator();			
	}
	
	/**
	 * 1. Go to https://www.microsoft.com/en-us/
	 */

	@BeforeSuite
	public void startBrowser() {
		try {		
			
			automator.start(WebBrowserType.CHROME);
			mainPage = PageFactory.initElements(automator.getDriver(), MainPageActions.class);
			automator.waitForNewPage(automator.getConfig().MAIN_URL);
			mainPage.maximizePage();

			assertEquals(automator.getDriver().getCurrentUrl(), automator.getConfig().MAIN_URL);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 2. Validate all menu items are present (Office - Windows - Surface - Xbox -
	 * Deals - Support)
	 */

	@Test(priority = 0)
	public void itemsArePresent() {
		automator.waitForElement(mainPage.getItemOffice());

		assertTrue(mainPage.getItemOffice().isDisplayed());
		assertTrue(mainPage.getItemWindows().isDisplayed());
		assertTrue(mainPage.getItemSurface().isDisplayed());
		assertTrue(mainPage.getItemXbox().isDisplayed());
		assertTrue(mainPage.getItemDeals().isDisplayed());
		assertTrue(mainPage.getItemSupport().isDisplayed());

	}

	/**
	 * 3. Go to Windows
	 * 
	 */

	@Test(priority = 1)
	public void goToWindowsPage() {
		try {
		
			mainPage.clickElement(1);
			automator.waitForNewPage(automator.getConfig().WINDOWS_URL);
			windowsPage = PageFactory.initElements(automator.getDriver(), WindowsPageActions.class);
			assertEquals(automator.getDriver().getCurrentUrl(), automator.getConfig().WINDOWS_URL);
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}
	}

	/**
	 * 4. Once in Windows page, click on Windows 10 Menu 
	 * 5. Print all Elements in the dropdown
	 */
	@Test(priority = 2)
	public void clickAndPrint() {
		try {
			automator.waitForElement(windowsPage.getButtonWindows());
			windowsPage.clickElement(1);

			String text = windowsPage.getTextFromElement(1);
			
			Reporter.log("Elements in the dropdown:\n"+text,true);	
			Thread.sleep(2000);
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}
	}

	/**
	 * 6. Go to Search next to the shopping cart 
	 * 7. Search for Visual Studio
	 * 
	 */

	@Test(dependsOnMethods = {"clickAndPrint"})
	public void searchForVisual() {
		try {
						
			windowsPage.clickElement(2);
			automator.waitForElement(windowsPage.getTextBoxSearch());
			windowsPage.writeOnTextBox("Visual Studio");
			windowsPage.clickElement(2);

			automator.waitForElement(windowsPage.getCancelButton());
			windowsPage.clickElement(3);

			searchPage = PageFactory.initElements(automator.getDriver(), SearchPageActions.class);
			assertEquals(automator.getDriver().getCurrentUrl(), automator.getConfig().SEARCH_URL);

		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}
	}

	/**
	 * 8. Print the price for the 3 first elements listed in Software result list 
	 * 9. Store the price of the first one
	 */

	private String price1 = "";

	@Test(priority = 4)
	public void printPrices() {
		automator.waitForElement(searchPage.getFirstItem());
		price1 = searchPage.getPrice1().getText();
		
		Reporter.log("3 first elements listed in result list: \n"
				+"Price 1: " + price1+"\n"
				+"Price 2: " + searchPage.getPrice2().getText()+"\n"
				+"Price 3: " + searchPage.getPrice3().getText()+"\n"					
				,true);
		
		assertEquals(searchPage.getTextFromElement(1), "$799.00");
		assertEquals(searchPage.getTextFromElement(2), "$5,999.00");
		assertEquals(searchPage.getTextFromElement(3), "$899.00");
	}

	/**
	 * 10. Click on the first one to go to the details page 
	 * 11. Once in the details page, validate both prices are the same
	 */
	@Test(priority = 5)
	public void seeDetails() {
		searchPage.clickElement(1);
		automator.waitForNewPage(automator.getConfig().DETAILS_URL);
		detailsPage = PageFactory.initElements(automator.getDriver(), DetailsPageActions.class);

		detailsPage.clickElement(2);
		assertEquals(detailsPage.getTextFromElement(1), price1);
	}

	/**
	 * 12. Click Add To Cart
	 */

	@Test(priority = 6)
	public void clicAddToCart() {
		automator.waitForElementToClick(detailsPage.getButtonAddToCart());
		detailsPage.clickElement(3);
		automator.waitForNewPage(automator.getConfig().SHOPCART_URL);

		cartPage = PageFactory.initElements(automator.getDriver(), CartPageActions.class);

		assertEquals(automator.getDriver().getCurrentUrl(), automator.getConfig().SHOPCART_URL);
	}

	/**
	 * 13. Verify all 3 price amounts are the same
	 */

	@Test(priority = 7)
	public void verifyAmounts() {
		automator.waitForElement(cartPage.getTotal());
		assertTrue(cartPage.getTextFromElement(1).equals(cartPage.getTextFromElement(2))
				&& cartPage.getTextFromElement(1).equals(cartPage.getTextFromElement(3)));
	}

	/**
	 * 14. On the # of items dropdown select 20 and validate the Total amount is
	 * Unit Price * 20
	 */

	@Test(priority = 8)
	public void selectQuantity() {
		automator.waitForElement(cartPage.getWEQuantityList());
		cartPage.selectElementFromList("20");
		automator.waitForElement(cartPage.getTotal());
		double unitPrice = Double.parseDouble(cartPage.getTextFromElement(1).replaceAll("[$,]", ""));
		unitPrice *= 20;

		automator.waitForTextInElement(cartPage.getTotal(), "$15,980.00");
		assertEquals(cartPage.getTextFromElement(3).replaceAll("[$,]", ""), String.format("%.2f", unitPrice));
	}

	@AfterSuite
	public void closeBrowser() {
		try {		
			automator.closeAllDrivers();
		} catch (Exception e) {
			Reporter.log(e.getMessage());
		}
	}

}
