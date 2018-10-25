package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;


public class HomePage extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver();

	}

	@Test(dataProvider="getData")
	public void basePageNavigation(String Username, String Password , String text) throws IOException
	{
	//	driver= initializeDriver();
		driver.get(prop.getProperty("url"));
		
		LandingPage l = new LandingPage (driver);
		l.getLogin().click();
		LoginPage lp =new LoginPage(driver);
		
//		lp.getEmail().sendKeys("abcd@efgh.com");
		lp.getEmail().sendKeys(Username);
//		lp.getPassword().sendKeys("123456");
		lp.getPassword().sendKeys(Password);
	//	System.out.println(text); or below object 
		log.info(text);
		
		lp.getlogin().click();
		
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][3];
		data[0][0] = "nonrestricted@efgh.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted Users";

		data[1][0] = "restricted@efgh.com";
		data[1][1] = "123456";
		data[1][2] = "Non Restricted Users";
		
		return data;
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}
	
}
