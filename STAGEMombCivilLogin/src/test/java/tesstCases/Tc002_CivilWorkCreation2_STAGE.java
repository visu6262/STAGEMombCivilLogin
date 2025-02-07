package tesstCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Utilities.ExcelDataProviders;
import pageObjects.HomePage;
import pageObjects.loginPage;
import testBase.BaseClass;

public class Tc002_CivilWorkCreation2_STAGE extends BaseClass{

	@Test(priority=1)
	public void testlogin() throws InterruptedException
	{
		HomePage hp=new HomePage(driver);
		
		driver.get(prop.getProperty("stage_url_momb"));
		
		logger.info("*** Chrome Browser open and maximied***");
		hp.click_btn_login();
		hp.enter_txt_Userid(prop.getProperty("stage_civil_login_uid"));
		hp.enter_txt_Password(prop.getProperty("stage_civil_login_pwd"));
		hp.click_txt_Captcha();
		Thread.sleep(9000);
		hp.click_btn_Submit();
		logger.info("1 Strating loginpage");

	}

	@Test(priority=2)
	public void navegatehomepage()
	{
		loginPage lp=new loginPage(driver);

		lp.click_lnk_workshome();
		logger.info("2 Click on Home link");
	}
	
	@Test(priority = 3,dataProvider = "WorkData",dataProviderClass = ExcelDataProviders.class,groups = "Datadriven")
	public void workcreation(String District,String Mandal,String School_Name,String Typ_1,String Typ_2,String Typ_3,String Typ_4,String Jail_1,String Jail_2,String Jail_3,String jail_4) throws InterruptedException
	{
		//Sanction Letter Number
		String Sanction_no="Lr.No.389/A3/2024 Dt: 14/06/2024";

		//Admin Sanction date
		String year="2024";
		String month="July";
		String date="10";

		// Sanction pdf upload file
		//String path="C:\\Users\\91939\\eclipse-workspace\\STAGEMombCivilLogin\\testData\\Suryapet_PO.pdf";   //taking pdf file from testData
		String path=System.getProperty("user.dir")+"\\testData\\HYDERABAD.pdf";

		loginPage lp=new loginPage(driver);
		//		
				lp.click_lnk_workshome();
		//		logger.info("2 Click on Home link");

		lp.click_lnk_Estimations();
		lp.click_lnk_PO_Generation_for_CPM_Works();

		logger.info("3 Estimation page");

		lp.select_District(District);
		lp.select_Phase("Phase-I");
		lp.select_Mandal(Mandal);
		lp.select_Module("MOMB");

		boolean school_selected=false;
		//		System.out.println("1 school selected :"+school_selected);
		List <WebElement> schools_list=lp.select_Schools_list();
		for(WebElement each_school:schools_list)
		{
			String oneschool=each_school.getText();
			//			System.out.println("School names form Momb :"+oneschool);
			if(oneschool.equalsIgnoreCase(School_Name))
			{
				lp.select_School(oneschool);
				school_selected =lp.select_School_status();
				//				System.out.println("2 school selected :"+school_selected);
				break;
			}

			//			else
			//			{
			//				lp.select_Module("AAPC");
			//				lp.select_School(School_Name);
			//				System.out.println("2 school selected :"+lp.select_School_status());
			//				break;
			//			}
		}

		if(!school_selected)
		{
			lp.select_Module("AAPC");
			lp.select_School(School_Name);
		}

		lp.select_Work_Name("FURNITURE TO STUDENTS AND STAFF (DUAL DESK)"); // W010 = FURNITURE TO STUDENTS AND STAFF (DUAL DESK)

		lp.click_btn_Go();
		Thread.sleep(1000);
		System.out.println("Dist: "+District+" Mandal: "+Mandal+" School Name: "+School_Name);
		int row= lp.No_of_Rows();
		//		System.out.println("1 table row :"+row);
		if(row==4)
		{
			if(Integer.parseInt(Typ_1) > 0){	lp.click_t1060();	}
			if(Integer.parseInt(Typ_2) > 0){	lp.click_t1061();	}
			if(Integer.parseInt(Typ_3) > 0){	lp.click_t1062();	}
			if(Integer.parseInt(Typ_4) > 0){	lp.click_t1063();	}
		}

		lp.click_Add_Task_Details();


		int table_two_row=lp.table2_no_of_rows();
		//		System.out.println("2 table row :"+table_two_row);
		for (int r = 2; r <= table_two_row; r++)
		{
			//			System.out.println("print table_two r value is :"+r);
			String Taskid=lp.get_task_code(driver,r);
			//			System.out.println("Taskids are :\n"+Taskid);
			/*
			if(Taskid.equals("T1060"))
			{
				lp.get_total_qty_click(driver, r);
				lp.get_total_qty(driver,r,Typ_1);
			}
			else if(Taskid.equals("T1061"))
			{
				lp.get_total_qty_click(driver, r);
				lp.get_total_qty(driver,r,Typ_2);
			}
			else if(Taskid.equals("T1062"))
			{
				lp.get_total_qty_click(driver, r);
				lp.get_total_qty(driver,r,Typ_3);
			}
			else if(Taskid.equals("T1063"))
			{
				lp.get_total_qty_click(driver, r);
				lp.get_total_qty(driver,r,Typ_4);
			}
			Thread.sleep(2000);

			 */
			switch(Taskid)
			{
			case "T1060":
				lp.get_total_qty_click(driver, r);
				lp.get_total_qty(driver,r,Typ_1);
				break;
			case "T1061":
				lp.get_total_qty_click(driver, r);
				lp.get_total_qty(driver,r,Typ_2);
				break;
			case "T1062":
				lp.get_total_qty_click(driver, r);
				lp.get_total_qty(driver,r,Typ_3);
				break;
			case "T1063":
				lp.get_total_qty_click(driver, r);
				lp.get_total_qty(driver,r,Typ_4);
				break;
			}
			//			Thread.sleep(2000);
		}


		lp.get_txt_AdminSanctionNo(driver,Sanction_no);

		lp.click_imgcalender();

		String monthandyear_user=month+", "+year;
		//		String sday=month+" "+date+","+year;
		//		System.out.println("Month & year from user:"+monthandyear_user);
		//		System.out.println("day from user:"+sday);
		while(true)
		{
			String monthyear=lp.get_month_year();
			//			System.out.println("Month and year form web:"+monthyear);
			if(monthandyear_user.equalsIgnoreCase(monthyear))
			{
				break;
			}
			lp.click_prevArrow();

		}

		Thread.sleep(2000);
		List<WebElement> days=lp.get_calendar_days();
		for(WebElement day:days)
		{
			String date_data=day.getAttribute("title");
			//			System.out.println(date_data);
			if(date.equals(day.getText()) && date_data.contains(month))
			{
				day.click();
			}
		}

		Thread.sleep(2000);

		lp.file_upload(path);
		Thread.sleep(1000);
		lp.click_btnSubmit();
		//		System.out.println(lp.my_alert(driver).getText());
		Thread.sleep(1000);
		lp.my_alert(driver).accept();
		System.out.println("Work id :"+lp.my_alert(driver).getText());
		//		System.out.println(lp.my_alert(driver).getText());
		Thread.sleep(1000);
		lp.my_alert(driver).accept();

	}

	@Test(priority=4)
	public void testlogout()
	{
		loginPage lp=new loginPage(driver);
		lp.click_lnk_logout();

	}

}
