package microsoft.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * Se obtienen los valores del archivo de configuración..
 * @author Laura López
 *
 */
public class Config {
	
	private Properties prop = new Properties();
	
	private String ROOT_DIR = System.getProperty("user.dir");
	
	private String CONFIG_DIR;
		
	private String DRIVERS_DIR;
		
	public String CHROME_DRIVER;
	public String CHROME_KEYVALUE;
	
	public String GECKO_DRIVER;
	public String GECKO_KEYVALUE;
		
	public String MAIN_URL;
	public String WINDOWS_URL;
	public String SEARCH_URL;
	public String DETAILS_URL;
	public String SHOPCART_URL;
	
	public long MAX_WAIT_TIME;
	
	public Config() {
		try {		
			CONFIG_DIR = ROOT_DIR + File.separator+"resources"
					+File.separator+"config.xml";
			prop.loadFromXML(new FileInputStream(CONFIG_DIR));
			DRIVERS_DIR = ROOT_DIR + prop.getProperty("driversDir");
			CHROME_DRIVER = DRIVERS_DIR + prop.getProperty("chromeDriverName");
			CHROME_KEYVALUE = prop.getProperty("chromeDriverKeyValue");
			GECKO_DRIVER = DRIVERS_DIR + prop.getProperty("geckoDriverName");
			GECKO_KEYVALUE = prop.getProperty("geckoDriverKeyValue");
			
			MAX_WAIT_TIME= Integer.parseInt(prop.getProperty("maxWaitTime"));
			
			MAIN_URL = prop.getProperty("mainUrl");
			WINDOWS_URL = prop.getProperty("windowsUrl");
			SEARCH_URL= prop.getProperty("searchUrl");
			DETAILS_URL = prop.getProperty("detailsUrl");
			SHOPCART_URL = prop.getProperty("shopCart");
			
		}catch(Exception e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
	
	
	
}
