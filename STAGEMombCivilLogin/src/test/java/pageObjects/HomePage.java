package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	// Locators
	
	@FindBy(xpath="//button[@id='btnlogin']") WebElement btn_login;
	
	@FindBy(xpath="//input[@id='txtUserId']") WebElement txt_Userid;
	@FindBy(xpath="//input[@id='txtPassword']") WebElement txt_Password;
	@FindBy(xpath="//input[@id='txtCaptcha']") WebElement txt_Captcha;
	@FindBy(xpath="//input[@id='btnSubmit']") WebElement btn_Submit;
	
	
	//MainActions
	

	
	public void click_btn_login()
	{
		btn_login.click();
	}
	
	public void enter_txt_Userid(String Userid)
	{
		txt_Userid.sendKeys(Userid);
	}
	
	public void enter_txt_Password(String Password)
	{
		txt_Password.sendKeys(Password);
	}
	
	public void click_txt_Captcha()
	{
		txt_Captcha.click();
	}
	
	public void click_btn_Submit()
	{
		btn_Submit.click();
	}

}
