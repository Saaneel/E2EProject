package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;

public class base {

	public static WebDriver driver;

	public Properties prop;
	public WebDriver initializeDriver() throws IOException
	{
		prop =new Properties();
		FileInputStream fis =new FileInputStream("C:\\Users\\Saaneel\\eclipse-workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		String browsername=prop.getProperty("browser");
		System.out.println(browsername);

		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Saaneel\\eclipse-workspace\\UnitedSpritFreamworks\\chromedriver.exe");

			driver = new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",
					"C:\\Warehouse\\PIIT\\Software\\Firefox Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browsername.equals("IE"))
		{
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		return driver;

	}
	
	public void getScreenshot(String result) throws IOException 
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://Users//Saaneel//eclipse-workspace//E2EProject//src//"+result+"screenshot.png"));
	}
	

}
