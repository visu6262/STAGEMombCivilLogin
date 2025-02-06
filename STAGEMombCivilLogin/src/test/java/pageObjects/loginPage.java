package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage extends BasePage {
	
	WebDriver driver;
	
	public loginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators

	@FindBy(xpath="//a[@id='ctl00_lnkworkshome']") WebElement lnk_workshome;
	@FindBy(xpath="//a[@id='ctl00_LinkButton3']") WebElement lnk_logout;
	@FindBy(xpath="//a[contains(.,'ESTIMATIONS')]")  WebElement lnk_Estimations;
	@FindBy(xpath="//a[contains(.,'PO Generation for CPM')]")  WebElement lnk_PO_Generation_for_CPM_Works;
	
	//Work Proposal Information
	
	@FindBy(xpath="//select[@id='ctl00_ContentPlaceHolder1_ddlDistrict']") WebElement District;
	@FindBy(xpath="//select[@id='ctl00_ContentPlaceHolder1_ddlPhase']") WebElement Phase;
	@FindBy(xpath="//select[@id='ctl00_ContentPlaceHolder1_ddlBlock']") WebElement Mandal;
	@FindBy(xpath="//select[@id='ctl00_ContentPlaceHolder1_ddlModule']") WebElement Module;
	@FindBy(xpath="//select[@id='ctl00_ContentPlaceHolder1_ddl_School']") WebElement School;
	@FindBy(xpath="//select[@id='ctl00_ContentPlaceHolder1_ddlWorkName']") WebElement Work;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_btnGo0']") WebElement btn_Go;
	
	@FindBy(xpath="//table[@id='tblTaskDetails']/tbody/tr") List<WebElement> rows;
	
	@FindBy(xpath="//table[@id='tblTaskDetails']/tbody/tr[1]/td[2]/input[1]") WebElement t1060;
	@FindBy(xpath="//table[@id='tblTaskDetails']/tbody/tr[2]/td[2]/input[1]") WebElement t1061;
	@FindBy(xpath="//table[@id='tblTaskDetails']/tbody/tr[3]/td[2]/input[1]") WebElement t1062;
	@FindBy(xpath="//table[@id='tblTaskDetails']/tbody/tr[4]/td[2]/input[1]") WebElement t1063;
	
	@FindBy(xpath="//table[@id='tblTaskDetails']/tbody/tr[5]/td[2]/input[1]") WebElement t1270;
	@FindBy(xpath="//table[@id='tblTaskDetails']/tbody/tr[6]/td[2]/input[1]") WebElement t1271;
	@FindBy(xpath="//table[@id='tblTaskDetails']/tbody/tr[7]/td[2]/input[1]") WebElement t1272;
	@FindBy(xpath="//table[@id='tblTaskDetails']/tbody/tr[8]/td[2]/input[1]") WebElement t1273;
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_btnAddTaskDetails']") WebElement Add_Task_Details;
	
	@FindBy(xpath="//table[@id='ctl00_ContentPlaceHolder1_grdSelectedTasks']/tbody/tr") List<WebElement> table2_rows;
	
	@FindBy(xpath="//div[@id='ctl00_ContentPlaceHolder1_txtdate_CalendarExtenderSD2_title']") WebElement month_year;
	@FindBy(xpath="//div[@id='ctl00_ContentPlaceHolder1_txtdate_CalendarExtenderSD2_prevArrow']") WebElement prevArrow;
	@FindBy(xpath="//table[contains(@id,'daysTable')]//tbody/tr/td/div") List<WebElement> calendar_days;
	
	
	public String get_task_code(WebDriver driver,int r)
	{
		String taskcode=driver.findElement(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_grdSelectedTasks']/tbody/tr["+r+"]//table/tbody/tr/td[2]/span")).getText();
//		String code=taskcode.getText();
		return taskcode;
	}
	
	
	public void get_total_qty_click(WebDriver driver,int r) throws InterruptedException
	{
		WebElement totalqty=driver.findElement(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_grdSelectedTasks']/tbody/tr["+r+"]//table/tbody/tr/td[6]/input"));
		totalqty.click();
	}
	
	public void get_total_qty(WebDriver driver,int r,String value) throws InterruptedException
	{
		WebElement totalqty=driver.findElement(By.xpath("//table[@id='ctl00_ContentPlaceHolder1_grdSelectedTasks']/tbody/tr["+r+"]//table/tbody/tr/td[6]/input"));
		new Actions(driver).moveToElement(totalqty).click(totalqty).doubleClick(totalqty).sendKeys(value).perform();
	}
	
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_txtAdminSanctionNo']") WebElement txt_AdminSanctionNo;
	@FindBy(xpath="//img[@id='ctl00_ContentPlaceHolder1_txtdate_ImgBntCalc']") WebElement imgcalender;
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_fuAcctDoc']") WebElement file_upload;
	@FindBy(xpath="//input[@id='ctl00_ContentPlaceHolder1_btnSubmit']") WebElement btnSubmit;
	
	
	//MainActions
	
	
	public void click_lnk_workshome()
	{
//		new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated((By) lnk_workshome)).click();
//		mywait.until(ExpectedConditions.visibilityOf(lnk_workshome)).click();
		lnk_workshome.click();
	}
	
	public void click_lnk_logout()
	{
		lnk_logout.click();
	}
	
	public void click_lnk_Estimations()
	{
//		Actions act= new Actions(driver);
//		new Actions(driver).moveToElement(lnk_Estimations).perform();
		lnk_Estimations.click();
	}

	public void click_lnk_PO_Generation_for_CPM_Works()
	{
		lnk_PO_Generation_for_CPM_Works.click();
	}

	public void select_District(String dist)
	{
//		new Select(District).selectByVisibleText(dist);
		mysel(District).selectByVisibleText(dist);
	}
	
	public void select_Phase(String Phase1)
	{
		new Select(Phase).selectByVisibleText(Phase1);
	}

	public void select_Mandal(String mandal_name)
	{
		new Select(Mandal).selectByVisibleText(mandal_name);
//		mysel(Mandal).selectByVisibleText(mandal_name);
	}
	
	public void select_Module(String phase)
	{
		new Select(Module).selectByVisibleText(phase);
	}
	
	public void select_School(String school_name)
	{
		new Select(School).selectByVisibleText(school_name);
	}
	
	public boolean select_School_status()
	{
		if(new Select(School).getFirstSelectedOption().getText().equals("--SELECT--"))
		{
			return false;
		}
		return true;
	}

	public List<WebElement> select_Schools_list()
	{
		List <WebElement> aa=new Select(School).getOptions();
		return aa;
	}
	
	public void select_Work_Name(String work_name)
	{
		new Select(Work).selectByVisibleText(work_name);
	}
	
	public void click_btn_Go()
	{
		btn_Go.click();
	}
	
	public int No_of_Rows()
	{
		int aa = rows.size();
		return aa;
	}

	
	public void click_t1060()
	{
		t1060.click();
	}
	
	public void click_t1061()
	{
		t1061.click();
	}
	public void click_t1062()
	{
		t1062.click();
	}
	public void click_t1063()
	{
		t1063.click();
	}
	public void click_t1270()
	{
		t1270.click();
	}
	public void click_t1271()
	{
		t1271.click();
	}
	public void click_t1272()
	{
		t1272.click();
	}
	public void click_t1273()
	{
		t1273.click();
	}
	
	public void click_Add_Task_Details()
	{
		Add_Task_Details.click();
	}
	
	public int table2_no_of_rows()
	{
		int t2rows=table2_rows.size();
		return t2rows;
	}
	
	public void get_txt_AdminSanctionNo(WebDriver driver,String Sanction_no)
	{
		txt_AdminSanctionNo.click();
		new Actions(driver).moveToElement(txt_AdminSanctionNo).click().sendKeys(Sanction_no).perform();
//		act(txt_AdminSanctionNo).click().sendKeys(Sanction_no).perform();
//		txt_AdminSanctionNo.sendKeys(Sanction_no);
	}
	public void click_imgcalender()
	{
		imgcalender.click();
	}
	
	public void file_upload(String filepath)
	{
		file_upload.sendKeys(filepath);
	}

	public String get_month_year()
	{
		return month_year.getText();
	}
	
	public void click_prevArrow()
	{
		prevArrow.click();
	}
	
	public List<WebElement> get_calendar_days()
	{
		return calendar_days;
	}
	
	public void click_btnSubmit()
	{
		btnSubmit.click();
	}
	public Alert my_alert(WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		return alert;
	}

	
}
