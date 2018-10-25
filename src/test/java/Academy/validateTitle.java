package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class validateTitle extends base {
	private static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver= initializeDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigate to home page");
	}

	@Test()
	public void basePageNavigation() throws IOException
	{
		
//	driver= initializeDriver();
//		driver.get("https://qaclickacademy.com");
		
		LandingPage l = new LandingPage (driver);
		
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Successfully validated");
			
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver=null;
	}	
	
	
}
