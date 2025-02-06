package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	WebDriver driver;
	WebDriverWait mywait;

	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		this.mywait=new WebDriverWait(driver,Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	public Select mysel(WebElement name)
	{
		Select mysele=new Select(name);
		return mysele;
	}

	public WebDriverWait my_wite()
	{
		return new WebDriverWait(this.driver,Duration.ofSeconds(10));
	}

	public Actions act(WebElement name)
	{
		Actions actt=new Actions(this.driver);
		return actt.moveToElement(name);
	}

}
