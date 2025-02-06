package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass 
{
	public WebDriver driver;
	public Logger logger;
	public Properties prop;
	@BeforeClass
	public void setup() throws IOException
	{
		
		logger=LogManager.getLogger(this.getClass());
		
//		FileReader reader=new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		FileReader reader=new FileReader("./src/test/resources/config.properties");
		prop=new Properties();
		prop.load(reader);
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get(prop.getProperty("url_momb")); // driver.get("https://manaoorumanabadi.telangana.gov.in/momb/");
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	

	public String randamString()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return generatedstring;
	}
	public String randamnumber()
	{
		String generatednumber=RandomStringUtils.randomNumeric(9);
		return generatednumber;
	}
	public String randam_number_string()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(4);
		String generatednumber=RandomStringUtils.randomNumeric(3);
		return (generatedstring+generatednumber);
	}

	
	
}
